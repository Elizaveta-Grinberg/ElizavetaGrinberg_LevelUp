package homework_number_4.products;

import homework_number_4.Calories;

import java.util.Objects;

public class Groats extends Product implements Calories {

    private double kkal;
    private final boolean vegan = true;

    public Groats(String name, int amount, String colour) {
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
        return "Groats{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", gramm=" + gramm +
                ", kkal=" + kkal +
                ", amount=" + amount +
                ", vegan=" + vegan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Groats groats = (Groats) o;
        return Double.compare(groats.kkal, kkal) == 0 &&
                vegan == groats.vegan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kkal, vegan);
    }
}
