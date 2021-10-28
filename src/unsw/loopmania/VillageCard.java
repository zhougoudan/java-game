package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a village card in the backend game world
 */
public class VillageCard extends Card {
    /**
     * constructor of village card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public VillageCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "VILLAGE";
        String description = "Character regains health when passing through.";
        super.init(name, description);
    }    
}
