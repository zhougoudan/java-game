package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class TreeStump extends Item {

    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }
    
}
