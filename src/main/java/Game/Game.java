package Game;

import Entities.AIPlayer;
import Entities.Player;
import Entities.RealPlayer;
import ParseFactory.FactoryBuilder;

import java.util.*;

public class Game {

    private static List<String> citiesList;

    private static char firstLetter;
    private static String currentWord;
    private static String winner;

    private static LinkedList<Player> playersList = new LinkedList<>();

    public Game() {

        setCitiesList(new FactoryBuilder().createCitiesBuilder("EXEL"));


    }

    public static String getWinner() {
        return winner;
    }

    public static void setWinner(String winner) {
        Game.winner = winner;
    }

    public static List<String> getCitiesList() {
        return citiesList;
    }

    public static void setCitiesList(List citiesList) {
        Game.citiesList = citiesList;
    }

    public static LinkedList<Player> getPlayersList() {
        return playersList;
    }

    public static void setPlayersList(LinkedList<Player> playersList) {
        Game.playersList = playersList;
    }

    public static String getCurrentWord() {
        return currentWord;
    }

    public static void setCurrentWord(String currentWord) {
        Game.currentWord = currentWord;
    }


    public static char getFirstLetter() {
        return firstLetter;
    }

    public static void setFirstLetter(char firstLetter) {
        Game.firstLetter = firstLetter;
    }


    public void start() {

        int realPlayerCount = 0;
        int AIPlayerCount = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter real player count");


        while (!scanner.hasNextInt()) {
            System.out.println("Not a number");
            scanner.next();

        }
        realPlayerCount = scanner.nextInt();


        System.out.println("Enter AI player count");


        while (!scanner.hasNextInt())

        {
            System.out.println("Not a number");
            scanner.next();

        }


        AIPlayerCount = scanner.nextInt();


        setPlayersList(realPlayerCount, AIPlayerCount);

        firstLetter = 'A';
        System.out.println("First Letter = " + firstLetter);

        while ( getPlayersList().size() != 1) {

            for (Iterator<Player> playerIterator = getPlayersList().iterator(); playerIterator.hasNext(); ) {/*Player player : playersList)*/
                {
                    Player player = playerIterator.next();
                    if (player instanceof RealPlayer) {

                        if (((RealPlayer) player).move()) {

                            System.out.println(((RealPlayer) player).getName() + " inserted " + getCurrentWord());

                        } else {
                            System.out.println(((RealPlayer) player).getName() + " removed from game");
                            playerIterator.remove();
                            continue;

                        }

                    }
                    if (player instanceof AIPlayer) {


                        if (((AIPlayer) player).move()) {

                            System.out.println(((AIPlayer) player).getName() + " inserted " + getCurrentWord());


                        } else {
                            System.out.println(((AIPlayer) player).getName() + " removed from game");
                            playerIterator.remove();                            
                            continue;


                        }
                    } else {
                        continue;
                    }


                }


            }




        }
        checkWinner();
    }


    public static void checkWinner() {

        Player winner = playersList.getFirst();
        String winnerString;
        if (winner instanceof RealPlayer) {
            winnerString = ((RealPlayer) winner).getName();


        } else {
            winnerString = ((AIPlayer) winner).getName();
        }

        System.out.println("Winner is " + winnerString);
    }


    public static void setPlayersList(int real, int AI) {

        for (int i = 0; i < real; i++) {
            try {
                getPlayersList().add(new RealPlayer("RealPlayer " + i));

            } catch (NullPointerException e) {

                System.out.println("Null pointer in setPlayersListREAL");

            }
        }


        for (int i = 0; i < AI; i++) {
            try {
                getPlayersList().add(new AIPlayer("AIPlayer " + i));

            } catch (NullPointerException e) {

                System.out.println("Null pointer in setPlayersListAI");

            }
        }

    }
}
