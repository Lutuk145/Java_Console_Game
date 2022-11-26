package org.example;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        //vars for running and hp
        int enemy = 20;
        boolean resume = true;
//parsing JSON

        JSONObject json = (JSONObject) readJSON(".\\jsonFiles\\stats.json");


//getting line input anywhere
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));


//converting from JSON to vars
        String name = (String) json.get("name");
        int damage = ((Long) json.getOrDefault("damage", 0)).intValue();
        int health = ((Long) json.getOrDefault("health", 40)).intValue();
        int agility = ((Long) json.getOrDefault("agility", 0)).intValue();


        //creats new save
        if (name == "") {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your name: ");
            name = input.nextLine();
            json.put("name", name);
        }
        System.out.println("Use:");
        System.out.println("f       : To move forward");
        System.out.println("l       : To move left");
        System.out.println("r       : To move right");
        System.out.println("stop    : To stop the game");
        System.out.println("restart : To restart the save");
        System.out.println("stats   : To show your stats");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        for (int r = 0; r < 100; r++) {

        while (resume) {
            //main loop
            String command = reader1.readLine();
            if (command.equals("stop")) {
                System.exit(0);
            }
            if (command.equals("stats")) {//shows you your saved data

                System.out.println("Name: " + name);
                System.out.println("Damage: " + damage);
                System.out.println("Health: " + health);
                System.out.println("Agility: " + agility);
                System.out.println(" ");
                System.out.println("Use:");
                System.out.println("f : To move forward");
                System.out.println("l : To move left");
                System.out.println("r : To move right");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");

            }
            if (command.equals("restart")) {//restarts your save
                System.out.println("Enter your name: ");
                name = reader1.readLine();
                json.put("name", name);
                json.put("damage", 0);
                json.put("health", 40);
                json.put("agility", 0);

                System.out.println("Name: " + name);
                System.out.println("Damage: " + damage);
                System.out.println("Health: " + health);
                System.out.println("Agility: " + agility);
                System.out.println(" ");
                System.out.println("Use:");
                System.out.println("f : To move forward");
                System.out.println("l : To move left");
                System.out.println("r : To move right");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");


            } else if (command.equals("f")) {//you mover  forward
                Random random = new Random();
                int i = random.nextInt(7);
                if (i == 0) {//adds 1 dmg
                    damage = damage + 1;
                    System.out.println("You offered a lumberjack help with moving logs");
                    System.out.println("You have gained 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                } else if (i == 1) {//you fight an enemy
                    enemy = 20;
                    System.out.println("A wild enemy has appeared");
                    System.out.println("Press Enter to continue");
                    resume = false;


                } else if (i == 2) {// you gain 1 agility
                    agility = agility + 1;
                    System.out.println("You went for a run around the village");
                    System.out.println("You have gained 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");

                } else if (i == 3) {// you lose 1 damage
                    damage = damage - 1;
                    System.out.println("You your muscles feel weaker today");
                    System.out.println("You have lost 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                } else if (i == 4) { //you loose 1 agility
                    agility = agility - 1;
                    System.out.println("You tripped on a rock");
                    System.out.println("You have lost 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 5) {//add 5 hp
                    health = health + 5;
                    System.out.println("You feel well rested today");
                    System.out.println("You have gained 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 6){//remove 5 hp
                    health = health - 5;
                    System.out.println("You got infected");
                    System.out.println("You have lost 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }

            } else if (command.equals("r")) {//you mover right
                Random random = new Random();
                int i = random.nextInt(7);
                if (i == 0) {//adds 1 dmg
                    damage = damage + 1;
                    System.out.println("You offered a lumberjack help with moving logs");
                    System.out.println("You have gained 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                } else if (i == 1) {//you fight an enemy
                    enemy = 20;
                    System.out.println("A wild enemy has appeared");
                    System.out.println("Press Enter to continue");
                    resume = false;


                } else if (i == 2) {// you gain 1 agility
                    agility = agility + 1;
                    System.out.println("You went for a run around the village");
                    System.out.println("You have gained 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");

                } else if (i == 3) {// you lose 1 damage
                    damage = damage - 1;
                    System.out.println("You your muscles feel weaker today");
                    System.out.println("You have lost 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                } else if (i == 4) { //you loose 1 agility
                    agility = agility - 1;
                    System.out.println("You tripped on a rock");
                    System.out.println("You have lost 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 5) {//add 5 hp
                    health = health + 5;
                    System.out.println("You feel well rested today");
                    System.out.println("You have gained 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 6){//remove 5 hp
                    health = health - 5;
                    System.out.println("You got infected");
                    System.out.println("You have lost 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }

            } else if (command.equals("l")) {//you move left
                Random random = new Random();
                int i = random.nextInt(7);
                if (i == 0) {//adds 1 dmg
                    damage = damage + 1;
                    System.out.println("You offered a lumberjack help with moving logs");
                    System.out.println("You have gained 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                } else if (i == 1) {//you fight an enemy
                    enemy = 20;
                    System.out.println("A wild enemy has appeared");
                    System.out.println("Press Enter to continue");
                    resume = false;


                } else if (i == 2) {// you gain 1 agility
                    agility = agility + 1;
                    System.out.println("You went for a run around the village");
                    System.out.println("You have gained 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");

                } else if (i == 3) {// you lose 1 damage
                    damage = damage - 1;
                    System.out.println("You your muscles feel weaker today");
                    System.out.println("You have lost 1 damage");
                    System.out.println("Your damage is now: " + damage);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f       : To move forward");
                    System.out.println("l       : To move left");
                    System.out.println("r       : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                } else if (i == 4) { //you loose 1 agility
                    agility = agility - 1;
                    System.out.println("You tripped on a rock");
                    System.out.println("You have lost 1 agility");
                    System.out.println("Your agility is now: " + agility);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 5) {//add 5 hp
                    health = health + 5;
                    System.out.println("You feel well rested today");
                    System.out.println("You have gained 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }else if (i == 6){//remove 5 hp
                    health = health - 5;
                    System.out.println("You got infected");
                    System.out.println("You have lost 5 health points");
                    System.out.println("Your health is now: " + health);
                    System.out.println(" ");
                    System.out.println("Use:");
                    System.out.println("f : To move forward");
                    System.out.println("l : To move left");
                    System.out.println("r : To move right");
                    System.out.println("stop    : To stop the game");
                    System.out.println("restart : To restart the save");
                    System.out.println("stats   : To show your stats");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");


                }

            }
            //game save
            FileWriter fileWriter = new FileWriter(".\\jsonFiles\\stats.json");
            json.put("name", name);
            json.put("damage", damage);
            json.put("health", health);
            json.put("agility", agility);
            fileWriter.write(json.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        }
        while (!resume) {//while in battle
            BufferedReader fight = new BufferedReader(
                    new InputStreamReader(System.in));
            String line = fight.readLine();
            System.out.println("What will you do:");
            System.out.println("1. Attack");
            System.out.println("2. Run");
            System.out.println("3. Heal");


            //battle

            Random healthMinus = new Random();
            int hMinus = healthMinus.nextInt(4) + 1;


            if (line.toLowerCase().equals("attack") || line.equals("1")) {//you attack
                enemy = enemy - 1 - damage;
                health = health - hMinus;
                int tempDmg = damage + 1;
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Your health is now: " + health);
                System.out.println("You have dealt: " + tempDmg + " damage");
                System.out.println("Enemy has " + enemy + " health remaining");
                if (enemy <= 0 || enemy == 0){
                    System.out.println("You have killed the enemy");
                    resume = true;


                }




            } else if (line.toLowerCase().equals("run") || line.equals("2")) {//you try to run

                Random random1 = new Random();
                int run = random1.nextInt(10);
                if (run - agility <= 2) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("You ran away from the enemy");
                } else {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("You weren't able to run from the enemy");
                    health = health - hMinus;
                    System.out.println("You took damage from the enemy");
                    System.out.println("Your health is now : " + health);


                }

            } else if (line.toLowerCase().equals("heal") || line.equals("3")) {// you heal
                health = health + 6;
                health = health - hMinus;
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("Your health is now: " + health);


            }


            }
            //game save
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



    public static String fileLocation = ".\\jsonFiles\\stats.json";
    public static Object readJSON(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        return parser.parse(reader);

    }



}