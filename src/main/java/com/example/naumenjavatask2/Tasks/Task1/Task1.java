package com.example.naumenjavatask2.Tasks.Task1;


import java.util.Arrays;
import java.util.Random;

public class Task1 {


         int[] list;
        Random r= new Random();

        public Task1(int len) {

            if (len <= 0)
                throw new IllegalArgumentException("Длина массива должна быть больше 0.");

            list=new int[len];
            generateMass(len);

            showInfoAndResult();
        }


    private void showInfoAndResult() {
        System.out.println("Массив: "+ Arrays.toString(list));
        findLastPositive();
    }

    public void generateMass(int len)
        {


            for (int i = 0; i < len; i++) {
                list[i]=r.nextInt();
            }
        }

        public void findLastPositive()
        {
            int res;
            for (int i = list.length-1; i >= 0; i--) {
                if (list[i]>0) {
                    System.out.println("Последний положительный элемент: "+list[i]);
                    System.out.println("Под индексом: "+i);
                    res=list[i];
                    return;
                }
            }
            System.out.println("Положительных элементов нет.");
            //return res;
        }

    public static void main(String[] args) {
        new Task1(100);
    }

}
