package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one entity
 * can occupy the same square.
 */
public class LoopManiaWorld {
    /**
     * width and height of the unequippedInventory slots
     */
    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;

    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    /**
     * the charcter
     */
    private Character character;

    /**
     * list of basic enemies
     */
    private List<BasicEnemy> enemies;

    /**
     * list of cards
     */
    private List<Card> cardEntities;

    /**
     * list of items
     */
    private List<Item> unequippedInventoryItems;

    /**
     * list of items
     */
    private List<Item> equippedInventoryItems;

    /**
     * list of building entities
     */
    private List<Building> buildingEntities;

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse
     * them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    /**
     * list of goals showing
     */
    private Goal goalCondition;

    /**
     * the number of rounds
     */
    private int roundsNum = 0;

    /**
     * the number of rounds
     */
    private boolean UsedTheOneRing = false;    
    private boolean IsFight = false;
    private boolean IsDead = false;

    private int slugsNum;
    private int zombiesNum;
    private int vampiresNum;
    private int elanmuskeNum;
    private int doggiesNum;
    private int bossNum;

    int encounterSlugsNum = 0;
    int encounterZombiesNum = 0;
    int encounterVampiresNum = 0;
    int encounterElanmuskeNum = 0;
    int encounterDoggiesNum = 0;
    int encounterDoggie = 0;
    int encounterElanMuske = 0;

    private String battleItem;
    /**
     * create the world (constructor)
     * 
     * @param width       width of world in number of cells
     * @param height      height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing
     *                    position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        equippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
        //this.goalCondition = 

    }

    /**
     * get world wigth
     * 
     * @return world wigth
     */
    public int getWidth() {
        return width;
    }

    /**
     * get world height
     * 
     * @return world height
     */
    public int getHeight() {
        return height;
    }

    /**
     * get world boss number
     * 
     * @return boss number
     */
    public int getBossNum() {
        return bossNum;
    }

