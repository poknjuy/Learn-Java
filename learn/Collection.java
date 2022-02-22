package learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        System.out.println(list.size());

        list.add(null);
        String second = list.get(3);
        System.out.println(second);

        List<Integer> list1 = List.of(1, 2, 5);
        List<String> list2 = List.of("apple", "pear", "banana");
        for (int i = 0; i < list2.size(); i++) {
            String s = list2.get(i);
            System.out.println(s);
        }

        for (Iterator<String> it = list2.iterator(); it.hasNext(); ) {
            String s2 = it.next();
            System.out.println(s2);
        }

        for (String s : list2) {
            System.out.println(s);
        }

        Object[] array = list2.toArray();
        for (Object s : array) {
            System.out.println(s);
        }

        Integer[] array1 = list1.toArray(new Integer[3]);
        for (Integer n : array1) {
            System.out.println(n);
        }

        Number[] array2 = list1.toArray(new Number[3]);
        for (Number n : array2) {
            System.out.println(n);
        }

        Integer[] array3 = list1.toArray(new Integer[list1.size()]);
        Integer[] array4 = list1.toArray(Integer[]::new);

        Integer[] array5 = {1, 2, 3};
        List<Integer> list3 = List.of(array5);
        


    }
}
