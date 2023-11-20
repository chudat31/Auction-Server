package com.example.product.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column
    private String name;

    @Column
    private int price;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    @Column
    private LocalDateTime datetime;

    @Column
    private String username;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
}
