package com.team97.team97project;

import com.team97.team97project.enemy.Enemy;
import com.team97.team97project.tower.Tower;
import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.Timer;
import java.io.FileNotFoundException;
import java.util.*;

public class TowerDefense extends Application {
    private ArrayList<Tower> inGameTowers = new ArrayList<>();
    private double gameMoney = 0;
    private double monumentHealth = 1;
    private int wave = 0;
    private DefaultMap map = new DefaultMap();
    private Difficulty thisGameDifficulty;
    private final ComboBox<String> gameTowerChoices = new ComboBox<>();
    private Text stats = new Text(
            "Money: " + gameMoney + "\n"
                    + "Monument Health: " + monumentHealth + "\n"
                    + "Wave: " + wave);
    private MapTile[][] tiles;
    private final int[][] pathPath = map.getPathPath();
    private boolean canStartWave = true;
    private int dead;
    private int enemyTest = 0;
    private ArrayList<Enemy> inGameEnemies = new ArrayList<>();
    private int placedTowers = 0;
    private int deadEnemies = 0;
    private int totalSpent = 0;
    private int mostUpgraded = 0;
    private boolean win = false;
    private Enemy boss = null;

    private Timer tickTimer;
    private int tickInterval;
    /**
     * A hashmap for holding the long names for the options
     * Since these are used in multiple places, I though it would
     * be a good idea to have 1 copy that is referenced so typos
     * wont be causing runtime errors
     * <p>
     * Indexed by the tower's name
     */
    private static final HashMap<String, String> TOWER_OPTIONS = new HashMap<>();
    private static final HashMap<Difficulty, Double> DIFF_DAMAGE_MODIF = new HashMap<>();

    static {
        TOWER_OPTIONS.put(Constants.KNIFE_NAME,
                Constants.KNIFE_NAME + ": " + Constants.KNIFE_DESCRIPTION);
        TOWER_OPTIONS.put(Constants.BOMB_NAME,
                Constants.BOMB_NAME + ": " + Constants.BOMB_DESCRIPTION);
        TOWER_OPTIONS.put(Constants.SNIPER_NAME,
                Constants.SNIPER_NAME + ": " + Constants.SNIPER_DESCRIPTION);

        DIFF_DAMAGE_MODIF.put(Difficulty.EASY, 0.5);
        DIFF_DAMAGE_MODIF.put(Difficulty.MEDIUM, 1d);
        DIFF_DAMAGE_MODIF.put(Difficulty.HARD, 1.5);
        DIFF_DAMAGE_MODIF.put(Difficulty.IMPOSSIBLE, 1000d);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        GridPane gpane = new GridPane();

        //Register tower & enemy types
        fillRegistry();

        //Creates and intializes the map
        populateDefaultMap(gpane);

        // Go init the ui in a different method so this one is under 150 lines
        initUi(primaryStage, gpane);

        // Show Initial Game Scene
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        if (tickTimer != null) {
            tickTimer.stop();
        }
    }

