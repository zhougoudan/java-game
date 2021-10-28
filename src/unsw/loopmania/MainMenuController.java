package unsw.loopmania;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * controller for the main menu.
 */
public class MainMenuController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;
    public Mode mode_req;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private AnchorPane contentPanel;

    @FXML
    private Label title;

    @FXML
    private Label tips;

    @FXML
    private HBox StandardBox;

    @FXML
    private HBox SurvivalBox;

    @FXML
    private HBox BerserkerBox;


    private MenuSwitcher mainMenuSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }
    public Mode getMode_req() {
        return mode_req;
    }

    public void init(){

        title.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,28));
        title.setTextFill(new Color(1,1,1,1));

        tips.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        tips.setTextFill(new Color(1,1,1,1));

        Label label = new Label("Standard Mode");
        label.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        label.setTextFill(new Color(1,1,1,1));
        StandardBox.getChildren().add(label);

        label = new Label("Survival Mode");
        label.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        label.setTextFill(new Color(1,1,1,1));
        SurvivalBox.getChildren().add(label);

        label = new Label("Berserker Mode");
        label.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,14));
        label.setTextFill(new Color(1,1,1,1));
        BerserkerBox.getChildren().add(label);


        StandardBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                ModeContext modeContext = new ModeContext(new ModeStandard());
                mode_req = modeContext.executeMode("Standard");
                //mode_req = new ModeReq("Standard");
                
                gameSwitcher.switchMenu();
            }
		});

        SurvivalBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                ModeContext modeContext = new ModeContext(new ModeSurvial());
                mode_req = modeContext.executeMode("survival");
                //mode_req = new ModeReq("survival");
                gameSwitcher.switchMenu();
            }
		});

        BerserkerBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                ModeContext modeContext = new ModeContext(new ModeBerserker());
                mode_req = modeContext.executeMode("berserker");
                //mode_req = new ModeReq("berserker");
                
                gameSwitcher.switchMenu();
            }
		});

    }
}
