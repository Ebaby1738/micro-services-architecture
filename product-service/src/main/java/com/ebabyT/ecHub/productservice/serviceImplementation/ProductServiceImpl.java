package com.ebabyT.ecHub.productservice.serviceImplementation;

import com.ebabyT.ecHub.productservice.dto.requestDto.ProductRequest;
import com.ebabyT.ecHub.productservice.dto.responseDto.ProductResponse;
import com.ebabyT.ecHub.productservice.entity.Product;
import com.ebabyT.ecHub.productservice.repository.ProductRepository;
import com.ebabyT.ecHub.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved successfully", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(this::mapProductResponse).toList();

    }

    private ProductResponse mapProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(String.valueOf(product.getPrice()))
                .build();

    }
}
