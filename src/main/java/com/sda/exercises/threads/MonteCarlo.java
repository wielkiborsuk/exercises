package com.sda.exercises.threads;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MonteCarlo {

    ExecutorService es = Executors.newFixedThreadPool(10);
    private int hitCount = 0;

    synchronized private void hitInc() {
        hitCount++;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        MonteCarlo m = new MonteCarlo();
        System.out.println(m.monteCarlo(10000000));

        System.out.println((System.currentTimeMillis() - start)/1000.0);
        m.es.shutdownNow();
    }

    public double monteCarlo(long iterations) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = IntStream.range(0, 10)
                .mapToObj(n -> es.submit(() -> getHitCount(iterations)))
                .collect(Collectors.toList());

        int count = 0;
        for (Future<Integer> f : futures) {
            count += f.get();
        }

        return 4.0 * count / iterations / 10;
    }

    private Integer getHitCount(long iterations) {
        Integer count = 0;
        Random random = new Random();
        for (long i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            // !!! generating with Math.random() forced threads to wait for each other
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                count++;
            }
        }
        return count;
    }
}
