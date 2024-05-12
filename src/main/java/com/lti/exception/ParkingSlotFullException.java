package com.lti.exception;

public class ParkingSlotFullException extends RuntimeException{

    public ParkingSlotFullException(String msg){
        super(msg);
    }

}
