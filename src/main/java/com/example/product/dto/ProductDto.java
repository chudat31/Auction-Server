package com.example.product.dto;

import com.example.product.models.User;
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

    private String username;

}
