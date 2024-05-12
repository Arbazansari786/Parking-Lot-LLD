package com.lti.command;

import com.lti.exception.InvalidSlotException;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

public class LeaveCommandExecutor implements  CommandExecutor{

    @Override
    public void execute(Command command) {

        int leaveSlotNo=Integer.parseInt(command.getParams().get(0));
        ParkingLotSystem parkingLotSystem=ParkingLotSystem.getParkingLotSystem();
        try {
            parkingLotSystem.freeSlot(leaveSlotNo);
            OutputPrint.exit(leaveSlotNo);
        } catch (InvalidSlotException e) {
                OutputPrint.printMsg(e.getMessage());
        }

    }
}
