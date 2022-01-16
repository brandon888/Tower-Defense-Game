package com.team97.team97project;

import com.team97.team97project.enemy.Enemy;
import com.team97.team97project.tower.Tower;

import java.util.HashMap;

/**
 * Fun class to get rid of creating explicit data classes
 * (eg. the old BombTower, KnifeTower, SniperTower classes)
 * Instead create an instance of the Object and register it here
 * with its name, to create a copy use the create...() method
 */
public class Registry {

    /**
     * Magic hashmap that holds the templates to copy
     */
    private static final HashMap<String, Tower> TOWER_TYPES = new HashMap<>();

    /**
     * Adds a given tower to the registry to copy later
     *
     * @param name  is the name of the tower being put in the registry
     * @param tower is the template for the tower (basically the tower with its initial stats)
     */
    public static void registerTower(String name, Tower tower) {
        TOWER_TYPES.put(name, tower);
    }

    /**
     * Creates a new tower from an existing one in the registry
     * If the given tower name is not present, this method WILL return NULL
     *
     * @param name is the name of the tower to copy
     * @return a new copy of a specified tower if it exists, or null if it does not exist
     */
    public static Tower createTowerFromRegistry(String name) {
        if (TOWER_TYPES.containsKey(name)) {
            return TOWER_TYPES.get(name).copy();
        }
        return null;
    }

    /**
     * Magic hashmap that holds the templates to copy
     */
    private static final HashMap<String, Enemy> ENEMY_TYPES = new HashMap<>();

    /**
     * Adds a given enemy to the registry to copy later
     *
     * @param name  is the name of the enemy being put in the registry
     * @param enemy is the template for the enemy (basically the enemy with its initial stats)
     */
    public static void registerEnemy(String name, Enemy enemy) {
        ENEMY_TYPES.put(name, enemy);
    }

    /**
     * Creates a new enemy from an existing one in the registry
     * If the given enemy name is not present, this method WILL return NULL
     *
     * @param name is the name of the enemy to copy
     * @param difficulty is te difficulty level for the enemy
     * @param wave is the wave of the enemy
     * @return a new copy of a specified enemy if it exists, or null if it does not exist
     */
    public static Enemy createEnemyFromRegistry(String name, int difficulty, int wave) {
        if (ENEMY_TYPES.containsKey(name)) {
            return ENEMY_TYPES.get(name).copy(difficulty, wave);
        }
        return null;
    }
}
