package com.example.product.controller;

import com.example.product.dto.CertificateDto;
import com.example.product.models.Certificate;
import com.example.product.response.APIResponse;
import com.example.product.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<APIResponse> getListCertificate(){
        List<Certificate> certificateList = certificateService.certificateList();
        List<CertificateDto> certificateDto = certificateList.stream().map(Certificate::toDto).collect(Collectors.toList());
        APIResponse apiResponse = APIResponse.success(certificateDto, HttpStatus.OK.value(), "Danh sach giay chung nhan");
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse> addNewCertificate(@RequestBody Certificate certificate) {
        certificateService.addNewCertificate(certificate);
        CertificateDto certificateDto = certificate.toDto();
        APIResponse apiResponse = APIResponse.success(certificateDto, HttpStatus.OK.value(), "Them giay chung nhan thanh cong ");
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse> deleteCertificateById(@PathVariable Integer id){
        certificateService.deleteCertificateById(id);
        APIResponse apiResponse = APIResponse.success(null, HttpStatus.OK.value(), "Xoa giay chung nhan thanh cong");
        return ResponseEntity.ok(apiResponse);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<APIResponse> updateCertificate(@PathVariable Integer id, @RequestBody Certificate new_certificate){
        Certificate certificate = certificateService.updateCertificate(id, new_certificate.getEnd_date());
        CertificateDto certificateDto = certificate.toDto();
        APIResponse apiResponse = APIResponse.success(certificateDto, HttpStatus.OK.value(), "Gia han giay chung nhan thanh cong");
        return ResponseEntity.ok(apiResponse);
    }
}
