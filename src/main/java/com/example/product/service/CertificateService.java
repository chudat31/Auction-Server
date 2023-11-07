package com.example.product.service;

import com.example.product.models.Certificate;
import org.springframework.data.relational.core.sql.In;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CertificateService {

    List<Certificate> certificateList();

    Certificate addNewCertificate(Certificate certificate);

    Certificate getCertificateById(Integer id);

    void deleteCertificateById(Integer id);

    Certificate updateCertificate(Integer id, LocalDate new_end_date);
}
