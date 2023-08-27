package com.example.Java_Practice_6.Controllers;

import com.example.Java_Practice_6.Helpers.ArrayHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class Task2Controller {
    @GetMapping("/task2")
    public String index (Model model) {
        return "task2";
    }

    @PostMapping("/post-task-2")
    public String task1(int[] array, Model model) {

        AtomicInteger sum = new AtomicInteger();
        AtomicReference<Double> avg = new AtomicReference<>((double) 0);

        Thread findSum = new Thread(()->{
            sum.set(ArrayHelper.findSum(array));
        });

        Thread findAvg = new Thread(()->{
           avg.set(ArrayHelper.findAvg(array));
        });

        findSum.start();
        findAvg.start();

        try {
            findSum.join();
            findAvg.join();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        model.addAttribute("sum", sum);
        model.addAttribute("avg", avg);
        model.addAttribute("array", ArrayHelper.ToString(array));

        return "task2";
    }
}
