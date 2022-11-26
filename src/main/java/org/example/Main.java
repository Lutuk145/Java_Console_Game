package org.example;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean running = true;
        int enemy = 20;


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        JSONObject json = (JSONObject) readJSON(".\\jsonFiles\\stats.json");
        String name = (String) json.get("name");
        Long damage = ((Long) json.getOrDefault("damage", 0)).longValue();
        Long health = ((Long) json.getOrDefault("health", 20)).longValue();
        Long agility = ((Long) json.getOrDefault("agility", 0)).longValue();


        //new saveFile
        if (name == ""){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your name: ");
            name = input.nextLine();
            json.put("name", name);
        }



while (running == true){

    String command = reader.readLine();
    if (command.equals("stats")){
        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Health: " + health);
        System.out.println("Agility: " + agility);
    }else if (command.equals("restart")) {
        System.out.println("Enter your name: ");
        name = reader.readLine();
        json.put("name", name);
        json.put("damage", 0);
        json.put("health", 20);
        json.put("agility", 0);

        System.out.println("Name: " + name);
        System.out.println("Damage: " + damage);
        System.out.println("Health: " + health);
        System.out.println("Agility: " + agility);


    } else if (command.equals("f")) {
        Random random = new Random();
        int i = random.nextInt(5);
        if (i == 0){
            damage = damage + 1;
            System.out.println("You have received damage boost: +1");
            System.out.println("Your damage is now: "+damage);

        } else if (i == 1){

            if (enemy >= 1 || enemy == 1){
                if (command.equals("damage")){
                    Random healthMinus = new Random();
                    int hMinus = healthMinus.nextInt(4) + 1;
                    enemy = enemy - 1 - damage.intValue();
                    health = health - hMinus;
                }

            } else if (enemy <= 0 || enemy == 0) {

            }

        } else if (i == 2){

        }else if (i == 3) {

        }else if (i == 4){

        }
        System.out.println(i);
    } else if (command.equals("r")) {

    } else if (command.equals("l")) {

    }

    FileWriter fileWriter = new FileWriter(".\\jsonFiles\\stats.json");
    json.put("name", name);
    json.put("damage", damage);
    json.put("health", health);
    json.put("agility", agility);
    fileWriter.write(json.toJSONString());
    fileWriter.flush();
    fileWriter.close();

}











    }

    public static Object readJSON(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        return parser.parse(reader);

    }

}



