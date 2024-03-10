package org.example.Exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(){
        super("Customer Not Found!");
    }
}
