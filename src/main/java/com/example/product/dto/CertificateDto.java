package com.example.product.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class CertificateDto {
    private Integer id;
    private LocalDate start_date;
    private LocalDate end_date;
}
