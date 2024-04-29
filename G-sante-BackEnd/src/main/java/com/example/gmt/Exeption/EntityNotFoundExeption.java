package com.example.gmt.Exeption;

public class EntityNotFoundExeption  extends RuntimeException{
    public  ErrorCode errorCode;
    public EntityNotFoundExeption(String message,ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
