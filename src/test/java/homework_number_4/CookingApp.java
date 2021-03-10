package homework_number_4;

import homework_number_4.products.Groats;
import homework_number_4.products.Meat;
import homework_number_4.products.Product;
import homework_number_4.products.Vegetable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CookingApp {

    public static void main(String[] args) throws FileNotFoundException {

        Meat beef = new Meat("Beef", 1, "Red");
        beef.countKkal(400, 0);
        Vegetable cabbage = new Vegetable("Cabbage", 1, "Green");
        cabbage.countKkal(150, 300);
        Vegetable carrot = new Vegetable("Carrot", 2, "Orange");
        carrot.countKkal(50, 150);
        Vegetable beetroot = new Vegetable("Beetroot", 3, "Red");
        beetroot.countKkal(80, 400);
        Vegetable onion = new Vegetable("Onion", 2, "White");
        onion.countKkal(70, 100);
        Groats pearl = new Groats("Pearl-Barley", 1, "Gray");
        pearl.countKkal(40, 250);

        Meal borsch = new Meal("Borsch");
        borsch.add(borsch.water(1));
        borsch.add(borsch.oil(3));
        borsch.add(borsch.salt(4));
        borsch.add(borsch.garlic(2));

        List<Product> addProduct = new ArrayList<>();
        addProduct.add(beef);
        addProduct.add(cabbage);
        addProduct.add(carrot);
        addProduct.add(beetroot);
        addProduct(addProduct);

        borsch.cook();

        List<Vegetable> addComponent = new ArrayList<>();
        addComponent.add(cabbage);
        addComponent.add(beetroot);
        addComponent.add(carrot);
        addComponent.add(carrot);
        addComponent.add(carrot);
        addComponent.add(carrot);
        sortVegetables(addComponent);

        try {
            addComponent.get(7);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Index ist greater than list size");
        }

        printVegetableList("C:/Users/elvoroni/Documents/ElizavetaGrinberg_LevelUp");
    }


    private static void sortVegetables(List<Vegetable> vegetableList) {
        System.out.println(vegetableList.size());
        vegetableList.sort(Comparator.comparing(Vegetable::getAmount));
        vegetableList.forEach(System.out::println);

    }

    private static void addProduct(List<Product> productList) {
        System.out.println(productList.size());
        productList.stream().filter(product -> product.getGramm() > 350).forEach(System.out::println);
    }

    private static void printVegetableList(String filePath) throws FileNotFoundException {
        String firstString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            firstString = reader.readLine();
        } catch (IOException e) {
            System.out.println("File not found. Get valid path " + e );
        }
        System.out.println(firstString);
    }
}