    private void fillRegistry() {
        //Knife Tower
        Registry.registerTower(
                Constants.KNIFE_NAME,
                new Tower(new Tower.TowerProperties()
                        .setTowerName(Constants.KNIFE_NAME)
                        .setTowerDescription(Constants.KNIFE_DESCRIPTION)
                        .setTowerStyle(Constants.KNIFE_FX_COLOR)
                        .setPrice(10)
                        .setDamage(1.0)
                        .setSpeed(2)
                        .setRadius(1.0)
                        .setImagePath("file:images/test.png")
                        .setRangeFunc((int x, int y) -> (x * x + y * y <= 1))
                        .setLevel(1)
                )
        );

        //Bomb Tower
        Registry.registerTower(
                Constants.BOMB_NAME,
                new Tower(new Tower.TowerProperties()
                        .setTowerName(Constants.BOMB_NAME)
                        .setTowerDescription(Constants.BOMB_DESCRIPTION)
                        .setTowerStyle(Constants.BOMB_FX_COLOR)
                        .setPrice(30)
                        .setDamage(2.0)
                        .setSpeed(10)
                        .setRadius(3)
                        .setRangeFunc((int x, int y) -> (x * x + y * y <= 9))
                        .setLevel(1)
                )
        );

        //Sniper Tower
        Registry.registerTower(
                Constants.SNIPER_NAME,
                new Tower(new Tower.TowerProperties()
                        .setTowerName(Constants.SNIPER_NAME)
                        .setTowerDescription(Constants.SNIPER_DESCRIPTION)
                        .setTowerStyle(Constants.SNIPER_FX_COLOR)
                        .setPrice(100)
                        .setDamage(8.0)
                        .setSpeed(25)
                        .setRadius(10)
                        .setRangeFunc((int x, int y) -> (x * x + y * y <= 100))
                        .setLevel(1)
                )
        );

        //Standard enemy (Average Health, Average Damage, Average Speed)
        Registry.registerEnemy(
                Constants.STANDARD_NAME,
                new Enemy(new Enemy.EnemyProperties()
                        .setHealth(4)
                        .setMaxHealth(4)
                        .setEnemyName(Constants.STANDARD_NAME)
                        .setRewardMoney(20)
                        .setDamage(25)
                        .setSpeed(10)
                        .setIsAlive(true)
                        .setPPIndex(-1)
                        .setImagePath("file:images/Soldier_NOT_DAMAGED_IMAGE.png")
                )
        );

        //Fast Enemy (Low Health, High Damage, High Speed)
        Registry.registerEnemy(
                Constants.FAST_NAME,
                new Enemy(new Enemy.EnemyProperties()
                        .setHealth(2)
                        .setMaxHealth(2)
                        .setEnemyName(Constants.FAST_NAME)
                        .setRewardMoney(40)
                        .setDamage(50)
                        .setSpeed(5)
                        .setIsAlive(true)
                        .setPPIndex(-1)
                        .setImagePath("file:images/Speedster_NOT_DAMAGED_IMAGE.png")
                )
        );

        //Slow Enemy (High Health, High Damage, Low Speed)
        Registry.registerEnemy(
                Constants.SLOW_NAME,
                new Enemy(new Enemy.EnemyProperties()
                        .setHealth(8)
                        .setMaxHealth(8)
                        .setEnemyName(Constants.SLOW_NAME)
                        .setRewardMoney(60)
                        .setDamage(100)
                        .setSpeed(20)
                        .setIsAlive(true)
                        .setPPIndex(-1)
                        .setImagePath("file:images/Tankster_NOT_DAMAGED_IMAGE.png")
                )
        );

        //Boss (High Health, Death, Lowest Speed)
        Registry.registerEnemy(
                Constants.BOSS_NAME,
                new Enemy(new Enemy.EnemyProperties()
                        .setHealth(128)
                        .setMaxHealth(128)
                        .setEnemyName(Constants.BOSS_NAME)
                        .setRewardMoney(0)
                        .setDamage(100000)
                        .setSpeed(100)
                        .setIsAlive(true)
                        .setPPIndex(-1)
                        .setImagePath("file:images/Boss_NOT_DAMAGED_IMAGE.png")
                )
        );
    }

