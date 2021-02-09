package homework_number_2;

import java.util.Scanner;

public class Calculator {

    double firstValue;
    double secondValue;

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public void getOperation() {
        Scanner consoleReader = new Scanner(System.in);
        int userOperation = 0;
        if (consoleReader.hasNextInt()) {
            userOperation = consoleReader.nextInt();
        }

        if(!(userOperation == 5) && !(userOperation == 6)){
            System.out.println("Enter second value :");
            setSecondValue(consoleReader.nextInt());
        }

        switch(userOperation) {
            case 1:
                sum(firstValue, secondValue);
                break;
            case 2:
                subtraction(firstValue, secondValue);
                break;
            case 3:
                multiplication(firstValue, secondValue);
                break;
            case 4:
                power((int) firstValue, (int) secondValue);
                break;
            case 5:
                factorial((int) firstValue);
                break;
            case 6:
                fibonacci((int) firstValue);
                break;
            default:
                System.out.println("Error. Repeat!");
        }
    }

    protected void sum(double firstNumber, double secondNumber){
        double sum = firstNumber + secondNumber;
        System.out.println("Result of operation Sum: " + sum);
    }

    protected void subtraction(double firstNumber, double secondNumber){
        double subtr = firstNumber - secondNumber;
        System.out.println("Result of operation subtraction: " + subtr);
    }

    protected void multiplication(double firstNumber, double secondNumber){
        double mult = firstNumber * secondNumber;
        System.out.println("Result of operation multiplication: " + mult);
    }

    protected void power(int value, int powValue){
        int power = 1;
        for (int i = 1; i <= powValue ; i++) {
            power = power * value;
        }
        System.out.println("Result of operation power: " + power);
    }

    protected int factorial(int value){
        if(value <= 1){
            return 1;
        } else {
            int result = value * factorial(value - 1);
            System.out.println("Result of operation factorial: " + result);
            return result;
        }
    }

    protected void fibonacci(int value){
        int[] arr = new int[value];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr [i - 2];
        }

        for (int j : arr) {
            System.out.println("Result of operation fibonacci: " + j);
        }
    }

}
