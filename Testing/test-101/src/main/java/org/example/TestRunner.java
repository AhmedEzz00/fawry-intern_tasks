package org.example;

public class TestRunner {

    int total, failed, succeeded;

    public void test(String name, Runnable task) {
        try {
            task.run();
            succeeded++;
        } catch (Exception ex) {
            failed++;
            System.out.println("Test " + name + " failed: " + ex.getMessage());
        }
        total++;
    }

    void printSummary() {
        System.out.println("Testing completed for "
                + total + " tests "
                + succeeded + " test succeeded, "
                + failed + " test failed");
    }

}
