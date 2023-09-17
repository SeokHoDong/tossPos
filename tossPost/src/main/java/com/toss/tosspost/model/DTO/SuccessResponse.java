package com.toss.tosspost.model.DTO;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SuccessResponse {
    private String message;

    public SuccessResponse(String message) {
        this.message = message;
    }
}
