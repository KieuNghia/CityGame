package Game;

import Entities.AIPlayer;
import Entities.Player;
import Entities.RealPlayer;
import ParseFactory.FactoryBuilder;

import java.util.*;

public class Game {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("debugLogger");
    private static List<String> citiesList;
    private static LinkedList<Player> playersList = new LinkedList<>();

    private static char firstLetter;
    private static String currentWord;


    public Game() {

        setCitiesList(new FactoryBuilder().createCitiesBuilder("EXEL"));
        Collections.shuffle(getCitiesList());



    }


    public static List<String> getCitiesList() {
        return citiesList;
    }

    public static void setCitiesList(List citiesList) {
        Game.citiesList = citiesList;
    }

    public  LinkedList<Player> getPlayersList() {
        return playersList;
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
        log.trace("First letter" + firstLetter);
        System.out.println("First Letter = " + firstLetter);

        while (getPlayersList().size() != 1) {

            for (Iterator<Player> playerIterator = getPlayersList().iterator(); playerIterator.hasNext(); ) {/*Player player : playersList)*/
                {
                    Player player = playerIterator.next();
                    if (player instanceof RealPlayer) {

                        if (((RealPlayer) player).move()) {
                            log.info(((RealPlayer) player).getName() + " inserted " + getCurrentWord());
                            System.out.println(((RealPlayer) player).getName() + " inserted " + getCurrentWord());

                        } else {
                            log.info(((RealPlayer) player).getName() + " inserted " + getCurrentWord());
                            log.info(((RealPlayer) player).getName() + "lose, removed from game");
                            System.out.println(((RealPlayer) player).getName() + "lose, removed from game");
                            playerIterator.remove();
                            continue;

                        }

                    }
                    if (player instanceof AIPlayer) {


                        if (((AIPlayer) player).move()) {
                            log.info(((AIPlayer) player).getName() + " inserted " + getCurrentWord());

                            System.out.println(((AIPlayer) player).getName() + " inserted " + getCurrentWord());


                        } else {
                            log.info(((AIPlayer) player).getName() + "lose, removed from game");
                            System.out.println(((AIPlayer) player).getName() + "lose, removed from game");
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


    public  void setPlayersList(int real, int AI) {

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
