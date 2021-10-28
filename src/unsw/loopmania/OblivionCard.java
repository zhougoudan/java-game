package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents a oblivion castle card in the backend game world
 */
public class OblivionCard extends Card{
    /**
     * constructor of trap card
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public OblivionCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        String name = "Oblivion";
        String description = "Use this card to demolish unwanted structures built before.";
        super.init(name, description);
    }       
}