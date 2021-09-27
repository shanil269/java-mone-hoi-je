package com.dayName;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.print("Input: ");
            byte inputNumber = new Scanner(System.in).nextByte();
            boolean validated = validateNumber(inputNumber);
            String output = (validated) ? dayNameFinder(inputNumber) : "Input number must be equal or between 1 and 31";
            System.out.println("Output: " + output);
        } catch (InputMismatchException e) {
            System.out.println("Input number must be equal or between 1 and 31");
        }
    }

    static boolean validateNumber(byte num) {
        return num >= 1 && num <= 31;
    }

    static String dayNameFinder(byte num) {
        String[] day = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return day[num % 7];
    }
}
