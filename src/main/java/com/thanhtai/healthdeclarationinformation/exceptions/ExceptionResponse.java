package com.thanhtai.healthdeclarationinformation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    @Getter
    private Date timestamp;
    @Getter
    private int status;
    @Getter
    private String error;
    @Getter
    private String errorMessage;
}
