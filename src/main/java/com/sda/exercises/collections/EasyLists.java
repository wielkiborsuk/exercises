package com.sda.exercises.collections;

import java.util.*;

public class EasyLists {
    public static void main(String[] args) {

        words();
        uniqueWords();
        sortedWords();
        sortedUniqueWords();
    }

    static void words() {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        String line = sc.nextLine();

        while(!"-".equals(line)) {
            words.add(line);
            line = sc.nextLine();
        }

        System.out.println(words);
    }

    static void uniqueWords() {
        Scanner sc = new Scanner(System.in);
        Set<String> words = new HashSet<String>();
        String line = sc.nextLine();

        while(!"-".equals(line)) {
            words.add(line);
            line = sc.nextLine();
        }

        System.out.println(words);
    }

    static void sortedWords() {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        String line = sc.nextLine();

        while(!"-".equals(line)) {
            words.add(line);
            line = sc.nextLine();
        }

        Collections.sort(words);
        System.out.println(words);
    }

    static void sortedUniqueWords() {
        Scanner sc = new Scanner(System.in);
        Set<String> words = new TreeSet<String>();
        String line = sc.nextLine();

        while(!"-".equals(line)) {
            words.add(line);
            line = sc.nextLine();
        }

        System.out.println(words);
    }
}
