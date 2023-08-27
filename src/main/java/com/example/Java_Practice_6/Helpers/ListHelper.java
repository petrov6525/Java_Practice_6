package com.example.Java_Practice_6.Helpers;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

    public static List<Integer> getListFromInt (int number) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            list.add(i);
        }

        return list;
    }
}
