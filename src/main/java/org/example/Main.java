package org.example;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        JSONObject json = (JSONObject) readJSON(".\\jsonFiles\\stats.json");
        String name = (String) json.get("name");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = input.nextLine();
        json.put("name", name);
        System.out.println(name);




        FileWriter fileWriter = new FileWriter(".\\jsonFiles\\stats.json");
        fileWriter.write(json.toJSONString());
        fileWriter.flush();
        fileWriter.close();





    }

    public static Object readJSON(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        return parser.parse(reader);

    }
}



