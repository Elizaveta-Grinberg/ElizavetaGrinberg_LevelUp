package homework_number3.products;

import homework_number3.Calories;

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
        double result = (kkal * 100) / gramms;
        System.out.println("Amount of kalories in " + getName() + " is: " + result);
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
