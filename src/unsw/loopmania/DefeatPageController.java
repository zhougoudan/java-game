package unsw.loopmania;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class DefeatPageController {
    
    @FXML
    private HBox exitGame;

    @FXML
    private Label infoLabel;  

    public void init(){
        exitGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                // exit game
                System.exit(0);
            }
		});
        infoLabel.setWrapText(true);
    }
    public void update(LoopManiaWorld world){
        infoLabel.setText(String.format("You have defeated %d slugs,%d zombies and %d vampires in %d rounds.", world.getSlugsNum(),
            world.getZombiesNum(),world.getVampiresNum(),world.getRoundsNum()));
    }
}