    private void initUi(Stage primaryStage, GridPane gpane) {
        primaryStage.setTitle("Tower Defense"); //title
        TextField nameField = new TextField(); //name field
        nameField.setPromptText("Name...");
        nameField.setFocusTraversable(false);
        //difficulty selection
        Difficulty[] diffChoices = {Difficulty.EASY, Difficulty.MEDIUM,
            Difficulty.HARD, Difficulty.IMPOSSIBLE};
        ComboBox<Difficulty> gameDifficulty = new ComboBox<>();
        ObservableList<Difficulty> comboBoxItems = FXCollections.observableArrayList(diffChoices);
        gameDifficulty.getItems().addAll(comboBoxItems);
        gameDifficulty.setPromptText("Select your difficulty");
        String[] towerChoices = {//tower purchasing
                TOWER_OPTIONS.get(Constants.KNIFE_NAME),
                TOWER_OPTIONS.get(Constants.BOMB_NAME),
                TOWER_OPTIONS.get(Constants.SNIPER_NAME)
        };
        ObservableList<String> comboBoxTowers = FXCollections.observableArrayList(towerChoices);
        gameTowerChoices.getItems().addAll(comboBoxTowers);
        gameTowerChoices.setPromptText("Select the tower you would like to purchase");
        Button startButton = new Button("Start"); //buttons
        Button gameButton = new Button("Let's Play!");
        Text gameOverText = new Text("GAME OVER"); //gameover stuff
        gameOverText.setFont(new Font("Times New Roman", 30));
        Button restart = new Button("Main Menu");
        Button quit = new Button("Quit");
        VBox gameOverButtons = new VBox();
        Text wavesCompleted = new Text("Waves Completed: " + wave + "/" + Constants.FINAL_WAVE);
        Text enemysDefeated = new Text("Enemies Defeated: " + deadEnemies);
        Text moneySpent = new Text("Money Spent: " + totalSpent);
        Text towersPlaced = new Text("Towers Placed: " + placedTowers);
        Text bestTower = new Text("Your most upgraded tower was upgraded to level "
                + mostUpgraded + "!");
        BorderPane welcomePane = new BorderPane(); //panes
        BorderPane configPane = new BorderPane();
        BorderPane gamePane = new BorderPane();
        BorderPane gameOverPane = new BorderPane();
        FlowPane topPane = new FlowPane();
        Scene welcomeScene = new Scene(welcomePane, 900, 600); //scenes
        welcomePane.setCenter(startButton);
        Scene configScene = new Scene(configPane, 900, 600);
        configPane.setTop(nameField);
        configPane.setCenter(gameDifficulty);
        configPane.setBottom(gameButton);
        Scene gameOver = new Scene(gameOverPane, 900, 600);
        gameOverButtons.getChildren().addAll(gameOverText, restart, quit);
        gameOverButtons.getChildren().addAll(wavesCompleted, enemysDefeated,
                moneySpent, towersPlaced, bestTower);
        gameOverPane.setCenter(gameOverButtons);
        gameOverButtons.setAlignment(Pos.CENTER);
        Scene gameScene = new Scene(gamePane, 900, 600);
        Button combatButton = new Button("Unleash the horde!");
        gamePane.setMaxSize(900, 600);
        gamePane.setBottom(combatButton);
        gamePane.setTop(gameTowerChoices);
        gamePane.setCenter(gpane);
        gamePane.setLeft(stats);
        primaryStage.setScene(welcomeScene); //Setting the scene
        primaryStage.show();
        //moving to the config page
        startButton.setOnAction(e -> primaryStage.setScene(configScene));
        gamePane.setMaxSize(900, 600); //Setting the game pane
        topPane.getChildren().add(gameTowerChoices);
        topPane.getChildren().add(combatButton);
        gamePane.setTop(topPane);
        gamePane.setCenter(gpane);
        gamePane.setLeft(stats);
        gameDifficulty.setOnAction(e -> { //Setting difficulty/health
            if (gameDifficulty.getValue() == Difficulty.EASY) {
                gameMoney = 300;
                monumentHealth = 1000;
            } else if (gameDifficulty.getValue() == Difficulty.MEDIUM) {
                gameMoney = 250;
                monumentHealth = 900;
            } else if (gameDifficulty.getValue() == Difficulty.HARD) {
                gameMoney = 200;
                monumentHealth = 800;
            } else {
                gameMoney = 200;
                monumentHealth = 1;
            }
            updateStats();
            thisGameDifficulty = gameDifficulty.getValue();
        });
        gameButton.setOnAction(e -> { //moving to the game page
            if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
                Alerts.NAME_ALERT.show();
            } else if (gameDifficulty.getValue() == null) {
                Alerts.DIFFICULTY_ALERT.show();
            } else {
                primaryStage.setScene(gameScene);
            }
        });
        combatButton.setOnAction(e -> { //combat
            if (canStartWave) {
                wave++;
                updateStats();
                try {
                    spawn(wave);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                canStartWave = false;
            }
        });
        stats.textProperty().addListener((observableValue, s, t1) -> { //Checks monument health
            if (monumentHealth <= 0) {
                inGameEnemies.clear();
                inGameTowers.clear();
                canStartWave = true;
                primaryStage.setScene(gameOver);
                int truewave = win ? wave : wave - 1;
                wavesCompleted.setText("Waves Completed: " + truewave + "/" + Constants.FINAL_WAVE);
                enemysDefeated.setText("Enemies Defeated: " + deadEnemies);
                moneySpent.setText("Money Spent: " + totalSpent);
                towersPlaced.setText("Towers Placed: " + placedTowers);
                bestTower.setText("Your most upgraded tower was upgraded to level "
                        + mostUpgraded + "!");
                gameOverText.setText(win ? "YOU HAVE DEFEATED THE HORDE!" : "GAME OVER");
            }
        });
        restart.setOnAction(e -> { //restart button
            populateDefaultMap(gpane);
            wave = 0;
            deadEnemies = 0;
            placedTowers = 0;
            totalSpent = 0;
            mostUpgraded = 0;
            win = false;
            boss = null;
            if (thisGameDifficulty == Difficulty.EASY) {
                setGameMoney(300);
                setMonumentHealth(1000);
            } else if (thisGameDifficulty == Difficulty.MEDIUM) {
                setGameMoney(250);
                setMonumentHealth(900);
            } else if (thisGameDifficulty == Difficulty.HARD) {
                setGameMoney(200);
                setMonumentHealth(800);
            } else {
                setGameMoney(200);
                setMonumentHealth(1);
            }
            primaryStage.setScene(welcomeScene);
        });
        quit.setOnAction(e -> System.exit(1)); //quit button
    }

