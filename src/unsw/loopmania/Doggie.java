package unsw.loopmania;

import java.util.List;
import java.util.Random;

public class Doggie extends BasicEnemy{

    public Doggie(PathPosition position) {
        super(position);
        super.setHealth(30); 
        super.setAggressivity(21); 
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(10);
        super.setEXP(80);
        super.setName("Doggie");
        super.setLevel("Boss");
    }
    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        int index = new Random().nextInt(10);
        if (index < 2) {
            DoggieAttack d = new DoggieAttack();
            d.hit(c, trancedEnemies, enemies, e, null);
        } else {
            CommonAttack a = new CommonAttack();
            a.hit(c, trancedEnemies, enemies, e, "enemy");
        }
    }
}
