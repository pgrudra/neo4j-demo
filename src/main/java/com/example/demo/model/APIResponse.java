package com.example.demo.model;

import lombok.Getter;

@Getter
public class APIResponse<T> {
    private final String message;
    private final T data;

    public APIResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}

