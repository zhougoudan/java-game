package unsw.loopmania;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CardDescription {
    private Label nameLabel;
    private Label descriptionLabel;
    private AnchorPane mstatsPane;
    private VBox descriptionPane;
    private String oldTitle;
    /**
     * constructor
     * @param x x of position
     * @param y y of position
     */
    public CardDescription(LoopManiaWorldController loopManiaWorldController){
        AnchorPane stats = loopManiaWorldController.getStats();
        mstatsPane = (AnchorPane)stats.getChildren().get(0);
        descriptionPane = (VBox)stats.getChildren().get(1);
        nameLabel = loopManiaWorldController.getTitleLabel();
        descriptionLabel = new Label();
        descriptionLabel.setFont(Font.font("Microsoft YaHei",FontWeight.BOLD,16));
        descriptionLabel.setWrapText(true);
        descriptionLabel.setAlignment(Pos.CENTER);
        descriptionPane.setPadding(new Insets(8));
        descriptionPane.setSpacing(5);
        descriptionPane.getChildren().add(descriptionLabel);
    }

    /**
     * show the stage
     * @param description description of the card
     */
    public void show(String name, String description){
        oldTitle = nameLabel.getText();
        nameLabel.setText(name);
        descriptionLabel.setText(description);
        mstatsPane.setVisible(false);
        descriptionPane.setVisible(true);
    }

    /**
     * close the stage
     */
    public void close(){
        mstatsPane.setVisible(true);
        descriptionPane.setVisible(false);
        nameLabel.setText(oldTitle);
    }
}
