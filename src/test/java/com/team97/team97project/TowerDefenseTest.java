package com.team97.team97project;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import java.io.FileNotFoundException;

class TowerDefenseTest extends ApplicationTest {

    private TowerDefense td;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        td = new TowerDefense();
        td.start(primaryStage);
    }

    //Milestone 2

    //    @Test
    //    void initializationTest() {
    //        verifyThat("Start", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void secondScreenTest() {
    //        clickOn("Start");
    //        verifyThat("Let's Play!", NodeMatchers.isNotNull());
    //        verifyThat("Name...", NodeMatchers.isNotNull());
    //        verifyThat("Select your difficulty", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testNameEntry() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //
    //        clickOn("Let's Play!");
    //        verifyThat("Please choose a different name.", NodeMatchers.isNotNull());
    //        clickOn("OK");
    //        String s = " ";
    //        clickOn("Name...");
    //        for (int i = 1; i <= 4; i++) {
    //            write(' ');
    //            clickOn("Let's Play!");
    //            verifyThat("Please choose a different name.", NodeMatchers.isNotNull());
    //            clickOn("OK");
    //            clickOn(s);
    //            s = s + " ";
    //        }
    //    }
    //
    //    @Test
    //    void testDifficultyEntry() {
    //        clickOn("Start");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //        verifyThat("Please select a difficulty.", NodeMatchers.isNotNull());
    //        clickOn("OK");
    //
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        Assertions.assertEquals(300, td.getGameMoney());
    //        Assertions.assertEquals(1000, td.getMonumentHealth());
    //
    //        clickOn("EASY");
    //        clickOn("MEDIUM");
    //        Assertions.assertEquals(250, td.getGameMoney());
    //        Assertions.assertEquals(900, td.getMonumentHealth());
    //
    //        clickOn("MEDIUM");
    //        clickOn("HARD");
    //        Assertions.assertEquals(200, td.getGameMoney());
    //        Assertions.assertEquals(800, td.getMonumentHealth());
    //    }
    //
    //    @Test
    //    void testThirdScreen() throws FileNotFoundException {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        verifyThat("Money: 300.0\nMonument Hea
    //        lth: 1000.0\nWave: 0", NodeMatchers.isNotNull());
    //        FileInputStream inputstream = new FileInputStream("images/path.jpg");
    //        Image image = new Image(inputstream);
    //        ImageView imageView = new ImageView(image);
    //        verifyThat(imageView, NodeMatchers.isNotNull());
    //    }
    //
    //    //Milestone 3
    //
    //    @Test
    //    void testTowerMenu() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //
    //        String knifeText =
    //                "Knife Chucker: This tower rapidly throws low-damage knives at the enemy.";
    //        String bombText =
    //                "Grenadier: This tower slowly throws high-damaging explosives at the enemy.";
    //        String sniperText =
    //                "Sniper: This tower slowly but accurately picks o
    //                ff all but the strongest enemies.";
    //        verifyThat(knifeText, NodeMatchers.isNotNull());
    //        verifyThat(bombText, NodeMatchers.isNotNull());
    //        verifyThat(sniperText, NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testTilePattern() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        DefaultMap dMap = new DefaultMap();
    //        TileType[][] map = dMap.getMap();
    //        MapTile[][] tiles = td.getTiles();
    //        for (int colPointer = 0; colPointer < tiles.length; colPointer++) {
    //            for (int rowPointer = 0; rowPointer < tiles[colPointer].length; rowPointer++) {
    //                switch (map[colPointer][rowPointer]) {
    //                case Grass:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: green",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Path:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: brown",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Monument:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: pink",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Tower:
    //                    Assertions.fail();
    //                    break;
    //                default:
    //                }
    //            }
    //        }
    //    }
    //
    //    @Test
    //    void testPlaceOnPath() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][0].getUiButton());
    //
    //        verifyThat("You cannot place a tower in an
    //        occupied location.", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testPlaceKnifeTowerEasy() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][6].getUiButton());
    //        Assertions.assertEquals(290, td.getGameMoney());
    //    }
    //
    //    @Test
    //    void testPlaceTowerOnTower() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[1][1].getUiButton());
    //        clickOn(tiles[1][1].getUiButton());
    //        verifyThat("You cannot place a tower in an oc
    //        cupied location.", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testRunOutOfMoney() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn(
    //                "Sniper: "
    //                        +
    //                        "This tower slowly but accurately p
    //                        icks off all but the strongest enemies."
    //        );
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[1][1].getUiButton());
    //        clickOn(tiles[3][3].getUiButton());
    //        clickOn(tiles[4][4].getUiButton());
    //        clickOn(tiles[6][6].getUiButton());
    //        verifyThat("You can't afford to buy this.", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testPlaceBombTowerEasy() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Grenadier: This tower
    //        slowly throws high-damaging explosives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][6].getUiButton());
    //        Assertions.assertEquals(270, td.getGameMoney());
    //    }
    //
    //    @Test
    //    void testPlaceSniperTowerEasy() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn(
    //                "Sniper: This tower slowly but accuratel
    //                y picks off all but the strongest enemies."
    //        );
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][6].getUiButton());
    //        Assertions.assertEquals(200, td.getGameMoney());
    //    }
    //
    //    @Test
    //    void testPlaceTowerOnMonument() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][10].getUiButton());
    //        verifyThat("You cannot place a tower in an occup
    //        ied location.", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testPlaceKnifeTowerMedium() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("MEDIUM");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Select the tower you would like to purchase");
    //        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
    //        MapTile[][] tiles = td.getTiles();
    //        clickOn(tiles[0][6].getUiButton());
    //        Assertions.assertEquals(235, td.getGameMoney());
    //    }



    // Milestone 4
    //    @Test
    //   void testGameOver() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        //This is an async function
    //        //Must sleep right after it to make sure it completes
    //        Platform.runLater(() -> {
    //            td.damageMonument(1000);
    //        });
    //        sleep(1000);
    //
    //        verifyThat("GAME OVER", NodeMatchers.isNotNull());
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        verifyThat("Quit", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testBasicRestart() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        //This is an async function
    //        //Must sleep right after it to make sure it completes
    //        Platform.runLater(() -> {
    //            td.damageMonument(1000);
    //        });
    //        sleep(1000);
    //
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        clickOn("Main Menu");
    //        verifyThat("Start", NodeMatchers.isNotNull());
    //        clickOn("Start");
    //        verifyThat("Let's Play!", NodeMatchers.isNotNull());
    //        verifyThat("Testing", NodeMatchers.isNotNull());
    //        verifyThat("EASY", NodeMatchers.isNotNull());
    //        clickOn("Let's Play!");
    //        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 0"
    //                + "", NodeMatchers.isNotNull());
    //        DefaultMap dMap = new DefaultMap();
    //        TileType[][] map = dMap.getMap();
    //        MapTile[][] tiles = td.getTiles();
    //        for (int colPointer = 0; colPointer < tiles.length; colPointer++) {
    //            for (int rowPointer = 0; rowPointer < tiles[colPointer].length; rowPointer++) {
    //                switch (map[colPointer][rowPointer]) {
    //                case Grass:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: green",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Path:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: brown",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Monument:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: pink",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Tower:
    //                    Assertions.fail();
    //                    break;
    //                default:
    //                }
    //            }
    //        }
    //    }
    //
    //    @Test
    //    void waveDeathRestart() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("MEDIUM");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        for (int x = 0; x < 5; x++) {
    //            clickOn("Unleash the horde!");
    //            sleep(2000);
    //        }
    //        sleep(5000);
    //
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        clickOn("Main Menu");
    //        verifyThat("Start", NodeMatchers.isNotNull());
    //        clickOn("Start");
    //        verifyThat("Let's Play!", NodeMatchers.isNotNull());
    //        verifyThat("Testing", NodeMatchers.isNotNull());
    //        verifyThat("MEDIUM", NodeMatchers.isNotNull());
    //        clickOn("Let's Play!");
    //        verifyThat("Money: 250.0\nMonument Health: 900.0\nWave: 0"
    //                + "", NodeMatchers.isNotNull());
    //        DefaultMap dMap = new DefaultMap();
    //        TileType[][] map = dMap.getMap();
    //        MapTile[][] tiles = td.getTiles();
    //        for (int colPointer = 0; colPointer < tiles.length; colPointer++) {
    //            for (int rowPointer = 0; rowPointer < tiles[colPointer].length; rowPointer++) {
    //                switch (map[colPointer][rowPointer]) {
    //                case Grass:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: green",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Path:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: brown",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Monument:
    //                    Assertions.assertEquals(
    //                            "-fx-background-color: pink",
    //                            tiles[colPointer][rowPointer].getUiButton().getStyle()
    //                    );
    //                    break;
    //                case Tower:
    //                    Assertions.fail();
    //                    break;
    //                default:
    //                }
    //            }
    //        }
    //    }
    //
    //    @Test
    //    void testEasyEnemyDamage() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Unleash the horde!");
    //        sleep(5000);
    //
    //        verifyThat("Money: 300.0\nMonument Health: 988.0\nWave: 1"
    //                + "", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testMediumEnemyDamage() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("MEDIUM");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Unleash the horde!");
    //        sleep(5000);
    //
    //        verifyThat("Money: 250.0\nMonument Health: 875.0\nWave: 1"
    //                + "", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testHardEnemyDamage() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("HARD");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Unleash the horde!");
    //        sleep(5000);
    //
    //        verifyThat("Money: 200.0\nMonument Health: 763.0\nWave: 1"
    //                + "", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testWavesIncrement() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        clickOn("Unleash the horde!");
    //        sleep(1000);
    //        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 1"
    //                + "", NodeMatchers.isNotNull());
    //        clickOn("Unleash the horde!");
    //        sleep(1000);
    //        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 2"
    //                + "", NodeMatchers.isNotNull());
    //        clickOn("Unleash the horde!");
    //        sleep(1000);
    //        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 3"
    //                + "", NodeMatchers.isNotNull());
    //    }
    //
    //    @Test
    //    void testGameOverEasy() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("EASY");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        for (int x = 0; x < 7; x++) {
    //            clickOn("Unleash the horde!");
    //            sleep(3000);
    //        }
    //        sleep(3000);
    //        verifyThat("GAME OVER", NodeMatchers.isNotNull());
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        verifyThat("Quit", NodeMatchers.isNotNull());
    //
    //        clickOn("Main Menu");
    //    }
    //    @Test
    //    void testGameOverMedium() {
    //        clickOn("Start");
    //        clickOn("Select your difficulty");
    //        clickOn("MEDIUM");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        for (int x = 0; x < 5; x++) {
    //            clickOn("Unleash the horde!");
    //            sleep(3000);
    //        }
    //        sleep(3000);
    //        verifyThat("GAME OVER", NodeMatchers.isNotNull());
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        verifyThat("Quit", NodeMatchers.isNotNull());
    //
    //        clickOn("Main Menu");
    //
    //    }
    //
    //    @Test
    //    void testGameOverHard() {
    //        sleep(1000);
    //        clickOn("Start");
    //        sleep(1000);
    //        clickOn("Select your difficulty");
    //        clickOn("HARD");
    //        clickOn("Name...");
    //        write("Testing");
    //        clickOn("Let's Play!");
    //
    //        for (int x = 0; x < 4; x++) {
    //            clickOn("Unleash the horde!");
    //            sleep(3000);
    //        }
    //        sleep(3000);
    //        verifyThat("GAME OVER", NodeMatchers.isNotNull());
    //        verifyThat("Main Menu", NodeMatchers.isNotNull());
    //        verifyThat("Quit", NodeMatchers.isNotNull());
    //
    //        clickOn("Main Menu");
    //
    //    }

    //Milestone 5
    /*
    @Test
    void testSlowEnemyDamageAndSpeed() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        td.setEnemyTest(1);
        clickOn("Unleash the horde!");
        sleep(5000);
        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 1", NodeMatchers.isNotNull());
        sleep(15000);
        verifyThat(
                "Money: 300.0\n"
                        + "Monument Health: 950.0\n"
                        + "Wave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testFastEnemyDamageAndSpeed() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        td.setEnemyTest(2);
        clickOn("Unleash the horde!");
        sleep(5000);

        verifyThat(
                "Money: 300.0\n"
                        + "Monument Health: 975.0\n"
                        + "Wave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testNormalEnemyDamageAndSpeed() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Unleash the horde!");
        sleep(5000);
        verifyThat("Money: 300.0\nMonument Health: 1000.0\nWave: 1", NodeMatchers.isNotNull());
        sleep(5000);
        verifyThat(
                "Money: 300.0\n"
                        + "Monument Health: 988.0"
                        + "\nWave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testKnifeTowerDamageBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        sleep(2000);

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies = td.getEnemies();
        for (Enemy enemy: enemies) {
            Assertions.assertEquals(4, enemy.getEnemyHealth());
        }
    }

    @Test
    void testBombTowerDamageBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Grenadier: This tower slowly throws high-damaging explosives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        sleep(4000);

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies = td.getEnemies();
        for (Enemy enemy: enemies) {
            System.out.println(enemy.getEnemyHealth());
            Assertions.assertEquals(-21, enemy.getEnemyHealth());
        }
    }

    @Test
    void testSniperTowerDamageBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Sniper: This tower slowly but accurately "
                + "picks off all but the strongest enemies.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        sleep(2000);

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies = td.getEnemies();
        for (Enemy enemy: enemies) {
            Assertions.assertEquals(-496, enemy.getEnemyHealth());
        }
    }
    @Test
    void testKnifeTowerKillingBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][1].getUiButton());
        clickOn(tiles[1][2].getUiButton());
        clickOn(tiles[1][3].getUiButton());
        clickOn(tiles[1][4].getUiButton());

        clickOn("Unleash the horde!");
        sleep(3000);
        verifyThat(
                "Money: 270.0\n"
                        + "Monument Health: 1000.0\n"
                        + "Wave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testBombTowerKillingBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Grenadier: This tower slowly throws high-damaging explosives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        sleep(3000);
        verifyThat(
                "Money: 280.0\n"
                        + "Monument Health: 1000.0\n"
                        + "Wave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testSniperTowerKillingBalloons() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Sniper: This tower slowly but accurately"
                + " picks off all but the strongest enemies.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        sleep(3000);
        verifyThat(
                "Money: 210.0\n"
                        + "Monument Health: 1000.0\n"
                        + "Wave: 1 CLEARED",
                NodeMatchers.isNotNull());
    }

    @Test
    void testMoneyReceivedBackFromKills() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Sniper: This tower slowly but accurately "
                + "picks off all but the strongest enemies.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][6].getUiButton());

        clickOn("Unleash the horde!");
        Assertions.assertEquals(200, td.getGameMoney());
        sleep(3000);
        Assertions.assertEquals(210, td.getGameMoney());
    }
    @Test
    void testChangingImages() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][4].getUiButton());
        clickOn(tiles[2][6].getUiButton());
        clickOn(tiles[3][4].getUiButton());


        clickOn("Unleash the horde!");
        sleep(8000);
        clickOn("Unleash the horde!");

        Assertions.assertEquals(td.getEnemies().get(0).getImagePath(),
                "file:images/Soldier_VERY_DAMAGED_IMAGE.png");

        Assertions.assertEquals(1, 1);
    }
     */
    // Milestone 6
    @Test
    void testNewGameOver() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        Platform.runLater(() -> td.damageMonument(1000));
        sleep(1000);

        verifyThat("GAME OVER", NodeMatchers.isNotNull());
        verifyThat("Main Menu", NodeMatchers.isNotNull());
        verifyThat("Quit", NodeMatchers.isNotNull());
        verifyThat("Waves Completed: -1/" + Constants.FINAL_WAVE, NodeMatchers.isNotNull());
        verifyThat("Enemies Defeated: 0", NodeMatchers.isNotNull());
        verifyThat("Towers Placed: 0", NodeMatchers.isNotNull());
    }

    @Test
    void testVictory() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");

        Platform.runLater(() -> td.forceVictory());
        sleep(1000);

        verifyThat("YOU HAVE DEFEATED THE HORDE!", NodeMatchers.isNotNull());
        verifyThat("Main Menu", NodeMatchers.isNotNull());
        verifyThat("Quit", NodeMatchers.isNotNull());
        verifyThat("Waves Completed: 0/" + Constants.FINAL_WAVE, NodeMatchers.isNotNull());
        verifyThat("Enemies Defeated: 0", NodeMatchers.isNotNull());
        verifyThat("Towers Placed: 0", NodeMatchers.isNotNull());
    }

    @Test
    void testFirstUpgrade() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][1].getUiButton());
        clickOn(tiles[1][1].getUiButton());
        Assertions.assertEquals(2, tiles[1][1].getTower().getTowerLevel());
    }

    @Test
    void testUpgradeMultipleTimes() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        for (int i = 0; i < 10; i++) {
            clickOn(tiles[1][1].getUiButton());
        }
        Assertions.assertEquals(10, tiles[1][1].getTower().getTowerLevel());
    }

    @Test
    void testUpgradeWithDifferentTower() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][1].getUiButton());
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        clickOn("Grenadier: This tower slowly throws high-damaging explosives at the enemy.");
        clickOn(tiles[1][1].getUiButton());
        verifyThat("You cannot place a tower in an occupied location.", NodeMatchers.isNotNull());
        Assertions.assertEquals(1, tiles[1][1].getTower().getTowerLevel());
    }

    @Test
    void testMoneyTracking() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][0].getUiButton());
        clickOn(tiles[2][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[4][0].getUiButton());
        clickOn(tiles[5][0].getUiButton());
        Assertions.assertEquals(100, td.getMoneySpent());
    }

    @Test
    void testMaxLevelNoUpgrades() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[0][0].getUiButton());
        verifyThat("You cannot place a tower in an occupied location.", NodeMatchers.isNotNull());
        Assertions.assertEquals(0, td.getMostUpgraded());
    }

    @Test
    void testMaxLevelUpgraded() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        clickOn(tiles[1][0].getUiButton());
        clickOn(tiles[1][0].getUiButton());
        clickOn(tiles[2][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[3][0].getUiButton());
        clickOn(tiles[4][0].getUiButton());
        clickOn(tiles[4][0].getUiButton());
        clickOn(tiles[5][0].getUiButton());
        Assertions.assertEquals(3, td.getMostUpgraded());
    }

    @Test
    void testFinalBoss() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        for (int i = 0; i < 10; i++) {
            clickOn(tiles[1][4].getUiButton());
            clickOn(tiles[1][3].getUiButton());
        }
        clickOn(tiles[1][2].getUiButton());
        clickOn(tiles[1][1].getUiButton());
        td.forceWave(9);
        clickOn("Unleash the horde!");
        sleep(1000);
        Assertions.assertNotNull(td.getBoss());
    }


    @Test
    void testResetFromWin() {
        clickOn("Start");
        clickOn("Select your difficulty");
        clickOn("EASY");
        clickOn("Name...");
        write("Testing");
        clickOn("Let's Play!");
        clickOn("Select the tower you would like to purchase");
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        MapTile[][] tiles = td.getTiles();
        for (int i = 0; i < 10; i++) {
            clickOn(tiles[1][4].getUiButton());
            clickOn(tiles[1][3].getUiButton());
        }
        clickOn(tiles[1][2].getUiButton());
        clickOn(tiles[1][1].getUiButton());
        td.setGameMoney(1000);
        clickOn("Knife Chucker: This tower rapidly throws low-damage knives at the enemy.");
        clickOn("Sniper: This tower slowly but accurately picks"
                + " off all but the strongest enemies.");
        for (int i = 0; i < 10; i++) {
            clickOn(tiles[1][6].getUiButton());
        }
        td.forceWave(9);
        clickOn("Unleash the horde!");
        sleep(20000);
        verifyThat("YOU HAVE DEFEATED THE HORDE!", NodeMatchers.isNotNull());
        clickOn("Main Menu");
        verifyThat("Start", NodeMatchers.isNotNull());
    }

}

