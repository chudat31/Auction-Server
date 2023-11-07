package com.example.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {
    private int code;
    private String message;
    private Object data;

    public APIResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static APIResponse success (Object data, int code, String message) {
        Object dataList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(data)) {
            dataList = data;
        }
        return APIResponse.builder()
                .message(StringUtils.hasText(message) ? message : "")
                .code(code)
                .data(dataList)
                .build();
    }
}
