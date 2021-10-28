package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class TrapBuilding extends Building {
    private int attackDamage = 12;
    /**
     * constructor of trap building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * use the function of the builidng
     */
    public List<BasicEnemy> work(List<BasicEnemy> enemies){
        List<BasicEnemy> deadEnemies = new ArrayList<>();
        for(BasicEnemy enemy : enemies){
            if(getX() == enemy.getX() && getY() == enemy.getY()){
                enemy.setHealth(enemy.getHealth()-attackDamage);
                if(enemy.getHealth() <= 0){
                    deadEnemies.add(enemy);
                }
            }       
        }
        return deadEnemies;
    }
}
