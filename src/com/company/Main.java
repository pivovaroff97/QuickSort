package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lenght = scanner.nextInt();
        int[] mas = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            int x = scanner.nextInt();
            mas[i] = x;
        }

        int begin = 0;
        int end = mas.length - 1;
        int separator = toSeparate(begin, end, mas);

        quickSort(0, separator - 1, mas);
        quickSort(separator, end, mas);
        for (int i = 0; i < separator; i++) System.out.print(mas[i] + " ");
        for (int i = mas.length - 1; i >= separator; i--) System.out.print(mas[i] + " ");
    }

    public static int toSeparate(int begin, int end, int[] mas) {
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

    public static void quickSort(int begin, int end, int[] mas) {
        if (begin >= end) return;
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
