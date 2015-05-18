package Entities;


import Game.Game;


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

        for(String city: Game.citiesList){
            if(Character.toUpperCase(letter) == Character.toUpperCase(city.charAt(1)) ){
                Game.setCurrentWord(city);
                Game.setFirstLetter(city.charAt(city.length() - 1));
                Game.citiesList.remove(city);
                return true;

            }
        }

        return false;


    }
}
