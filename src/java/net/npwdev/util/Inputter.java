package net.npwdev.util;

import java.util.Scanner;

import static net.npwdev.util.Printer.print;

//Inputter: Takes input from a keyboard

public class Inputter {

    //Base input method, takes any one word string of console input
    public static String inputTranslator(){
        print("Enter your input on the keyboard into the console and then press ENTER.");

        //Stream in input
        Scanner inputter = new Scanner(System.in);

        //Grab it
        String input = inputter.next();

        //Store and Report it
        if(input != null){
            print("You entered: '" + input + "'.");
            return input;
        }

        return null;
    }

    //Char input method
    public static char charTranslator(){
        //Use base method
        String input = inputTranslator();

        //Convert and Store as Char
        if(input != null)
            return input.charAt(0);
        return 'z';
    }

    //Integer input method
    public static int intTranslator(){
        //Base method
        String input = inputTranslator();

        //Convert and Store as int
        if(input != null)
            return Integer.parseInt(input);
        return -1;
    }
}