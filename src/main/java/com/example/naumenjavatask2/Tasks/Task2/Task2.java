package com.example.naumenjavatask2.Tasks.Task2;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {

    ArrayList<Double> list = new ArrayList<Double>();
    Random r = new Random();


    public Task2(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("Длина массива должна быть больше 0.");
        }
        generateMass(len);
        showInfoAndResult();
    }

    private void showInfoAndResult() {

        System.out.println("Массив: " + list);
        sortSelection();
        System.out.println("Массив: " + list);
    }

    private void sortSelection() {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (list.get(minIndex)<list.get(i)) {
                double temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }

    }

    private void generateMass(int len) {

        for (int i = 0; i < len; i++) {
            list.add(r.nextDouble());
        }
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2(10);
    }
}
