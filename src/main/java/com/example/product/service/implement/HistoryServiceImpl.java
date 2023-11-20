package com.example.product.service.implement;

import com.example.product.models.History;
import com.example.product.repository.HistoryRepository;
import com.example.product.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<History> historyList() {
        return historyRepository.findAll();
    }

    @Override
    public List<History> getHistoryByUsername(String username) {
        return historyRepository.findByUsername(username);
    }

    @Override
    public History addNewHistory(History history) {
        return (History) historyRepository.save(history);
    }
}
