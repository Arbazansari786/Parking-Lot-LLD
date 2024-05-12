package com.lti.factory;

import com.lti.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    Map<String, CommandExecutor> commandExecutorMap;

    public CommandExecutorFactory(){
        commandExecutorMap=new HashMap<>();

        commandExecutorMap.put("create_parking_lot",new CreateCommandExecutor());
        commandExecutorMap.put("park",new ParkCommandExecutor());
        commandExecutorMap.put("leave",new LeaveCommandExecutor());
        commandExecutorMap.put("registration_numbers_for_cars_with_colour",new SearchCarByColorCommandExecutor());
        commandExecutorMap.put("slot_number_for_registration_number",new SearchSlotByRegNo());
        commandExecutorMap.put("slot_numbers_for_cars_with_colour",new SearchSlotsNumberByColor());
        commandExecutorMap.put("exit",new ExitCommandExecutor());
        commandExecutorMap.put("status",new StatusCommandExecutor());
    }

    private CommandExecutor commandExecutor;

    public CommandExecutor getCommandExecutor(Command command){

        return commandExecutorMap.get(command.getCommandName().toLowerCase());
    }








}
