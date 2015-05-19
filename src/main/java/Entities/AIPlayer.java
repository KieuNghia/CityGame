package Entities;


import Game.Game;

import java.util.Iterator;


public class AIPlayer extends Player {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AIPlayer(String name) {
        this.name = name;
    }

    @Override
    public boolean move() {

    char letter = Game.getFirstLetter();
        Iterator<String> cityIterator = Game.getCitiesList().iterator();
        while (cityIterator.hasNext())/*(String city: Game.getCitiesList())*/{
            String city = cityIterator.next();
            if(Character.toUpperCase(letter) == Character.toUpperCase(city.charAt(0)) ){
                Game.setCurrentWord(city);
                Game.setFirstLetter(city.charAt(city.length() - 1));
                Game.getCitiesList().remove(Game.getCitiesList().indexOf(city));
                return true;

            }
        }

        return false;


    }
}
