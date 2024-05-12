package com.lti.service;

import com.lti.exception.CarNotFoundException;
import com.lti.exception.InvalidSlotException;
import com.lti.exception.ParkingLotException;
import com.lti.model.Car;
import com.lti.model.ParkingLot;
import com.lti.model.ParkingTicket;
import com.lti.model.Slot;
import com.lti.strategy.NaturalParkingStrategy;
import com.lti.strategy.ParkingStrategy;
import com.lti.utility.RandomGenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ParkingLotSystem {


    private ParkingLot parkingLot;

    private List<ParkingTicket> parkingTickets;

    private ParkingStrategy strategy;

    private static ParkingLotSystem parkingLotSystem = null;

    private ParkingLotSystem() {

    }


    public static ParkingLotSystem getParkingLotSystem() {
        if (parkingLotSystem == null)
            parkingLotSystem = new ParkingLotSystem();

        return parkingLotSystem;
    }


    public ParkingTicket generateTicket(Car car) {
        return null;
    }

    public Slot getNextFreeSlot() {
        return null;
    }

    public void freeSlot(int slotId) throws InvalidSlotException {

        this.parkingLot.freeSlot(slotId);
        this.strategy.addSlot(slotId);

    }

    public ParkingTicket park(Car car) throws InvalidSlotException {
        Integer slotId=strategy.getNextSlot();
        Slot slot=parkingLot.park(slotId,car);
        strategy.removeSlot(slotId);
        RandomGenerator randomGenerator=new RandomGenerator();
        ParkingTicket parkingTicket=new ParkingTicket(car,slot,randomGenerator.generateId(),new Date());
        car.assignTicket(parkingTicket);
        return  parkingTicket;
    }

    public void createParkingLot(Integer maxCapacity) {

        if (parkingLot != null) {
            throw new ParkingLotException("Parking Lot is already created");
        }

        strategy = new NaturalParkingStrategy(maxCapacity);
        for (int i = 1; i <= maxCapacity; i++)
            strategy.addSlot(i);
        parkingLot = new ParkingLot(new HashMap(), 1, maxCapacity);
    }

    public List<Car> getCarsByColor(String color) throws CarNotFoundException {
            return parkingLot.searchCarByColor(color);
    }

    public Slot getSlotByRegNo(String regNo) {

        return  parkingLot.searchSlotByRegNo(regNo);
    }

    public List<Slot> getSlotByColor(String color) {

        return  parkingLot.getSlotsByCarColor(color);

    }

    public List<Slot> getAllSlot(){
        return parkingLot.getAllSlots();
    }



}
