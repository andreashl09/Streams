package de.example.greet;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Greet> greetList = List.of(
                new Greet("Anna Bauer", 11, true),
                new Greet("Vittorio De-Marzi", 34, false),
                new Greet("Zana Prka", 18, true),
                new Greet("Bob Baumeister", 55, false),
                new Greet("Hugo Maier", 10, false),
                new Greet("Beate Strohmeier", 7, true)
        );


        // Vornamen aller volljährigen Personen in einer Liste
        List<String> firstNameWithAge = greetList.stream()
                .filter((n) -> n.getAlter() >= 18)
                .map(Greet::getFirstname)
                .toList();

        System.out.println(firstNameWithAge);

        // Liste der Nachnamen aller Personen
        List<String> lastName = greetList.stream()
                .map(Greet::getLastname)
                .toList();

        // Durchschnittliche Alter in einem Double
        var averageAge = greetList.stream()
                .mapToDouble(Greet::getAlter)
                .average();


        // Grußformel der Ältesten Person in einer String-Variable speichern

        String greet = greetList.stream()
                .max(Comparator.comparingInt(Greet::getAlter))
                .get()
                .greetMe();

        System.out.println(greet);

        // Grußformel für alle weiblichen Personen in die Konsole ausgeben
        greetList.stream()
                .filter(Greet::isFemale)
                .forEach((n) -> System.out.println(n.greetMe()));
    }
}
