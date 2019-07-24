package com.sda.exercises;

import org.apache.commons.collections4.bag.TreeBag;

import java.util.*;

import static java.lang.String.format;

public class SmartLists {
    public static void main(String[] args) {

        readWords(new ArrayList<>());
        readWords(new HashSet<>());
        readWords(new TreeBag<>());
        readWords(new TreeSet<>());
    }

    private static void readWords(Collection<String> storage) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while(!"-".equals(line)) {
            storage.add(line);
            line = sc.nextLine();
        }

        storage.forEach(s -> System.out.print(format("%s, ", s)));
        System.out.println();
    }
}
