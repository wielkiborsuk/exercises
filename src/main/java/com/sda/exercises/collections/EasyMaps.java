package com.sda.exercises.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.String.format;

public class EasyMaps {

    public static void main(String[] args) throws IOException {
        readUniqueNames(); // use with "pesele.i.nazwiska.txt" file from resources
//        readDuplicateNames(); // use with "pesele.i.powtorzone.nazwiska.txt" file from resources
//        readCountries(); // use with "kraje.txt" file from resources
    }

    private static void readUniqueNames() throws IOException {
        String fileName = "src/main/resources/input/maps/pesele.i.nazwiska.txt";
        Map<String, String> people = new HashMap<>();

        Files.lines(Paths.get(fileName))
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    people.put(parts[0], format("%s %s", parts[1], parts[2]));
                });

        Scanner sc = new Scanner(System.in);

        System.out.println(people.get(sc.nextLine()));
    }

    private static void readDuplicateNames() throws IOException {
        String fileName = "src/main/resources/input/maps/pesele.i.powtorzone.nazwiska.txt";
        Map<String, List<String>> people = new HashMap<>();

        Files.lines(Paths.get(fileName))
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    String name = format("%s %s", parts[1], parts[2]);
                    if (!people.containsKey(name)) {
                        people.put(name, new ArrayList<>());
                    }
                    people.get(name).add(parts[0]);
                });

        Scanner sc = new Scanner(System.in);

        System.out.println(people.get(sc.nextLine()));
    }

    private static void readCountries() throws IOException {
        String fileName = "src/main/resources/input/maps/kraje.txt";
        Map<String, String> countryToCode = new HashMap<>();
        Map<String, String> codeToCountry = new HashMap<>();

        Files.lines(Paths.get(fileName))
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    countryToCode.put(parts[0], parts[1]);
                    codeToCountry.put(parts[1], parts[0]);
                });
        Scanner sc = new Scanner(System.in);

        System.out.println(countryToCode.get(sc.nextLine()));
        System.out.println(codeToCountry.get(sc.nextLine()));
    }

}
