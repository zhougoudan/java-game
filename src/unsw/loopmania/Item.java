package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped armour in the backend world
 */
public class Item extends StaticEntity {
    private int damageValue;
    private int defenseValue;
    private int price;

    /**
     * constructor of item
     * @param x             SimpleIntegerProperty
     * @param y             SimpleIntegerProperty
     * @param damageValue   damage value 
     * @param defenseValue  defense value 
     * @param price         price
     */
    public Item (SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y);
        this.damageValue = damageValue;
        this.defenseValue = defenseValue;
        this.price = price;
    } 

    /**
     * get item damage value 
     * @return item damage value 
     */
    public int getDamageValue() {
        return this.damageValue;
    }

    /**
     * set item damage value 
     * @param damageValue item damage value 
     */
    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    /**
     * get item defense value
     * @return item defense value 
     */
    public int getDefenseValue() {
        return this.defenseValue;
    }

    /**
     * set item defense value
     * @param defenseValue item defense value
     */
    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    /**
     * get item price 
     * @return item price 
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * set item price 
     * @param price item price 
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
}
