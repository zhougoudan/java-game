package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.Zombie;

public class EnemyTest {

    @Test
    public void SlugTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));

        int currentPositionInPath = 2;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);

        Slug slug = new Slug(pathPosition);
        assertEquals(slug.getX(), 2);
        assertEquals(slug.getY(), 0);
        assertEquals(slug.getHealth(), 12);
        assertEquals(slug.getAggressivity(), 4);
        assertEquals(slug.getSupportRange(), 1);
        assertEquals(slug.getAttackRange(), 1);
        assertEquals(slug.getGoldDefeated(), 1);
        assertEquals(slug.getEXP(), 20);
        assertEquals(slug.getName(), "Slug");
        int x = slug.getX();
        int y = slug.getY();
        slug.move();
        assertEquals(x == slug.getX() && y == slug.getY(), false);
    }

    @Test
    public void ZombieTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));

        int currentPositionInPath = 5;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);

        Zombie zombie = new Zombie(pathPosition,null);
        assertEquals(zombie.getX(), 3);
        assertEquals(zombie.getY(), 2);
        assertEquals(zombie.getHealth(), 18);
        assertEquals(zombie.getAggressivity(), 8);
        assertEquals(zombie.getSupportRange(), 0);
        assertEquals(zombie.getAttackRange(), 2);
        assertEquals(zombie.getGoldDefeated(), 3);
        assertEquals(zombie.getEXP(), 40);
        assertEquals(zombie.getName(), "Zombie");

        int x = zombie.getX();
        int y = zombie.getY();
        zombie.move();
        assertEquals(x == zombie.getX() && y == zombie.getY(), false);
    }

    @Test
    public void VampireTest(){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        orderedPath.add(new Pair<Integer, Integer>(1,0));
        orderedPath.add(new Pair<Integer, Integer>(2,0));
        orderedPath.add(new Pair<Integer, Integer>(3,0));
        orderedPath.add(new Pair<Integer, Integer>(3,1));
        orderedPath.add(new Pair<Integer, Integer>(3,2));
        orderedPath.add(new Pair<Integer, Integer>(3,3));
        orderedPath.add(new Pair<Integer, Integer>(2,3));
        orderedPath.add(new Pair<Integer, Integer>(1,3));
        orderedPath.add(new Pair<Integer, Integer>(0,3));
        orderedPath.add(new Pair<Integer, Integer>(0,2));
        orderedPath.add(new Pair<Integer, Integer>(0,1));

        int currentPositionInPath = 4;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);

        Vampire vampire = new Vampire(pathPosition,null);
        assertEquals(vampire.getX(), 3);
        assertEquals(vampire.getY(), 1);
        assertEquals(vampire.getHealth(), 32);
        assertEquals(vampire.getAggressivity(), 15);
        assertEquals(vampire.getSupportRange(), 2);
        assertEquals(vampire.getAttackRange(), 2);
        assertEquals(vampire.getGoldDefeated(), 5);
        assertEquals(vampire.getEXP(), 60);
        assertEquals(vampire.getName(), "Vampire");
        int x = vampire.getX();
        int y = vampire.getY();
        vampire.move();
        assertEquals(x == vampire.getX() && y == vampire.getY(), false);
    }
}
