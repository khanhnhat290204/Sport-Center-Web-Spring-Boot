package com.nkn.SportCenter.exception;

public enum ErrorCode {
    USER_EXIST(1001,"user existed"),
    
    ;

    ErrorCode(int code, String message){
        this.code=code;
        this.message=message;
    }

    private int code;
    private String message;

   

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    

}
