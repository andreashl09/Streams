package de.example.streams_intro;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(
                1, 2, -5, 6, 8, 2, -4, 6, 3, 3, 3, 3, 21, 6, 8, -12, 68));

        List<String> stringList = new ArrayList<>(Arrays.asList(
                "programmieren", "java", "funktionale programmierung", "grundlagen", "entwurfsmuster"
        ));

        // Filter alle geraden Zahlen aus der Liste
        List<Integer> evenNumbers = integerList.stream()
                .filter((i) -> i % 2 == 0)
                .toList();

        System.out.println("Gerade Zahlen:" + evenNumbers);

        // Wandele alle Zeichenketten in der Liste in Großbuchstaben um
        List<String> uppercaseStrings = (List<String>) stringList.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Uppercase:" + uppercaseStrings);

        // Berechne die Summe aller Zahlen in der Liste
        int result = integerList.stream()
                .mapToInt(i -> i)
                .sum();

        System.out.println("Summe aller Zahlen" + result);

        // Duplikate aus einer Liste entfernen
        List<Integer> removeDuplicates = integerList.stream()
                .distinct()
                .toList();

        System.out.println(removeDuplicates);

        // Durchschnitt einer Liste von Zahlen berechnen
        var average = integerList.stream()
                .mapToInt(i -> i)
                .average();

        System.out.println(average);

        // Zeichenketten nach Länge sortieren

        List<String> sortListByStringLength = stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();

        System.out.println(sortListByStringLength);
    }
}
