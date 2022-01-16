package com.team97.team97project.enemy;

import com.team97.team97project.Constants;

public class Enemy implements Comparable<Enemy> {

    /**
     * This object holds all the properties for the enemy
     */
    private final EnemyProperties properties;

    /**
     * By only requiring a properties object, call size is reduced
     *
     * @param properties is the properties of the enemy
     */
    public Enemy(EnemyProperties properties) {
        this.properties = properties;
    }

    public boolean reduceHP(double hpLost) {
        this.properties.setHealth((int) (this.getEnemyHealth() - hpLost));
        if (this.getEnemyHealth() <= 0) {
            this.properties.setIsAlive(false);
        }
        return this.properties.isAlive;
    }


    /**
     * @return the damage that the enemy deals
     */
    public double getEnemyDamage() {
        return properties.damage;
    }

    /**
     * @return the maximum health that the enemy can have
     */
    public int getEnemyMaxHealth() {
        return properties.maxHealth;
    }

    /**
     * @return the health that the enemy has
     */
    public int getEnemyHealth() {
        return properties.health;
    }

    /**
     * @return the amount of money rewarded upon killing this enemy
     */
    public int getRewardMoney() {
        return properties.rewardMoney;
    }

    /**
     * @return the speed of the enemy
     */
    public double getEnemySpeed() {
        return properties.speed;
    }

    /**
     * @return the javafx coloring style string for this enemy
     */
    public String getStyle() {
        return properties.enemyStyle;
    }

    /**
     * @return the name of the enemy
     */
    public String getEnemyName() {
        return properties.enemyName;
    }

    /**
     * @return the path for the image of the enemy
     */
    public String getImagePath() {
        return properties.imagePath;
    }

    /**
     * @param newImagePath the new image path for the image of the enemy
     */
    public void setImagePath(String newImagePath) {
        this.properties.setImagePath(newImagePath);
    }

    /**
     * @return the pathPath index of the enemy
     */
    public int getPPIndex() {
        return properties.ppIndex;
    }

    public void setRemoved(boolean isRemoved) {
        this.properties.setIsRemoved(isRemoved);
    }

    public boolean getRemoved() {
        return properties.isRemoved;
    }

    /**
     *
     * @return if the enemy is alive or not
     */
    public boolean getAlive() {
        return properties.isAlive;
    }

    public void setPPIndex(int i) {
        this.properties.setPPIndex(i);
    }

    public void setSpeed(double s) {
        this.properties.setSpeed(s);
    }

    /**
     * Creates a duplicate enemy with the exact same state as the source
     * @param difficulty is the difficulty of the enemy
     * @param wave is the wave of the enemy
     * @return a duplicate of the enemy
     */
    public Enemy copy(int difficulty, int wave) {
        double waveRatio = (double) wave / (double) Constants.FINAL_WAVE;
        return new Enemy(new Enemy.EnemyProperties()
                .setHealth((int) (this.properties.health * difficulty * (1.0 + waveRatio)))
                .setMaxHealth((int) (this.properties.maxHealth * difficulty * (1.0 + waveRatio)))
                .setEnemyName(this.properties.enemyName)
                .setRewardMoney((int) (this.properties.rewardMoney * (1.0 / difficulty)))
                .setDamage(this.properties.damage)
                .setSpeed(this.properties.speed)
                .setIsAlive(this.properties.isAlive)
                .setIsRemoved(this.properties.isRemoved)
                .setPPIndex(this.properties.ppIndex)
                .setImagePath(this.properties.imagePath)
                .setIsAlive(this.properties.isAlive)
                .setIsRemoved(this.properties.isRemoved)
                .setPPIndex(this.properties.ppIndex)
        );
    }

    public void incrementPPIndex() {
        this.properties.setPPIndex(this.properties.ppIndex + 1);
    }

    public void damage(int damage) {
        this.properties.setHealth(this.properties.health - damage);
        if (this.properties.health <= 0) {
            this.kill();
        }
    }

    public void kill() {
        this.properties.setIsAlive(false);
    }

    @Override
    public int compareTo(Enemy e) {
        if (this.getPPIndex() > e.getPPIndex()) {
            return -1;
        } else if (this.getPPIndex() < e.getPPIndex()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * An object that holds all the properties of an enemy
     * Only this class can access the properties
     * Only this & children classes can set properties
     * All setter methods return self for chaining (see child class for example)
     */
    public static class EnemyProperties {
        /**
         * maxHealth    The maximum amount of health the enemy has
         * health       The amount of health the enemy has
         * rewardMoney  The amount of money rewarded upon killing this enemy
         * damage       The damage that the enemy deals
         * speed        The speed at which the enemy travels (lower speed --> Faster)
         * enemyStyle   The javafx color style of the enemy
         * enemyName    The name of the enemy
         * imagePath    The path to the image for the enemy
         * isAlive      The life status of the enemy
         * ppIndex      The index of the enemy's position in the pathPath array
         */
        private int maxHealth;
        private int health;
        private int rewardMoney;
        private double damage;
        private double speed;
        private String enemyStyle;
        private String enemyName;
        private String imagePath;
        private boolean isAlive;
        private boolean isRemoved;
        private int ppIndex;

        public EnemyProperties() {
        }

        public EnemyProperties setHealth(int health) {
            this.health = health;
            return this;
        }

        public EnemyProperties setRewardMoney(int rewardMoney) {
            this.rewardMoney = rewardMoney;
            return this;
        }

        public EnemyProperties setDamage(double damage) {
            this.damage = damage;
            return this;
        }

        public EnemyProperties setSpeed(double speed) {
            this.speed = speed;
            return this;
        }

        public EnemyProperties setEnemyStyle(String enemyStyle) {
            this.enemyStyle = enemyStyle;
            return this;
        }

        public EnemyProperties setEnemyName(String enemyName) {
            this.enemyName = enemyName;
            return this;
        }

        public EnemyProperties setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public EnemyProperties setIsAlive(boolean isAlive) {
            this.isAlive = isAlive;
            return this;
        }

        public EnemyProperties setIsRemoved(boolean isRemoved) {
            this.isRemoved = isRemoved;
            return this;
        }

        public EnemyProperties setPPIndex(int ppIndex) {
            this.ppIndex = ppIndex;
            return this;
        }

        public EnemyProperties setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
            return this;
        }


    }
}
