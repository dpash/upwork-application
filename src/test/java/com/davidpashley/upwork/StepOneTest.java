package com.davidpashley.upwork;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class StepOneTest {

    @Test
    void testStepOne() throws IOException {
        String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";

        var stepOne = new StepOne();

        try (var os = new ByteArrayOutputStream();
             var out = new PrintStream(os)) {
            stepOne.run(20, out);

            var actual = out.toString();
            assertThat(actual, is(expected));
        }
    }

}
