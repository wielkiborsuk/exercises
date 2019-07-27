package com.sda.exercises.functional;

import org.apache.commons.math3.primes.Primes;

import java.util.stream.IntStream;

public class PrimeSquareSum {

    public static void main(String[] args) {
        System.out.println(squareSum());
    }

    static long squareSum() {
        return IntStream.range(201, 1200)
                .filter(n -> n % 10 == 3)
                .filter(Primes::isPrime)
                .mapToLong(n -> n * n)
                .reduce(0, Long::sum);
    }
}
