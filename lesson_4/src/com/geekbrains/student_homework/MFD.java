package com.geekbrains.student_homework;

public class MFD extends Thread {
    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public void scan() {
        synchronized (mon1) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scan");
        }
    }

    public void print() {
        synchronized (mon2) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("print");
        }
    }

    public void photocopy() {
        synchronized (mon1) {
            synchronized (mon2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("photocopy");
            }
        }
    }
}
