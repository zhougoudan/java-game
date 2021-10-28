package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a vampire castle card in the backend game world
 */
public class CampfireCard extends Card {
    /**
     * constructor of campfire card
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public CampfireCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "CAMPFIRE";
        String description = "There is a kind of radius attacking bonus, within its radius all kinds of attacking will be doubled.";
        super.init(name, description);
    }    
}
