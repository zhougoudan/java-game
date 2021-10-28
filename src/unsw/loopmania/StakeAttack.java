package unsw.loopmania;

import java.util.List;

public class StakeAttack implements Attack{
    @Override
    /**
     * character attact with stake
     */
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        int hurt = 0;
        if (c.getArmour() instanceof Helmet) {
            hurt = - 2;
        }
        if (e.getName().equals("Vampire")) {
            hurt = hurt + c.getAggressivity() + 8;
        } else {
            hurt = hurt + c.getAggressivity();
        }

        e.setHealth(e.getHealth() - hurt);
    }
}
