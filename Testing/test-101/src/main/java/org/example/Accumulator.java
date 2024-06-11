package org.example;

public class Accumulator {

    private final int MAX_VALUE = 10;

    private int counter;

    public int accumulate(int value) {
        this.counter += value;
        if (counter > MAX_VALUE) {
            counter = counter % MAX_VALUE;
        }
        return this.counter;
    }

}
