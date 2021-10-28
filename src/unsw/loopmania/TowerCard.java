package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class TowerCard extends Card {
    /**
     * constructor of tower card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public TowerCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "TOWER";
        String description = "The defense tower has long range attack capability within a specific shooting radius.";
        super.init(name, description);
    }    
}
