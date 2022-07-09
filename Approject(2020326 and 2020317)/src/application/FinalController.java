package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class FinalController implements Initializable {
	@FXML
	private AnchorPane finalpane;
	@FXML
	private Label user1;
	@FXML
	private Label user2;
	@FXML
	private ImageView celebgif;
	
	private File file;
	private Media media;
	private MediaPlayer mediaplayer;
	
	public void setnames(String a1,String a2) {
		user1.setText(a1);
		user2.setText(a2);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		finalpane.setBackground(new Background(new BackgroundFill(Color.PEACHPUFF	, CornerRadii.EMPTY, Insets.EMPTY)));
		file=new File("celebrate.mp4");
		celebgif.fitWidthProperty().bind(finalpane.widthProperty());
		celebgif.fitHeightProperty().bind(finalpane.heightProperty());
		celebgif.setPreserveRatio(true);
		media=new Media(file.toURI().toString());
		mediaplayer=new MediaPlayer(media);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaplayer.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mediaplayer.seek(Duration.seconds(0));
				mediaplayer.play();
			}
		});
	}
	
}
