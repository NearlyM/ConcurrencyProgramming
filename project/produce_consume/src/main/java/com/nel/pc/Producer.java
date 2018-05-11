package com.nel.pc;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<Product> mProducts;
    private int length;

    public Producer(List<Product> producers, int length) {
        this.mProducts = producers;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                Random random = new Random();
                int temp = random.nextInt(100);
                System.out.println(Thread.currentThread().getId() + " product : " + temp);
                Product product = new Product(temp);
                synchronized (mProducts) {
                    if (mProducts.size() >= length) {
                        mProducts.notifyAll();
                        mProducts.wait();
                    } else {
                        mProducts.add(product);
                    }

                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
