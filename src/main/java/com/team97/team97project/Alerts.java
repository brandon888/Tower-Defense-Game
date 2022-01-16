package com.team97.team97project;

import javafx.scene.control.Alert;

/**
 * Constant class for holding & organizing alerts
 */
public class Alerts {

    //Confirm
    public static final Alert GAME_OVER_ALERT = new Alert(Alert.AlertType.CONFIRMATION);

    //Info
    public static final Alert TOWER_PLACEMENT_ALERT = new Alert(Alert.AlertType.INFORMATION);

    //Warn
    public static final Alert TOWER_SELECT_ALERT = new Alert(Alert.AlertType.WARNING);

    //Error
    public static final Alert DIFFICULTY_ALERT = new Alert(Alert.AlertType.ERROR);
    public static final Alert NAME_ALERT = new Alert(Alert.AlertType.ERROR);
    public static final Alert PATH_ALERT = new Alert(Alert.AlertType.ERROR);
    public static final Alert PURCHASE_ALERT = new Alert(Alert.AlertType.ERROR);
    public static final Alert TILE_OCCUPIED_ALERT = new Alert(Alert.AlertType.ERROR);

    static {
        //Confirm
        GAME_OVER_ALERT.setContentText("Your monument has run out of health.  Game over!");

        //Info
        TOWER_PLACEMENT_ALERT.setContentText(
                "Please click the tileType where you would like to place your tower."
        );

        //Warn
        TOWER_SELECT_ALERT.setContentText("No tower was selected.");

        //Error
        DIFFICULTY_ALERT.setContentText("Please select a difficulty.");
        NAME_ALERT.setContentText("Please choose a different name.");
        PATH_ALERT.setContentText("You cannot place a tower here.");
        PURCHASE_ALERT.setContentText("You can't afford to buy this.");
        TILE_OCCUPIED_ALERT.setContentText("You cannot place a tower in an occupied location.");
    }
}
