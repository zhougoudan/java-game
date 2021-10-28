package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import unsw.loopmania.Anduril;
import unsw.loopmania.Armour;
import unsw.loopmania.BarrackBuilding;
import unsw.loopmania.BarrackCard;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Building;
import unsw.loopmania.CARDS_TYPE;
import unsw.loopmania.Card;
import unsw.loopmania.Character;
import unsw.loopmania.Goal;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Slug;
import unsw.loopmania.Vampire;
import unsw.loopmania.Doggie;
import unsw.loopmania.ElanMuske;
import unsw.loopmania.Helmet;
import unsw.loopmania.ITEMS_TYPE;
import unsw.loopmania.Item;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Shield;
import unsw.loopmania.Slug;
import unsw.loopmania.Staff;
import unsw.loopmania.Stake;
import unsw.loopmania.Sword;
import unsw.loopmania.TheOneRing;
import unsw.loopmania.TreeStump;
import unsw.loopmania.VampireCastleBuilding;
import unsw.loopmania.VampireCastleCard;
import unsw.loopmania.VillageBuilding;
import unsw.loopmania.Zombie;

public class LoopManiaWorldTest {
    @Test
    public void loadCardTest(){
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
        
        Card card = world.loadCard(CARDS_TYPE.BARRACK);
        assertEquals(card instanceof BarrackCard, true);

        card = world.loadCard(CARDS_TYPE.VAMPIRECASTLE);
        assertEquals(card instanceof VampireCastleCard, true);
    }

    @Test
    public void convertCardToBuildingByCoordinates(){
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
        
        world.loadCard(CARDS_TYPE.BARRACK);
        world.loadCard(CARDS_TYPE.VAMPIRECASTLE);
        world.loadCard(CARDS_TYPE.VILLAGE);

        Building building = world.convertCardToBuildingByCoordinates(0,0,0,2);
        assertEquals(building instanceof BarrackBuilding, true);

        building = world.convertCardToBuildingByCoordinates(0,0,1,1);
        assertEquals(building instanceof VampireCastleBuilding, true);

        building = world.convertCardToBuildingByCoordinates(0,0,1,3);
        assertEquals(building instanceof VillageBuilding, true);
    }

    @Test
    public void buildingFunctionTest(){
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
        world.loadCard(CARDS_TYPE.TRAP);
        world.loadCard(CARDS_TYPE.TOWER);
        world.loadCard(CARDS_TYPE.VILLAGE);

        world.convertCardToBuildingByCoordinates(0,0,2,0);
        world.convertCardToBuildingByCoordinates(0,0,2,1);
        world.convertCardToBuildingByCoordinates(0,0,1,3);
        
        world.spawnAZombie(2,1,null);

        int currentPositionInPath = 8;
        PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
        Character character = new Character(pathPosition);
        character.setHealth(40);
        world.setCharacter(character);
        List<BasicEnemy> deadEnemies = world.buildingFunction();
        assertEquals(character.getHealth(), 60);
        assertEquals(deadEnemies.size(), 1);
    }

    @Test
    public void checkAdjacentPathTest(){
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

        assertEquals(world.checkAdjacentPath(1, 2), true);
        assertEquals(world.checkAdjacentPath(2, 2), true);
        assertEquals(world.checkAdjacentPath(0, 1), false);
        assertEquals(world.checkAdjacentPath(1, 2), true);
    }

