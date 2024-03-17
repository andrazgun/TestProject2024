package org.siit.course;

import javax.swing.*;
import java.util.Scanner;

public class LeapYear {
    /* Display the number of days in month February from a year between 1900-2016 that is read from keyboard
            HINT
    A year is a leap year if:
            -Is divisible by 4 but not by 100
            -Is divisible by 100 but not by 400 */

    public static void main(String[] args) {

        int year;

        Scanner input= new Scanner(System.in); //taking input in console
                System.out.println("Enter year between 1900 and 2016:");
        year = input.nextInt();

        boolean isLeapYear = false;

        if ((year < 1900) || (year > 2016)) {
            System.out.println(year + " is not between 1900 and 2006");
        } else {
            if ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)) {
                System.out.println(year + " : Leap year");
            }
            else {
                System.out.println(year + " : Not leap year");
            }

        }

    }
}
