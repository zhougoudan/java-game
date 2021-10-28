package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    private int health;
    private int aggressivity;
    private int defense;
    private List<AlliedSoldier> soldiers;
    private Item weapon;
    private Item armour;
    private Item shield;
    private Item theOneRing;
    private int gold;
    private EXP EXP;
    private boolean attackEnhance;
    private boolean stupor;
    private int stuporTurn;

    /**
     * constructor of character
     * @param position character position
     */
    public Character(PathPosition position) {
        super(position);
        setGold(0);
        EXP = new EXP(0);
        setHealth(100);
        setAggressivity(4);
        soldiers = new ArrayList<AlliedSoldier>();
        stupor = false;
        stuporTurn = 0;
    }

    /**
     * get character health value
     * @return character health value
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * set character health value (max 100)
     * @param health character health value
     */
    public void setHealth(int health) {
        this.health = Math.max(Math.min(health, 100), 0);
    }

    /**
     * get character damage value
     * @return character damage value
     */
    public int getAggressivity() {
        if(attackEnhance){
            return 2 * aggressivity;
        }
        return aggressivity;
    }

    /**
     * set character damage value
     * @param aggressivity character damage value
     */
    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    /**
     * get character defense value
     * @return character defense value
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * set character defense value
     * @param defense character defense value
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * get character EXP
     * @return character EXP
     */
    public int getEXP() {
        return EXP.getCurrentEXP();
    }

    /**
     * get character equipped Armour
     * @return character equipped Armour
     */
    public Item getArmour() {
        return this.armour;
    }

    /**
     * set character equipped Armour
     * @param armour character equipped Armour
     */
    public void setArmour(Item armour) {
        this.armour = armour;
    }

    /**
     * get character equipped Shield
     * @return character equipped Shield
     */
    public Item getShield() {
        return this.shield;
    }

    /**
     * set get character equipped Shield
     * @param shield character equipped Shield
     */
    public void setShield(Item shield) {
        this.shield = shield;
    }

    /**
     * set character owned gold
     * @param gold character owned gold
     */
    public void setGold(int gold){
        this.gold=(gold);
    }

    /**
     * get character owned gold
     * @return character owned gold
     */
    public int getGold(){
        return gold;
    }

    /**
     * set character EXP
     * @param EXP character EXP
     */
    public void setEXP(int EXP){
        this.EXP.setCurrentEXP(EXP);
        
    }

    /**
     * set enhance attack
     * @param enhance enhance attack
     */
    public void setAttackEnhance(Boolean enhance){
        attackEnhance = enhance;
    }

    /**
     * get enhance attack
     * @return enhance attack
     */
    public boolean isAttackEnhance(){
        return attackEnhance;
    }

    /**
     * add allied soldier with character
     * @param s allied soldier
     */
    public void addSoldier(AlliedSoldier s) {
        soldiers.add(s);
    }

    /**
     * get character allied soldier list
     * @return list of allied soldier
     */
    public List<AlliedSoldier> getSoldiers() {
        return soldiers;
    }

    /**
     * get character equipped weapon
     * @return character equipped weapon
     */
    public Item getWeapon() {
        return this.weapon;
    }

    /**
     * set character equipped weapon
     * @param weapon character equipped weapon
     */
    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    /**
     * get character equipped ring
     * @return character equipped ring
     */
    public Item getTheOneRing() {
        return this.theOneRing;
    }

    /**
     * set character equipped ring
     * @param ring character equipped ring
     */
    public void setTheOneRing(Item ring) {
        this.theOneRing = ring;
    }

    public boolean getStupor() {
        return this.stupor;
    }

    public void setStupor(boolean b) {
        this.stupor = b;
    }

    public int getStuporTurn() {
        return this.stuporTurn;
    }

    public void setStuporTurn(int i) {
        this.stuporTurn = i;
    }

}
