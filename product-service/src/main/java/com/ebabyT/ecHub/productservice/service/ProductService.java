package com.ebabyT.ecHub.productservice.service;

import com.ebabyT.ecHub.productservice.dto.requestDto.ProductRequest;
import com.ebabyT.ecHub.productservice.dto.responseDto.ProductResponse;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();
}
