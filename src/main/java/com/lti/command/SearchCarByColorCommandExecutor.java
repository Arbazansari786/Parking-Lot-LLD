package com.lti.command;

import com.lti.exception.CarNotFoundException;
import com.lti.model.Car;
import com.lti.service.ParkingLotSystem;
import com.lti.utility.OutputPrint;

import java.util.List;

public class SearchCarByColorCommandExecutor implements CommandExecutor {


    @Override
    public void execute(Command command) {
        ParkingLotSystem parkingLotSystem= ParkingLotSystem.getParkingLotSystem();
        try {
            String color = command.getParams().get(0).toLowerCase();
            List<Car> cars = parkingLotSystem.getCarsByColor(color);
            OutputPrint.printCarsByColor(cars, color);
        }
        catch(CarNotFoundException e){
            OutputPrint.printMsg(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
}
