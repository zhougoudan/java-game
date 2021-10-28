package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Anduril extends Item {

    public Anduril(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }
    
}
