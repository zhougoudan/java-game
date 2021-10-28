package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class Building extends StaticEntity {
    /**
     * constructor of building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
}
