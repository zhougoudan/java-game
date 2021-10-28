package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;

import unsw.loopmania.AlliedSoldier;
import unsw.loopmania.Armour;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.CommonAttack;
import unsw.loopmania.Helmet;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.StaffAttack;
import unsw.loopmania.Stake;
import unsw.loopmania.StakeAttack;
import unsw.loopmania.Vampire;
import unsw.loopmania.VampireAttack;
import unsw.loopmania.Zombie;
import unsw.loopmania.ZombieAttack;

public class AttackTest {

    private CommonAttack ca = new CommonAttack();
        
    @Test
    public void slugAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 96);
    }

    @Test
    public void VampireAttackTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(Character.getHealth(), 85);
    }

    @Test
    public void VampireAttackTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        Zombie z = new Zombie(Pp,null);
        enemies.add(z);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "allied");
        assertNotEquals(z.getHealth(), 3);
    }

    @Test
    public void VampireAttackTest3(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        Slug s= new Slug(Pp);
        trancedEnemies.add(s);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(s.getHealth(), 3);
    }

    @Test
    public void VampireAttackTest4(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        Vampire v = new Vampire(Pp,null);
        trancedEnemies.add(v);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(v.getHealth(), 3);
    }

    @Test
    public void VampireAttackTest5(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Helmet h = new Helmet(null, null, 0, 0, 0);
        Character.setArmour(h);
        Vampire e = new Vampire(Pp,null);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(Character.getHealth(), 90);
    }

    @Test
    public void VampireAttackTest6(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Armour a= new Armour(null, null, 0, 0, 0);
        Character.setArmour(a);
        Vampire e = new Vampire(Pp,null);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertNotEquals(Character.getHealth(), 93);
    }

    @Test
    public void VampireAttackTest7(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Character.setDefense(30);
        Vampire e = new Vampire(Pp,null);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 100);
    }

    @Test
    public void VampireAttackTest8(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Character Character = new Character(Pp);
        Character.addSoldier(soldier);
        Vampire e = new Vampire(Pp,null);
        VampireAttack va = new VampireAttack();
        va.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getSoldiers().size(), 0);
    }

    @Test
    public void ZombiecommonAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Zombie e = new Zombie(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 92);
    }

    @Test
    public void ZombieAttackTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Character.addSoldier(soldier);
        assertEquals(Character.getSoldiers().size(), 1);
        Zombie e = new Zombie(Pp,null);
        ZombieAttack za = new ZombieAttack();
        za.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getSoldiers().size(), 0);
    }

    @Test
    public void AmmourTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Armour am = new Armour(null, null, 0, 0, 0);
        Character.setArmour(am);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 98);
    }

    @Test
    public void HelmetTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Helmet Hm = new Helmet(null, null, 0, 0, 0);
        Character.setArmour(Hm);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getHealth(), 100);
    }

    @Test
    public void HelmetTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Helmet Hm = new Helmet(null, null, 0, 0, 0);
        Character.setArmour(Hm);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 10);
    }

    @Test
    public void CharacterTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Slug e = new Slug(Pp);
        ca.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 8);
    }

    @Test
    public void CharacterTestWithStake(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        StakeAttack sa = new StakeAttack();
        Character.setWeapon(s);
        Slug e = new Slug(Pp);
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 8);
    }

    @Test
    public void CharacterTestWithStake2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Vampire e = new Vampire(Pp,null);
        StakeAttack sa = new StakeAttack();
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 20);
    }

    @Test
    public void CharacterTestWithStake3(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Helmet h = new Helmet(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Character.setArmour(h);
        Vampire e = new Vampire(Pp,null);
        StakeAttack sa = new StakeAttack();
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getHealth(), 22);
    }

    @Test
    public void CharacterTestWithStaff(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Stake s = new Stake(null, null, 0, 0, 0);
        Character.setWeapon(s);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getTranceTurn(), 0);
        StaffAttack sa = new StaffAttack();
        sa.hit(Character, trancedEnemies, enemies, e, "character");
        assertEquals(e.getTranceTurn(), 5);
        e.setTranceTurn(2);
        assertEquals(e.getTranceTurn(), 2);
        assertEquals(trancedEnemies.size(), 1);
        assertEquals(enemies.size(), 0);
    }

    @Test
    public void trancedEnemyBeAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        Slug v = new Slug(Pp);
        trancedEnemies.add(v);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(trancedEnemies.size(), 0);
    }

    @Test
    public void soldierBeAttackedTest1(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Vampire e = new Vampire(Pp,null);
        Character.addSoldier(soldier);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getSoldiers().size(), 0);
    }

    @Test
    public void soldierBeAttackedTest2(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Slug e = new Slug(Pp);
        Character.addSoldier(soldier);
        ca.hit(Character, trancedEnemies, enemies, e, "enemy");
        assertEquals(Character.getSoldiers().size(), 1);
    }

    @Test
    public void soldierCommonAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "soldier");
        assertEquals(e.getHealth(), 32);
        Character.addSoldier(soldier);
        ca.hit(Character, trancedEnemies, enemies, e, "soldier");
        assertEquals(e.getHealth(), 27);
    }

    @Test
    public void slugCommonAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "slug");
        assertEquals(e.getHealth(), 28);
    }

    @Test
    public void zombieCommonAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "zombie");
        assertEquals(e.getHealth(), 24);
    }

    @Test
    public void vampireCommonAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "vampire");
        assertEquals(e.getHealth(), 17);
    }

    @Test
    public void nullCommonAttackedTest(){
        List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> trancedEnemies = new ArrayList<BasicEnemy>();
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Character Character = new Character(Pp);
        Vampire e = new Vampire(Pp,null);
        ca.hit(Character, trancedEnemies, enemies, e, "null");
        assertEquals(e.getHealth(), 32);
    }

    
}
