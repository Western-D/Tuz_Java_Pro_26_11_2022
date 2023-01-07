package hometask9;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ValueCalculator valueCalculator = new ValueCalculator();
        Thread thread1 = new Thread(valueCalculator);
        Thread thread2 = new Thread(valueCalculator);
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();
        valueCalculator.mergesArrayAndCalculateAndPrintTime();
    }
}
