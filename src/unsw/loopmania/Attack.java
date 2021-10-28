package unsw.loopmania;

import java.util.List;

public interface Attack {
    /**
     * constructor of attack
     * @param c                 character
     * @param trancedEnemies    tranced enemies list
     * @param enemies           basic enemies list
     * @param e                 current enemey
     * @param who               attacker
     */
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who);
}