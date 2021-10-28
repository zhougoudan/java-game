package test;

import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;
import unsw.loopmania.BarrackBuilding;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Building;
import unsw.loopmania.CampfireBuilding;
import unsw.loopmania.Card;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.OblivionCard;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.TowerBuilding;
import unsw.loopmania.TrapBuilding;
import unsw.loopmania.Vampire;
import unsw.loopmania.VampireCastleBuilding;
import unsw.loopmania.VillageBuilding;
import unsw.loopmania.Zombie;
import unsw.loopmania.ZombiePitBuilding;

public class BuildingTest{
    @Test
    public void TowerBuildingTest(){
        TowerBuilding building = new TowerBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 1);

        List<BasicEnemy> enemies = new ArrayList<>();
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
        enemies.add(slug);

        currentPositionInPath = 6;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        slug = new Slug(pathPosition);
        enemies.add(slug);

        List<BasicEnemy> deadEnemies = building.work(enemies);
        assertEquals(deadEnemies.size(), 1);
        assertEquals(deadEnemies.get(0), enemies.get(0));
    }

    @Test
    public void ZombiePitBuildingTest(){
        ZombiePitBuilding building = new ZombiePitBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        List<BasicEnemy> enemies = building.spawnZombie(world);
        assertEquals(enemies.size(), 1);
    }

    @Test
    public void VampireCastleBuildingTest(){
        VampireCastleBuilding building = new VampireCastleBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        List<BasicEnemy> enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 1);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 0);
        enemies = building.spawnVampires(world);
        assertEquals(enemies.size(), 1);
    }

    @Test
    public void BarrackBuildingTest(){
        BarrackBuilding building = new BarrackBuilding(new SimpleIntegerProperty(3), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 3);
        assertEquals(building.getY(), 1);

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
        Character character = new Character(pathPosition);
        building.work(character);
        assertEquals(character.getSoldiers().size(), 1);

        currentPositionInPath = 5;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        building.work(character);
        assertEquals(character.getSoldiers().size(), 0);
    }

    @Test
    public void VillageBuildingTest(){
        VillageBuilding building = new VillageBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(1));
        assertEquals(building.getX(), 0);
        assertEquals(building.getY(), 1);

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

        int currentPositionInPath = 10;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(40);
        assertEquals(character.getHealth(), 40);
        building.work(character);
        assertEquals(character.getHealth(), 40);

        currentPositionInPath = 11;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        character.setHealth(52);
        assertEquals(character.getHealth(), 52);
        building.work(character);
        assertEquals(character.getHealth(), 72);
    }

    @Test
    public void TrapBuildingTest(){
        TrapBuilding building = new TrapBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(3));
        assertEquals(building.getX(), 0);
        assertEquals(building.getY(), 3);

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

        List<BasicEnemy> enemies = new ArrayList<>();
        int currentPositionInPath = 9;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Slug slug = new Slug(pathPosition);
        slug.setHealth(10);
        enemies.add(slug);

        currentPositionInPath = 9;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        slug = new Slug(pathPosition);
        slug.setHealth(22);
        enemies.add(slug);

        List<BasicEnemy> deadEnemies = building.work(enemies);
        assertEquals(deadEnemies.size(), 1);
        assertEquals(enemies.get(1).getHealth(), 10);
    }

    @Test
    public void CampfireBuildingTest(){
        CampfireBuilding building = new CampfireBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building.getX(), 2);
        assertEquals(building.getY(), 2);

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
        Character character = new Character(pathPosition);
        assertEquals(building.work(character), true);

        currentPositionInPath = 1;
        pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        character = new Character(pathPosition);
        assertEquals(building.work(character), false);
    }
    @Test
    public void OblivionDemolishOrdinaryBuildingTest(){
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
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        // add buildings
        List<Building> buildings = world.getBuildingEntities();
        CampfireBuilding building1 = new CampfireBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(2));
        assertEquals(building1.getX(), 2);
        assertEquals(building1.getY(), 2);
        buildings.add(building1);

        BarrackBuilding building2 = new BarrackBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(3));
        assertEquals(building2.getX(), 0);
        assertEquals(building2.getY(), 3);
        buildings.add(building2);

        VillageBuilding building3 = new VillageBuilding(new SimpleIntegerProperty(3), new SimpleIntegerProperty(2));
        assertEquals(building3.getX(), 3);
        assertEquals(building3.getY(), 2);
        buildings.add(building3);


        // add oblivion card
        List<Card> cardEntities = world.getCardsEntities();
        Card card = new OblivionCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        cardEntities.add(card);
        assertEquals(card.getX(), 0);
        assertEquals(card.getY(), 0);
        
        Building mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assumeNotNull(mBuilding);


        // check whether the building was removed
        Building newBuilding = world.convertCardToBuildingByCoordinates(card.getX(), card.getY(), 0, 3);
        assertNull(newBuilding);
        assertEquals(0, cardEntities.size());
        buildings.remove(building2);
        building2.destroy();
        assertEquals(buildings.size(),2);

        mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assertNull(mBuilding);
    }
    @Test
    public void OblivionDemolishZombiePitBuildingTest(){
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
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        // add buildings
        List<Building> buildings = world.getBuildingEntities();
        ZombiePitBuilding building1 = new ZombiePitBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(1));
        assertEquals(building1.getX(), 2);
        assertEquals(building1.getY(), 1);
        buildings.add(building1);

        List<BasicEnemy> enemies = world.getEnemies();
        int currentPositionInPath = 2;
        PathPosition position = new PathPosition(currentPositionInPath, orderedPath);
        enemies.add(new Zombie(position, building1));

        BarrackBuilding building2 = new BarrackBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(3));
        assertEquals(building2.getX(), 0);
        assertEquals(building2.getY(), 3);
        buildings.add(building2);

        // add oblivion card
        List<Card> cardEntities = world.getCardsEntities();
        Card card = new OblivionCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        cardEntities.add(card);
        assertEquals(card.getX(), 0);
        assertEquals(card.getY(), 0);
        
        Building mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assumeNotNull(mBuilding);

        // check whether the building was removed
        Building newBuilding = world.convertCardToBuildingByCoordinates(card.getX(), card.getY(), 0, 3);
        assertNull(newBuilding);
        assertEquals(0, cardEntities.size());
        buildings.remove(building2);
        building2.destroy();

        Iterator<BasicEnemy> it = enemies.iterator();
        while(it.hasNext()){
            BasicEnemy enemy = it.next();
            if(enemy instanceof Zombie && ((Zombie)enemy).getZombieBuilding()==building1){
                enemy.destroy();
                it.remove();
            }
        }
        assertEquals(buildings.size(),1);
        assertEquals(0, enemies.size());

        mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assertNull(mBuilding);
    }
    @Test
    public void OblivionDemolishVampireCastleBuildingTest(){
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
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedPath);
        
        // add buildings
        List<Building> buildings = world.getBuildingEntities();
        VampireCastleBuilding building1 = new VampireCastleBuilding(new SimpleIntegerProperty(2), new SimpleIntegerProperty(1));
        assertEquals(building1.getX(), 2);
        assertEquals(building1.getY(), 1);
        buildings.add(building1);

        List<BasicEnemy> enemies = world.getEnemies();
        int currentPositionInPath = 2;
        PathPosition position = new PathPosition(currentPositionInPath, orderedPath);
        enemies.add(new Vampire(position, building1));
        currentPositionInPath = 3;
        position = new PathPosition(currentPositionInPath, orderedPath);
        enemies.add(new Vampire(position, building1));

        BarrackBuilding building2 = new BarrackBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(3));
        assertEquals(building2.getX(), 0);
        assertEquals(building2.getY(), 3);
        buildings.add(building2);

        // add oblivion card
        List<Card> cardEntities = world.getCardsEntities();
        Card card = new OblivionCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        cardEntities.add(card);
        assertEquals(card.getX(), 0);
        assertEquals(card.getY(), 0);
        
        Building mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assumeNotNull(mBuilding);

        // check whether the building was removed
        Building newBuilding = world.convertCardToBuildingByCoordinates(card.getX(), card.getY(), 0, 3);
        assertNull(newBuilding);
        assertEquals(0, cardEntities.size());
        buildings.remove(building2);
        building2.destroy();

        Iterator<BasicEnemy> it = enemies.iterator();
        while(it.hasNext()){
            BasicEnemy enemy = it.next();
            if(enemy instanceof Vampire && ((Vampire)enemy).getVampireCastleBuilding()==building1){
                enemy.destroy();
                it.remove();
            }
        }
        assertEquals(buildings.size(),1);
        assertEquals(0, enemies.size());

        mBuilding = null;
        for(Building building : buildings){
            if(building.getX() == 0 && building.getY() == 3){
                mBuilding = building;
            }
        }
        assertNull(mBuilding);
    }
}