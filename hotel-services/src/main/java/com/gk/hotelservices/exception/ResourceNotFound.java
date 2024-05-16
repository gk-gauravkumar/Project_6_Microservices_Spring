package com.gk.hotelservices.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
    public ResourceNotFound(){
        super("Resourse Not found !! ");
    }
}
