package tech.npwd.roots;

import java.util.Random;

//Randomer Generates randomized int's and flag's

public class Randomer extends Random {

    //Generate random int
    public static int random(int lowerBound, int upperBound){
        //Init Random.java & Set a random value
        Random random = new Randomer();
        int randomInt = random.nextInt(upperBound);

        //If a lower bound is specified, repeat the randomization until the condition is met
        if(lowerBound > -1)
            while(randomInt <= lowerBound)
                randomInt = random.nextInt(upperBound);
        return randomInt;
    }

    //Generates a random percent double
    public static double randomPercent(){
        //Use master method to generate a number from 1 to 10 and then convert to percent
        return ((double)random(0, 11) / 10.0);
    }

    //Generate random flag/boolean
    public static boolean randomFlag(){
        //Use previous method to generate a 0 or a 1 & Mark the boolean based off that
        if(random(-1, 2) == 1)
            return true;
        return false;
    }
}
