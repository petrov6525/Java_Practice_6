package com.example.Java_Practice_6.Controllers;

import com.example.Java_Practice_6.Helpers.FileHelper;
import com.example.Java_Practice_6.Helpers.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Task4Controller {
    @GetMapping("/task4")
    public String index (Model model) {
        return "task4";
    }

    @PostMapping("/post-task-4")
    public String task1(String file_path, String search_word, Model model) {


        String content = FileHelper.getFileContent(file_path);
        AtomicInteger count = new AtomicInteger();

        Thread findWord = new Thread(()->{
            count.set(StringHelper.getWordCountInContent(content, search_word));
        });

        findWord.start();

        try {
            findWord.join();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        model.addAttribute("content", content);
        model.addAttribute("searchWord", search_word);
        model.addAttribute("count", count);

        return "task4";
    }
}
