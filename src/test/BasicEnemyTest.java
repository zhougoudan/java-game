package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.AlliedSoldier;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.Zombie;

import org.javatuples.Pair;

public class BasicEnemyTest {
    @Test
    public void enemyTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getAggressivity(), 4);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void enemyTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getHealth(), 12);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void enemyTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
    
        assertEquals(e.getAttackRange(), 1);
        e.setAttackRange(2);
        assertEquals(e.getAttackRange(), 2);
    }

    @Test
    public void enemyTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        
        assertEquals(e.getSupportRange(), 1);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void enemyTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getName(), "Slug");
        e.setName("Steve");
        assertEquals(e.getName(), "Steve");
    }

    @Test
    public void enemyTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getGoldDefeated(), 1);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void enemyTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Slug e = new Slug(Pp);
        assertEquals(e.getEXP(), 20);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void zombieTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getAggressivity(), 8);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void zombieTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getHealth(), 18);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void zombieTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void zombieTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        
        assertEquals(e.getSupportRange(), 0);
        e.setSupportRange(2);
        assertEquals(e.getSupportRange(), 2);
    }

    @Test
    public void zombieTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getName(), "Zombie");
        e.setName("Jeffery");
        assertEquals(e.getName(), "Jeffery");
    }

    @Test
    public void zombieTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getGoldDefeated(), 3);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void zombieTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Zombie e = new Zombie(Pp,null);
        assertEquals(e.getEXP(), 40);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void vampireTest1(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getAggressivity(), 15);
        e.setAggressivity(1);
        assertEquals(e.getAggressivity(), 1);
    }

    @Test
    public void vampireTest2(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getHealth(), 32);
        e.setHealth(1);
        assertEquals(e.getHealth(), 1);
    }

    @Test
    public void vampireTest3(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);;
    
        assertEquals(e.getAttackRange(), 2);
        e.setAttackRange(1);
        assertEquals(e.getAttackRange(), 1);
    }

    @Test
    public void vampireTest4(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        
        assertEquals(e.getSupportRange(), 2);
        e.setSupportRange(1);
        assertEquals(e.getSupportRange(), 1);
    }

    @Test
    public void vampireTest5(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getName(), "Vampire");
        e.setName("Victor");
        assertEquals(e.getName(), "Victor");
    }

    @Test
    public void vampireTest6(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getGoldDefeated(), 5);
        e.setGoldDefeated(2);
        assertEquals(e.getGoldDefeated(), 2);
    }

    @Test
    public void vampireTest7(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<Integer, Integer>(1,1));
        PathPosition Pp = new PathPosition(0, orderedPath);
        Vampire e = new Vampire(Pp,null);
        assertEquals(e.getEXP(), 60);
        e.setEXP(1);
        assertEquals(e.getEXP(), 1);
    }

    @Test
    public void alliedSoldierTest1(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        assertEquals(soldier.getAggressivity(), 5);
    }

    @Test
    public void alliedSoldierTest2(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        assertEquals(soldier.getHealth(), 15);
    }

    @Test
    public void alliedSoldierTest3(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        soldier.setAggressivity(1);
        assertEquals(soldier.getAggressivity(), 1);
    }

    @Test
    public void alliedSoldierTest4(){
        AlliedSoldier soldier = new AlliedSoldier(new SimpleIntegerProperty(1),new SimpleIntegerProperty(1));
        soldier.setHealth(1);
        assertEquals(soldier.getHealth(), 1);
    }
}
