package com.lti.strategy;

import com.lti.exception.ParkingSlotFullException;
import com.lti.model.Slot;

import java.util.HashSet;
import java.util.TreeSet;

public class NaturalParkingStrategy implements ParkingStrategy{

    TreeSet<Integer> set= new TreeSet<>();
    int maxCapacity;

    public NaturalParkingStrategy(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public Integer getNextSlot() {
        if(set.size()==0)
            throw new ParkingSlotFullException("Parking Lot is Full");
       return this.set.first();
    }

    @Override
    public void addSlot(Integer slotId) {
        set.add(slotId);
    }

    @Override
    public void removeSlot(int slot) {
        set.remove(slot);
    }


}
