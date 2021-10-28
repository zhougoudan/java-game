package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    public String name;
    public String description;
    /**
     * constructor of card
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * init card name and description
     * @param name          card name
     * @param description   card description
     */
    public void init(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * get card name
     * @return card name
     */
    public String getName(){
        return name;
    }

    /**
     * get card description
     * @return card description
     */
    public String getDescription(){
        return description;
    }
}
