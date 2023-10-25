package com.ebabyTecHub.orderservice.serviceImplementation;

import com.ebabyTecHub.orderservice.dto.request.OrderLineItemsDto;
import com.ebabyTecHub.orderservice.dto.request.OrderRequest;
import com.ebabyTecHub.orderservice.dto.response.InventoryResponse;
import com.ebabyTecHub.orderservice.entity.Order;
import com.ebabyTecHub.orderservice.entity.OrderLineItems;
import com.ebabyTecHub.orderservice.repository.OrderRepository;
import com.ebabyTecHub.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    @Override
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
        //call inventory service and place order if product is in stock
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory/confirm-inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class).block();
        boolean allProductInStock = Arrays.stream(inventoryResponses)
                .allMatch(InventoryResponse::isInStock);

        if (allProductInStock){
            orderRepository.save(order);
        } else{
            throw new IllegalArgumentException("product is not in stock, please try again later");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderlineItems = new OrderLineItems();
        orderlineItems.setPrice(orderLineItemsDto.getPrice());
        orderlineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderlineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderlineItems;
    }


}
