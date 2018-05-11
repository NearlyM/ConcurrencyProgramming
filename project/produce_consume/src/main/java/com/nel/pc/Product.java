package com.nel.pc;

/**
 * Description :
 * CreateTime : 2018/5/11 14:02
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class Product {
    private float value;

    public Product(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                " value=" + value +
                '}';
    }
}
