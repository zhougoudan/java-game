package unsw.loopmania;

import java.util.List;

public class Slug extends BasicEnemy{
    /**
     * slug constructor
     * @param position slug position
     */
    public Slug(PathPosition position) {
        super(position);
        super.setHealth(12);
        super.setAggressivity(4);
        super.setSupportRange(1);
        super.setAttackRange(1);
        super.setGoldDefeated(1);
        super.setEXP(20);
        super.setName("Slug");
        super.setLevel("Monster");
    }

    @Override
    public void attack(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies,BasicEnemy e) {
        CommonAttack ca = new CommonAttack();
        ca.hit(c, trancedEnemies, enemies, e, "enemy");
    }
}
