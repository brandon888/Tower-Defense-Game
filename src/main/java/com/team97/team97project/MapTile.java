package com.team97.team97project;

import com.team97.team97project.enemy.Enemy;
import com.team97.team97project.tower.Tower;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

/**
 * Contains information linking the buttons on the ui to info abt the tile
 */
public class MapTile {

    private TileType tileType;
    private Tower towerIn;
    private LinkedList<Enemy> enemyIn;
    private final Button uiButton;

    /**
     * Creates a tile to be displayed on the map
     * Allows for easier control of tower placement/checking for tiles
     * Separated the concept "tile" from the ui element "button"
     * @param uiButton is the reference to the button displayed on the ui
     * @param tileType is the type of tile this tile is
     */
    public MapTile(Button uiButton, TileType tileType) {
        this.uiButton = uiButton;
        this.tileType = tileType;
        this.towerIn = null;
        this.enemyIn = new LinkedList<>();
    }

    /**
     * @return the button reference for the ui
     */
    public Button getUiButton() {
        return uiButton;
    }

    /**
     * @return the type of tile this tile has
     */
    public TileType getTileType() {
        return tileType;
    }

    /**
     * @param tileType is the tile type to set this tile to
     */
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    /**
     * @return whether this tile can be placed on
     *     (does not have a tower, nor is a not-placeable tile)
     */
    public boolean isPlaceable() {
        return
                !(tileType == TileType.Monument
                || tileType == TileType.Path
                || isTower());
    }

    /**
     * @return whether the tile has a tower in it
     */
    public boolean isTower() {
        return towerIn != null;
    }

    /**
     * @return whether the tile has an enemy in it
     */
    public boolean isEnemy() {
        return enemyIn != null;
    }

    /**
     * Puts a tower into this tile
     * Will override any tower in this spot
     * @param tower is the tower to place in the tile
     */
    public void putTower(Tower tower) {
        towerIn = tower;
    }

    /**
     * Puts an enemy into this tile
     * Will override any enemy in this spot
     * @param enemy is the enemy to place in the tile
     */
    public void putEnemy(Enemy enemy) {
        enemyIn.add(enemy);
    }

    /**
     * Removes the tower from this tile
     * @return the removed tower for additional calculation (price return or etc)
     */
    public Tower removeTower() {
        Tower tower = towerIn;
        towerIn = null;
        return tower;
    }

    /**
     * Removes the enemy from this tile
     * @param enemy is the enemy to remove
     * @return the removed enemy for additional calculation (price return or etc)
     */
    public Enemy removeEnemy(Enemy enemy) {
        enemyIn.remove(enemy);
        return enemy;
    }

    /**
     * CAN RETURN NULL, CHECK BEFORE USING
     * @return null (if unoccupied) or the reference to the tower in this spot
     */
    public Tower getTower() {
        return towerIn;
    }

    /**
     * CAN RETURN NULL, CHECK BEFORE USING
     * @return null (if unoccupied) or the reference to the enemy in this spot
     */
    public LinkedList<Enemy> getEnemy() {
        return enemyIn;
    }

    /**
     * Changes how the button is displayed in the game
     * Should be called whenever *anything* should change with
     * how the button looks
     */
    public void updateDisplay() {
        // I am unable to test this if statement atm but I hope it works
        // In case it doesn't, it is meant to remove the image before potentially
        // setting it later, but allows the removal of images
        if (uiButton.getGraphic() != null) {
            uiButton.setGraphic(null);
        }


        // Logic for telling what should be displayed on the tile
        if (towerIn != null) {
            if (towerIn.getImagePath() != null) {
                uiButton.setGraphic(
                        new ImageView(towerIn.getImagePath()
                        )
                );
            }
            if (towerIn.getStyle() != null) {
                uiButton.setStyle(towerIn.getStyle());
            }
            uiButton.setText(towerIn.getTowerLevel() + "");
        } else if (enemyIn != null && !enemyIn.isEmpty()) {
            if (enemyIn.get(0).getImagePath() != null) {
                uiButton.setGraphic(
                        new ImageView(enemyIn.get(0).getImagePath()
                        )
                );
            }
            if (enemyIn.get(0).getStyle() != null) {
                uiButton.setStyle(enemyIn.get(0).getStyle());
            }
        } else {
            uiButton.setStyle(TileType.COLOR_OF.get(tileType));
        }
    }
}
