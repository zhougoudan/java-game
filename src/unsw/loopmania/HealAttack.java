package unsw.loopmania;

import java.util.List;

public class HealAttack implements Attack{

    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies, BasicEnemy e, String who) {
        int currentHealth = enemies.get(0).getHealth();
        enemies.get(0).setHealth(currentHealth + 5);
        int hurt = 0;
        if (!trancedEnemies.isEmpty()) {
            hurt = e.getAggressivity();
            trancedEnemies.get(0).setHealth(trancedEnemies.get(0).getHealth() - hurt);
            if (trancedEnemies.get(0).getHealth() <= 0) {
                trancedEnemies.get(0).destroy();
                trancedEnemies.remove(0);
            }
        } else if (c.getSoldiers().isEmpty()) {
            hurt = e.getAggressivity() - c.getDefense();
            if (c.getArmour() instanceof Armour) {
                hurt = hurt / 2;
            } else if (c.getArmour() instanceof Helmet) {
                hurt = hurt - 5;
            } else if (c.getShield() instanceof TreeStump) {
                hurt = hurt / 3;
            }
            if (hurt < 0) {
                hurt = 0;
            }
            c.setHealth(c.getHealth() - hurt);
        } else {
            AlliedSoldier soldier = c.getSoldiers().get(0);
            hurt = e.getAggressivity();
            soldier.setHealth(soldier.getHealth() - hurt);
            if (soldier.getHealth() <= 0) {
                soldier.destroy();
                c.getSoldiers().get(0).destroy();
                c.getSoldiers().remove(0);
            }
        }
    }
    
}
