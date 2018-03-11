package com.rainea.ssm.exception;

/**
 * <p>Title: CustomeException.java</p>
 * <p>Description: 自定义异常类</p>
 * @author liulang
 * @date   Apr 15, 2017
 * @version 
 */
public class CustomeException extends Exception {

    private String message;
    
    public CustomeException() {}
    
    public CustomeException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