    private void populateDefaultMap(GridPane gpane) {
        Button combatButton = new Button("Unleash the Horde");

        int height = 11;
        int width = 15;
        MapTile[][] btns = new MapTile[height][width];
        setTiles(btns);
        for (int m = 0; m < height; m++) {
            gpane.getRowConstraints().add(new RowConstraints(50));
            gpane.getColumnConstraints().add(new ColumnConstraints(50));
            for (int n = 0; n < width; n++) {
                btns[m][n] = new MapTile(new Button(), map.getTile(m, n));
                btns[m][n].getUiButton().setMaxSize(50, 50);
                btns[m][n].getUiButton().setMinSize(50, 50);
                gpane.add(btns[m][n].getUiButton(), n, m); // column=n row=m

                btns[m][n].updateDisplay();

                Button someButton = btns[m][n].getUiButton();
                someButton.setUserData(new int[]{m, n});
                int[] udata = (int[]) someButton.getUserData();
                int by = udata[0];
                int bx = udata[1];
                MapTile thisTile = btns[by][bx]; //(m, n)
                someButton.setOnAction(e -> {

                    //Placing a tower

                    String tString = gameTowerChoices.getValue();
                    if (tString == null) {
                        tString = "";
                    }
                    //Choose what tower
                    Tower tower;
                    if (tString.equals(TOWER_OPTIONS.get(Constants.KNIFE_NAME))) {
                        tower = Registry.createTowerFromRegistry(Constants.KNIFE_NAME);
                    } else if (tString.equals(TOWER_OPTIONS.get(Constants.BOMB_NAME))) {
                        tower = Registry.createTowerFromRegistry(Constants.BOMB_NAME);
                    } else if (tString.equals(TOWER_OPTIONS.get(Constants.SNIPER_NAME))) {
                        tower = Registry.createTowerFromRegistry(Constants.SNIPER_NAME);
                    } else {
                        Alerts.TOWER_SELECT_ALERT.show();
                        return;
                    }

                    //Place if possible
                    if (thisTile.isPlaceable()) {
                        if (buyTower(thisGameDifficulty, tower)) {
                            btns[by][bx].putTower(tower);
                            btns[by][bx].updateDisplay();
                            inGameTowers.add(tower);
                            tower.setPosition(new int[]{by, bx});
                            placedTowers++;
                            if (mostUpgraded == 0) {
                                mostUpgraded = 1;
                            }
                        }
                    } else if (thisTile.getTower() != null
                            &&
                            thisTile.getTower().getTowerName().equals(tower.getTowerName())
                            &&
                            thisTile.getTower().getTowerLevel() < 10) {
                        if (buyTower(thisGameDifficulty, tower)) {
                            thisTile.getTower().upgradeTower(thisTile.getTower());
                            if (thisTile.getTower().getTowerLevel() > mostUpgraded) {
                                mostUpgraded = thisTile.getTower().getTowerLevel();
                            }
                            btns[by][bx].updateDisplay();
                        }
                    } else {
                        Alerts.TILE_OCCUPIED_ALERT.show();
                    }
                });


            }
        }
    }

