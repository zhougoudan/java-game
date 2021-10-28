package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class DoggieCoin extends Item implements Observer{

    public DoggieCoin(SimpleIntegerProperty x, SimpleIntegerProperty y, int damageValue, int defenseValue, int price) {
        super(x, y, damageValue, defenseValue, price);
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setPrice(price);
    }

    @Override
    public void updatePrice(int price) {
        setPrice(price);
        System.out.println("The price of DoggieCoin changed!");
        System.out.println("DoggieCoin: " + getPrice() + ".");
    }
    

}
