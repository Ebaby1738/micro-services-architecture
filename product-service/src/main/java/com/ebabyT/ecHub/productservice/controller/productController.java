package com.ebabyT.ecHub.productservice.controller;

import com.ebabyT.ecHub.productservice.dto.requestDto.ProductRequest;
import com.ebabyT.ecHub.productservice.dto.responseDto.ProductResponse;
import com.ebabyT.ecHub.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request){
        productService. createProduct(request);
    }

    @GetMapping("/getAllProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProducts();
    }

}
