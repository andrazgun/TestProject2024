package org.siit.course;

public class Calculator {

//    Implement an arithmetic calculator that takes 3 arguments: the first
//    number, the operation, the second number.
    public static void main(String[] args) {
        if (args.length == 3) {
            double a = Float.parseFloat(args[0]);
            double b = Float.parseFloat(args[2]);
            String operator = args[1];
// implement calculator logic here
            double result = 0;
            switch (operator) {
                case "+": result = a + b;
                    break;
                case "-": result = a - b;
                    break;
                case "*": result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        System.out.println("Divide by ZERO");
                    } else {
                        result = a / b;
                    }
                    break;
                case "%": result = a % b;
                    break;
                default: {
                    System.out.println("Unsupported operator: " + operator);
                }
            }

            System.out.println("Argument #1: " + a);
            System.out.println("Argument #2: " + operator);
            System.out.println("Argument #3: " + b);
            System.out.println("Result is: " + result);
        } else {
            System.err.println("3 args are needed!");
        }

    }

}
