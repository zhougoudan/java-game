package unsw.loopmania;

/**
 * a basic form of building in the world
 */
public class EXP {
    public int CurrentEXP;
    
    public EXP(int i) {
        this.CurrentEXP = i;

    }
    /**
     * setting current EXP
     * 
     * @param  Gold_aim
     * @return 
     */
    public void setCurrentEXP(int aim){
        CurrentEXP = aim;
    } 
    /**
     * GETTING current EXP
     * 
     * @param  Gold_aim
     * @return 
     */
    public int getCurrentEXP(){
        return this.CurrentEXP;
    }
}
