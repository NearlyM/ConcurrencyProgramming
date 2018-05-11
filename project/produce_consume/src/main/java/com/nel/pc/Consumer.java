package com.nel.pc;

import java.util.List;

/**
 * Description :
 * CreateTime : 2018/5/11 14:01
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class Consumer implements Runnable {

    private List<Product> mProducts;

    public Consumer(List<Product> products) {
        this.mProducts = products;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                Product data = null;
                synchronized (mProducts) {
                    if (mProducts.size() == 0) {
                        mProducts.wait();
                        mProducts.notifyAll();
                    }
                    data = mProducts.remove(0);
                }
                System.out.println(Thread.currentThread().getId() + " consume:" + data.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
