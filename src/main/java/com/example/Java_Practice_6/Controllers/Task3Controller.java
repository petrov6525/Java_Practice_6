package com.example.Java_Practice_6.Controllers;

import com.example.Java_Practice_6.Helpers.ArrayHelper;
import com.example.Java_Practice_6.Helpers.FileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class Task3Controller {
    @GetMapping("/task3")
    public String index (Model model) {
        return "task3";
    }

    @PostMapping("/post-task-3")
    public String task1(String file_path, Model model) {

        AtomicReference<AtomicIntegerArray> pairs = new AtomicReference<>(new AtomicIntegerArray(new int[]{}));
        AtomicReference<AtomicIntegerArray> nonePairs = new AtomicReference<>(new AtomicIntegerArray(new int[]{}));

        String content = FileHelper.getFileContent(file_path);
        int[] array = ArrayHelper.parseFile(file_path);

        Thread findPairs = new Thread(()->{
            pairs.set(new AtomicIntegerArray(ArrayHelper.getPairs(array)));
            FileHelper.rewriteFile("pairs.txt", pairs.toString());
        });

        Thread findNonePairs = new Thread(()->{
           nonePairs.set(new AtomicIntegerArray(ArrayHelper.getNonePairs(array)));
            FileHelper.rewriteFile("none_pairs.txt", nonePairs.toString());
        });

        findPairs.start();
        findNonePairs.start();

        try {
            findPairs.join();
            findNonePairs.join();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        model.addAttribute("pairs", pairs.get().length());
        model.addAttribute("nonePairs", nonePairs.get().length());
        model.addAttribute("array", ArrayHelper.ToString(array));

        return "task3";
    }
}
