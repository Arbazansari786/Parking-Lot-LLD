package com.lti.command;

import com.lti.exception.InvalidCommandException;
import com.lti.utility.OutputPrint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public  class Command {

    private String commandName;

    public Command(String inputLine) {

        try {
            List<String> tokenList = Arrays.stream(inputLine.trim().split(" ")).map((str) -> str.trim())
                    .filter((word) -> word.length() > 0).collect(Collectors.toList());
            if (tokenList.isEmpty())
                throw new InvalidCommandException("Command in invalid");
            this.commandName = tokenList.get(0);

            tokenList.remove(0);
            this.params = tokenList;
        }
        catch (Exception e){
            OutputPrint.printMsg(e.getMessage());
        }
    }

    private List<String> params;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }
}
