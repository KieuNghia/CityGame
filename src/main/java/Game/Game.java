package Game;

import Entities.AIPlayer;
import Entities.Player;
import Entities.RealPlayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    public static ArrayList<String> citiesList;
    private static char firstLetter;
    private static LinkedList<Player> players;

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


    public  void start() {

        int realPlayerCount;
        int AIPlayerCount;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter real player count");

        while (!scanner.hasNextInt() || scanner.nextInt() == 0) {
            System.out.println("Not a number");
            scanner.next();

        }

        realPlayerCount = scanner.nextInt();

        System.out.println("Enter AI player count");

        while (!scanner.hasNextInt() || scanner.nextInt() == 0) {
            System.out.println("Not a number");
            scanner.next();

        }

        AIPlayerCount = scanner.nextInt();

        Game.setPlayers(setPlayersList(realPlayerCount, AIPlayerCount));

        firstLetter = 'A';
        System.out.println("First Letter = " + firstLetter);
        while (players.size() != 1) {

            for (Player player : players) {
                if (player instanceof RealPlayer) {

                    if (((RealPlayer) player).move()) {

                        continue;

                    } else {

                        players.remove(player);
                        continue;

                    }
                } else {

                    if (((AIPlayer) player).move()) {

                        continue;


                    } else {

                        players.remove(player);
                        continue;

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

            players.add(new RealPlayer("RealPlayer " + i));

        }


        for (int i = 0; i < AI; i++) {
            players.add(new AIPlayer("AIPlayer " + i));
        }

        return players;

    }


}
