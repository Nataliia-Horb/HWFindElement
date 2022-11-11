package org.example;

import lombok.Data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] mas = new Integer[]{6, 1, 2, 5, 31, 3, 1, 10, 24, 1, 30, 4};
        findThirdMin(mas);

        String[] mas1 = new String[]{"Petia", "Vasia", "Lola", "Tim", "Albert", "Ed", "Barbara", "Denis"};
        findThirdMin(mas1);

        Person[] mas2 = new Person[]{new Person("Petia", 44), new Person("Vasia", 29),
                new Person("Lola", 12), new Person("Ivan", 18), new Person("Tim", 15)};
        findThirdMin(mas2);
    }


    public static <T extends Comparable<T>> T findThirdMin(T[] mas) {
        List<T> results = sortErstThreeValues(mas);
        if (results != null) {
            if (mas.length > 3) {
                for (int i = 3; i < mas.length; i++) {
                    for (int j = 0; j < results.size(); j++) {
                        if (mas[i].compareTo(results.get(j)) <= 0) {
                            results.set(j, mas[i]);
                            j = results.size();
                        }
                    }
                }
            }
            System.out.println("Value of the third minimum element in the array is: " + results.get(2));
            return results.get(2);
        }
        System.out.println("Value of the third minimum element in the array was not found");
        return null;
    }


    public static <T extends Comparable<T>> List sortErstThreeValues(T[] mas) {
        if (mas.length < 3) {
            System.out.println("There are no 2, 3 elements in the array");
            return null;
        } else {
            if (mas[1].compareTo(mas[0]) > 0 && mas[2].compareTo(mas[0]) > 0) {
                return findErstThreeValues(mas[0], mas[1], mas[2]);
            } else if (mas[2].compareTo(mas[1]) > 0 && mas[0].compareTo(mas[1]) > 0) {
                return findErstThreeValues(mas[1], mas[0], mas[2]);
            } else {
                return findErstThreeValues(mas[2], mas[0], mas[1]);
            }
        }
    }

    public static <T extends Comparable<T>> List findErstThreeValues(T val0, T val1, T val2) {
        List list = new ArrayList<T>();
        list.add(val0);
        if (val2.compareTo(val1) > 0) {
            list.add(val1);
            list.add(val2);
        } else {
            list.add(val2);
            list.add(val1);
        }
        return list;
    }
}

@Data
class Person implements Comparable {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return ((Person) o).getAge() - this.age;
    }
}