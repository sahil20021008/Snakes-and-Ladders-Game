package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class PlayerInp {
    @FXML
    private Label inpLabel;
    @FXML
    private TextField playername1;
    @FXML
    private TextField playername2;
    @FXML
    private Button startgame;
    @FXML
    private AnchorPane pane1;

    private Parent root;
	private Stage stage;
	private Scene scene;
	
    public void login(ActionEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/Main.fxml"));
		root=loader.load();
		Dice d=loader.getController();
		d.setname(playername1.getText(), playername2.getText());
		stage=(Stage)(pane1.getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
}