    public double getGameMoney() {
        return this.gameMoney;
    }

    public void setGameMoney(double newGameMoney) {
        this.gameMoney = newGameMoney;
        updateStats();
    }

    public void updateStats() {
        stats.setText(
                "Money: " + gameMoney + "\n"
                + "Monument Health: " + monumentHealth + "\n"
                + "Wave: " + wave);
    }

    public boolean spendMoney(double moneySpent) {
        boolean ret = testSpend(moneySpent);
        if (ret) {
            setGameMoney(getGameMoney() - moneySpent);
            updateStats();
            totalSpent += moneySpent;
        }
        return ret;
    }

    public boolean testSpend(double moneySpent) {
        return ((getGameMoney() - moneySpent) >= 0);
    }

    public double getMonumentHealth() {
        return this.monumentHealth;
    }

    private void setMonumentHealth(double newMonumentHealth) {
        this.monumentHealth = newMonumentHealth;
        updateStats();
    }

    public void damageMonument(double damageDealt) {
        setMonumentHealth(getMonumentHealth() - damageDealt);
    }

    public double getTowerPrice(Difficulty gameDifficulty, Tower tower) {
        if (tower == null) {
            throw new IllegalArgumentException("Tower provided was null.");
        }
        if (gameDifficulty == Difficulty.EASY) {
            return tower.getTowerPrice();
        } else if (gameDifficulty == Difficulty.MEDIUM) {
            return tower.getTowerPrice() * 1.5;
        } else if (gameDifficulty == Difficulty.HARD) {
            return tower.getTowerPrice() * 3;
        } else if (gameDifficulty == Difficulty.IMPOSSIBLE) {
            return tower.getTowerPrice() * 3;
        }
        return 0;
    }

    public boolean buyTower(Difficulty gameDifficulty, Tower tower) {
        if (!testSpend(getTowerPrice(gameDifficulty, tower))) {
            Alerts.PURCHASE_ALERT.show();
            return false;
        } else {
            return placeNewTower(tower);
        }
    }

    private boolean placeNewTower(Tower tower) {
        return spendMoney(getTowerPrice(thisGameDifficulty, tower));
    }

    public MapTile[][] getTiles() {
        return tiles;
    }

    public ArrayList<Enemy> getEnemies() {
        return inGameEnemies;
    }

    private void setTiles(MapTile[][] tiles) {
        this.tiles = tiles;
    }

