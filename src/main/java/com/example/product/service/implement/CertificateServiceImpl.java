package com.example.product.service.implement;

import com.example.product.models.Certificate;
import com.example.product.repository.CertificateRepository;
import com.example.product.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> certificateList() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate addNewCertificate(Certificate certificate) {
        return (Certificate) certificateRepository.save(certificate);
    }


    @Override
    public Certificate getCertificateById(Integer id) {
        Certificate certificate = (Certificate) certificateRepository.findById(id).get();
        return certificate;
    }

    @Override
    public void deleteCertificateById(Integer id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public Certificate updateCertificate(Integer id, LocalDate new_end_date){
        Certificate certificate = (Certificate) certificateRepository.findById(id).get();
        certificate.setEnd_date(new_end_date);
        return (Certificate) certificateRepository.save(certificate);
    }
}
