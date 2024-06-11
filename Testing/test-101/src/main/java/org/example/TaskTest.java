package org.example;

import java.util.Date;

public class TaskTest {


    static class DatePrintingTask implements Task {

        @Override
        public void execute() {
            System.out.println(new Date());
        }
    }

    static class HelloTask implements Task {

        String name;

        public HelloTask(String name) {
            this.name = name;
        }

        @Override
        public void execute() {
            System.out.println("Hello " + name);
        }
    }

    public static void main(String[] args) {

        DatePrintingTask datePrintingTask = new DatePrintingTask();
        HelloTask helloAhmed = new HelloTask("Ahmed");

        executeTask(datePrintingTask);
        executeTask(helloAhmed);
        executeTask(() -> System.out.println("ABC"));


    }

    private static void executeTask(Task task) {
        task.execute();
    }

}
