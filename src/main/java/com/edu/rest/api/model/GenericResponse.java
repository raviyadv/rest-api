package com.edu.rest.api.model;

public class GenericResponse {

    private int status;
    private String message;
    private Object response;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public GenericResponse(int status, String message, Object response) {
        this.status = status;
        this.message = message;
        this.response = response;




    }
}