    @Test
    public void spawnEnemiesByBuilding(){
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

        world.loadCard(CARDS_TYPE.ZOMBIEPIT);
        world.loadCard(CARDS_TYPE.VAMPIRECASTLE);

        world.convertCardToBuildingByCoordinates(0,0,1,2);
        world.convertCardToBuildingByCoordinates(0,0,2,2);

        List<BasicEnemy> retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 2);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 1);
        retLis = world.spawnEnemiesByBuilding();
        assertEquals(retLis.size(), 2);
    }

    @Test
    public void checkInPathTest(){
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

        assertEquals(world.checkInPath(1, 2), false);
        assertEquals(world.checkInPath(2, 2), false);
        assertEquals(world.checkInPath(2, 3), true);
        assertEquals(world.checkInPath(0, 2), true);
    }

    @Test
    public void removeCardTest(){
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
        
        Card card1 = world.loadCard(CARDS_TYPE.TRAP);
        Card card2 = world.loadCard(CARDS_TYPE.TOWER);
        world.loadCard(CARDS_TYPE.VILLAGE);

        world.removeCard(2);
        assertEquals(world.getLastCardEntity(), card2);

        world.removeCard(1);
        assertEquals(world.getLastCardEntity(), card1);

        world.removeCard(0);
        assertEquals(world.getLastCardEntity(), null);
    }

    @Test
    public void getLastCardEntityTest(){
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
        
        Card card = world.loadCard(CARDS_TYPE.TRAP);
        assertEquals(world.getLastCardEntity(), card);
        card = world.loadCard(CARDS_TYPE.TOWER);
        assertEquals(world.getLastCardEntity(), card);
        card = world.loadCard(CARDS_TYPE.VILLAGE);
        assertEquals(world.getLastCardEntity(), card);
    }

    @Test
    public void addUnequippedItem(){
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
        
        Item item = world.addUnequippedItem(ITEMS_TYPE.SWORD);
        assertEquals(item instanceof Sword, true);

        Item item2 = world.addUnequippedItem(ITEMS_TYPE.STAFF);
        assertEquals(item2 instanceof Staff, true);

        Item item3 = world.addUnequippedItem(ITEMS_TYPE.STAKE);
        assertEquals(item3 instanceof Stake, true);

        Item item4 = world.addUnequippedItem(ITEMS_TYPE.SHIELD);
        assertEquals(item4 instanceof Shield, true);

        Item item5 = world.addUnequippedItem(ITEMS_TYPE.ARMOUR);
        assertEquals(item5 instanceof Armour, true);

        Item item6 = world.addUnequippedItem(ITEMS_TYPE.HELMET);
        assertEquals(item6 instanceof Helmet, true);

        Item item7 = world.addUnequippedItem(ITEMS_TYPE.ANDURIL);
        assertEquals(item7 instanceof Anduril, true);

        Item item8 = world.addUnequippedItem(ITEMS_TYPE.TREESTUMP);
        assertEquals(item8 instanceof TreeStump, true);

        Item item9 = world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(item9 instanceof TheOneRing, true);
    }

    @Test
    public void GRUnequippedInventoryItemByCoordinatesTest(){
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
        
        world.addUnequippedItem(ITEMS_TYPE.SWORD);
        assertEquals(world.getUnequippedInventoryItems().size(), 1);
        world.removeUnequippedInventoryItemByCoordinates(0, 0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
    }

    @Test
    public void GetEquippedFromUnequippedByCoordinatesTest(){
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
        
        Item item = world.addUnequippedItem(ITEMS_TYPE.SWORD);
        world.addEquippedInventoryItems(item);
        assertEquals(world.getEquippedInventoryItems().get(0), item);
        assertEquals(world.getEquippedInventoryItems().size(), 1);
        assertEquals(item instanceof Sword, true);
    }

    @Test
    public void setCharacterEquipmentTest(){
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
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        Character character = new Character(pathPosition);
        world.setCharacter(character);
        assertEquals(world.getCharacter(), character);

        world.addUnequippedItem(ITEMS_TYPE.SWORD);
        Item item = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getAggressivity(), 4);
        world.setCharacterEquipment(character, item);
        assertEquals(character.getAggressivity(), 10);

        world.addUnequippedItem(ITEMS_TYPE.STAKE);
        Item item2 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getAggressivity(), 10);
        world.setCharacterEquipment(character, item2);
        assertEquals(character.getAggressivity(), 8);

        world.addUnequippedItem(ITEMS_TYPE.STAFF);
        Item item4 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getAggressivity(), 8);
        world.setCharacterEquipment(character, item4);
        assertEquals(character.getAggressivity(), 6);

        world.addUnequippedItem(ITEMS_TYPE.ANDURIL);
        Item item8 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getAggressivity(), 6);
        world.setCharacterEquipment(character, item8);
        assertEquals(character.getAggressivity(), 13);

        world.addUnequippedItem(ITEMS_TYPE.ARMOUR);
        Item item3 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 0, 1);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getDefense(), 0);
        world.setCharacterEquipment(character, item3);
        assertEquals(character.getDefense(), 3);

        world.addUnequippedItem(ITEMS_TYPE.HELMET);
        Item item5 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 0, 1);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getDefense(), 3);
        world.setCharacterEquipment(character, item5);
        assertEquals(character.getDefense(), 1);

        world.addUnequippedItem(ITEMS_TYPE.SHIELD);
        Item item6 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 1);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getDefense(), 1);
        world.setCharacterEquipment(character, item6);
        assertEquals(character.getDefense(), 1);

        world.addUnequippedItem(ITEMS_TYPE.TREESTUMP);
        Item item7 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 1, 1);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        assertEquals(character.getDefense(), 1);
        world.setCharacterEquipment(character, item7);
        assertEquals(character.getDefense(), 1);

        world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        Item item9 = world.GetEquippedFromUnequippedByCoordinates(0, 0, 2, 1);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
        world.setCharacterEquipment(character, item9);
        assertEquals(world.GetUsedTheOneRing(), false);
    }

    @Test
    public void GSetUsedTheOneRingTest(){
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
        world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        world.GetEquippedFromUnequippedByCoordinates(0, 0, 2, 1);
        assertEquals(world.GetUsedTheOneRing(), false);
        world.setUsedTheOneRing(true);
        assertEquals(world.GetUsedTheOneRing(), true);
    }

    @Test
    public void getLastUnequippedInventoryItemTest(){
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
        Item item = world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(world.getUnequippedInventoryItems().size(), 1);
        assertEquals(world.getUnequippedInventoryItems().get(0), item);
        assertEquals(world.getLastUnequippedInventoryItem(), item);
    }

    @Test
    public void getFirstAvailableSlotForItemTest(){
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
        world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(world.getFirstAvailableSlotForItem(), new Pair<Integer, Integer>(1, 0));
        world.addUnequippedItem(ITEMS_TYPE.SWORD);
        assertEquals(world.getFirstAvailableSlotForItem(), new Pair<Integer, Integer>(2, 0));
    }
    
    @Test
    public void removeItemByPositionInUnequippedInventoryItemsTest(){
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
        world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(world.getUnequippedInventoryItems().size(), 1);
        world.removeItemByPositionInUnequippedInventoryItems(0);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
    }

    @Test
    public void removeUnequippedInventoryItemTest(){
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
        Item item = world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(world.getUnequippedInventoryItems().size(), 1);
        world.removeUnequippedInventoryItem(item);
        assertEquals(world.getUnequippedInventoryItems().size(), 0);
    }

    @Test
    public void getUnequippedInventoryItemEntityByCoordinatesTest(){
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
        Item item = world.addUnequippedItem(ITEMS_TYPE.THEONERING);
        assertEquals(world.getUnequippedInventoryItemEntityByCoordinates(0,0), item);
    }

    @Test
    public void getWidthHeightTest(){
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
        assertEquals(world.getWidth(), 4);
        assertEquals(world.getHeight(), 4);
    }

    @Test
    public void possiblySpawnEnemies(){
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
        assertEquals(world.getRoundsNum(), 0);
        world.addRoundsNum();
        assertEquals(world.getRoundsNum(), 1);
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        Character character = new Character(pathPosition);
        world.setCharacter(character);
        world.possiblySpawnEnemies();
        // spawn enemy is probability, so it will increase test time.
        /*
        while (world.getEnemies().isEmpty()) {
            world.possiblySpawnEnemies();   
        }
        assertEquals(world.getEnemies().get(0) instanceof Slug, true);
        for (int i = 0; i < 21; i++) {
            world.addRoundsNum();
        }
        assertEquals(world.getRoundsNum(), 21);
        while (!(world.getEnemies().get(world.getEnemies().size() - 1) instanceof Doggie)) {
            world.possiblySpawnEnemies();   
        }
        assertEquals(world.getEnemies().get(world.getEnemies().size() - 1) instanceof Doggie, true);
        assertEquals(world.getBossNum(), 1);
        for (int i = 0; i < 20; i++) {
            world.addRoundsNum();
        }
        assertEquals(world.getRoundsNum(), 41);      
        character.setEXP(10001);
        assertEquals(character.getEXP(), 10001); 
        while (!(world.getEnemies().get(world.getEnemies().size() - 1) instanceof ElanMuske)) {
            world.possiblySpawnEnemies();   
        }
        assertEquals(world.getEnemies().get(world.getEnemies().size() - 1) instanceof ElanMuske, true);
        assertEquals(world.getBossNum(), 2);*/
        assertEquals(world.getBossNum(), 0);
        world.setBossNum(world.getBossNum() + 1);
        assertEquals(world.getBossNum(), 1);
    }


