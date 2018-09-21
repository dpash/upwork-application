package com.davidpashley.upwork;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class StepThree {

    /* This method takes a PrintStream as an input so that we can grab the
     * output in unit tests. The public run(int) method uses System.out as a
     * default.
     */
    void run(int max, PrintStream out) {
        var counts = new HashMap<String, AtomicInteger>();
        IntStream.rangeClosed(1, max)
                .forEach(i -> {
                    if (i % 10 == 3) {
                        out.print("lucky");
                        incrementCount(counts, "lucky");
                    } else if (i % 15 == 0) {
                        out.print("fizzbuzz");
                        incrementCount(counts, "fizzbuzz");
                    } else if (i % 5 == 0) {
                        out.print("buzz");
                        incrementCount(counts, "buzz");
                    } else if (i % 3 == 0) {
                        out.print("fizz");
                        incrementCount(counts, "fizz");
                    } else {
                        out.print(i);
                        incrementCount(counts, "integer");
                    }
                    if (i != max) {
                        out.print(" ");
                    }
                });
        out.println();
        for (var key : List.of("fizz", "buzz", "fizzbuzz", "lucky", "integer")) {
            out.printf("%s: %d\n", key, counts.getOrDefault(key, new AtomicInteger(0)).get());
        }


    }

    private int incrementCount(HashMap<String, AtomicInteger> counts, String key) {
        return counts.computeIfAbsent(key, k -> new AtomicInteger(0)).incrementAndGet();
    }

    /**
     * Output to standard out a list of numbers from 1 to @{code max}, transforming
     * the number using the following rules:
     *
     * * If the number is divisible by three, replace it with 'fizz'
     * * If the number is divisible by five, replace it with 'buzz'
     * * If the number is divisible by three and five, replace it with 'fizzbuzz'
     * * If the number contains a three, replace it with 'lucky'. This overrides
     *   any existing behaviour
     *
     *  At the end of the output, a summary is printed of the number of times
     *   each option wasoutput
     * @param max the maximum number to output
     */
    public void run(int max) {
        run(max, System.out);
    }

    public static void main(String... args) {
        int max = args.length > 0 ? Integer.valueOf(args[0]) : 20;

        var stepThree = new StepThree();
        stepThree.run(max);
    }
}
