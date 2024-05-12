package com.lti.command;

import com.lti.model.Car;
import com.lti.model.ParkingTicket;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

public class ParkCommandExecutor implements  CommandExecutor{

    @Override
    public void execute(Command command) {

        try {

            ParkingLotSystem parkingLotSystem = ParkingLotSystem.getParkingLotSystem();
            String carRegNo = command.getParams().get(0).toLowerCase();

            String color = command.getParams().get(1).toLowerCase();
            Car car = new Car(carRegNo, color);
            ParkingTicket parkingTicket = parkingLotSystem.park(car);
            OutputPrint.park(parkingTicket);
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }

    }
}
