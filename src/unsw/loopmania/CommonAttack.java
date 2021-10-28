package unsw.loopmania;

import java.util.List;

public class CommonAttack implements Attack{
    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e, String who) {
        int hurt;
        switch(who) {
            case "enemy":
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
                    } else if (c.getShield() instanceof TreeStump && e.getLevel().equals("Boss")) {
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
                        c.getSoldiers().remove(0);
                    }
                }
                break;
            case "soldier":
                if (!c.getSoldiers().isEmpty()) {
                    hurt = 5;
                    e.setHealth(e.getHealth() - hurt);
                }
                break;
            
            case "character":
                hurt = c.getAggressivity();
                if (c.getArmour() instanceof Helmet) {
                    hurt = hurt - 2;
                }
                e.setHealth(e.getHealth() - hurt);
                break;

            case "vampire":
                hurt = 15;
                e.setHealth(e.getHealth() - hurt);
                break;
            
            case "zombie":
                hurt = 8;
                e.setHealth(e.getHealth() - hurt);
                break;

            case "slug":
                hurt = 4;
                e.setHealth(e.getHealth() - hurt);
                break;
        }

    }
}