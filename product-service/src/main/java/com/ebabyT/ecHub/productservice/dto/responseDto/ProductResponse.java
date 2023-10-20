package com.ebabyT.ecHub.productservice.dto.responseDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

        private Long id;

        private String name;


        private String description;


        private String price;
}
