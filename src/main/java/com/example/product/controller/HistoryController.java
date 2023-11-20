package com.example.product.controller;

import com.example.product.models.History;
import com.example.product.response.APIResponse;
import com.example.product.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/{username}")
    public ResponseEntity<APIResponse> getListHistoryByUsername(@PathVariable String username){
        List<History> historyList = historyService.getHistoryByUsername(username);
        if(username.equalsIgnoreCase("chudat")) {
            historyList = historyService.historyList();
        }
        APIResponse apiResponse = APIResponse.success(historyList, HttpStatus.OK.value(), "Lich su dau gia");
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    public ResponseEntity<APIResponse> getListHistory(){
        List<History> historyList = historyService.historyList();
        APIResponse apiResponse = APIResponse.success(historyList, HttpStatus.OK.value(), "Lich su dau gia");
        return ResponseEntity.ok(apiResponse);
    }
}