    //starts enemy wave
    private void spawn(int wave) throws InterruptedException {
        dead = 0;
        double pSlow = wave < 10 ? (wave - 1) * 0.02 : 0.20;
        double pFast = wave < 10 ? (wave - 1) * 0.03 : 0.30;
        switch (enemyTest) {
        case 1:
            pSlow = 1;
            enemyTest = 0;
            break;
        case 2:
            pFast = 1;
            enemyTest = 0;
            break;
        default:
            break;
        }
        ArrayList<Enemy> enemySpawnList = new ArrayList<>();
        if (wave == Constants.FINAL_WAVE) {
            String name = Constants.BOSS_NAME;
            Enemy enemy = Registry.createEnemyFromRegistry(name,
                    thisGameDifficulty.ordinal() + 1, wave);
            enemySpawnList.add(enemy);
            inGameEnemies.add(enemy);
            boss = enemy;
        }
        for (int i = 0; i < wave; i++) {
            for (int j = 0; j < wave; j++) {
                Enemy enemy;
                String name = "";
                double random = Math.random();
                if (random <= pSlow) {
                    name = Constants.SLOW_NAME;
                } else if (random <= pSlow + pFast) {
                    name = Constants.FAST_NAME;
                } else {
                    name = Constants.STANDARD_NAME;
                }
                enemy = Registry.createEnemyFromRegistry(name,
                        thisGameDifficulty.ordinal() + 1, wave);
                enemySpawnList.add(enemy);
                inGameEnemies.add(enemy);
            }
        }
        Enemy firstEnemy = enemySpawnList.remove(0);
        firstEnemy.setPPIndex(0);
        int[] z = pathPath[firstEnemy.getPPIndex()];
        int y = z[0];
        int x = z[1];
        tiles[y][x].putEnemy(firstEnemy);
        tiles[y][x].updateDisplay();
        ArrayList<Enemy> placedEnemies = new ArrayList<>();
        ArrayList<Enemy> toBeRemoved = new ArrayList<>();
        placedEnemies.add(firstEnemy);
        tickTimer = new Timer(83, e -> { // tick system
            for (int[] coord: pathPath) {
                MapTile t = tiles[coord[0]][coord[1]];
                if (!t.getUiButton().getStyle().equals(Constants.TILE_MONUMENT_FX_COLOR)) {
                    t.getUiButton().setStyle(Constants.TILE_PATH_FX_COLOR);
                }
            }
            tickInterval = (tickInterval + 1) % 250;
            for (Tower tower : inGameTowers) {
                if (tickInterval % tower.getTowerSpeed() == 0) {
                    if (Objects.equals(tower.getTowerName(), Constants.SNIPER_NAME)) {
                        ArrayList<Enemy> inRangeEnemies = new ArrayList<>();
                        for (Enemy en : placedEnemies) {
                            if (!toBeRemoved.contains(en)) {
                                if (en.getAlive() && tower.isInRange(en,
                                        pathPath[en.getPPIndex()])) {
                                    inRangeEnemies.add(en);
                                }
                            }
                        }
                        if (!inRangeEnemies.isEmpty()) {
                            int max = 0;
                            for (int i = 0; i < inRangeEnemies.size(); i++) {
                                int thisHealth = inRangeEnemies.get(i).getEnemyHealth();
                                if (thisHealth > inRangeEnemies.get(max).getEnemyHealth()) {
                                    max = i;
                                }
                            }
                            tower.damageEnemy(inRangeEnemies.get(max), tower.getTowerDamage());
                            Enemy en = inRangeEnemies.get(max);
                            MapTile t = tiles[pathPath[en.getPPIndex()][0]]
                                    [pathPath[en.getPPIndex()][1]];
                            t.getUiButton().setStyle(tower.getStyle());
                        }
                    } else {
                        try {
                            for (Enemy en : placedEnemies) {
                                if (!toBeRemoved.contains(en)) {
                                    if (en.getAlive() && tower.isInRange(en,
                                            pathPath[en.getPPIndex()])) {
                                        tower.damageEnemy(en, tower.getTowerDamage());
                                        MapTile t = tiles[pathPath[en.getPPIndex()][0]]
                                                [pathPath[en.getPPIndex()][1]];
                                        t.getUiButton().setStyle(tower.getStyle());
                                    }
                                }
                            }
                        } catch (ConcurrentModificationException cme) {
                            cme = null;
                        }
                    }
                }
            }
            if (boss != null) {
                int speed = (int) (((double) boss.getEnemyHealth()
                        /
                        (double) boss.getEnemyMaxHealth()) * 100);
                speed = speed - (speed % 5);
                if (speed == 0) {
                    speed = 5;
                }
                boss.setSpeed(speed);
            }
        });
        tickTimer.start();
        AnimationTimer releaseEnemies = createAnimationTimer(
                placedEnemies,
                toBeRemoved,
                enemySpawnList
        );
        releaseEnemies.start();
    }

