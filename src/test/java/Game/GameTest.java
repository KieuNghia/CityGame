package Game;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GameTest {


    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("reportsLog");
    Game game;

    @DataProvider
    public Object[][] dpSetPlayerMethod(){
        return new Object[][]{
                new Object[]{1,3},new Object[]{2,4}, new Object[]{3,3}};

    }

    @BeforeClass
    public void beforeClass(){

        game = new Game();
        log.trace("Game created");



    }

    @Test(description = "Check setPlayer method", dataProvider = "dpSetPlayerMethod")
    public void setPlayerTest(Integer r, Integer a){
        game.setPlayersList(r, a);
        Assert.assertEquals(game.getPlayersList().size(), r + a);
        game.getPlayersList().clear();

    }





}
