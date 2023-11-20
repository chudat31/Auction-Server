package com.example.product.service;

import com.example.product.models.History;

import java.util.List;

public interface HistoryService {
    List<History> historyList();

    List<History> getHistoryByUsername(String username);

    History addNewHistory(History history);
}
