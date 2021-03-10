package homework_number_4.products;

import homework_number_4.Calories;

public class Meat extends Product implements Calories {

    double kkal;
    boolean vegan = false;

    public Meat(String name, int amount, String colour) {
        super.name = name;
        super.amount = amount;
        super.colour = colour;
    }

    @Override
    public void countKkal(double kkal, double gramms) {
        this.kkal = kkal;
        this.gramm = gramms;

        try {
            double result = (kkal * 100) / gramms;
            if (result == Double.parseDouble(null)) {
                throw new NullPointerException();
            } else {
                System.out.println("Amount of kalories in " + getName() + " is: " + result);
            }
        } catch (ArithmeticException e) {
            System.out.println(e + "Division by zero is prohibited!");
        } catch (NullPointerException e) {
            System.out.println("Processing fail. Got a null response");
        }

    }

    @Override
    public boolean isVegan() {
        return vegan;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", gramm=" + gramm +
                ", kkal=" + kkal +
                ", amount=" + amount +
                ", vegan=" + vegan +
                '}';
    }
}
