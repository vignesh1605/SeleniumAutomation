package javabasics;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

    public static void main(String[] args) {

        List<Integer> list= new ArrayList<>();
        list.add(12);
        list.add(20);
        System.out.println(list);
        System.out.println(list.get(2));
    }
}
