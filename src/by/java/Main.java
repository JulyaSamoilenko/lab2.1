package by.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размерность двумерного массива 'n':");
        int n = sc.nextInt();
        while (n < 1) {
            System.out.println("Введена неверная размерность, попробуйте еще раз:");
            n = sc.nextInt();
        }

        System.out.println("Введите размерность двумерного массива 'm':");
        int m = sc.nextInt();
        while (m < 1) {
            System.out.println("Введена неверная размерность, попробуйте еще раз:");
            m = sc.nextInt();
        }

        System.out.println("Сгенерированный массив:");
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new Random().nextInt(10);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        Integer[] b = new Integer[n + m];
        for (int i = 0; i < arr.length; i++) {
            int el = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (Math.abs(el) < Math.abs(arr[i][j])) {
                    el = arr[i][j];
                }
            }
            b[i] = el;
        }

        for (int i = 0; i < m; i++) {
            int el = 0;
            for (int j = 0; j < n; j++) {
                if (Math.abs(el) < Math.abs(arr[j][i])) {
                    el = arr[j][i];
                }
            }
            b[n + i] = el;
        }

        printArr(b);
        Integer[] c = b.clone();
        Arrays.sort(b, Collections.reverseOrder());
        printArr(b);
        sort(c);
        printArr(c);


    }

    private static void printArr(Integer[] a) {
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private static void sort(Integer[] a) {
        System.out.println("---");
        for (int i = 0; i < a.length-1 ; i++) {
            if (a[i + 1] > a[i]) {
                int max = a[i + 1];
                a[i + 1] = a[i];
                a[i] = max;
                printArr(a);
            }
            for (int j = i; j > 0; j--) {
                if (a[j] > a[j - 1]) {
                    int max = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = max;
                    printArr(a);
                } else {
                    break;
                }
            }
        }
        System.out.println("---");
    }
}
