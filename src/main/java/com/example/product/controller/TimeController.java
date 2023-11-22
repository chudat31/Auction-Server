package com.example.product.controller;

import com.example.product.dto.CertificateDto;
import com.example.product.dto.ProductDto;
import com.example.product.dto.TimeDto;
import com.example.product.models.Certificate;
import com.example.product.models.Product;
import com.example.product.models.Time;
import com.example.product.response.APIResponse;
import com.example.product.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/time")
@CrossOrigin
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping("/{id}")
    public Time getTime(@PathVariable Integer id){
        Time time = timeService.getTimeById(id);
        return time;
    }

    @PatchMapping("/update/{id}")
    public Time updateTime(@PathVariable Integer id, @RequestBody TimeDto timeDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(timeDto.getTime(), formatter);
        Time time = timeService.updateTime(id, localDateTime);
        return time;
    }
}
