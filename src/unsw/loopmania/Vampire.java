package unsw.loopmania;

import java.util.List;
import java.util.Random;

public class Vampire extends BasicEnemy{
    private Building building;
    /**
     * constructor of vampire
     * @param position position
     */
    public Vampire(PathPosition position,Building building) {
        super(position);
        super.setHealth(32);
        super.setAggressivity(15);
        super.setSupportRange(2);
        super.setAttackRange(2);
        super.setGoldDefeated(5);
        super.setEXP(60);
        super.setName("Vampire");
        super.setLevel("Monster");
        this.building = building;
    }

    /**
     * move the vampire
     */
    @Override
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(6);
        if (directionChoice < 2){
            moveUpPath();
        }
        else{
            moveDownPath();
        }
    }
    public Building getVampireCastleBuilding(){
        return building;
    }

    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        int randomNum = new Random().nextInt(10);
        CommonAttack ca = new CommonAttack();
        if (randomNum < 3) {
            if (c.getShield() instanceof Shield) {
                int index = new Random().nextInt(10);
                if (index < 4) {
                    VampireAttack va = new VampireAttack();
                    va.hit(c, trancedEnemies, enemies, e, "enemy");
                } else {
                    ca.hit(c, trancedEnemies, enemies, e, "enemy");
                }
            } else {
                VampireAttack va = new VampireAttack();
                va.hit(c, trancedEnemies, enemies, e, "enemy");
            }
        } else {
            ca.hit(c, trancedEnemies, enemies, e, "enemy");
        }
    }
}
