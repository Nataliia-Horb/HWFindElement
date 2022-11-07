package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] mas = new Integer[]{3, 5, 7, 22, 15, 48};
        String[] mas1 = new String[]{"Olena", "Maria", "Serhii", "Vasilii"};
        Object[] mas3 = new Person[]{new Person(
                "Olena", 17), new Person("Maria", 22), new Person("Serhii", 35)};
        findTwoThree(mas);
        findTwoThree(mas1);
        findTwoThree(mas3);
    }

    public static <E> List findTwoThree(E[] mas) {
        if (mas.length >= 3) {
            List list = new ArrayList<E>();
            list.add(mas[1]);
            list.add(mas[2]);
            System.out.println(list);
            return list;
        } else {
            System.out.println("There are no 2, 3 elements in the array");
            return null;
        }
    }
}

class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}