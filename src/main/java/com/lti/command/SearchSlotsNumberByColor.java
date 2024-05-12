package com.lti.command;

import com.lti.model.Slot;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

import java.util.List;

public class SearchSlotsNumberByColor implements  CommandExecutor {


    @Override
    public void execute(Command command) {

        try {
            ParkingLotSystem parkingLotSystem = ParkingLotSystem.getParkingLotSystem();
            String color = command.getParams().get(0).toLowerCase();
            List<Slot> slots = parkingLotSystem.getSlotByColor(color);
            OutputPrint.printSlotsByColor(slots, color);
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }

    }
}
