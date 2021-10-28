package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Anduril;
import unsw.loopmania.Armour;
import unsw.loopmania.Character;
import unsw.loopmania.DoggieCoin;
import unsw.loopmania.HealthPotion;
import unsw.loopmania.Helmet;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Shield;
import unsw.loopmania.Staff;
import unsw.loopmania.Stake;
import unsw.loopmania.Sword;
import unsw.loopmania.TheOneRing;
import unsw.loopmania.TreeStump;

public class ItemsTest {

    // test items created
    @Test
    public void SwordItemTest() {
        Sword sword = new Sword(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 6, 0, 10);
        assertEquals(sword.getX(), 0);
        assertEquals(sword.getY(), 0);
        assertEquals(sword.getDamageValue(), 6);
        assertEquals(sword.getDefenseValue(), 0);
        assertEquals(sword.getPrice(), 10);
    }

    @Test
    public void StakeItemTest() {
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        assertEquals(stake.getX(), 0);
        assertEquals(stake.getY(), 0);
        assertEquals(stake.getDamageValue(), 4);
        assertEquals(stake.getDefenseValue(), 0);
        assertEquals(stake.getPrice(), 10);
    }

    @Test
    public void StaffItemTest() {
        Staff staff = new Staff(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 2, 0, 15);
        assertEquals(staff.getX(), 0);
        assertEquals(staff.getY(), 0);
        assertEquals(staff.getDamageValue(), 2);
        assertEquals(staff.getDefenseValue(), 0);
        assertEquals(staff.getPrice(), 15);
    }

    @Test
    public void ArmourItemTest() {
        Armour armour = new Armour(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 3, 20);
        assertEquals(armour.getX(), 0);
        assertEquals(armour.getY(), 0);
        assertEquals(armour.getDamageValue(), 0);
        assertEquals(armour.getDefenseValue(), 3);
        assertEquals(armour.getPrice(), 20);
    }

    @Test
    public void ShieldItemTest() {
        Shield shield = new Shield(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 20);
        assertEquals(shield.getX(), 0);
        assertEquals(shield.getY(), 0);
        assertEquals(shield.getDamageValue(), 0);
        assertEquals(shield.getDefenseValue(), 0);
        assertEquals(shield.getPrice(), 20);
    }

    @Test
    public void HelmetItemTest() {
        Helmet helmet = new Helmet(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 1, 20);
        assertEquals(helmet.getX(), 0);
        assertEquals(helmet.getY(), 0);
        assertEquals(helmet.getDamageValue(), 0);
        assertEquals(helmet.getDefenseValue(), 1);
        assertEquals(helmet.getPrice(), 20);
    }

    @Test
    public void TheOneRingItemTest() {
        TheOneRing theOneRing = new TheOneRing(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 0);
        assertEquals(theOneRing.getX(), 0);
        assertEquals(theOneRing.getY(), 0);
        assertEquals(theOneRing.getDamageValue(), 0);
        assertEquals(theOneRing.getDefenseValue(), 0);
        assertEquals(theOneRing.getPrice(), 0);
    }

    @Test
    public void HealthPotionItemTest() {
        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 10);
        assertEquals(healthPotion.getX(), 0);
        assertEquals(healthPotion.getY(), 0);
        assertEquals(healthPotion.getDamageValue(), 0);
        assertEquals(healthPotion.getDefenseValue(), 0);
        assertEquals(healthPotion.getPrice(), 10);
    }

    @Test
    public void AndurilItemTest() {
        Anduril anduril = new Anduril(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 9, 0, 30);
        assertEquals(anduril.getX(), 0);
        assertEquals(anduril.getY(), 0);
        assertEquals(anduril.getDamageValue(), 9);
        assertEquals(anduril.getDefenseValue(), 0);
        assertEquals(anduril.getPrice(), 30);
    }

    @Test
    public void TreeStumpItemTest() {
        TreeStump treeStump = new TreeStump(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 30);
        assertEquals(treeStump.getX(), 0);
        assertEquals(treeStump.getY(), 0);
        assertEquals(treeStump.getDamageValue(), 0);
        assertEquals(treeStump.getDefenseValue(), 0);
        assertEquals(treeStump.getPrice(), 30);
    }

    @Test
    public void DoggieCoinTest() {
        DoggieCoin doggieCoin = new DoggieCoin(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 40);
        assertEquals(doggieCoin.getX(), 0);
        assertEquals(doggieCoin.getY(), 0);
        assertEquals(doggieCoin.getDamageValue(), 0);
        assertEquals(doggieCoin.getDefenseValue(), 0);
        assertEquals(doggieCoin.getPrice(), 40);
    }   
    //-----------------------------------------------------------------------------------//
    // test character equipped items
    @Test
    public void EquippedSwordTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Sword sword = new Sword(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 6, 0, 10);
        // check character without equip sword
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip sword
        world.setCharacterEquipment(character, sword);
        assertEquals(character.getAggressivity(), 10);
        assertEquals(character.getDefense(), 0);       
    }

    @Test
    public void EquippedStakeTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        // check character without equip stake
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip stake
        world.setCharacterEquipment(character, stake);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 0);       
    }

    @Test
    public void EquippedStaffTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Staff staff = new Staff(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 2, 0, 15);
        // check character without equip staff
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip staff
        world.setCharacterEquipment(character, staff);
        assertEquals(character.getAggressivity(), 6);
        assertEquals(character.getDefense(), 0);       
    }  
    
    @Test
    public void EquippedArmourTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Armour armour = new Armour(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 3, 20);
        // check character without equip armour
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip armour
        world.setCharacterEquipment(character, armour);
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 3);       
    } 

    @Test
    public void EquippedShieldTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Shield shield = new Shield(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 20);
        // check character without equip shield
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip shield
        world.setCharacterEquipment(character, shield);
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);       
    }

    @Test
    public void EquippedHelmetTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Helmet helmet = new Helmet(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 1, 20);
        // check character without equip helmet
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip helmet
        world.setCharacterEquipment(character, helmet);
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 1);       
    }

    @Test
    public void EquippedAndurilTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Anduril anduril = new Anduril(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 9, 0, 30);
        // check character without equip anduril
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip sword
        world.setCharacterEquipment(character, anduril);
        assertEquals(character.getAggressivity(), 13);
        assertEquals(character.getDefense(), 0);       
    }

    @Test
    public void EquippedTreeStumpTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        TreeStump treeStump = new TreeStump(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 30);
        // check character without equip treeStump
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip treeStump
        world.setCharacterEquipment(character, treeStump);
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);       
    }

    @Test
    public void EquippedNewWeaponTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        // check character without equip stake
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip stake
        world.setCharacterEquipment(character, stake);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 0); 
        // check charcter equip a sword(new weapon)  
        Sword sword = new Sword(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 6, 0, 10);
        world.setCharacterEquipment(character, sword);
        assertEquals(character.getAggressivity(), 10);
        assertEquals(character.getDefense(), 0);      
    }

    @Test
    public void EquippedAllTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        // check character without equip stake
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip stake
        world.setCharacterEquipment(character, stake);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 0);  
        // check charcter after equip armour
        Armour armour = new Armour(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 3, 20);
        world.setCharacterEquipment(character, armour);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 3); 
        // check charcter after equip shield
        Shield shield = new Shield(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 0, 0, 20);
        world.setCharacterEquipment(character, shield);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 3);    
    }
}
