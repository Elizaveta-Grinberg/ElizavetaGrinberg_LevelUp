package homework_number_4.generateCollection;

import java.util.*;

public class Collection {


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i) + " Result is mixed");
        }

        Set<Integer> collection = new HashSet<>(list);
        System.out.println(" Collection size " + collection.size());

        System.out.println("==================");
        System.out.println("Size of two collections should be the same. All elements are unique");
        System.out.println(collection.size() == list.size());
        System.out.println("==================");

        List<Integer> list2 = new ArrayList<>();

        for (Integer integer : collection) {
            if ((integer % 2 == 0)) {
                //System.out.println("Number " + integer);
                list2.add(integer);
            }
        }
        System.out.println("Final result for 2 - " + list2.size());

        for (Integer integer : collection) {
            if (integer % 2 == 0 && integer % 3 == 0) {
                //System.out.println("Number 2/3 " + integer);
                list2.add(integer);
            }
            if (integer % 2 == 0 && integer % 5 == 0) {
                //System.out.println("Number 2/5 " + integer);
                list2.add(integer);
            }
            if (integer % 2 == 0 && integer % 7 == 0) {
                //System.out.println("Number 2/7 " + integer);
                list2.add(integer);
            }
            if (integer % 2 == 0 && integer % 3 == 0 && integer % 5 == 0) {
                //System.out.println("Number 2/3/5 " + integer);
                list2.add(integer);
            }
            if (integer % 2 == 0 && integer % 3 == 0 && integer % 5 == 0 && integer % 7 == 0) {
                //System.out.println("Number 2/3/5/7 " + integer);
                list2.add(integer);
            }
        }
        System.out.println("NEW Final result for 2 - " + list2.size());
        list2.removeAll(collection);

        for (Integer integer : collection) {
            if (integer % 3 == 0) {
                //System.out.println("Number " + integer);
                list2.add(integer);
            }
        }
        System.out.println("Final result for 3 - " + list2.size());
        list2.removeAll(collection);

        for (Integer integer : collection) {
            if (integer % 5 == 0) {
                //System.out.println("Number " + integer);
                list2.add(integer);
            }
        }
        System.out.println("Final result for 5 - " + list2.size());
        list2.removeAll(collection);

        for (Integer integer : collection) {
            if (integer % 7 == 0) {
                //System.out.println("Number " + integer);
                list2.add(integer);
            }
        }
        System.out.println("Final result for 7 - " + list2.size());
    }
}
