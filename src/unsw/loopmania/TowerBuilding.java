package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class TowerBuilding extends Building {
    private double attackRange = 2;
    private int attackDamage = 13;
    /**
     * constructor of tower building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * use the function of the builidng
     */
    public List<BasicEnemy> work(List<BasicEnemy> enemies){
        List<BasicEnemy> deadEnemies = new ArrayList<>();
        for(BasicEnemy enemy : enemies){
            if(Math.pow(getX()-enemy.getX(), 2)+Math.pow(getY()-enemy.getY(), 2) 
                <= Math.pow( attackRange, 2)){
                enemy.setHealth(enemy.getHealth()-attackDamage);
                if(enemy.getHealth() <= 0){
                    deadEnemies.add(enemy);
                }
            }
        }
        return deadEnemies;
    }
}
