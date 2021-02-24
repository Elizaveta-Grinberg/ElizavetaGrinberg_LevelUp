package homework_number_2;

import java.util.Scanner;

public class CalculatorApp {



    public static void main(String[] args) {
        Calculator calc = new Calculator();

        Scanner consoleReader = new Scanner(System.in);
        System.out.println("Enter first value :");
        calc.setFirstValue(consoleReader.nextInt());

        System.out.println("Choose operation: 1) +, 2) -, 3) *, 4) power, 5) factorial, 6) fibonacci");
        calc.getOperation();

    }










}
