package com.sda.exercises.collections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.*;

import static java.lang.String.format;

public class SmartMaps {

    public static void main(String[] args) {
        readUniqueNames(); // use with "pesele.i.nazwiska.txt" file from resources
//        readDuplicateNames(); // use with "pesele.i.powtorzone.nazwiska.txt" file from resources
//        readCountries(); // use with "kraje.txt" file from resources
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
        MultiValuedMap<String, String> people = new ArrayListValuedHashMap<>();
        String[] parts = sc.nextLine().split(" ");

        while(!"0".equals(parts[0])) {
            String name = format("%s %s", parts[1], parts[2]);
            people.put(name, parts[0]);
            parts = sc.nextLine().split(" ");
        }

        System.out.println(people.get(sc.nextLine()));
    }

    private static void readCountries() {
        Scanner sc = new Scanner(System.in);
        BidiMap<String, String> countries = new TreeBidiMap<>();
        String[] parts = sc.nextLine().split(" ");

        while(!"-".equals(parts[0])) {
            countries.put(parts[0], parts[1]);
            parts = sc.nextLine().split(" ");
        }

        System.out.println(countries.get(sc.nextLine()));
        System.out.println(countries.getKey(sc.nextLine()));
    }
}
