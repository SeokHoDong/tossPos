package com.toss.tosspost.model.DTO;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }


}
