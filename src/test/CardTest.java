package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.BarrackCard;
import unsw.loopmania.CampfireCard;
import unsw.loopmania.OblivionCard;
import unsw.loopmania.TowerCard;
import unsw.loopmania.TrapCard;
import unsw.loopmania.VampireCastleCard;
import unsw.loopmania.VillageCard;
import unsw.loopmania.ZombiePitCard;

public class CardTest{
    @Test
    public void TowerCardTest(){
        TowerCard towerCard = new TowerCard(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0));
        assertEquals(towerCard.getX(), 0);
        assertEquals(towerCard.getY(), 0);
        assertEquals(towerCard.getName(), "TOWER");
        assertEquals(towerCard.getDescription(), "The defense tower has long range attack capability within a specific shooting radius.");
    }
    @Test
    public void ZombieCardTest(){
        ZombiePitCard zombiePitCard = new ZombiePitCard(new SimpleIntegerProperty(1) ,new SimpleIntegerProperty(0));
        assertEquals(zombiePitCard.getX(), 1);
        assertEquals(zombiePitCard.getY(), 0);
        assertEquals(zombiePitCard.getName(), "ZOMBIEPIT");
        assertEquals(zombiePitCard.getDescription(), "Several zombies will come out each turn of the game.");
    }
    @Test
    public void VampireCastleCardTest(){
        VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(2) ,new SimpleIntegerProperty(0));
        assertEquals(vampireCastleCard.getX(), 2);
        assertEquals(vampireCastleCard.getY(), 0);
        assertEquals(vampireCastleCard.getName(), "VAMPIRECASTLE");
        assertEquals(vampireCastleCard.getDescription(), "Vampires will come out each 5 loops of the game.");
    }
    @Test
    public void BarrackCardTest(){
        BarrackCard barrackCard = new BarrackCard(new SimpleIntegerProperty(3) ,new SimpleIntegerProperty(0));
        assertEquals(barrackCard.getX(), 3);
        assertEquals(barrackCard.getY(), 0);
        assertEquals(barrackCard.getName(), "BARRACK");
        assertEquals(barrackCard.getDescription(), "Character obtains one allied soldier for free when they pass through Barracks.");
    }
    @Test
    public void VillageCardTest(){
        VillageCard villageCard= new VillageCard(new SimpleIntegerProperty(4) ,new SimpleIntegerProperty(0));
        assertEquals(villageCard.getX(), 4);
        assertEquals(villageCard.getY(), 0);
        assertEquals(villageCard.getName(), "VILLAGE");
        assertEquals(villageCard.getDescription(), "Character regains health when passing through.");
    }
    @Test
    public void TrapCardTest(){
        TrapCard trapCard = new TrapCard(new SimpleIntegerProperty(5) ,new SimpleIntegerProperty(0));
        assertEquals(trapCard.getX(), 5);
        assertEquals(trapCard.getY(), 0);
        assertEquals(trapCard.getName(), "TRAP");
        assertEquals(trapCard.getDescription(), "If the enemies would be damaged if they touch those instruments.");
    }
    @Test
    public void CampfireCardTest(){
        CampfireCard campfireCard = new CampfireCard(new SimpleIntegerProperty(6) ,new SimpleIntegerProperty(0));
        assertEquals(campfireCard.getX(), 6);
        assertEquals(campfireCard.getY(), 0);
        assertEquals(campfireCard.getName(), "CAMPFIRE");
        assertEquals(campfireCard.getDescription(), "There is a kind of radius attacking bonus, within its radius all kinds of attacking will be doubled.");
    }
    @Test
    public void OblivionCardTest(){
        OblivionCard oblivionCard = new OblivionCard(new SimpleIntegerProperty(6) ,new SimpleIntegerProperty(0));
        assertEquals(oblivionCard.getX(), 6);
        assertEquals(oblivionCard.getY(), 0);
        assertEquals(oblivionCard.getName(), "Oblivion");
        assertEquals(oblivionCard.getDescription(), "Use this card to demolish unwanted structures built before.");
    }
}