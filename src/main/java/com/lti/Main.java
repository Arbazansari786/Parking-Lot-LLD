package com.lti;

import com.lti.mode.InteractiveMode;
import com.lti.mode.Mode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Mode mode=new InteractiveMode();
        mode.processCommand();

    }
}