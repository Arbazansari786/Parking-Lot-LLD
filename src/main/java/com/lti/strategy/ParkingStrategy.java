package com.lti.strategy;

import com.lti.model.Slot;

public interface ParkingStrategy {

    public Integer getNextSlot();

    public void addSlot(Integer slotId);

    public void removeSlot(int slot);

}
