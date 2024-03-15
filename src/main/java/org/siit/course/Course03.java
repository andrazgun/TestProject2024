package org.siit.course;

public class Course03 {

    static int x = 5;
    public static void main(String[] args) {
        int y = 1;
        boolean myBool = true;

        final int MAX_SIZE = 100; //naming convention for constant variables, uppercase split by _

        String name = "Ana are mere";

        System.out.println("Hello Course 03!");
        x += y;
        System.out.println(x);

        if ( x > 1 ) {
            System.out.println("Number is greater than 5");
        }

        if ( y < MAX_SIZE) {
            System.out.println("Number is less than " + MAX_SIZE);
        } else {
            System.out.println("Number is greater than " + MAX_SIZE);
        }

        switch (y) {
            case 0: {
                System.out.println("Number is 0");
                break;
            }
            case 1: {
                System.out.println("Number is 1");
                break;
            }
            default: {
                System.out.println("Not 0 not 1");
            }
        }

        //while example

        int index = 0;
        while (myBool) {
            System.out.println("Infinite while loop nr " + index);
            if (index > 5) {
                myBool = false;
            }
            index++;
        }

        // do while example
        myBool = true;
        index = 0;
        do {
            System.out.println("Infinite do-while loop nr " + index);
            if (index > 5) {
                myBool = false;
            }
            index++;
        }
        while (myBool);

        // do while example without myBool variable
        index = 0;
        do {
            System.out.println("Infinite do-while example loop nr " + index);
            if (index > 5) {
                break;
            }
            index++;
        }
        while (true);

        // for loop example
        index = 0;
        for (index = 0 ; index <= 5 ; index++) {
            System.out.println("For loop nr " + index);
        }

            for (index = 0 ; index < args.length -1 ; index++) {
                System.out.println(args[index]); //iterate and print arguments
            }
            // simple for loop to iterate and print arguments, equivalent to foreach
        for (String s : args){
            System.out.println(s);
        }

        // for loop to iterate and print all characters in a string, equivalent to foreach
        for (char c : name.toCharArray()) {
            System.out.println(c);
        }

        //continue and break

        int[] numbers = { 10, 20, 30, 40, 50, 60, 70 };
        int sum = 0;
        for (int x : numbers) {
            if (x == 30) {
                continue;
            }
            sum += x;
            if (sum > 100) {
                break;
            }
            System.out.println(x);
        }
        System.out.println("sum: " + sum);

        int sum1 = 0;
        for (int i = 1; i < 100; i++) {
         sum1 += i;
        }
        System.out.println("Suma 1 este " + sum1);

        //Calculate the sum of the first 100 numbers higher than 0 --> MAX_SIZE = 100
        int sum2 = 0;
        for (int i = 1; i <= MAX_SIZE ; i++) {
            sum2 += i;
        }
        System.out.println("Suma 2 este " + sum2);
        System.out.println("suma 2 este " + (MAX_SIZE * (MAX_SIZE + 1))/ 2); //Gauss formula

        //Display all the prime numbers lower than 1000
        final int MAX_NUMBER = 1000;
        int countPrime = 0;
        for (int i = 2; i < MAX_NUMBER ; i++) {
            // i is the current number we test if it is prime
            boolean isPrime = true;
            for (int j = 2; j < i / 2 ; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println("Number " + i + " is prime");
                countPrime++;
            }
                else {
                    System.out.println("Number " + i + " is even");
                }

        }
        System.out.println("Total number of primes are " + countPrime);

    }
}
