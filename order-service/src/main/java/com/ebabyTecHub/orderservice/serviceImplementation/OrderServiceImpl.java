package com.ebabyTecHub.orderservice.serviceImplementation;

import com.ebabyTecHub.orderservice.dto.request.OrderLineItemsDto;
import com.ebabyTecHub.orderservice.dto.request.OrderRequest;
import com.ebabyTecHub.orderservice.entity.Order;
import com.ebabyTecHub.orderservice.entity.OrderLineItems;
import com.ebabyTecHub.orderservice.repository.OrderRepository;
import com.ebabyTecHub.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderlineItems = new OrderLineItems();
        orderlineItems.setPrice(orderLineItemsDto.getPrice());
        orderlineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderlineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderlineItems;
    }


}
