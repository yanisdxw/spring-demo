package com.dxw.common;

import lombok.Data;

@Data
public class Response<T> {

    private Integer code;

    private Boolean success;

    private T data;

    private String message;

    private Response(){

    }

    public static<T> Response ofSuccess(T data){
        Response response = new Response<>();
        response.setCode(200);
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static Response ofSuccess(){
        Response response = new Response<>();
        response.setCode(200);
        response.setSuccess(true);
        return response;
    }

    public static Response ofFailure(String message){
        Response response = new Response();
        response.setCode(1);
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

}
