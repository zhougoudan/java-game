package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class ZombiePitBuilding extends Building {
    /**
     * constructor of zombie pit building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * spawn a zombie each turn of the game
     */
    public List<BasicEnemy> spawnZombie(LoopManiaWorld world){
        List<BasicEnemy> retList = new ArrayList<>();
        retList.add(world.spawnAZombie(getX(),getY(),this));
        return retList;
    }
}
