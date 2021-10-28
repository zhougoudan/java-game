package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zombie extends BasicEnemy{
    private Building building;

    private List<BasicEnemy> intefactors;

    /**
     * constructor of zombie
     * @param position position
     */
    public Zombie(PathPosition position, Building building) {
        super(position);
        super.setHealth(18);
        super.setAggressivity(8);
        super.setSupportRange(0);
        super.setAttackRange(2);
        super.setGoldDefeated(3);
        super.setEXP(40);
        super.setName("Zombie");
        super.setLevel("Monster");
        intefactors = new ArrayList<BasicEnemy>();
        this.building = building;
    } 

    /**
     * move the zombie
     */
    @Override
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(6);
        if (directionChoice < 4){
            moveUpPath();
        }
        else{
            moveDownPath();
        }
    }
    public Building getZombieBuilding(){
        return building;
    }

    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        int randomNum = new Random().nextInt(10);
        CommonAttack ca = new CommonAttack();
        if (!intefactors.isEmpty()) {
            for (BasicEnemy i:intefactors) {
                i.attack(c, trancedEnemies, enemies, e);
            }
        }
        if (randomNum < 3 && !c.getSoldiers().isEmpty()) {
            c.getSoldiers().remove(0);
            Zombie z = new Zombie(c.getPosition(),null);
            this.intefactors.add(z);
        } else {
            ca.hit(c, trancedEnemies, enemies, e, "enemy");
        }
    }
}
