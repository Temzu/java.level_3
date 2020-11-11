package com.geekbrains.student_homework;

public class Main {
    public static volatile char letter = 'A';
    public static Object monitor = new Object();

    public static void main(String[] args) {
        Main main = new Main();
        WaitNotifyThread wnt1 = new WaitNotifyThread(() -> main.printA());
        WaitNotifyThread wnt2 = new WaitNotifyThread(() -> main.printB());
        WaitNotifyThread wnt3 = new WaitNotifyThread(() -> main.printC());

        wnt1.start();
        wnt2.start();
        wnt3.start();

        MFD mfd = new MFD();
        mfd.start();
        Employee employee1 = new Employee(new Runnable() {
            @Override
            public void run() {
                mfd.scan();
            }
        });
        Employee employee2 = new Employee(new Runnable() {
            @Override
            public void run() {
                mfd.photocopy();
            }
        });
        Employee employee3 = new Employee(new Runnable() {
            @Override
            public void run() {
                mfd.scan();
            }
        });
        Employee employee4 = new Employee(new Runnable() {
            @Override
            public void run() {
                mfd.print();
            }
        });
        Employee employee5 = new Employee(new Runnable() {
            @Override
            public void run() {
                mfd.print();
            }
        });
        employee1.start();
        employee2.start();
        employee3.start();
        employee4.start();
        employee5.start();
    }

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (letter != 'A') {
                        monitor.wait();
                    }
                    System.out.print('A');
                    letter = 'B';
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (letter != 'B') {
                        monitor.wait();
                    }
                    System.out.print('B');
                    letter = 'C';
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (letter != 'C') {
                        monitor.wait();
                    }
                    System.out.print('C');
                    letter = 'A';
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
