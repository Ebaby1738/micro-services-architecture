package com.ebabyTecHub.orderservice.dto.request;

import com.ebabyTecHub.orderservice.entity.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data@Builder
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
