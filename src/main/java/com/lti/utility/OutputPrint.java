package com.lti.utility;

import com.lti.model.Car;
import com.lti.model.ParkingTicket;
import com.lti.model.Slot;

import java.util.List;

public class OutputPrint {

    public static void welcome(){
        System.out.println("Welcome to the Arbaz ka Parking Lot");
    }

    public static void exit(int leaveSlotNo){
        System.out.println("Slot No "+leaveSlotNo+" is free");
    }

    public static void createParkingLot(int size){
        System.out.println("Successfully Create Parking lot in with size "+size);
    }

    public  static  void park(ParkingTicket parkingTicket){
        System.out.println("Car with regNo "+parkingTicket.getCar().getModelNo()+" in slot "+parkingTicket.getSlot().getSlotId());
    }

    public static  void printCarsByColor(List<Car> cars,String color){
        System.out.println("Below are the Cars RegNo with Color :: "+color);
        for(int i=0;i<cars.size();i++){
            System.out.println(cars.get(i).getModelNo().toUpperCase());
        }
    }

    public static  void printSlotByRegNo(Slot slot,String regNo){

        System.out.println("The vehicle with RegNo "+regNo.toUpperCase()+" is Parked at slot :: "+slot.getSlotId());

    }

    public static  void printSlotsByColor(List<Slot> slots, String color){

        System.out.println("The slots are below which is having Cars which are "+color);
        for(int i=0;i<slots.size();i++){
            System.out.println(slots.get(i).getCar().getModelNo().toUpperCase()+" "+slots.get(i).getSlotId());
        }

    }

    public  static void  printMsg(String msg){
        System.out.println(msg);
    }

    public static void exitSystem(){
        System.out.println("System is Closing");
        System.exit(1);
    }

    public  static  void status(List<Slot> slots){
        System.out.println("Slot No "+"Registration No  "+"Colour");
        for (int i=0;i<slots.size();i++){
            System.out.print(slots.get(i).getSlotId()+"      ");
            System.out.print(slots.get(i).getCar().getModelNo()+"     ");
            System.out.print(slots.get(i).getCar().getColor()+"      ");
            System.out.println();
        }


    }


}
