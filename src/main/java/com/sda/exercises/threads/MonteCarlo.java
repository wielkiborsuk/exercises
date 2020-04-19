package com.sda.exercises.threads;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MonteCarlo {

    private static double hitSum = 0;
    private static long iterationSum = 0;

    synchronized private static void addValues(double hits, long iterations) {
        hitSum += hits;
        iterationSum += iterations;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println(monteCarlo(10000000));
        System.out.println("seconds passed: " + (System.currentTimeMillis()-start)/1000.0);

        start = System.currentTimeMillis();
        System.out.println(parallelMonteCarlo(10, 1000000));
        System.out.println("seconds passed: " + (System.currentTimeMillis()-start)/1000.0);
    }

    public static double monteCarlo(long iterations) {
        int hitCount = 0;
        for (long i = 0; i < iterations; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                hitCount++;
            }
        }
        return 4.0 * hitCount / iterations;
    }

    public static double parallelMonteCarlo(int threads, long iterations) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(threads);
        for (int i=0; i<threads; i++) {
            es.execute(() -> {
                monteCarloThread(iterations);
            });
        }
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        return 4.0 * hitSum / iterationSum;
    }

    private static void monteCarloThread(long iterations) {
        Random random = new Random();
        long hitCount = 0;
        for (long i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                hitCount++;
            }
        }
        addValues(hitCount, iterations);
    }
}
