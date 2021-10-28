package unsw.loopmania;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

public class HeroCastleBuilding extends Building{
    /**
     * store
     */
    private MStore store;
    private boolean hasShowStore;
    /**
     * constructor of hero castle building
     * @param x                         SimpleIntegerProperty
     * @param y                         SimpleIntegerProperty
     * @param loopManiaWorldController  LoopManiaWorldController
     */
    public HeroCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y, LoopManiaWorldController loopManiaWorldController) {
        super(x, y);
        // build up the store
        store = new MStore(loopManiaWorldController);
    }
    
    /**
     * build work function
     * @param character                 character
     * @param loopManiaWorldController  LoopManiaWorldController
     * @return                          boolean
     */
    public boolean work(Character character, LoopManiaWorldController loopManiaWorldController){
        LoopManiaWorld world = loopManiaWorldController.getLoopManiaWorld();
        if(characterIsInHerosCastle(world.getCharacter())){
            System.out.println(1);
            if(!hasShowStore){
                // show the store
                loopManiaWorldController.pause();
                store.show();
                hasShowStore = true;
                return true;
            }else{
                hasShowStore = false;
                world.addRoundsNum();
                loopManiaWorldController.setFocus();
            }
            List<BasicEnemy> retList = world.spawnEnemiesByBuilding();
            for(BasicEnemy enemy : retList){
                loopManiaWorldController.onLoad(enemy);
            }
        }
        return false;
    }
        
    /**
     * check whether the position is in the Hero's Castle
     */
    public boolean characterIsInHerosCastle(Character character){
        return getX() == character.getX() && getY() == character.getY();
    }
    
    /**
     * close the store
     */
    public void closeStore(){
        store.close();
    }
}
