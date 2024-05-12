package com.lti.mode;

import com.lti.command.Command;
import com.lti.command.CommandExecutor;
import com.lti.exception.InvalidCommandException;
import com.lti.factory.CommandExecutorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class InteractiveMode implements Mode {


    @Override
    public void processCommand() throws IOException {
        Scanner sc = new Scanner(System.in);
        CommandExecutorFactory factory = new CommandExecutorFactory();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {


            String input = reader.readLine();
            Command command = new Command(input);
            try {
                CommandExecutor commandExecutor = factory.getCommandExecutor(command);

                if (commandExecutor == null)
                    throw new InvalidCommandException(command.getCommandName() + " Command is invalid");
                commandExecutor.execute(command);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
