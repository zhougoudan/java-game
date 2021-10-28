package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class VampireCastleCard extends Card {
    /**
     * constructor of vampire castle card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public VampireCastleCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "VAMPIRECASTLE";
        String description = "Vampires will come out each 5 loops of the game.";
        super.init(name, description);
    }    
}
