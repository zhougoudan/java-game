package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped HealthPotion in the backend world
 */
public class HealthPotion extends Item {
    public static int healAmount = 50;
    /**
     * constructor of healthpotion
     * @param x             SimpleIntegerProperty
     * @param y             SimpleIntegerProperty
     * @param damageValue   damage value 
     * @param defenseValue  defense value 
     * @param price         price
     */
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }

}  
