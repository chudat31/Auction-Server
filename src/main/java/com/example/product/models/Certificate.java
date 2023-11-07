package com.example.product.models;

import com.example.product.dto.CertificateDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Table(name = "certificate")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "start_date")
    private LocalDate start_date;

    @NonNull
    @Column(name = "end_date")
    private LocalDate end_date;

    public CertificateDto toDto(){
        return CertificateDto.builder().id(id).start_date(start_date).end_date(end_date).build();
    }
}
