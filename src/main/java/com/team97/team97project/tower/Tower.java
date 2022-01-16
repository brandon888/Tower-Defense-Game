package com.team97.team97project.tower;

import com.team97.team97project.Boolean2DFunction;
import com.team97.team97project.enemy.Enemy;

public class Tower {

    /**
     * This object holds all the properties for the tower
     */
    private final TowerProperties properties;


    public double damageEnemy(Enemy enemy, double damage) {
        if (!enemy.reduceHP(damage)) {
            return enemy.getRewardMoney();
        }
        return 0;
    }

    public boolean isInRange(Enemy enemy, int[] enemyLocation) {
        return enemy.getAlive() && properties.rangeFunc.evaluate(
                this.properties.position[0] - enemyLocation[0],
                this.properties.position[1] - enemyLocation[1]
        );
    }

    /**
     * By only requiring a properties object, call size is reduced
     *
     * @param properties is the properties of the tower
     */
    public Tower(TowerProperties properties) {
        this.properties = properties;
    }

    public void upgradeTower(Tower tower) {
        tower.properties.damage = tower.properties.damage * 1.5;
        tower.properties.level++;
    }

    private void upgradeTowerDamage(Tower tower) {
    }

    private void upgradeTowerSpeed(Tower tower) {
    }

    public void setPosition(int[] position) {
        this.properties.position = position;
    }

    /**
     * @return the price of the tower
     */
    public double getTowerPrice() {
        return properties.price;
    }

    /**
     * @return the damage that the tower deals
     */
    public double getTowerDamage() {
        return properties.damage;
    }

    /**
     * @return the speed of the tower
     */
    public double getTowerSpeed() {
        return properties.speed;
    }

    /**
     * @return the javafx coloring style string for this tower
     */
    public String getStyle() {
        return properties.towerStyle;
    }

    /**
     * @return the name of the tower
     */
    public String getTowerName() {
        return properties.towerName;
    }

    /**
     * @return the position of the tower
     */
    public int[] getPosition() {
        return properties.position;
    }

    /**
     * @return the level of the tower
     */
    public int getTowerLevel() {
        return properties.level;
    }

    /**
     * @return the description of the tower
     */
    public String getTowerDescription() {
        return properties.towerDescription;
    }

    /**
     * @return the path for the image of the tower
     */
    public String getImagePath() {
        return properties.imagePath;
    }

    /**
     * Creates a duplicate tower with the exact same state as the source
     *
     * @return a duplicate of the tower with null position
     */
    public Tower copy() {
        TowerProperties tp = new TowerProperties();
        tp.setPrice(this.properties.price);
        tp.setDamage(this.properties.damage);
        tp.setSpeed(this.properties.speed);
        tp.setRadius(this.properties.radius);
        tp.setTowerStyle(this.properties.towerStyle);
        tp.setTowerName(this.properties.towerName);
        tp.setLevel(this.properties.level);
        tp.setTowerDescription(this.properties.towerDescription);
        tp.setImagePath(this.properties.imagePath);
        tp.setRangeFunc(this.properties.rangeFunc);
        return new Tower(tp);
    }

    /**
     * An object that holds all the properties of a tower
     * Only this class can access the properties
     * Only this & children classes can set properties
     * All setter methods return self for chaining (see child class for example)
     */
    public static class TowerProperties {
        /**
         * price        The price of the tower
         * damage       The damage that the tower deals
         * speed        The speed at which the tower shoots
         * radius       The radius of the tower's range
         * position     The position of the tower
         * level        The level of the tower (from upgrades)
         * towerStyle   The javafx color style of the tower
         * towerName    The name of the tower
         * towerDesc..  The description of the tower
         * imagePath    The path to the image for the tower
         */
        private int price;
        private double damage;
        private double speed;
        private double radius;
        private int[] position;
        private int level;
        private String towerStyle;
        private String towerName;
        private String towerDescription;
        private String imagePath;
        private Boolean2DFunction rangeFunc;

        public TowerProperties() {
        }

        public TowerProperties setPrice(int price) {
            this.price = price;
            return this;
        }

        public TowerProperties setDamage(double damage) {
            this.damage = damage;
            return this;
        }

        public TowerProperties setSpeed(double speed) {
            this.speed = speed;
            return this;
        }

        public TowerProperties setRadius(double radius) {
            this.radius = radius;
            return this;
        }

        public TowerProperties setPosition(int[] position) {
            this.position = position;
            return this;
        }

        public TowerProperties setLevel(int level) {
            this.level = level;
            return this;
        }

        public TowerProperties setTowerStyle(String towerStyle) {
            this.towerStyle = towerStyle;
            return this;
        }

        public TowerProperties setTowerName(String towerName) {
            this.towerName = towerName;
            return this;
        }

        public TowerProperties setTowerDescription(String towerDescription) {
            this.towerDescription = towerDescription;
            return this;
        }

        public TowerProperties setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public TowerProperties setRangeFunc(Boolean2DFunction func) {
            this.rangeFunc = func;
            return this;
        }
    }
}
