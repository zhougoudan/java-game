package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class BarrackCard extends Card {
    /**
     * constructor of barrack card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public BarrackCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "BARRACK";
        String description = "Character obtains one allied soldier for free when they pass through Barracks.";
        super.init(name, description);
    }    
}
