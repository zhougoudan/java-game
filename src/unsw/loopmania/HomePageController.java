package unsw.loopmania;

import java.io.File;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class HomePageController {

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane contentPanel;

    @FXML
    private Label title;

    @FXML
    private Label tips;

    @FXML
    private HBox newgame;

    private MenuSwitcher mainMenuSwitcher;

    public void init(){
        mainPanel.setBackground(new Background(new BackgroundFill(new Color(250/255.0,205/255.0,145/255.0,1),null,null)));
        contentPanel.setBackground(new Background(new BackgroundFill(new Color(245/255.0,154/255.0,35/255.0,1),null,null)));

        title.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,28));
        title.setTextFill(new Color(1,1,1,1));

        tips.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        tips.setTextFill(new Color(1,1,1,1));

        Label label = new Label("NEW GAME");
        label.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        label.setTextFill(new Color(1,1,1,1));
        ImageView imageView = new ImageView();
        imageView.setImage(new Image((new File("src/images/vampire_castle_card.png")).toURI().toString()));
        newgame.getChildren().add(imageView);
        newgame.setSpacing(30);
        newgame.getChildren().add(label);

        newgame.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                // new game
                mainMenuSwitcher.switchMenu();
            }
		});

    }

    public void setMainMenuSwitcher(MenuSwitcher mainMenuSwitcher){
        this.mainMenuSwitcher = mainMenuSwitcher;
    }
    
}
