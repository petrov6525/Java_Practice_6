package com.example.Java_Practice_6.Controllers;

import com.example.Java_Practice_6.Helpers.ArrayHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Task1Controller {
    @GetMapping("/task1")
    public String index (Model model) {
        return "task1";
    }

    @PostMapping("/post-task-1")
    public String task1(int[] array, Model model) {

        AtomicInteger max = new AtomicInteger(-1);
        AtomicInteger min = new AtomicInteger(-1);

        Thread findMax = new Thread(()->{
            max.set(ArrayHelper.getMax(array));
        });

        Thread findMin = new Thread(()->{
           min.set(ArrayHelper.getMin(array));
        });

        findMax.start();
        findMin.start();

        try {
            findMax.join();
            findMin.join();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(max);
        System.out.println(min);

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("array", ArrayHelper.ToString(array));

        return "task1";
    }
}
