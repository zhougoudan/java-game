package unsw.loopmania;

import java.util.List;

public class AndurilAttack implements Attack{

    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies, BasicEnemy e, String who) {
        int hurt = 0;
        if (c.getArmour() instanceof Helmet) {
            hurt = - 2;
        }
        if (e.getLevel().equals("Boss")) {
            hurt = (hurt + c.getAggressivity()) * 3;
        } else {
            hurt = hurt + c.getAggressivity();
        }
        //System.out.println(hurt);
        e.setHealth(e.getHealth() - hurt);
        
    }
    
}
