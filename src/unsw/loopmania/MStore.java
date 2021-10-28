package unsw.loopmania;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MStore {

    private AnchorPane storePane;
    private VBox buyPane;
    private VBox sellPane;
    private int currentPaneIndex;
    private LoopManiaWorldController loopManiaWorldController;
    private ImageView[] buyImageView;
    private ImageView[] unequippedImageView;

    private enum ITEM_TYPE{
        ARMOUR, SHIELD, HELMET,STAKE,STAFF, SWORD,HEALTHPOTION, THEONERING, ANDURIL, TREESTUMP, DOGGIECOIN, ARMOUR_SLOT, SHIELD_SLOT,HELMET_SLOT,SWORD_SLOT,EMPTY_SLOT
    };
             
    private Map<ITEM_TYPE,Image> itemsImages;

    /**
     * images 
     */
    static Image[] images = {
        new Image((new File("src/images/armour.png")).toURI().toString()),
        new Image((new File("src/images/shield.png")).toURI().toString()),
        new Image((new File("src/images/helmet.png")).toURI().toString()),
        new Image((new File("src/images/basic_sword.png")).toURI().toString()),
        new Image((new File("src/images/staff.png")).toURI().toString()),
        new Image((new File("src/images/stake.png")).toURI().toString()),
        new Image((new File("src/images/brilliant_blue_new.png")).toURI().toString()),
        new Image((new File("src/images/the_one_ring.png")).toURI().toString()),
        new Image((new File("src/images/anduril_flame_of_the_west.png")).toURI().toString()),
        new Image((new File("src/images/doggiecoin.png")).toURI().toString()),
        new Image((new File("src/images/tree_stump.png")).toURI().toString()),
        new Image((new File("src/images/armour_slot.png")).toURI().toString()),
        new Image((new File("src/images/helmet_slot.png")).toURI().toString()),
        new Image((new File("src/images/sword_unequipped.png")).toURI().toString()),
        new Image((new File("src/images/shield_unequipped.png")).toURI().toString()),
        new Image((new File("src/images/empty_slot.png")).toURI().toString())
    };
    /**
     * price range
     */
    private int[] prices = {
        20, 20, 20, 10, 15, 10, 10
    };

    private Mode modeReq;
    private Context context;
    /**
     * MStore constructor
     * @param loopManiaWorldController
     */
    public MStore(LoopManiaWorldController loopManiaWorldController){     
        storePane = loopManiaWorldController.getStorePane();  
        // items
        itemsImages = new HashMap<>();
        itemsImages.put(ITEM_TYPE.ARMOUR, images[0]);
        itemsImages.put(ITEM_TYPE.SHIELD, images[1]);
        itemsImages.put(ITEM_TYPE.HELMET, images[2]);
        itemsImages.put(ITEM_TYPE.SWORD, images[3]);
        itemsImages.put(ITEM_TYPE.STAFF, images[4]);
        itemsImages.put(ITEM_TYPE.STAKE, images[5]);
        itemsImages.put(ITEM_TYPE.HEALTHPOTION, images[6]);
        itemsImages.put(ITEM_TYPE.THEONERING, images[7]);
        itemsImages.put(ITEM_TYPE.ANDURIL, images[8]);
        itemsImages.put(ITEM_TYPE.DOGGIECOIN, images[9]);
        itemsImages.put(ITEM_TYPE.TREESTUMP, images[10]);
        itemsImages.put(ITEM_TYPE.ARMOUR_SLOT, images[11]);
        itemsImages.put(ITEM_TYPE.HELMET_SLOT, images[12]);
        itemsImages.put(ITEM_TYPE.SWORD_SLOT, images[13]);
        itemsImages.put(ITEM_TYPE.SHIELD_SLOT, images[14]);
        itemsImages.put(ITEM_TYPE.EMPTY_SLOT, images[15]);

        buyImageView = new ImageView[7];
        unequippedImageView = new ImageView[16];
        this.loopManiaWorldController = loopManiaWorldController;
        initBuyPane();
        initSellPane();
        storePane.toFront();
        storePane.setVisible(false);
        currentPaneIndex = 1;
    }

    /**
     * buy interface
     */
    public void initBuyPane(){
        String[] str = {
            "20 gold","20 gold","20 gold","10 gold","15 gold","10 gold"
        };

        buyPane = new VBox();
        buyPane.setAlignment(Pos.CENTER);
        buyPane.setLayoutX(20);
        buyPane.setVisible(false);

        // title
        HBox hBox = new HBox();
        hBox.setPrefHeight(100);
        hBox.setAlignment(Pos.CENTER);
        Label title = new Label("STORE-Click to buy / sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        buyPane.getChildren().add(hBox);


        // items which can be bought
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(50);
        gridPane.setVgap(30);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2;j++){
                VBox vBox = new VBox();
                vBox.setAlignment(Pos.CENTER);
                buyImageView[i*2+j] = new ImageView();
                buyImageView[i*2+j].setImage(images[i*2+j]);
                vBox.getChildren().add(buyImageView[i*2+j]);
                Text text = new Text(str[i*2+j]);
                vBox.getChildren().add(text);
                gridPane.add(vBox, j, i);

                // set mouse click events
                buyImageView[i*2+j].setOnMouseClicked(new ImageViewClick(1, i*2+j));
            }
        }
        buyPane.getChildren().add(gridPane);

        // health potion
        hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        buyImageView[6] = new ImageView();
        buyImageView[6].setImage(images[6]);
        vBox.getChildren().add(buyImageView[6]);
        // set mouse click events
        buyImageView[6].setOnMouseClicked(new ImageViewClick(1, 6));
        Text text = new Text("10 gold");
        vBox.getChildren().add(text);
        hBox.getChildren().add(vBox);
        buyPane.getChildren().add(hBox);


        // buttions
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(60);
        Button toSellBtn = new Button("To Sell");
        gridPane.add(toSellBtn, 0, 0);

        Button closeBtn = new Button("Close");
        gridPane.add(closeBtn, 1, 0);

        toSellBtn.setOnAction((ActionEvent e)->{
            updateItems();
            sellPane.setVisible(true);
            close();
            currentPaneIndex = 2;
        });
        closeBtn.setOnAction((ActionEvent e)->{
            close();
            storePane.setVisible(false);
            loopManiaWorldController.startTimer();
        });
        buyPane.getChildren().add(gridPane);
        storePane.getChildren().add(buyPane);
    }

    /**
     * sell interface
     */
    public void initSellPane(){
        sellPane = new VBox();
        sellPane.setAlignment(Pos.CENTER);
        sellPane.setLayoutX(20);
        sellPane.setVisible(false);

        // title
        HBox hBox = new HBox();
        hBox.setPrefHeight(100);
        hBox.setAlignment(Pos.CENTER);
        Label title = new Label("STORE-Click to buy / sell");
        title.setFont(new Font(15));
        hBox.getChildren().add(title);
        sellPane.getChildren().add(hBox);

        
        // unequipped
        GridPane unequippedGridPane = new GridPane();
        unequippedGridPane.setAlignment(Pos.CENTER);
        unequippedGridPane.setHgap(3);
        unequippedGridPane.setVgap(3);
        unequippedGridPane.setPadding(new Insets(40));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                unequippedImageView[i*4+j] = new ImageView();
                unequippedImageView[i*4+j].setImage(itemsImages.get(ITEM_TYPE.EMPTY_SLOT));
                unequippedGridPane.add(unequippedImageView[i*4+j], j, i);
            }
        }
        sellPane.getChildren().add(unequippedGridPane);
        
        // set mouse click events
        for(int i = 0; i < 16; i++){
            unequippedImageView[i].setOnMouseClicked(new ImageViewClick(3, i));
        }

        // buttions
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(60);
        Button toBuyBtn = new Button("To Buy");
        gridPane.add(toBuyBtn, 0, 0);

        Button closeBtn = new Button("Close");
        gridPane.add(closeBtn, 1, 0);

        toBuyBtn.setOnAction((ActionEvent e)->{
            buyPane.setVisible(true);
            close();
            currentPaneIndex = 1;
        });
        closeBtn.setOnAction((ActionEvent e)->{
            close();
            storePane.setVisible(false);
            loopManiaWorldController.startTimer();
        });
        sellPane.getChildren().add(gridPane);
        storePane.getChildren().add(sellPane);
    }

    /**
     * update items which can be sold
     */
    public void updateItems(){
        // unequipped
        GridPane unequippedGridPane = new GridPane();
        unequippedGridPane.setAlignment(Pos.CENTER);
        List<Item> unequippedInventoryItems = loopManiaWorldController.getLoopManiaWorld().getUnequippedInventoryItems();
        for(Item item : unequippedInventoryItems){
            int mIndex = item.getY()*4 + item.getX();
            if(item instanceof Armour){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.ARMOUR));
            }
            else if(item instanceof Sword){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.SWORD));
            }
            else if(item instanceof Shield){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.SHIELD));
            }
            else if(item instanceof Helmet){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.HELMET));
            }
            else if(item instanceof Staff){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.STAFF));
            }
            else if(item instanceof Stake){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.STAKE));
            }
            else if(item instanceof TheOneRing){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.THEONERING));
            }
            else if(item instanceof Anduril){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.ANDURIL));
            }
            else if(item instanceof DoggieCoin){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.DOGGIECOIN));
            }
            else if(item instanceof TreeStump){
                unequippedImageView[mIndex].setImage(itemsImages.get(ITEM_TYPE.TREESTUMP));
            }
        }
    }
    
    /**
     * show the interface
     */
    public void show(){
        modeReq = loopManiaWorldController.getModeReq();
        Character character = loopManiaWorldController.getLoopManiaWorld().getCharacter();
        context = new Context(modeReq.mode, prices, character, loopManiaWorldController);
        if(currentPaneIndex == 1){
            buyPane.setVisible(true);
        }else{
            sellPane.setVisible(true);
        }
        storePane.setVisible(true);
        // update items which can be sold
        updateItems();
    }
    
    /**
     * close the interface
     */
    public void close(){
        if(currentPaneIndex == 1){
            buyPane.setVisible(false);
        }else{
            sellPane.setVisible(false);
        }
        currentPaneIndex = 1;
    }

    /**
     * eventhandler used to respond to mouse click events
     */
    private  class ImageViewClick implements EventHandler<MouseEvent>{
        private int index = 0;
        private int type = 0;
        public ImageViewClick(int type, int index){
            this.type = type;
            this.index = index;
        }
        @Override
        public void handle(MouseEvent e) {
            Character character = loopManiaWorldController.getLoopManiaWorld().getCharacter();
            if(type == 1){       // buy items
                switch(index){
                    case 0:{     // armour
                        context.handle(index, ITEMS_TYPE.ARMOUR);
                        break;
                    }
                    case 1:{    // shield 
                        context.handle(index, ITEMS_TYPE.SHIELD);
                        break;
                    }
                    case 2:{    // helmet
                        context.handle(index, ITEMS_TYPE.HELMET);
                        break;
                    } 
                    case 3:{    // sword
                        context.handle(index, ITEMS_TYPE.SWORD);
                        break;
                    }
                    case 4:{    // staff
                        context.handle(index, ITEMS_TYPE.STAFF);
                        break;
                    }
                    case 5:{    // stake
                        context.handle(index, ITEMS_TYPE.STAKE);
                        break;
                    }
                    case 6:{    // health potion
                        context.handle(index, ITEMS_TYPE.HEALTHPOTION);
                        break;
                    }
                }
            }
            if(type == 2){     // sell equipped items

            }

            if(type == 3){     // sell unequipped items
                List<Item> unequippedInventoryItems = loopManiaWorldController.getLoopManiaWorld().getUnequippedInventoryItems();
                int x = index % 4;
                int y = index / 4;
                
                // find the item
                boolean isFind = false;
                Item curItem = null;
                for(Item item : unequippedInventoryItems){
                    if(x == item.getX() && y == item.getY()){
                        isFind = true;
                        curItem = item;
                        break;
                    }
                }
                if(!isFind) return;
                // calculate the gain
                int price = 0;
                Item item = curItem;
                if(item instanceof Armour){
                    price = ((Armour)item).getPrice();
                }
                else if(item instanceof Sword){
                    price = ((Sword)item).getPrice();
                }
                else if(item instanceof Shield){
                    price = ((Shield)item).getPrice();
                }
                else if(item instanceof Helmet){
                    price = ((Helmet)item).getPrice();
                }
                else if(item instanceof Staff){
                    price = ((Staff)item).getPrice();
                }
                else if(item instanceof Stake){
                    price = ((Stake)item).getPrice();
                }
                else if(item instanceof TheOneRing){
                    price = ((TheOneRing)item).getPrice();
                }
                else if(item instanceof Anduril){
                    price = ((Anduril)item).getPrice();
                }
                else if(item instanceof DoggieCoin){
                    price = ((DoggieCoin)item).getPrice();
                }
                else if(item instanceof TreeStump){
                    price = ((TreeStump)item).getPrice();
                }
                price = (int)(price*0.4);
                character.setGold(character.getGold()+price);
                // remove the item from the unequipped inventory
                loopManiaWorldController.getLoopManiaWorld().removeUnequippedInventoryItemByCoordinates(x, y);
                sellPane.getChildren().remove(unequippedImageView[index]);
                unequippedImageView[index].setImage(itemsImages.get(ITEM_TYPE.EMPTY_SLOT));
            }
            loopManiaWorldController.updateDisplay();
        }
    }

    private class Context{
        private StoreState state;
        String mode;
        Character character;
        LoopManiaWorldController controller;
        int[] prices;
        public Context(String mode, int[] prices, Character character, LoopManiaWorldController controller){
            this.state = new NormalState();
            this.mode = mode;
            this.character = character;
            this.controller = controller;
            this.prices = prices;
        }

        public void setState(StoreState state){
            this.state = state;
        }


        public void handle(int index, ITEMS_TYPE items_TYPE){
            state.handle(this, index, items_TYPE);
        }
    }

    private abstract class StoreState{
        public abstract void handle(Context context, int index, ITEMS_TYPE items_TYPE);
    }

    private class NormalState extends StoreState{
        @Override
        public void handle(Context context, int index, ITEMS_TYPE items_TYPE){
            if(context.prices[index] <= context.character.getGold()){
                context.character.setGold(context.character.getGold()-context.prices[index]);
                if(items_TYPE != ITEMS_TYPE.HEALTHPOTION){
                    context.controller.loadItemByType(items_TYPE);
                }else{
                    context.character.setHealth(context.character.getHealth()+HealthPotion.healAmount);
                }
                // change the state
                if(items_TYPE == ITEMS_TYPE.HEALTHPOTION && context.mode.equals("survival")){
                    context.setState(new LimitHealPotionState());
                }
                else if((items_TYPE == ITEMS_TYPE.ARMOUR || items_TYPE == ITEMS_TYPE.SHIELD || items_TYPE == ITEMS_TYPE.HELMET)
                && context.mode.equals("berserker")){
                    context.setState(new LimitProtectiveItemsState());
                }
            }
        }
    }

    private class LimitHealPotionState extends StoreState{
        @Override
        public void handle(Context context, int index, ITEMS_TYPE items_TYPE){
            if(items_TYPE != ITEMS_TYPE.HEALTHPOTION && context.prices[index] <= context.character.getGold()){
                context.character.setGold(context.character.getGold()-context.prices[index]);
                context.controller.loadItemByType(items_TYPE);
            }
        }
    }

    private class LimitProtectiveItemsState extends StoreState{
        @Override
        public void handle(Context context, int index, ITEMS_TYPE items_TYPE){
            if(items_TYPE != ITEMS_TYPE.ARMOUR && items_TYPE != ITEMS_TYPE.SHIELD && items_TYPE != ITEMS_TYPE.HELMET
                 && context.prices[index] <= context.character.getGold()){
                context.character.setGold(context.character.getGold()-context.prices[index]);
                context.controller.loadItemByType(items_TYPE);
            }
        }
    }
}