@Test
public void battleDetails1Test(){
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
    int currentPositionInPath = 2;
    PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Character character = new Character(pathPosition);
    character.setHealth(100);
    world.setCharacter(character);

    currentPositionInPath = 3;
    pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Slug slug = new Slug(pathPosition);
    List<BasicEnemy> enemies = world.getEnemies();
    enemies.add(slug);

    int healthPt = world.getCharacter().getHealth();
    world.runBattles();
    int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

    int slugsNum = world.getencounterSlugsNum();
    int zombiesNum = world.getEncounterZombiesNum();
    int vampiresNum = world.getencounterVampiresNum();

    assertFalse(world.getIsDead());
    assertEquals(slugsNum, 1);
    assertEquals(zombiesNum, 0);
    assertEquals(vampiresNum, 0);
    assertEquals(lossBlood, 12);
}
@Test
public void battleDetails2Test(){
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
    int currentPositionInPath = 2;
    PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Character character = new Character(pathPosition);
    character.setHealth(100);
    world.setCharacter(character);


    // set goal
    JSONObject json = new JSONObject();
    json.put("goal","AND");
    JSONArray jsonArray = new JSONArray();
    JSONObject tmp = new JSONObject();
    tmp.put("goal","cycles");
    tmp.put("quantity",10);
    jsonArray.put(tmp);
    tmp = new JSONObject();
    tmp.put("goal","OR");
    JSONArray jsonArray1 = new JSONArray();
    JSONObject tmp1 = new JSONObject();
    tmp1.put("goal","experience");
    tmp1.put("quantity",200);
    jsonArray1.put(tmp1);
    tmp1 = new JSONObject();
    tmp1.put("goal","gold");
    tmp1.put("quantity",200);
    jsonArray1.put(tmp1);
    tmp.put("subgoals",jsonArray1);
    jsonArray.put(tmp);
    json.put("subgoals",jsonArray);
    world.setGoalCondition(new Goal(json));
    
    // ad enemies
    currentPositionInPath = 3;
    pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Slug slug = new Slug(pathPosition);
    List<BasicEnemy> enemies = world.getEnemies();
    enemies.add(slug);

    currentPositionInPath = 1;
    Zombie zombie = new Zombie(pathPosition,null);
    enemies.add(zombie);

    // check
    int healthPt = world.getCharacter().getHealth();
    world.runBattles();
    int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

    int slugsNum = world.getencounterSlugsNum();
    int zombiesNum = world.getEncounterZombiesNum();
    int vampiresNum = world.getencounterVampiresNum();

    assertFalse(world.getIsDead());
    assertEquals(slugsNum, 1);
    assertEquals(zombiesNum, 1);
    assertEquals(vampiresNum, 0);
    assertEquals(lossBlood, 76);
}
@Test
public void battleDetails3Test(){
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
    int currentPositionInPath = 2;
    PathPosition pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Character character = new Character(pathPosition);
    character.setHealth(100);
    world.setCharacter(character);

    // set goal
    JSONObject json = new JSONObject();
    json.put("goal","AND");
    JSONArray jsonArray = new JSONArray();
    JSONObject tmp = new JSONObject();
    tmp.put("goal","cycles");
    tmp.put("quantity",10);
    jsonArray.put(tmp);
    tmp = new JSONObject();
    tmp.put("goal","OR");
    JSONArray jsonArray1 = new JSONArray();
    JSONObject tmp1 = new JSONObject();
    tmp1.put("goal","experience");
    tmp1.put("quantity",200);
    jsonArray1.put(tmp1);
    tmp1 = new JSONObject();
    tmp1.put("goal","gold");
    tmp1.put("quantity",200);
    jsonArray1.put(tmp1);
    tmp.put("subgoals",jsonArray1);
    jsonArray.put(tmp);
    json.put("subgoals",jsonArray);
    world.setGoalCondition(new Goal(json));
    
    // add enemies
    currentPositionInPath = 3;
    pathPosition = new PathPosition(currentPositionInPath, orderedPath);
    Slug slug = new Slug(pathPosition);
    List<BasicEnemy> enemies = world.getEnemies();
    enemies.add(slug);

    currentPositionInPath = 1;
    Vampire vampire = new Vampire(pathPosition,null);
    enemies.add(vampire);

    // check
    int healthPt = world.getCharacter().getHealth();
    world.runBattles();
    int lossBlood = Math.max(healthPt-world.getCharacter().getHealth(), 0);

    int slugsNum = world.getencounterSlugsNum();
    int zombiesNum = world.getEncounterZombiesNum();
    int vampiresNum = world.getencounterVampiresNum();

    assertTrue(world.getIsDead());
    assertEquals(slugsNum, 1);
    assertEquals(zombiesNum, 0);
    assertEquals(vampiresNum, 1);
    assertEquals(lossBlood, 100);
}
}
