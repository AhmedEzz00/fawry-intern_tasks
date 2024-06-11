package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {

    Accumulator accumulator = new Accumulator();

    public AccumulatorTest() {
        System.out.println("Accumulator()");
    }

    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach");
    }

    @Test
    void givenEmptyAccumulator_whenAccumulate_thenGetSameValue() {
        // Act
        int result = accumulator.accumulate(3);

        // Assert
        Assertions.assertEquals(3, result);
//        if (result != 3) {
//            throw new RuntimeException("Value should be 3");
//        }
    }


    @Test void givenAccumulatorWithValue_whenAccumulate_thenGetValueAddedToTheOldValue() {
        // Arrange
        accumulator.accumulate(3);

        // Act
        int result = accumulator.accumulate(4);

        // Assert
        Assertions.assertEquals(7, result);
//        if (result != 7) {
//            throw new RuntimeException("Value should be 7");
//        }
    }

    @Test void givenAccumulatorWithValue_whenAccumulate_thenAccumulatorOverFlowsAndGetModulusValue() {
        // Arrange
        accumulator.accumulate(7);

        // Act
        int result = accumulator.accumulate(5);

        // Assert
        Assertions.assertEquals(2, result);
//        if (result != 2) {
//            throw new RuntimeException("Value should be 2");
//        }
    }

}
