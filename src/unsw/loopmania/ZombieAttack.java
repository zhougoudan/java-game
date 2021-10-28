package unsw.loopmania;

import java.util.List;

public class ZombieAttack implements Attack{
    @Override
    /**
     * zombie attack
     */
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        c.getSoldiers().remove(0);
        Zombie z = new Zombie(c.getPosition(),null);
        enemies.add(z);
    }
}
