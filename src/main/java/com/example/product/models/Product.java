package com.example.product.models;


import com.example.product.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

//    @OneToOne
//    @JoinTable(name = "certificate", joinColumns = @JoinColumn(name = "product_id"))
//    private Set<Certificate> certificates = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private int price;

    @Column
    private String description;

    @Column
    private String image;

    public ProductDto toDto() {
        return ProductDto.builder().id(id)
                .name(name).price(price).image(image).description(description).build();
    }
}
