package com.team97.team97project;

/**
 * Class for organizing constants
 * Includes Tower name/desc/fx-color
 * Includes tile fx-colors
 */
public class Constants {

    //Towers
    public static final String BOMB_NAME = "Grenadier";
    public static final String BOMB_DESCRIPTION =
            "This tower slowly throws high-damaging explosives at the enemy.";
    public static final String BOMB_FX_COLOR = "-fx-background-color: black";


    public static final String KNIFE_NAME = "Knife Chucker";
    public static final String KNIFE_DESCRIPTION =
            "This tower rapidly throws low-damage knives at the enemy.";
    public static final String KNIFE_FX_COLOR = "-fx-background-color: grey";


    public static final String SNIPER_NAME = "Sniper";
    public static final String SNIPER_DESCRIPTION =
            "This tower slowly but accurately picks off all but the strongest enemies.";
    public static final String SNIPER_FX_COLOR = "-fx-background-color: blue";


    //Tiles
    public static final String TILE_GRASS_FX_COLOR = "-fx-background-color: green";
    public static final String TILE_PATH_FX_COLOR = "-fx-background-color: brown";
    public static final String TILE_MONUMENT_FX_COLOR = "-fx-background-color: pink";
    public static final String TILE_DEFAULT_FX_COLOR = "-fx-background-color: white";

    //Enemies

    public static final String STANDARD_NAME = "Soldier";
    public static final String FAST_NAME = "Speedster";
    public static final String SLOW_NAME = "Tankster";
    public static final String BOSS_NAME = "Boss";

    public static final String ENEMY_DEFAULT_FX_COLOR = "-fx-background-color: red";

    public static final int FINAL_WAVE = 10;
}
