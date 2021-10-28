package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building {
    private int counter = 5;
    /**
     * constructor of vampire castle building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * spawn a vampire each 5 loops of the game
     */
    public List<BasicEnemy> spawnVampires(LoopManiaWorld world){
        List<BasicEnemy> retList = new ArrayList<>();
        if(counter == 5){
            retList.add(world.spawnAVampire(getX(),getY(),this));
            counter = 1;
        }else{
            counter++;
        }
        return retList;
    }
}
