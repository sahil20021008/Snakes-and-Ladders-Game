package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

class timehandler implements EventHandler<ActionEvent>{
	private Dice temper;
	private boolean turner;
	private double x;
	private double y;
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		temper.movesmall(x,y,turner);
	}
	public timehandler(Dice temp,boolean turn,double xmove,double ymove) {
		this.temper=temp;
		this.turner=turn;
		this.x=xmove;
		this.y=ymove;
	}
}

public class Dice implements Initializable {
	
	@FXML
	private Button mydicebutton;
	@FXML
	private ImageView mydiceimage;
	@FXML
	private Label dicedisplay;
	@FXML
	private ImageView bluetoken;
	@FXML
	private ImageView greentoken;
	@FXML
	private Label textlabel;
	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView board;
	@FXML
	private Label p1name;
	@FXML
	private Label p2name;
	@FXML
	private ImageView arrowimage;
	@FXML
	private ImageView tempblue1;
	@FXML
	private ImageView tempgreen1;
	
	private Image arrow;
	
	protected boolean blue_turn,blue_out,green_out;
	
	protected int blue_no,green_no;
	
	
	private anim roll=new anim();
	
	protected Snakes_Ladders hast=new Snakes_Ladders();
	protected HashMap<Integer, Integer>snakes1=hast.snakes;
	protected HashMap<Integer, Integer>ladders1=hast.ladders;
	protected HashMap<Integer, Point2D>coord=hast.coordinates;
	protected HashMap<Integer, ArrayList<Point2D>>snakers1=hast.snakers;
	protected HashMap<Integer, ArrayList<Point2D>>ladderers1=hast.ladderers;

	private File file;
	private Media media;
	private MediaPlayer mediaplayer;
	
	private Glow glow;
	
	public void playdicesound() {
		mediaplayer.play();
		mediaplayer.pause();
		if(mediaplayer.getStatus()!=MediaPlayer.Status.READY) {
			mediaplayer.seek(Duration.seconds(0));
		}
	}
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	public void setname(String s1, String s2) {
		p1name.setText(s1);
		p2name.setText(s2);
	}
	
	public void finalshow() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/FinalShow.fxml"));
		root=loader.load();
		FinalController con=loader.getController();
		if(blue_no==100) {
			con.setnames(p1name.getText(), p2name.getText());
		}else {
			con.setnames(p2name.getText(), p1name.getText());
		}
		stage=(Stage)(pane.getScene().getWindow());
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public int roll() {
		Random rand=new Random();
		int ans=rand.nextInt(6);
		return ans+1;
	}
	
	public void movesmall(double x,double y,boolean turnit) {
		if(turnit) {
			bluetoken.setX(bluetoken.getX()+x);
			bluetoken.setY(bluetoken.getY()+y);
		}else {
			greentoken.setX(greentoken.getX()+x);
			greentoken.setY(greentoken.getY()+y);
		}
	}
	
