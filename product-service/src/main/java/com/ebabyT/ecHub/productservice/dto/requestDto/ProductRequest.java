package com.ebabyT.ecHub.productservice.dto.requestDto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductRequest {


    private String name;


    private String description;


    private BigDecimal price;
}
