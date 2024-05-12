package com.lti.command;

import com.lti.model.Slot;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

import java.util.List;

public class StatusCommandExecutor implements CommandExecutor{


    @Override
    public void execute(Command command) {
        try {
            List<Slot> slots = ParkingLotSystem.getParkingLotSystem().getAllSlot();
            OutputPrint.status(slots);
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }
    }
}