	class anim extends AnimationTimer{
		private long f=25L;
		private long in=1000000000L/(2*f);
		private long c=0;
		private int count=0;
		@Override
		public void handle(long arg0) {
			if(arg0-c>in) {
				Random ra=new Random();
				int r=ra.nextInt(6)+1;
				if(r==1) {
					Image one=new Image("dice1.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("1");
				}else if (r==2) {
					Image one=new Image("dice2.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("2");
				}else if (r==3) {
					Image one=new Image("dice3.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("3");
				}else if (r==4) {
					Image one=new Image("dice4.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("4");
				}else if (r==5) {
					Image one=new Image("dice5.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("5");
				}else if (r==6) {
					Image one=new Image("dice6.png");
					mydiceimage.setImage(one);
					dicedisplay.setText("6");
				}else {
					dicedisplay.setText(String.valueOf(r));
				}
				c=arg0;
				count++;
				if(count>20) {
					roll.stop();
					count=0;
					try {
						clicker();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void click(ActionEvent e) throws IOException {
		arrowimage.setImage(null);
		playdicesound();
		roll.start();
	}
	public void clicker() throws IOException {
		int r=roll();
		if(r==1) {
			Image one=new Image("dice1.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("1");
		}else if (r==2) {
			Image one=new Image("dice2.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("2");
		}else if (r==3) {
			Image one=new Image("dice3.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("3");
		}else if (r==4) {
			Image one=new Image("dice4.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("4");
		}else if (r==5) {
			Image one=new Image("dice5.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("5");
		}else if (r==6) {
			Image one=new Image("dice6.png");
			mydiceimage.setImage(one);
			dicedisplay.setText("6");
		}else {
			dicedisplay.setText(String.valueOf(r));
		}
		if(blue_turn) {
			if(blue_out) {
				if(blue_no+r>100) {
					
				}else if (blue_no+r==100) {
					for(int i=0;i<r;i++) {
						double xe=(coord.get(blue_no+1).getX()-coord.get(blue_no).getX())/50.0;
						double ye=(coord.get(blue_no+1).getY()-coord.get(blue_no).getY())/50.0;
						KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
						Timeline nete=new Timeline(net);
						nete.setCycleCount(50);
						nete.setDelay(Duration.millis(500*i));
						nete.play();
						blue_no++;
						if(blue_no==100) {
							nete.onFinishedProperty().set(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									mydicebutton.setDisable(true);
									try {
										finalshow();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
						}
					}
				}else {
					for(int i=0;i<r;i++) {
						double xe=(coord.get(blue_no+1).getX()-coord.get(blue_no).getX())/50.0;
						double ye=(coord.get(blue_no+1).getY()-coord.get(blue_no).getY())/50.0;
						KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
						Timeline nete=new Timeline(net);
						nete.setCycleCount(50);
						nete.setDelay(Duration.millis(500*i));
						nete.play();
						blue_no++;
					}
					if(snakes1.keySet().contains(blue_no)) {
						for(int i=1;i<snakers1.get(blue_no).size();i++) {
							double xe=(snakers1.get(blue_no).get(i).getX()-snakers1.get(blue_no).get(i-1).getX())/25.0;
							double ye=(snakers1.get(blue_no).get(i).getY()-snakers1.get(blue_no).get(i-1).getY())/25.0;
							KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
							Timeline nete=new Timeline(net);
							nete.setCycleCount(25);
							nete.setDelay(Duration.millis(500*r+250*i));
							nete.play();
						}
						blue_no=snakes1.get(blue_no);
					}else if (ladders1.keySet().contains(blue_no)) {
						for(int i=1;i<ladderers1.get(blue_no).size();i++) {
							double xe=(ladderers1.get(blue_no).get(i).getX()-ladderers1.get(blue_no).get(i-1).getX())/25.0;
							double ye=(ladderers1.get(blue_no).get(i).getY()-ladderers1.get(blue_no).get(i-1).getY())/25.0;
							KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
							Timeline nete=new Timeline(net);
							nete.setCycleCount(25);
							nete.setDelay(Duration.millis(500*r+250*i));
							nete.play();
						}
						blue_no=ladders1.get(blue_no);
					}
				}
			}else {
				if(r==1) {
					bluetoken.setX(coord.get(1).getX()-bluetoken.getLayoutX()-12);
					bluetoken.setY(coord.get(1).getY()-bluetoken.getLayoutY()-12);
					blue_out=true;
					blue_no=1;
				}
			}
		}else {
			if(green_out) {
				if(green_no+r>100) {
					
				}else if (green_no+r==100) {
					for(int i=0;i<r;i++) {
						double xe=(coord.get(green_no+1).getX()-coord.get(green_no).getX())/50.0;
						double ye=(coord.get(green_no+1).getY()-coord.get(green_no).getY())/50.0;
						KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
						Timeline nete=new Timeline(net);
						nete.setCycleCount(50);
						nete.setDelay(Duration.millis(500*i));
						nete.play();
						green_no++;
						if(green_no==100) {
							nete.onFinishedProperty().set(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									mydicebutton.setDisable(true);
									try {
										finalshow();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
						}
					}
				}else {
					for(int i=0;i<r;i++) {
						double xe=(coord.get(green_no+1).getX()-coord.get(green_no).getX())/50.0;
						double ye=(coord.get(green_no+1).getY()-coord.get(green_no).getY())/50.0;
						KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
						Timeline nete=new Timeline(net);
						nete.setCycleCount(50);
						nete.setDelay(Duration.millis(500*i));
						nete.play();
						green_no++;
					}
					if(snakes1.keySet().contains(green_no)) {
						for(int i=1;i<snakers1.get(green_no).size();i++) {
							double xe=(snakers1.get(green_no).get(i).getX()-snakers1.get(green_no).get(i-1).getX())/25.0;
							double ye=(snakers1.get(green_no).get(i).getY()-snakers1.get(green_no).get(i-1).getY())/25.0;
							KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
							Timeline nete=new Timeline(net);
							nete.setCycleCount(25);
							nete.setDelay(Duration.millis(500*r+250*i));
							nete.play();
						}
						green_no=snakes1.get(green_no);
					}else if (ladders1.keySet().contains(green_no)) {
						for(int i=1;i<ladderers1.get(green_no).size();i++) {
							double xe=(ladderers1.get(green_no).get(i).getX()-ladderers1.get(green_no).get(i-1).getX())/25.0;
							double ye=(ladderers1.get(green_no).get(i).getY()-ladderers1.get(green_no).get(i-1).getY())/25.0;
							KeyFrame net=new KeyFrame(Duration.millis(10), new timehandler(this, blue_turn, xe, ye));
							Timeline nete=new Timeline(net);
							nete.setCycleCount(25);
							nete.setDelay(Duration.millis(500*r+250*i));
							nete.play();
						}
						green_no=ladders1.get(green_no);
					}
				}
			}else {
				if(r==1) {
					greentoken.setX(coord.get(1).getX()-greentoken.getLayoutX()-4);
					greentoken.setY(coord.get(1).getY()-greentoken.getLayoutY()-4);
					green_out=true;
					green_no=1;
				}
			}
		}
		blue_turn = !blue_turn;
		arrowimage.setImage(arrow);
		if(blue_turn) {
			p1name.setEffect(glow);
			p2name.setEffect(null);
		}else {
			p2name.setEffect(glow);
			p1name.setEffect(null);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pane.setBackground(new Background(new BackgroundFill(Color.rgb(158, 0, 0)	, CornerRadii.EMPTY, Insets.EMPTY)));
		p1name.setBackground(new Background(new BackgroundFill(Color.rgb(10, 0, 120), CornerRadii.EMPTY, Insets.EMPTY)));
		p2name.setBackground(new Background(new BackgroundFill(Color.rgb(10, 0, 120), CornerRadii.EMPTY, Insets.EMPTY)));
		file=new File("dicesound.mp4");
		media=new Media(file.toURI().toString());
		mediaplayer=new MediaPlayer(media);
		arrow=new Image("snl_arrow.png");
		glow=new Glow();
		glow.setLevel(0.9);
		p1name.setEffect(glow);
		blue_turn=true;
	}
}
