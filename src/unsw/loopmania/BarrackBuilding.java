package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class BarrackBuilding extends Building {
    /**
     * constructor of barrack building
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public BarrackBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * use the function of the builidng
     */
    public void work(Character character){
        if(getX() == character.getX() && getY() == character.getY()){
            if(character.getSoldiers().size() == 5) return;
            character.addSoldier(new AlliedSoldier(new SimpleIntegerProperty(getX()),new SimpleIntegerProperty(getY())));
            System.out.printf("add a allied soldier\n");
        }
    }
}
