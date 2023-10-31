package com.ebabyTecHub.orderservice.service;

import com.ebabyTecHub.orderservice.dto.request.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
