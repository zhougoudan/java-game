package unsw.loopmania;

import java.util.List;
import java.util.Random;


/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {

    private int goldDefeated;
    private int exp;
    private String name;
    private int aggressivity;
    private int health;
    private int attackRange;
    private int supportRange;
    private int tranceTurn;
    private String level;

    /**
     * constructor of basic enemy
     * @param position enemy postion
     */
    public BasicEnemy(PathPosition position) {
        super(position);
        this.tranceTurn = 0;
    }

    /**
     * move the enemy
     */
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    /**
     * get enemy aggressivity
     * @return enemy aggressivity
     */
    public int getAggressivity() {
        return this.aggressivity;
    }

    /**
     * set enemy aggressivity
     * @param aggressivity enemy aggressivity
     */
    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    /**
     * get enemy health
     * @return enemy health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * set enemy health
     * @param health enemy health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * get enemy attack range
     * @return enemy attack range
     */
    public int getAttackRange() {
        return this.attackRange;
    }

    /**
     * set enemy attack range
     * @param attackRange enemy attack range
     */
    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    /**
     * get enemy support range
     * @return enemy support range
     */
    public int getSupportRange() {
        return this.supportRange;
    }

    /**
     * set enemy support range
     * @param supportRange enemy support range
     */
    public void setSupportRange(int supportRange) {
        this.supportRange = supportRange;
    }

    /**
     * get enemy name
     * @return enemy name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set enemy name
     * @param name enemy name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get trance turn
     * @return trance turn
     */
    public int getTranceTurn() {
        return this.tranceTurn;
    }

    /**
     * set trance turn
     * @param tranceTurn trance turn
     */
    public void setTranceTurn(int tranceTurn) {
        this.tranceTurn = tranceTurn;
    }

    /**
     * set rewards gold from defeat enemy
     * @param value rewards gold from defeat enemy
     */
    public void setGoldDefeated(int value){
        goldDefeated = value;
    }

    /**
     * set rewards EXP from defeat enemy
     * @param value rewards EXP from defeat enemy
     */
    public void setEXP(int value){
        exp = value;
    }

    /**
     * get rewards gold from defeat enemy
     * @return rewards gold from defeat enemy
     */
    public int getGoldDefeated(){
        return goldDefeated;
    }

    /**
     * get rewards EXP from defeat enemy
     * @return rewards EXP from defeat enemy
     */
    public int getEXP(){
        return exp;
    }

    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {

    }

    public void setLevel(String l) {
        this.level = l;
    }

    public String getLevel() {
        return this.level;
    }
}
