package com.base.chapter3.arrays;

import java.util.Arrays;
import java.util.Random;

public class MainRandom {
    public static void main(String[] args) {
        Random random = new Random();

        random.setSeed(System.currentTimeMillis());

        int[] data = new int[100];

        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }

        int[] copy = Arrays.copyOf(data, data.length);
        Arrays.sort(data);

        System.out.println(data.toString());
    }
}
