package com.example.demo.model;

public class APIResponseWithPagination extends APIResponse {
    private Long totalRecords=0L;
    public APIResponseWithPagination(String message, Object data, Long totalRecords) {
        super(message, data);
        this.totalRecords=totalRecords;
    }
}
