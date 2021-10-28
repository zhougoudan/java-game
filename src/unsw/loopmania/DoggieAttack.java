package unsw.loopmania;

import java.util.List;

public class DoggieAttack implements Attack{

    @Override
    public void hit(Character c, List<BasicEnemy> trancedEnemies, List<BasicEnemy> enemies, BasicEnemy e, String who) {
        c.setStupor(true);
        c.setStuporTurn(5);
    }
    
}