    /**
     * set world boss number
     * 
     * @return boss number
     */
    public void setBossNum(int newNum) {
        this.bossNum = newNum;
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity
     * out of the file
     * 
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the
     * world)
     * 
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // if more specialised types being added from main menu, add more methods like
        // this with specific input types...
        nonSpecifiedEntities.add(entity);
    }

    /**
     * spawns enemies if the conditions warrant it, adds to world
     * 
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies() {
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null) {
            int indexInPath = orderedPath.indexOf(pos);
            Slug slug = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(slug);
            spawningEnemies.add(slug);
            int rd = new Random().nextInt(10);
            if (roundsNum > 20) {
                if (rd < 5) {
                    Doggie doggie = new Doggie(new PathPosition(indexInPath, orderedPath));
                    enemies.add(doggie);
                    spawningEnemies.add(doggie);
                    setBossNum(getBossNum() + 1);  
                }
            }
            if (roundsNum > 40 && character.getEXP() > 10000) {
                if (rd < 2) {
                    ElanMuske elanMuske = new ElanMuske(new PathPosition(indexInPath, orderedPath));
                    for (Item item: unequippedInventoryItems) {
                        if (item instanceof DoggieCoin) {
                            elanMuske.registerObserver((DoggieCoin)item);
                        }
                    }
                    elanMuske.notifyObservers(80);
                    enemies.add(elanMuske);
                    spawningEnemies.add(elanMuske);
                    setBossNum(getBossNum() + 1);  
                }               
            }
        }
        return spawningEnemies;
    }

    /**
     * kill an enemy
     * 
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy) {
        enemy.destroy();
        enemies.remove(enemy);
    }

    private List<BasicEnemy> fight() {
        List<BasicEnemy> possibleSupporEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> fightEnemies = new ArrayList<BasicEnemy>();
        IsFight = false;
        encounterSlugsNum = 0;
        encounterZombiesNum = 0;
        encounterVampiresNum = 0;
        encounterDoggiesNum = 0;
        encounterElanmuskeNum = 0;
        encounterDoggie = 0;
        encounterElanMuske = 0;
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            // implement different RHS on this inequality, based on influence radii and battle radii
            // add enemy to fight list and possible support list
            switch (e.getName()) {
                case "Elan Muske":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                        int rd = new Random().nextInt(10);
                        if (rd < 2) {
                            fightEnemies.add(e);
                            encounterElanMuske += 1;
                            IsFight = true;
                        } 
                    }
                    break;
                case "Doggie":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                        fightEnemies.add(e);
                        encounterDoggie += 1;
                        IsFight = true;
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                case "Slug":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                        fightEnemies.add(e);
                        if(e.getName().equals("Doggie")){
                            encounterDoggiesNum += 1;
                        }else if(e.getName().equals("Elan Muske")){
                            encounterElanmuskeNum += 1;
                        }else if(e.getName().equals("Slug")){
                            encounterSlugsNum += 1;
                        }
                        IsFight = true;
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                case "Zombie":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                        fightEnemies.add(e);
                        encounterZombiesNum += 1;
                        IsFight = true;
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                case "Vampire":
                    if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                        fightEnemies.add(e);
                        encounterVampiresNum += 1;
                        IsFight = true;
                    } else {
                        possibleSupporEnemies.add(e);
                    }
                    break;
                default:
                    break;
            }
        }
        // check whether possible support enemy will add to fight
        if (IsFight) {
            for (BasicEnemy e: possibleSupporEnemies){
                switch (e.getName()) {
                    case "Dogie":
                    case "Elan Muske":
                    case "Slug":
                        if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= 1){
                            fightEnemies.add(e);
                        }
                        break;
                    case "Vampire":
                        if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 9){
                            fightEnemies.add(e);
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        return fightEnemies;
    }

    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> tranceEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> fightEnemies = fight();

        // fight with enemies
        while (!fightEnemies.isEmpty() && character.getHealth() > 0) {
            CommonAttack commonAttack = new CommonAttack();
            // check whether tranceEnemies existed
            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (b.getTranceTurn() == 0) {
                        tranceEnemies.remove(b);
                        fightEnemies.add(b);
                    }
                }
            }
            // fight with trance enemies case
            if (!tranceEnemies.isEmpty()) {
                for (BasicEnemy b:tranceEnemies) {
                    if (!fightEnemies.isEmpty()) {
                        if (b.getName().equals("Vampire")) {
                            int r = new Random().nextInt(10);
                            if (r < 3) {
                                VampireAttack va = new VampireAttack();
                                va.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "allied");
                            } else {
                                commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "vampire");
                            }
                        } else if (b.getName().equals("Zombie")) {
                            commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "zombie");
                        } else if (b.getName().equals("Slug")) {
                            commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "slug");
                        }
                        if (fightEnemies.get(0).getHealth() <= 0) {
                            defeatedEnemies.add(fightEnemies.get(0));
                            fightEnemies.remove(0);
                        }
                        b.setTranceTurn(b.getTranceTurn() - 1);
                    }
                }
            }
            // normal fight (enemy)
            for (BasicEnemy e:fightEnemies) {
                e.attack(character, tranceEnemies, fightEnemies, e);
            }

            // allied soldier fight case
            for (int a = 0; a < character.getSoldiers().size(); a++) {
                if (!fightEnemies.isEmpty()) {
                    commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "soldier");
                    if (fightEnemies.get(0).getHealth() <= 0) {
                        defeatedEnemies.add(fightEnemies.get(0));
                        fightEnemies.remove(0);
                    }
                }
            }
            // normal fight with equipment (character)
            if (!fightEnemies.isEmpty()) {
                if (character.getStupor()) {
                    character.setStuporTurn(character.getStuporTurn() - 1);
                    if (character.getStuporTurn() == 0) {
                        character.setStupor(false);
                    }
                } else {
                    if (character.getWeapon() instanceof Sword) {
                        commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                    } else if (character.getWeapon() instanceof Staff) {
                        int random = new Random().nextInt(10);
                        if (random == 2 && (fightEnemies.get(0).getLevel()).equals("Monster")) {
                            StaffAttack sa = new StaffAttack();
                            sa.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "null");
                        } else {
                            commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                        }
                    } else if (character.getWeapon() instanceof Stake) {
                        StakeAttack ak = new StakeAttack();
                        ak.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "null");
                    } else if (character.getWeapon() instanceof Anduril) {
                        AndurilAttack aa = new AndurilAttack();
                        aa.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "null");
                    } else {
                        commonAttack.hit(character, tranceEnemies, fightEnemies, fightEnemies.get(0), "character");
                    }
                }
            }

            // check whether enemy has been defeated
            if (!fightEnemies.isEmpty()) {
                if (fightEnemies.get(0).getHealth() <= 0) {
                    defeatedEnemies.add(fightEnemies.get(0));
                    fightEnemies.remove(0);
                }
            } else {
                for (BasicEnemy e:tranceEnemies) {
                    defeatedEnemies.add(e);
                }
            }
        }
        // kill all defeated enemies
        for (BasicEnemy e: defeatedEnemies){
            // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
            // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
            // due to mutating list we're iterating over
            System.out.println("The character kill the " + e.getName() + "!");
            killEnemy(e);
            if(e instanceof Slug) addSlugsNum(1);
            else if(e instanceof Zombie) addZombiesNum(1);
            else if(e instanceof Vampire) addVampiresNum(1);
            else if(e instanceof Doggie) addDoggieskesNum(1);
            else if(e instanceof ElanMuske) addElanMuskesNum(1);
        }

        // character HP check
        if (character.getHealth() <= 0 && character.getTheOneRing() != null) {
            System.out.println("The Character Using the ONE ring, respawns with full health!");
            character.setTheOneRing(null);
            character.setHealth(100);
            setUsedTheOneRing(true);
        } else if(character.getHealth() <= 0) {
            if (goalCheck()) {
                // game end
                System.out.print("you have meet the conditio, Game successful!");
            } else {
                System.out.print("you have not meet the conditio, Game fail!");

            }
            setIsDead(true);
            
        }
        return defeatedEnemies;
    }

    /**
     * spawn a card in the world and return the card entity
     * 
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(CARDS_TYPE cards_TYPE) {
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()) {
            // give some cash/experience/item rewards for the discarding of the oldest card
            int rdGold = new Random().nextInt(5);
            character.setGold(character.getGold() + rdGold);
            character.setEXP(character.getEXP() + 5);
            int rd = new Random().nextInt(100);
            if (rd <= 0) {
                addUnequippedItem(ITEMS_TYPE.SWORD);
            } else if (rd > 0 && rd <= 1) {
                addUnequippedItem(ITEMS_TYPE.STAKE);
            } else if (rd > 1 && rd <= 2) {
                addUnequippedItem(ITEMS_TYPE.STAFF);
            } else if (rd > 2 && rd <= 3) {
                addUnequippedItem(ITEMS_TYPE.ARMOUR);
            } else if (rd > 3 && rd <= 4) {
                addUnequippedItem(ITEMS_TYPE.SHIELD);
            } else if (rd > 4 && rd <= 5) {
                addUnequippedItem(ITEMS_TYPE.HELMET);
            } else if (rd > 5 && rd <= 6) {
                character.setHealth(character.getHealth() + 50); // health potion
            } else {
                // nothing
            }
            // remove oldest card
            removeCard(0);
        }
        Card card = null;
        switch (cards_TYPE) {
            case TOWER: {
                card = new TowerCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case ZOMBIEPIT: {
                card = new ZombiePitCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case VAMPIRECASTLE: {
                card = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()),
                        new SimpleIntegerProperty(0));
                break;
            }
            case BARRACK: {
                card = new BarrackCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case VILLAGE: {
                card = new VillageCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case TRAP: {
                card = new TrapCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case CAMPFIRE: {
                card = new CampfireCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            case Oblivion: {
                card = new OblivionCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                break;
            }
            default:
                break;
        }
        cardEntities.add(card);
        return card;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed
     * cards)
     * 
     * @param index the index of the card, from 0 to length-1
     */
    public void removeCard(int index) {
        Card c = cardEntities.get(index);
        int x = c.getX();
        c.destroy();
        cardEntities.remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    /**
     * spawn a item in the world and return the item entity
     * 
     * @return a item to be spawned in the controller as a JavaFX node
     */
    public Item addUnequippedItem(ITEMS_TYPE itemType) {
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null) {
            // eject the oldest unequipped item and replace it... oldest item is that at
            // beginning of items
            // give some cash/experience rewards for the discarding of the oldest item
            character.setGold(character.getGold() + unequippedInventoryItems.get(0).getPrice() / 5);
            character.setEXP(character.getEXP() + 5);
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        Item item = null;
        switch (itemType) {
            case SWORD: {
                item = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 6, 0, 10);
                break;
            }
            case STAKE: {
                item = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 4, 0, 10);
                break;
            }
            case STAFF: {
                item = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 2, 0, 15);
                break;
            }
            case ARMOUR: {
                item = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 3, 20);
                break;
            }
            case SHIELD: {
                item = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 1, 20);
                break;
            }
            case HELMET: {
                item = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 1, 20);
                break;
            }
            case THEONERING: {
                item = new TheOneRing(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 0, 0);
                break;
            }
            case ANDURIL: {
                item = new Anduril(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 9, 0, 30);
                break;
            }
            case TREESTUMP: {
                item = new TreeStump(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 0, 30);
                break;
            }
            case DOGGIECOIN: {
                item = new DoggieCoin(new SimpleIntegerProperty(firstAvailableSlot.getValue0()),
                        new SimpleIntegerProperty(firstAvailableSlot.getValue1()), 0, 0, 40);
                break;
            }
            default:
                break;
        }
        unequippedInventoryItems.add(item);

        return item;
    }

    /**
     * remove an item by x,y coordinates
     * 
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y) {
        Entity item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }

    /**
     * run moves which occur with every tick without needing to spawn anything
     * immediately
     */
    public void runTickMoves() {

        character.moveDownPath();
        int rd = new Random().nextInt(100);
        if (rd <= 0) {
            addUnequippedItem(ITEMS_TYPE.SWORD);
        } else if (rd > 0 && rd <= 1) {
            addUnequippedItem(ITEMS_TYPE.STAKE);
        } else if (rd > 1 && rd <= 2) {
            addUnequippedItem(ITEMS_TYPE.STAFF);
        } else if (rd > 2 && rd <= 3) {
            addUnequippedItem(ITEMS_TYPE.ARMOUR);
        } else if (rd > 3 && rd <= 4) {
            addUnequippedItem(ITEMS_TYPE.SHIELD);
        } else if (rd > 4 && rd <= 5) {
            addUnequippedItem(ITEMS_TYPE.HELMET);
        } else if (rd > 5 && rd <= 6) {
            loadCard(CARDS_TYPE.VAMPIRECASTLE);
        }else if (rd > 6 && rd <= 7) {
            loadCard(CARDS_TYPE.ZOMBIEPIT);
        }else if (rd > 7 && rd <= 8) {
            loadCard(CARDS_TYPE.TOWER);
        } else if (rd > 8 && rd <= 9) {
            loadCard(CARDS_TYPE.TRAP);
        } else if (rd > 9 && rd <= 10) {
            loadCard(CARDS_TYPE.BARRACK);
        } else if (rd > 10 && rd <= 11) {
            loadCard(CARDS_TYPE.VILLAGE);
        } else if (rd > 11 && rd <= 12) {
            loadCard(CARDS_TYPE.CAMPFIRE);
        } else if (rd > 12 && rd <= 15) {
            character.setHealth(character.getHealth() + 50); // health potion
        } else if (rd > 15 && rd <= 18) {
            character.setGold(character.getGold() + 2); // gold
        } else if (rd > 18 && rd <= 21) {
            character.setEXP(character.getEXP() + 5); // exp
        } else if (rd > 21 && rd < 100) {
            if(buildingEntities.size() <= 2){
                if (rd > 21 && rd <= 22) {
                    loadCard(CARDS_TYPE.Oblivion);
                }
            }
            else if(buildingEntities.size() < 5){
                if (rd > 21 && rd <= 24) {
                    loadCard(CARDS_TYPE.Oblivion);
                }
            }
            else if(buildingEntities.size() < 7){
                if (rd > 21 && rd <= 25) {
                    loadCard(CARDS_TYPE.Oblivion);
                }
            }
            else{
                if (rd > 21 && rd <= 26) {
                    loadCard(CARDS_TYPE.Oblivion);
                }
            }
            // nothing
        }
        moveBasicEnemies();
    }

    /**
     * remove an item from the unequipped inventory
     * 
     * @param item item to be removed
     */
    public void removeUnequippedInventoryItem(Entity item) {
        item.destroy();
        unequippedInventoryItems.remove(item);
    }

    /**
     * return an unequipped inventory item by x and y coordinates assumes that no 2
     * unequipped inventory items share x and y coordinates
     * 
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    public Item getUnequippedInventoryItemEntityByCoordinates(int x, int y) {
        for (Item e : unequippedInventoryItems) {
            if ((e.getX() == x) && (e.getY() == y)) {
                return e;
            }
        }
        return null;
    }

    /**
     * remove item at a particular index in the unequipped inventory items list
     * (this is ordered based on age in the starter code)
     * 
     * @param index index from 0 to length-1
     */
    public void removeItemByPositionInUnequippedInventoryItems(int index) {
        Entity item = unequippedInventoryItems.get(index);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the
     * unequipped inventory
     * 
     * @return x,y coordinate pair
     */
    public Pair<Integer, Integer> getFirstAvailableSlotForItem() {
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available
        // slot defined by looking row by row
        for (int y = 0; y < unequippedInventoryHeight; y++) {
            for (int x = 0; x < unequippedInventoryWidth; x++) {
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null) {
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * 
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x) {
        for (Card c : cardEntities) {
            if (c.getX() >= x) {
                c.x().set(c.getX() - 1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        for (BasicEnemy e : enemies) {
            e.move();
        }
    }

    /**
     * get a randomly generated position which could be used to spawn an enemy
     * 
     * @return null if random choice is that wont be spawning an enemy or it isn't
     *         possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition() {

        // has a chance spawning a basic enemy on a tile the character isn't on or
        // immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); 
        if ((choice == 0) && (enemies.size() < 2)) {
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size()) % orderedPath.size();
            int endNotAllowed = (indexPosition + 3) % orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i = endNotAllowed; i != startNotAllowed; i = (i + 1) % orderedPath.size()) {
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates
                    .get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    /**
     * remove a card by its x, y coordinates
     * 
     * @param cardNodeX     x index from 0 to width-1 of card to be removed
     * @param cardNodeY     y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Building convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX,
            int buildingNodeY) {
        // start by getting card
        Card card = null;
        for (Card c : cardEntities) {
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)) {
                card = c;
                break;
            }
        }
        // now spawn building
        Building newBuilding = null;
        if (card instanceof TowerCard) {
            newBuilding = new TowerBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof ZombiePitCard) {
            newBuilding = new ZombiePitBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof VampireCastleCard) {
            newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof BarrackCard) {
            newBuilding = new BarrackBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof VillageCard) {
            newBuilding = new VillageBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof TrapCard) {
            newBuilding = new TrapBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        } else if (card instanceof CampfireCard) {
            newBuilding = new CampfireBuilding(new SimpleIntegerProperty(buildingNodeX),
                    new SimpleIntegerProperty(buildingNodeY));
        }

        if(newBuilding != null){
            buildingEntities.add(newBuilding);
        }

        // destroy the card
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);

        return newBuilding;
    }

    /**
     * check whether the position is in the path
     * 
     * @param x x of the position
     * @param y y of the position
     * @return the result
     */
    public boolean checkInPath(Integer x, Integer y) {
        boolean ret = false;
        for (Pair<Integer, Integer> pair : orderedPath) {
            if (pair.getValue(0) == x && pair.getValue(1) == y) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    /**
     * check whether the position is adjacent to the path
     * 
     * @param x x of the position
     * @param y y of the position
     * @return the result
     */
    public boolean checkAdjacentPath(Integer x, Integer y) {
        if (checkInPath(x, y))
            return false;
        boolean ret = false;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        for (Pair<Integer, Integer> pair : orderedPath) {
            int mx = (Integer) pair.getValue(0);
            int my = (Integer) pair.getValue(1);
            for (int i = 0; i < 4; i++) {
                if (mx + dx[i] == x && my + dy[i] == y) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * getter of unequippedInventoryItems
     * 
     * @return unequippedInventoryItems
     */
    public List<Item> getUnequippedInventoryItems() {
        return unequippedInventoryItems;
    }

    public List<Item> getEquippedInventoryItems(){
        return equippedInventoryItems;
    }

    /**
     * spawn a zombie
     */
    public BasicEnemy spawnAZombie(int x, int y, Building building) {

        // find a adjacent position in the path
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        boolean isFind = false;
        for (Pair<Integer, Integer> pair : orderedPath) {
            int mx = (Integer) pair.getValue(0);
            int my = (Integer) pair.getValue(1);
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] == mx && y + dy[i] == my) {
                    x = mx;
                    y = my;
                    isFind = true;
                    break;
                }
            }
            if (isFind)
                break;
        }

        // spawn a zombie in the position (x,y)
        Pair<Integer, Integer> pos = new Pair<>(x, y);
        int indexInPath = orderedPath.indexOf(pos);
        Zombie zombie = new Zombie(new PathPosition(indexInPath, orderedPath),building);
        enemies.add(zombie);
        return zombie;
    }

    /**
     * spawn a vampire
     */
    public Vampire spawnAVampire(int x, int y,Building building) {
        // find a adjacent position in the path
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        boolean isFind = false;
        for (Pair<Integer, Integer> pair : orderedPath) {
            int mx = (Integer) pair.getValue(0);
            int my = (Integer) pair.getValue(1);
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] == mx && y + dy[i] == my) {
                    x = mx;
                    y = my;
                    isFind = true;
                    break;
                }
            }
            if (isFind)
                break;
        }

        // spawn a zombie in the position (x,y)
        Pair<Integer, Integer> pos = new Pair<>(x, y);
        int indexInPath = orderedPath.indexOf(pos);
        Vampire vampire = new Vampire(new PathPosition(indexInPath, orderedPath),building);
        enemies.add(vampire);
        return vampire;
    }

    /**
     * Generate enemies according to building characteristics
     */
    public List<BasicEnemy> spawnEnemiesByBuilding() {
        List<BasicEnemy> retList = new ArrayList<>();
        if (buildingEntities == null)
            return retList;
        for (Building building : buildingEntities) {
            if (building instanceof ZombiePitBuilding) {
                List<BasicEnemy> tmp = ((ZombiePitBuilding) building).spawnZombie(this);
                if (tmp.size() > 0) {
                    retList.addAll(tmp);
                }
            } else if (building instanceof VampireCastleBuilding) {
                List<BasicEnemy> tmp = ((VampireCastleBuilding) building).spawnVampires(this);
                if (tmp.size() > 0) {
                    retList.addAll(tmp);
                }
            }
        }
        return retList;
    }

    /**
     * add rouds number
     */
    public void addRoundsNum() {
        roundsNum++;
    }

    /**
     * get current rouds number
     */
    public int getRoundsNum() {
        return roundsNum;
    }

    /**
     * get the last added item in unequipped inventory
     * 
     * @return item
     */
    public Item getLastUnequippedInventoryItem() {
        if (unequippedInventoryItems.size() > 0) {
            return unequippedInventoryItems.get(unequippedInventoryItems.size() - 1);
        }
        return null;
    }

    /**
     * get the last added card in card list
     * 
     * @return card
     */
    public Card getLastCardEntity() {
        if (cardEntities.size() > 0) {
            return cardEntities.get(cardEntities.size() - 1);
        }
        return null;
    }

    /**
     * get the character
     * 
     * @return
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * building work
     * 
     * @return basic enemy list
     */
    public List<BasicEnemy> buildingFunction() {
        List<BasicEnemy> deadEnemies = new ArrayList<>();
        if (buildingEntities == null || buildingEntities.isEmpty())
            return deadEnemies;
        boolean hasAttackEnhance = false;
        for (Building building : buildingEntities) {

            // tower
            if (building instanceof TowerBuilding) {
                List<BasicEnemy> tmpEnemies = ((TowerBuilding) building).work(enemies);
                for (BasicEnemy e : tmpEnemies) {
                    killEnemy(e);
                }
                deadEnemies.addAll(tmpEnemies);
            }

            // villiage
            if (building instanceof VillageBuilding) {
                ((VillageBuilding) building).work(character);
            }

            // campfire
            if (building instanceof CampfireBuilding) {
                hasAttackEnhance = ((CampfireBuilding) building).work(character);
            }

            // trap
            if (building instanceof TrapBuilding) {
                List<BasicEnemy> tmpEnemies = ((TrapBuilding) building).work(enemies);
                for (BasicEnemy e : tmpEnemies) {
                    killEnemy(e);
                }
                deadEnemies.addAll(tmpEnemies);
            }

            // barrack
            if (building instanceof BarrackBuilding) {
                ((BarrackBuilding) building).work(character);
            }
        }

        if (hasAttackEnhance) {
            character.setAttackEnhance(true);
        }

        return deadEnemies;
    }

    /**
     * Get Equipped item From Unequipped inventroy By Coordinates
     * 
     * @param srcX  srouce X
     * @param srcY  srouce Y
     * @param destX destination X
     * @param destY destination Y
     * @return Item
     */
    public Item GetEquippedFromUnequippedByCoordinates(int srcX, int srcY, int destX, int destY) {
        Item item = getUnequippedInventoryItemEntityByCoordinates(srcX, srcY);
        if (destX == 1 & destY == 0) {
            if (item instanceof Sword || item instanceof Stake || item instanceof Staff || item instanceof Anduril) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {
                return null;
            }
        } else if (destX == 0 && destY == 1) {
            if (item instanceof Armour || item instanceof Helmet) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {
                return null;
            }
        } else if (destX == 1 && destY == 1) {
            if (item instanceof Shield || item instanceof TreeStump) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {
                return null;
            }
        } else if (destX == 2 && destY == 1) {
            if (item instanceof TheOneRing) {
                removeUnequippedInventoryItemByCoordinates(srcX, srcY);
                item.setPosition(destX, destY);
            } else {
                return null;
            }
        }
        return item;
    }

    /**
     * set current equipped item to character
     * 
     * @param item
     */
    public void setCharacterEquipment(Character character, Item item) {
        int basicDamage = 4;
        if (item instanceof Sword) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Stake) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Staff) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof Armour) {
            character.setDefense(item.getDefenseValue());
            character.setArmour(item);
        } else if (item instanceof Helmet) {
            character.setDefense(item.getDefenseValue());
            character.setArmour(item);
        } else if (item instanceof Shield) {
            character.setShield(item);
        } else if (item instanceof TheOneRing) {
            character.setTheOneRing(item);
        } else if (item instanceof Anduril) {
            character.setAggressivity(basicDamage + item.getDamageValue());
            character.setWeapon(item);
        } else if (item instanceof TreeStump) {
            character.setShield(item);
        }
    }

    /**
     * get whether used the one ring
     * @return whether used the one ring
     */
    public boolean GetUsedTheOneRing() {
        return this.UsedTheOneRing;
    }

    /**
     * set whether used the one ring
     * @param tf true/fasle
     */
    public void setUsedTheOneRing(boolean tf) {
        this.UsedTheOneRing = tf;
    }

    /**
     * check if meet the goal condition
     * 
     * @param 
     * @return boolean
     */

    public boolean goalCheck() {
        this.goalCondition.setCurrentStatus(character.getGold(), character.getEXP(), roundsNum, false);
        return this.goalCondition.goalCheck();

    }
    public String goal_print(){
        return this.goalCondition.goal_to_string();
    }
    /**
     * setting the goal condition
     * 
     * @param  Goal
     * @return 
     */
    public void setGoalCondition(Goal goalCondition) {
        this.goalCondition = goalCondition;
    }
    public int getMaximumLoop(){
        return (Integer)goalCondition.conditions.getJSONArray("subgoals").getJSONObject(0).get("quantity");
    }
    /**
     * setting is_dead  condition
     * 
     * @param  boolean
     * @return 
     */
    public void setIsDead(boolean t) {
        this.IsDead = t;
    }
    /**
     * getting is dead condition
     * 
     * @param  boolean
     * @return 
     */
    public boolean getIsDead() {
        return this.IsDead;
    }

    /**
     * add slus number
     * @param num
     */
    public void addSlugsNum(int num){
        slugsNum += num;
    }

    /**
     * get spwaned slug number
     * @return slug number
     */
    public int getSlugsNum(){
        return slugsNum;
    }

    /**
     * add zombie number
     * @param zombie number
     */
    public void addZombiesNum(int num){
        zombiesNum += num;
    }

    /**
     * get spawned zombie number
     * @return zombie number
     */
    public int getZombiesNum(){
        return zombiesNum;
    }

    /**
     * add vampire number
     * @param vampire number
     */
    public void addVampiresNum(int num){
        vampiresNum += num;
    }

    /**
     * get spawned vampire number
     * @return vampire number
     */
    public int getVampiresNum(){
        return vampiresNum;
    }
    public void addDoggieskesNum(int num){
        doggiesNum += num;
    }
    public int getDoggieskesNum(){
        return doggiesNum;
    }
    public void addElanMuskesNum(int num){
        elanmuskeNum += num;
    }
    public int getElanMuskesNum(){
        return elanmuskeNum;
    }
    /**
     * get battle item
     * @return battle item
     */
    public String getBattleItem(){
        return battleItem;
    }

    /**
     * get counterd slug number
     * @return counterd slug number
     */
    public int getencounterSlugsNum(){
        return encounterSlugsNum;
    }

    /**
     * get counterd zombie number
     * @return counterd zombie number
     */
    public int getEncounterZombiesNum(){
        return encounterZombiesNum;
    }

    /**
     * get counterd vampire number
     * @return counterd vampire number
     */
    public int getencounterVampiresNum(){
        return encounterVampiresNum;
    }
    public int getEncounterDoggiesNum(){
        return encounterDoggiesNum;
    }
    public int getencounterElanMuskesNum(){
        return encounterElanmuskeNum;
    }

    /**
     * get buildings
     * @return list of building
     */
    public List<Building> getBuildingEntities(){
        return buildingEntities;
    }

    /**
     * get world enemies
     * @return list of enemy
     */
    public List<BasicEnemy> getEnemies(){
        return enemies;
    }
    public List<Card> getCardsEntities(){
        return cardEntities;
    }
    /**
     * add item to equippedInventoryItems
     * @param item
     */
    public void addEquippedInventoryItems(Item item) {
        this.equippedInventoryItems.add(item);
    }
}
