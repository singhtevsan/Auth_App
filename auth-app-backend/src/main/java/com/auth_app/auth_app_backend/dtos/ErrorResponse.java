package com.auth_app.auth_app_backend.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private int code;
}
