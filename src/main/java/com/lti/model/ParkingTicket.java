package com.lti.model;

import java.util.Date;

public class ParkingTicket {

    private Car car;

    private Slot slot;

    public Car getCar() {
        return car;
    }

    public ParkingTicket(Car car, Slot slot, Integer parkingTicketId, Date timeStamp) {
        this.car = car;
        this.slot = slot;
        this.parkingTicketId = parkingTicketId;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "car=" + car +
                ", slot=" + slot +
                ", parkingTicketId=" + parkingTicketId +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Integer getParkingTicketId() {
        return parkingTicketId;
    }

    public void setParkingTicketId(Integer parkingTicketId) {
        this.parkingTicketId = parkingTicketId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    private Integer parkingTicketId;

    private Date timeStamp;

    public double calculateFee(int rate){
        return 0.0;
    }

}