    private AnimationTimer createAnimationTimer(
            ArrayList<Enemy> placedEnemies,
            ArrayList<Enemy> toBeRemoved,
            ArrayList<Enemy> enemySpawnList
    ) {
        return new AnimationTimer() {
            private long lastUpdate = 0;
            private double count = 0;
            @Override
            public void handle(long now) {
                if (inGameEnemies.isEmpty()) {
                    placedEnemies.clear();
                    toBeRemoved.clear();
                    enemySpawnList.clear();
                }
                for (Enemy enemy : placedEnemies) {
                    if ((enemy.getEnemyHealth() / (double) enemy.getEnemyMaxHealth()) > 0.75) {
                        enemy.setImagePath(
                                "file:images/" + enemy.getEnemyName()
                                        + "_NOT_DAMAGED_IMAGE.png");
                    } else if ((enemy.getEnemyHealth()
                            /
                            (double) enemy.getEnemyMaxHealth()) > 0.5) {
                        enemy.setImagePath(
                                "file:images/" + enemy.getEnemyName()
                                        + "_SLIGHTLY_DAMAGED_IMAGE.png");
                    } else if ((enemy.getEnemyHealth()
                            /
                            (double) enemy.getEnemyMaxHealth()) > 0.25) {
                        enemy.setImagePath(
                                "file:images/" + enemy.getEnemyName()
                                        + "_PRETTY_DAMAGED_IMAGE.png");
                    } else {
                        enemy.setImagePath(
                                "file:images/" + enemy.getEnemyName()
                                        + "_VERY_DAMAGED_IMAGE.png");
                    }
                }
                if (now - lastUpdate >= 50_000_000) {
                    if (count >= 100) {
                        count = 5;
                    } else {
                        count += 5;
                    }
                    if (enemySpawnList.isEmpty()) {
                        if (placedEnemies.size() == toBeRemoved.size()) {
                            placedEnemies.clear();
                            toBeRemoved.clear();
                            canStartWave = true;
                            stats.setText(stats.getText() + " CLEARED");
                            stop();
                            tickTimer.stop();
                            if (wave == Constants.FINAL_WAVE && monumentHealth > 0) {
                                forceVictory();
                            }
                        } else {
                            try {
                                moveAllPlaced(count, placedEnemies, toBeRemoved);
                            } catch (ConcurrentModificationException cme) {
                                cme = null;
                            }
                        }
                    } else {
                        moveAllPlaced(count, placedEnemies, toBeRemoved);
                        if (count % placedEnemies
                                .get(placedEnemies.size() - 1)
                                .getEnemySpeed() == 0) {
                            Enemy curEnemy = enemySpawnList.remove(0);
                            curEnemy.setPPIndex(0);
                            int[] z = pathPath[curEnemy.getPPIndex()];
                            int y = z[0];
                            int x = z[1];
                            tiles[y][x].putEnemy(curEnemy);
                            tiles[y][x].updateDisplay();
                            placedEnemies.add(curEnemy);
                        }
                    }
                    lastUpdate = now;
                }
            }
        };
    }


    private void moveAllPlaced(double count, ArrayList<Enemy> placed, ArrayList<Enemy> toRemove) {
        Collections.sort(placed);
        int enemyNum = 1;
        for (Enemy e : placed) {
            if (!inGameEnemies.contains(e)) {
                toRemove.add(e);
                e.setRemoved(true);
            }
            if (!e.getAlive() && !e.getRemoved()) {
                toRemove.add(e);
                e.setRemoved(true);
                gameMoney = gameMoney + e.getRewardMoney();
                updateStats();
                deadEnemies++;
            }
            if (!toRemove.contains(e)) {
                if (count % e.getEnemySpeed() == 0) {
                    int[] z = pathPath[e.getPPIndex()];
                    int y = z[0];
                    int x = z[1];
                    tiles[y][x].removeEnemy(e);
                    e.incrementPPIndex();
                    z = pathPath[e.getPPIndex()];
                    x = z[1];
                    y = z[0];
                    if (e.getPPIndex() == pathPath.length - 1) {
                        damageMonument(
                                (int) (e.getEnemyDamage()
                                        * DIFF_DAMAGE_MODIF.get(thisGameDifficulty))
                        );
                        toRemove.add(e);
                    } else {
                        tiles[y][x].putEnemy(e);
                        tiles[y][x].updateDisplay();
                    }
                    tiles[y][x].updateDisplay();
                }
            }
            enemyNum++;
        }
        for (Enemy e : toRemove) {
            tiles[pathPath[e.getPPIndex()][0]][pathPath[e.getPPIndex()][1]].removeEnemy(e);
        }
        for (int[] r : pathPath) {
            tiles[r[0]][r[1]].updateDisplay();
        }
    }

    public void setEnemyTest(int test) {
        enemyTest = test;
    }

    public void forceWave(int wave) {
        this.wave = wave;
    }

    public void forceVictory() {
        win = true;
        setMonumentHealth(-1);
    }

    public int getMoneySpent() {
        return totalSpent;
    }

    public int getMostUpgraded() {
        return mostUpgraded;
    }

    public Enemy getBoss() {
        return boss;
    }
}