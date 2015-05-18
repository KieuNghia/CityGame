package Entities;

import Game.*;

import java.util.Scanner;


public class RealPlayer extends Player {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealPlayer(String name) {
        this.name = name;
    }

    @Override
    public boolean move() {


        System.out.println("Insert city");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();

        if (Character.toUpperCase(city.charAt(1)) == Character.toUpperCase(Game.getFirstLetter())) {
            if (Game.citiesList.contains(city.toUpperCase())) {
                Game.setCurrentWord(city);
                Game.setFirstLetter(city.charAt(city.length() - 1));
                Game.citiesList.remove(city.toUpperCase());
                return true;


            }

        }

        return false;


    }
}
