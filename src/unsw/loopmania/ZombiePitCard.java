package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class ZombiePitCard extends Card {
    /**
     * constructor of zombie pit card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "ZOMBIEPIT";
        String description = "Several zombies will come out each turn of the game.";
        super.init(name, description);
    }    
}
