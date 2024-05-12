package com.lti.model;



public class Car {

    private String modelNo;

    public String getModelNo() {
        return modelNo;
    }

    public Car(String modelNo, String color) {
        this.modelNo = modelNo;
        this.color = color;

    }

    @Override
    public String toString() {
        return "Car{" +
                "modelNo='" + modelNo + '\'' +
                ", color='" + color + '\'';
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ParkingTicket getParkigTicket() {
        return parkigTicket;
    }

    public void setParkigTicket(ParkingTicket parkigTicket) {
        this.parkigTicket = parkigTicket;
    }



    private String color;

    private  ParkingTicket parkigTicket;




    public void assignTicket(ParkingTicket ticket){
        this.parkigTicket=ticket;
    }


}
