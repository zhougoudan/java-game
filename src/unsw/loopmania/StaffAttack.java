package unsw.loopmania;

import java.util.List;

public class StaffAttack implements Attack{
    @Override
    /**
     * character attact with staff
     */
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        enemies.remove(e);
        trancedEnemies.add(e);
        e.setTranceTurn(5);
    }
}