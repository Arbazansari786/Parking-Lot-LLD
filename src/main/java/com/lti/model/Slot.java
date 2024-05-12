package com.lti.model;

public class Slot {

    private Integer slotId;

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", isAvailable=" + isAvailable +
                '}';
    }

    private Car car;

    private boolean isAvailable;

    public Integer getSlotId() {
        return slotId;
    }

    public Slot(Integer slotId, boolean isAvailable) {
        this.slotId = slotId;
        this.isAvailable = isAvailable;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void makeFreeSlot(){
        this.isAvailable=true;
    }

    public void occupySlot(){
        this.isAvailable=false;
    }

    public void assignCar(Car car){
        this.car=car;
        occupySlot();
    }

    public void unAssignCar(){
        this.car=null;
        makeFreeSlot();
    }



}
