package de.example.flatmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 34, 7, 5};
        Integer[] arr2 = {78, 34, 34, 7, 51};
        Integer[] arr3 = {5, 2, 4, 6, 9};
        ArrayList<Integer[]> integers = new ArrayList<>(List.of(
                arr1, arr2, arr3
        ));

        // Liste von Listen zu einer einzigen Liste “flach machen”
        List<Integer> integerList = integers.stream()
                .flatMap(Arrays::stream)
                .toList();
        System.out.println(integerList);

        // Zeichenketten in eine Liste von Wörtern aufteilen
        String random = "fruitballs water sun book";

        List<String> individualCcharacterStrings = Stream.of(random)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();
        System.out.println(individualCcharacterStrings);

        // Filtern und flach machen einer Liste von Listen
        integers.stream()
                .flatMap(Arrays::stream)
                .filter(i -> i > 5)
                .forEach(System.out::println);

    }
}
