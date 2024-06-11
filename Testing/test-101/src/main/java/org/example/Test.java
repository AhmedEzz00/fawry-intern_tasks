package org.example;

public class Test {

//    static class ExampleRunnable implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println("ExampleRunnable");
//        }
//    }
//
//    static class Example2Runnable implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println("Example2Runnable");
//        }
//    }

    public static void main(String[] args) {

        TestRunner testRunner = new TestRunner();

        testRunner.test("Providing initial value", () -> {
            Accumulator accumulator = new Accumulator();
            int result = accumulator.accumulate(3);

            if (result != 3) {
                throw new RuntimeException("Value should be 3");
            }
        });

        testRunner.test("Providing another value", () -> {
            Accumulator accumulator = new Accumulator();
            accumulator.accumulate(3);
            int result = accumulator.accumulate(4);


            if (result != 7) {
                throw new RuntimeException("Value should be 7");
            }
        });

        testRunner.test("Providing value greater than max", () -> {
            Accumulator accumulator = new Accumulator();
            accumulator.accumulate(7);
            int result = accumulator.accumulate(5);

            if (result != 2) {
                throw new RuntimeException("Value should be 2");
            }
        });

        testRunner.printSummary();
    }

}
