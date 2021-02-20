package homework_number3.products;

import homework_number3.Calories;

import java.util.Objects;

public class Vegetable extends Product implements Calories {

    private double kkal;
    private final boolean vegan = true;

    public Vegetable(String name, int amount, String colour) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.kkal, kkal) == 0 &&
                vegan == vegetable.vegan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kkal, vegan);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", gramm=" + gramm +
                ", kkal=" + kkal +
                ", amount=" + amount +
                ", vegan=" + vegan +
                '}';
    }

}
