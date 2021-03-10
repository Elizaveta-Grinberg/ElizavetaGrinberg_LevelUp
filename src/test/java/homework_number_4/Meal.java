package homework_number_4;

import homework_number_4.products.Product;

public class Meal extends Product implements AddingProduct {

    protected String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    protected Meal(String name) {
        this.name = name;
    }

    @Override
    public int salt(int spoons) {
        System.out.println(spoons + " spoons of salt added");
        return spoons;
    }

    @Override
    public int garlic(int value) {
        System.out.println(value + " pieces of garlic added");
        return value;
    }

    @Override
    public int water(int liter) {
        System.out.println(liter + " liter of water added");
        return liter;
    }

    @Override
    public int oil(int spoons) {
        System.out.println(spoons + " spoons of oil added");
        return spoons;
    }

    @Override
    public Product add(int value) {

        return null;
    }

    public void cook() {
        System.out.println(getName() + " is ready for eat");
    }

}
