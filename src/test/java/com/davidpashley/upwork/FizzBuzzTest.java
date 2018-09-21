package com.davidpashley.upwork;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FizzBuzzTest {

    @Test
    void testStepOne() throws IOException {
        String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";

        var stepOne = new StepOne();

        try (var os = new ByteArrayOutputStream();
             var out = new PrintStream(os, false, UTF_8)) {
            stepOne.run(20, out);

            var actual = os.toString(UTF_8);
            assertThat(actual, is(expected));
        }
    }

    @Test
    void testStepTwo() throws IOException {
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";

        var stepTwo = new StepTwo();

        try (var os = new ByteArrayOutputStream();
             var out = new PrintStream(os, false, UTF_8)) {
            stepTwo.run(20, out);

            var actual = os.toString(UTF_8);
            assertThat(actual, is(expected));
        }
    }

    @Test
    void testStepThree() throws IOException {
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz\n"
                + "fizz: 4\n"
                + "buzz: 3\n"
                + "fizzbuzz: 1\n"
                + "lucky: 2\n"
                + "integer: 10\n";

        var stepThree = new StepThree();

        try (var os = new ByteArrayOutputStream();
             var out = new PrintStream(os, false, UTF_8)) {
            stepThree.run(20, out);

            var actual = os.toString(UTF_8);
            assertThat(actual, is(expected));
        }
    }

    @Test
    void testStepThreeZeroCount() throws IOException {
        String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz\n"
                + "fizz: 3\n"
                + "buzz: 2\n"
                + "fizzbuzz: 0\n"
                + "lucky: 1\n"
                + "integer: 6\n";

        var stepThree = new StepThree();

        try (var os = new ByteArrayOutputStream();
             var out = new PrintStream(os, false, UTF_8)) {
            stepThree.run(12, out);

            var actual = os.toString(UTF_8);
            assertThat(actual, is(expected));
        }
    }

}

