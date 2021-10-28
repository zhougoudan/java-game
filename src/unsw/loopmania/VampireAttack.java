package unsw.loopmania;

import java.util.List;
import java.util.Random;

public class VampireAttack implements Attack{
    @Override
    /**
     *  vampire attack
     */
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String string) {
        int addDamage = new Random().nextInt(10);
        if (addDamage == 0) {
            addDamage = 10;
        }
        int hurt;
        switch (string) {
            case "allied":
                hurt = 15 + addDamage;
                e.setHealth(e.getHealth() - hurt);
                break;
            
            case "enemy":
                if (!trancedEnemies.isEmpty()) {
                    hurt = e.getAggressivity() + addDamage;
                    trancedEnemies.get(0).setHealth(trancedEnemies.get(0).getHealth() - hurt);
                    if (trancedEnemies.get(0).getHealth() <= 0) {
                        trancedEnemies.get(0).destroy();
                        trancedEnemies.remove(0);
                    }
                } else if (c.getSoldiers().isEmpty()) {
                    hurt = e.getAggressivity() + addDamage - c.getDefense();
                    if (c.getArmour() instanceof Armour) {
                        hurt = hurt / 2;
                    } else if (c.getArmour() instanceof Helmet) {
                        hurt = hurt - 5;
                    }
                    if (hurt < 0) {
                        hurt = 0;
                    }
                    c.setHealth(c.getHealth() - hurt);
                } else {
                    AlliedSoldier soldier = c.getSoldiers().get(0);
                    hurt = e.getAggressivity() + addDamage;
                    soldier.setHealth(soldier.getHealth() - hurt);
                    if (soldier.getHealth() <= 0) {
                        soldier.destroy();
                        c.getSoldiers().get(0).destroy();
                        c.getSoldiers().remove(0);
                    }
                }
                break;
        }

    }

}
