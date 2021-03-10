package homework_number_4.products;

import java.util.Objects;

public abstract class Product {

    String name;
    String colour;
    double gramm;
    double kkal;
    int amount;
    boolean vegan;


    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public double getGramm() {
        return gramm;
    }

    public double getKkal() {
        return kkal;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGramm(double gramm) {
        this.gramm = gramm;
    }

    public void setKkal(double kkal) {
        this.kkal = kkal;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.gramm, gramm) == 0 &&
                Double.compare(product.kkal, kkal) == 0 &&
                amount == product.amount &&
                vegan == product.vegan &&
                Objects.equals(name, product.name) &&
                Objects.equals(colour, product.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colour, gramm, kkal, amount, vegan);
    }
}
