package com.exception;

public class MyException extends Exception {
    private static final long serialVersionUID = 167;

    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }
}
