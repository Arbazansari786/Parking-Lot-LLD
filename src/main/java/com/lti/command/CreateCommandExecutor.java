package com.lti.command;

import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

import java.util.List;

public class CreateCommandExecutor implements  CommandExecutor{

    @Override
    public void execute(Command command) {
        try {
            List<String> params = command.getParams();
            ParkingLotSystem.getParkingLotSystem().createParkingLot(Integer.parseInt(params.get(0)));
            OutputPrint.createParkingLot(Integer.parseInt(params.get(0)));
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }
    }
}
