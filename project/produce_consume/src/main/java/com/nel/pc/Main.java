package com.nel.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description :
 * CreateTime : 2018/5/11 14:01
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class Main {

    public static void main(String[] argv) {
        List<Product> queue = new ArrayList<Product>();
        int length = 10;
        Producer p1 = new Producer(queue,length);
        Producer p2 = new Producer(queue,length);
        Producer p3 = new Producer(queue,length);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
//        service.execute(p2);
//        service.execute(p3);
        service.execute(c1);
//        service.execute(c2);
//        service.execute(c3);

    }
}
