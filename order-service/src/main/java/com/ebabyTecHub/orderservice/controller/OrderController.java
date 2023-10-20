package com.ebabyTecHub.orderservice.controller;

import com.ebabyTecHub.orderservice.dto.request.OrderRequest;
import com.ebabyTecHub.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place-order")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody OrderRequest request){
        orderService.placeOrder(request);

        return "order placed successfully";
    }
}
