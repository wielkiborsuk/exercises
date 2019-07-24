package com.sda.exercises;

import java.util.*;

import static java.lang.String.format;

public class EasyMaps {

    public static void main(String[] args) {
//        readUniqueNames();
//        readDuplicateNames();
        readCountries();
    }

    private static void readUniqueNames() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> people = new HashMap<>();
        String[] parts = sc.nextLine().split(" ");

        while(!"0".equals(parts[0])) {
            people.put(parts[0], format("%s %s", parts[1], parts[2]));
            parts = sc.nextLine().split(" ");
        }

        System.out.println(people.get(sc.nextLine()));
    }

    private static void readDuplicateNames() {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> people = new HashMap<>();
        String[] parts = sc.nextLine().split(" ");

        while(!"0".equals(parts[0])) {
            String name = format("%s %s", parts[1], parts[2]);
            if (!people.containsKey(name)) {
                people.put(name, new ArrayList<>());
            }
            people.get(name).add(parts[0]);
            parts = sc.nextLine().split(" ");
        }

        System.out.println(people.get(sc.nextLine()));
    }

    private static void readCountries() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> countries = new HashMap<>();
        String[] parts = sc.nextLine().split(" ");

        while(!"-".equals(parts[0])) {
            countries.put(parts[0], parts[1]);
            parts = sc.nextLine().split(" ");
        }

        System.out.println(countries.get(sc.nextLine()));
        String countryCode = sc.nextLine();
        countries.forEach((key, value) -> {
            if (countryCode.equals(value)) {
                System.out.println(key);
            }
        });
    }

}
