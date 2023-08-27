package com.example.Java_Practice_6.Helpers;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayHelper {

    public static int getMax (int[] array) {
        int max = array[0];

        for(int item: array) {
            if(item > max) {
                max = item;
            }
        }

        return max;
    }

    public static int getMin(int[] array) {
        int min = array[0];

        for(int item: array) {
            if(item < min) {
                min = item;
            }
        }

        return min;
    }

    public static Object ToString(int[] array) {
        StringBuilder text = new StringBuilder();

        for (int item : array) {
            text.append(" ");
            text.append(String.valueOf(item));
        }

        return text.toString();
    }

    public static int findSum(int[] array) {
        int sum = 0;

        for(int item: array) {
            sum += item;
        }

        return sum;
    }

    public static double findAvg(int[] array) {
        return (double) findSum(array) / array.length;
    }

    public static int[] parseFile(String filePath) {

        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbers.add(number);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] numbersArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numbersArray[i] = numbers.get(i);
        }

        return toArray(numbers);
    }

    public static int[] toArray(ArrayList<Integer> list) {
        int[] numbersArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            numbersArray[i] = list.get(i);
        }

        return numbersArray;
    }


    public static int[] getPairs(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int item : array) {
            if (item % 2 == 0) {
                list.add(item);
            }
        }

        return toArray(list);
    }

    public static int[] getNonePairs(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int item : array) {
            if (item % 2 != 0) {
                list.add(item);
            }
        }

        return toArray(list);
    }
}
