package org.example;

import org.json.JSONObject;
import org.json.JSONString;

import java.io.FileWriter;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JSONObject j = new JSONObject();
        JSONString j = new JSONString;

        j.put("name", "Hukas Maj");


        FileWriter writer =new FileWriter("C:/Users/lukas/Desktop/IDKds/src/main/java/org/example/stats.json");
        writer.write(j.);




    }
}