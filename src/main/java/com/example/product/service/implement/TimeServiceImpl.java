package com.example.product.service.implement;

import com.example.product.models.Time;
import com.example.product.repository.TimeRepository;
import com.example.product.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public Time getTimeById(Integer id) {
        return timeRepository.findById(id).get();
    }

    @Override
    public Time updateTime(Integer id ,LocalDateTime time) {
        Time time1 = timeRepository.findById(id).get();
        time1.setTime(time);
        return timeRepository.save(time1);
    }
}
