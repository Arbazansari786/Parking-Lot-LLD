package com.lti.command;

import com.lti.utility.OutputPrint;

public class ExitCommandExecutor implements  CommandExecutor {


    @Override
    public void execute(Command command) {

        OutputPrint.exitSystem();
    }
}
