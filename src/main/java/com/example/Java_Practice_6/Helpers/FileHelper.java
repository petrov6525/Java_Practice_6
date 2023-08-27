package com.example.Java_Practice_6.Helpers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHelper {


    public static String getFileContent(String filePath) {

        StringBuilder content = new StringBuilder();
        try(FileReader reader = new FileReader(filePath))
        {

            int c;
            while((c=reader.read())!=-1){

                content.append((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return ex.getMessage();
        }


        return content.toString();
    }

    public static String rewriteFile(String filePath, String content) {
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            writer.write(content);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }

        return getFileContent(filePath);
    }
}
