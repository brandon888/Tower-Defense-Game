package com.team97.team97project;

/**
 * Template for a default map
 */
public class DefaultMap {
    public static final int HEIGHT = 10;
    public static final int WIDTH = 14;
    private final int[][] pathPath = {
            {0, 0},
            {0, 1},
            {0, 2},
            {0, 3},
            {0, 4},
            {0, 5},
            {1, 5},
            {2, 5},
            {2, 4},
            {2, 3},
            {2, 2},
            {2, 1},
            {3, 1},
            {4, 1},
            {5, 1},
            {6, 1},
            {7, 1},
            {8, 1},
            {9, 1},
            {10, 1},
            {10, 2},
            {10, 3},
            {10, 4},
            {10, 5},
            {10, 6},
            {10, 7},
            {10, 8},
            {10, 9},
            {10, 10},
            {10, 11},
            {10, 12},
            {10, 13},
            {10, 14},
            {9, 14},
            {8, 14},
            {8, 13},
            {8, 12},
            {8, 11},
            {8, 10},
            {8, 9},
            {8, 8},
            {8, 7},
            {8, 6},
            {8, 5},
            {8, 4},
            {8, 3},
            {7, 3},
            {6, 3},
            {5, 3},
            {5, 4},
            {5, 5},
            {5, 6},
            {5, 7},
            {5, 8},
            {5, 9},
            {4, 9},
            {3, 9},
            {3, 10},
            {3, 11},
            {2, 11}
    };

    private final TileType[][] map = {
            {
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Monument, TileType.Monument, TileType.Monument, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Monument, TileType.Monument, TileType.Monument, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Monument, TileType.Monument, TileType.Monument, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Path,
            TileType.Path, TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Path,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Path, TileType.Path,
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Path, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Path, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Path, TileType.Path,
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path
            },
            {
            TileType.Grass, TileType.Path, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass,
            TileType.Grass, TileType.Grass, TileType.Grass, TileType.Grass, TileType.Path
            },
            {
            TileType.Grass, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path,
            TileType.Path, TileType.Path, TileType.Path, TileType.Path, TileType.Path
            }
    };

    public TileType[][] getMap() {
        return this.map;
    }

    public TileType getTile(int h, int w) {
        return map[h][w];
    }

    public int[][] getPathPath() {
        return pathPath;
    }

    public void setTile(int h, int w, TileType tileType) {
        map[h][w] = tileType;
    }
}
