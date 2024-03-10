package org.example.Exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){
        super("Order Not Found!");
    }
}
