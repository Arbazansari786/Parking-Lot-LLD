package com.lti.utility;

import java.util.Random;

public class RandomGenerator implements  GenerateUniqueId{


    @Override
    public  Integer generateId() {
        Random rand=new Random();
        return  rand.nextInt(100000);
    }
}
