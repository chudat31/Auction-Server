package com.example.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Integer id;

    private String name;

    private String image;

    private String description;

    private float price;

    private Integer cert_id;

}
