package unsw.loopmania;

/**
 * a basic form of building in the world
 */
public class Gold {
    
    private int CurrentGold;
    public Gold (int i) {
        this.CurrentGold = i;
    }
    /**
     * setting current gold
     * 
     * @param  Gold_aim
     * @return 
     */
    public void setCurrentGold(int aim){
        this.CurrentGold = aim;
    } 
    /**
     * Getting current gold
     * 
     * @param  
     * @return gold
     */
    public int getCurrentGold(){
        return this.CurrentGold;
    }
    
}
