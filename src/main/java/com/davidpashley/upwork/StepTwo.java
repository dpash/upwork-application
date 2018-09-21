package com.davidpashley.upwork;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class StepTwo {

    /* This method takes a PrintStream as an input so that we can grab the
     * output in unit tests. The public run(int) method uses System.out as a
     * default.
     */
    void run(int max, PrintStream out) {
        IntStream.rangeClosed(1, max)
                .forEach(i -> {
                    if (i % 15 == 0) {
                        out.print("fizzbuzz");
                    } else if (i % 5 == 0) {
                        out.print("buzz");
                    } else if (i % 3 == 0) {
                        out.print("fizz");
                    } else {
                        out.print(i);
                    }
                    if (i != max) {
                        out.print(" ");
                    }
                });

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
     * @param max the maximum number to output
     */
    public void run(int max) {
        run(max, System.out);
    }

    public static void main(String... args) {
        int max = args.length > 0 ? Integer.valueOf(args[0]) : 20;

        var stepTwo = new StepTwo();
        stepTwo.run(max);
    }
}
