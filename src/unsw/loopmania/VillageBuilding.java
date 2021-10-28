package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class VillageBuilding extends Building {
    private int healAmount = 20;
    /**
     * constructor of village building
     * @param x SimpleIntegerProperty
     * @param y SimpleIntegerProperty
     */
    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * use the function of the builidng
     */
    public void work(Character character){
        if(getX() == character.getX() && getY() == character.getY()){
            character.setHealth(character.getHealth()+healAmount);
        }
    }
}
