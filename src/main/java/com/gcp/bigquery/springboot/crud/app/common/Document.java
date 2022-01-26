package com.gcp.bigquery.springboot.crud.app.common;

public class Document<T>{
    private T data;
    private String message;
    private int statusCode;

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

}