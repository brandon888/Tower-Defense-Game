package com.team97.team97project;

import java.util.HashMap;

public enum TileType {
    Path,
    Grass,
    Monument,
    Tower,
    Enemy;

    public static final HashMap<TileType, String> COLOR_OF = new HashMap<>();
    static {
        COLOR_OF.put(Path, Constants.TILE_PATH_FX_COLOR);
        COLOR_OF.put(Grass, Constants.TILE_GRASS_FX_COLOR);
        COLOR_OF.put(Monument, Constants.TILE_MONUMENT_FX_COLOR);
        COLOR_OF.put(Tower, Constants.TILE_DEFAULT_FX_COLOR);
        COLOR_OF.put(Enemy, Constants.ENEMY_DEFAULT_FX_COLOR);
    }
}
