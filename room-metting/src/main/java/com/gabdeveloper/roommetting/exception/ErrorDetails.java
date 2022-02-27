package com.gabdeveloper.roommetting.exception;

import java.util.Date;

public class ErrorDetails {
 
    private Date timestam;
    private String message;
    private String detail;

    public ErrorDetails(Date timestam, String message, String detail) {
        this.timestam = timestam;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestam() {
        return timestam;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    
}