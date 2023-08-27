package com.example.Java_Practice_6.Helpers;

import java.util.HashMap;
import java.util.Map;

public class StringHelper {

    public static int getWordCountInContent(String content, String word)
    {
        int count = 0;
        int index = content.indexOf(word);

        while (index != -1) {
            count++;
            index = content.indexOf(word, index + word.length());
        }
        return count;
    }
}
