package com.example.product.service;

import com.example.product.models.History;
import com.example.product.models.Time;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeService {
    Time getTimeById(Integer id);

    Time updateTime(Integer id ,LocalDateTime time);
}
