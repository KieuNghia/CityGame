package Game;

import Entities.AIPlayer;
import Entities.Player;
import Entities.RealPlayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    public static ArrayList<String> citiesList;
    private static char firstLetter;
    private static String currentWord;
    private static LinkedList<Player> players;

    public static String getCurrentWord() {
        return currentWord;
    }

    public static void setCurrentWord(String currentWord) {
        Game.currentWord = currentWord;
    }

    public static LinkedList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(LinkedList<Player> players) {
        Game.players = players;
    }


    public static char getFirstLetter() {
        return firstLetter;
    }

    public static void setFirstLetter(char firstLetter) {
        Game.firstLetter = firstLetter;
    }


    public void start() {

        int realPlayerCount;
        int AIPlayerCount = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter real player count");


        try {


            while (!scanner.hasNextInt()) {
                System.out.println("Not a number");
                scanner.next();

            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException real player count ");
        }
        realPlayerCount = scanner.nextInt();

        System.out.println("Enter AI player count");


        try {

            while (!scanner.hasNextInt()) {
                System.out.println("Not a number");
                scanner.next();

            }
        } catch (InputMismatchException e) {


            AIPlayerCount = scanner.nextInt();

            System.out.println("InputMismatchException AI player");
        }
        Game.setPlayers(setPlayersList(realPlayerCount, AIPlayerCount));

        firstLetter = 'A';
        System.out.println("First Letter = " + firstLetter);
        while (players.size() != 1) {

            for (Player player : players) {
                if (player instanceof RealPlayer) {

                    if (((RealPlayer) player).move()) {

                        System.out.println(((RealPlayer) player).getName() + " inserted " + getCurrentWord());


                    } else {
                        System.out.println(((RealPlayer) player).getName() + " removed from game");
                        players.remove(player);


                    }
                } else {

                    if (((AIPlayer) player).move()) {

                        System.out.println(((AIPlayer) player).getName() + " inserted " + getCurrentWord());



                    } else {
                        System.out.println(((AIPlayer) player).getName() + " removed from game");
                        players.remove(player);


                    }
                }


            }


        }


        checkWinner();

    }


    public static void checkWinner() {

        Player winner = players.getFirst();
        String winnerString;
        if (winner instanceof RealPlayer) {
            winnerString = ((RealPlayer) winner).getName();


        } else {
            winnerString = ((AIPlayer) winner).getName();
        }

        System.out.println("Winner is " + winnerString);
    }


    public static LinkedList<Player> setPlayersList(int real, int AI) {

        LinkedList<Player> players = null;

        for (int i = 0; i < real; i++) {
            try {
                players.add(new RealPlayer("RealPlayer " + i));

            } catch (NullPointerException e) {

                System.out.println("Null pointer in setPlayersList");

            }
        }


        for (int i = 0; i < AI; i++) {
            try {
                players.add(new AIPlayer("AIPlayer " + i));

            } catch (NullPointerException e) {

                System.out.println("Null pointer in setPlayersList");

            }
        }

        return players;

    }


}
