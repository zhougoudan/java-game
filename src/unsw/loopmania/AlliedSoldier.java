package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class AlliedSoldier extends StaticEntity{
    private int aggressivity;
    private int health;
    /**
     * constructor of allied solider
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public AlliedSoldier(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.aggressivity = 5;
        this.health = 15;
    }

    /**
     * get solieder aggressivity
     * @return integer of solieder aggressivity
     */
    public int getAggressivity() {
        return this.aggressivity;
    }

    /**
     * set solieder aggressivity
     * @param aggressivity solieder aggressivity
     */
    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    /**
     * get solieder health
     * @return solieder health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * set solieder health
     * @param health solieder health
     */
    public void setHealth(int health) {
        this.health = health;
    }

}
