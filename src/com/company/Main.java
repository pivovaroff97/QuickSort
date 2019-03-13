package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int[] mas = new int[10000];

    public static void main(String[] args) {
        Random generator = new Random();
        for (int i = 0; i < mas.length; i++) {  // создаем массив
            mas[i] = generator.nextInt(10000);
        }
       /* Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        int[] mas = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            int x = scanner.nextInt();
            mas[i] = x;
        }*/

        long startTime = System.currentTimeMillis();
        int begin = 0;
        int end = mas.length - 1;
        //System.out.println(Arrays.toString(mas));
        int separator = toSeparate(begin, end, mas); // номер первого нечетного числа массива

        quickSort(0, separator - 1, mas);
        quickSort(separator, end, mas);
        for (int i = 0; i < separator; i++) System.out.print(mas[i] + " ");
        for (int i = mas.length - 1; i >= separator; i--) System.out.print(mas[i] + " ");

       // System.out.println(Arrays.toString(mas));
        long spentTime = System.currentTimeMillis() - startTime;
        System.out.println();
        System.out.println(spentTime);
    }

    public static int toSeparate(int begin, int end, int[] mas) { //разделение на подмассивы четных и нечетных чисел
        int separator = (begin + end)/2;
        int i = begin;
        int j = end;
        while (i < j) {
            while (mas[i] %2 == 0 && i < separator)
                i++;
            while (mas[j] %2 == 1 && j > separator)
                j--;
            if (i < j) {
                int position = mas[i];
                mas[i] = mas[j];
                mas[j] = position;
                if (i == separator)
                    separator = j;
                else if (j == separator)
                    separator = i;
            }
        }
        if (mas[separator] %2 == 0) return separator+1;
        return separator;
    }

    public static void quickSort(int begin, int end, int[] mas) { // сортировка по возрастанию
        if (begin >= end) return;         // добавлять метку? записать все в одном методе?
        int midValue = (begin + end)/2;
        int i = begin;
        int j = end;
        while (i < j) {
            while (mas[i] <= mas[midValue] && i < midValue)
                i++;
            while (mas[j] >= mas[midValue] && j > midValue)
                j--;
            if (i < j) {
                int position = mas[i];
                mas[i] = mas[j];
                mas[j] = position;
                if (i == midValue)
                    midValue = j;
                else if (j == midValue)
                    midValue = i;
            }
        }
        quickSort(begin, midValue, mas);
        quickSort(midValue + 1, end, mas);
    }
}
