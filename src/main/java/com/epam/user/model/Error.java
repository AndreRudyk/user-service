package com.epam.user.model;

import com.epam.user.model.enums.ErrorCode;
import com.epam.user.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
    private String message;
    private ErrorCode errorCode;
    private ErrorType errorType;
    private LocalDateTime dateTime;
}
