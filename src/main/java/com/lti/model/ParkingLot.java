package com.lti.model;

import com.lti.exception.CarNotFoundException;
import com.lti.exception.InvalidSlotException;
import com.lti.exception.SlotNotAvailableException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + slots +
                ", parkingLotId=" + parkingLotId +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    public ParkingLot(Map<Integer, Slot> slots, Integer parkingLotId, Integer maxCapacity) {
        this.slots = slots;
        this.parkingLotId = parkingLotId;
        this.maxCapacity = maxCapacity;
    }

    Map<Integer, Slot> slots=null;

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    public void setSlots(Map<Integer, Slot> slots) {
        this.slots = slots;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    Integer parkingLotId;

    Integer maxCapacity;

    private Slot getSlot(final Integer slotNumber) throws InvalidSlotException {
        if (slotNumber > getMaxCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException();
        }
        final Map<Integer, Slot> allSlots = getSlots();
        if (!allSlots.containsKey(slotNumber)) {
            allSlots.put(slotNumber, new Slot(slotNumber, true));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(Integer slotId, Car car) throws InvalidSlotException {

        Slot slot = getSlot(slotId);

        slot.assignCar(car);

        slots.put(slot.getSlotId(), slot);
        return slot;
    }

    public void freeSlot(Integer slotId) throws InvalidSlotException {

        Slot slot = getSlot(slotId);
        slot.unAssignCar();

    }

    List<Slot> getOccupiedSlot(){
        return slots.entrySet().stream().map(Map.Entry::getValue).filter(slot -> !slot.isAvailable()).collect(Collectors.toList());
    }

    public List<Car> searchCarByColor(String color) throws CarNotFoundException {
            List<Slot> occupiedSlot=getOccupiedSlot();
//            occupiedSlot.forEach(System.out::println);
            List<Car> cars=occupiedSlot.stream().map(Slot::getCar).filter((car)->car.getColor().equals(color)).collect(Collectors.toList());

            if(cars.isEmpty())
                throw  new CarNotFoundException("Car is not available of color :: "+color);
            return  cars;

    }

    public Slot searchSlotByRegNo(String regNo) {

        if(slots==null)
            throw new SlotNotAvailableException("Slot is not Available with regNo :: "+regNo);

        List<Slot> slotByRegNo = slots.entrySet().stream().map((ele) -> ele.getValue()).filter((slot) ->  (!slot.isAvailable() && regNo.equals(slot.getCar().getModelNo()))).collect(Collectors.toList());

        if(slotByRegNo.isEmpty())
            throw new SlotNotAvailableException("Slot is not Available with regNo :: "+regNo);

        return slotByRegNo.get(0);

    }

    public List<Slot> getSlotsByCarColor(String color){

       List<Slot> occupiedSlots= getOccupiedSlot();
     List<Slot> slotByColor=  occupiedSlots.stream().filter((slot -> slot.getCar().getColor().equals(color))).collect(Collectors.toList());


       if(slotByColor.isEmpty())
           throw new SlotNotAvailableException("Slots are not available with color :: "+color);

       return slotByColor;

    }

    public List<Slot> getAllSlots(){
        return slots.entrySet().stream().map(Map.Entry::getValue).filter(((slot)->!slot.isAvailable())).collect(Collectors.toList());
    }


}
