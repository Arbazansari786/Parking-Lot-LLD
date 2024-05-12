package com.lti.command;

import com.lti.model.Car;
import com.lti.model.Slot;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

import java.util.List;

public class SearchSlotByRegNo implements  CommandExecutor{


    @Override
    public void execute(Command command) {
        try {
            ParkingLotSystem parkingLotSystem = ParkingLotSystem.getParkingLotSystem();
            String regNo = command.getParams().get(0).toLowerCase();
            Slot slot = parkingLotSystem.getSlotByRegNo(regNo);
            OutputPrint.printSlotByRegNo(slot, regNo);
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }

    }
}
