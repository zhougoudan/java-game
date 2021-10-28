package unsw.loopmania;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * represents a non-moving entity
 * unlike the moving entities, this can be placed anywhere on the game map
 */
public abstract class StaticEntity extends Entity {
    /**
     * x and y coordinates represented by IntegerProperty, so ChangeListeners can be added
     */
    private IntegerProperty x, y;

    /**
     * construcotr
     * @param x SimpleIntegerProperty 
     * @param y SimpleIntegerProperty 
     */
    public StaticEntity(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * get x IntegerProperty
     */
    public IntegerProperty x() {
        return x;
    }

    /**
     * get y IntegerProperty
     */
    public IntegerProperty y() {
        return y;
    }

    /**
     * get int X
     */
    public int getX() {
        return x().get();
    }

    /**
     * get int Y
     */
    public int getY() {
        return y().get();
    }

    /**
     * set static entity to new position with x,y
     * @param x int
     * @param y int
     */
    public void setPosition(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }
}
