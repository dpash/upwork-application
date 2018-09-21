package com.davidpashley.upwork;

import java.io.PrintStream;

public class StepOne {

    public void run(int max, PrintStream out) {

    }

    public void run(int max) {
        run(max, System.out);
    }

    public int main(String... args) {
        int max = args.length > 0 ? Integer.valueOf(args[0]) : 20;

        var stepOne = new StepOne();
        stepOne.run(max);
        return 0;
    }
}
