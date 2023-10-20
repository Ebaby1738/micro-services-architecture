package com.ebabyT.ecHub.productservice.repository;

import com.ebabyT.ecHub.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
