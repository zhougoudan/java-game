package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped shield in the backend world
 */
public class Shield extends Item {
    /**
     * constructor of shield
     * @param x             SimpleIntegerProperty
     * @param y             SimpleIntegerProperty
     * @param damageValue   damage value 
     * @param defenseValue  defense value 
     * @param price         price
     */
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }

}  
