package com.sda.exercises.collections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SmartMaps {

    public static void main(String[] args) throws IOException {
        readUniqueNames(); // use with "pesele.i.nazwiska.txt" file from resources
//        readDuplicateNames(); // use with "pesele.i.powtorzone.nazwiska.txt" file from resources
//        readCountries(); // use with "kraje.txt" file from resources
    }

    private static void readUniqueNames() throws IOException {
        String fileName = "src/main/resources/input/maps/pesele.i.nazwiska.txt";
        Map<String, String> people = Files.lines(Paths.get(fileName))
                .map(line -> line.split(" "))
                .collect(Collectors.toMap(parts -> parts[0], parts -> format("%s %s", parts[1], parts[2])));

        Scanner sc = new Scanner(System.in);
        System.out.println(people.get(sc.nextLine()));
    }

    private static void readDuplicateNames() throws IOException {
        String fileName = "src/main/resources/input/maps/pesele.i.pow.nazwiska.txt";
        MultiValuedMap<String, String> people = new ArrayListValuedHashMap<>();

        Files.lines(Paths.get(fileName))
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    String name = format("%s %s", parts[1], parts[2]);
                    people.put(name, parts[0]);
                });

        Scanner sc = new Scanner(System.in);
        System.out.println(people.get(sc.nextLine()));
    }

    private static void readCountries() throws IOException {
        String fileName = "src/main/resources/input/maps/kraje.txt";
        BidiMap<String, String> countries = new TreeBidiMap<>();

        Files.lines(Paths.get(fileName))
                .forEach(line -> {
                    String[] parts = line.split(" ");
                    countries.put(parts[0], parts[1]);
                });

        Scanner sc = new Scanner(System.in);
        System.out.println(countries.get(sc.nextLine()));
        System.out.println(countries.getKey(sc.nextLine()));
    }
}
