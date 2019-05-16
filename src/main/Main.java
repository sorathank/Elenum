package main;

import gui.BoardPane;
import gui.ControlPart;
import gui.RetryPane;
import gui.ScorePane;
import gui.SoundButton;
import gui.StartPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.ArrowButtonEventHandler;
import logic.BoardManager;
import logic.Direction;
import logic.EventManager;
import logic.Location;
import logic.SoundManager;
import logic.ArrowButtonEventHandler;

public class Main extends Application {

	private ControlPart controlPart;
	public static ScorePane scorePane;
	private BoardPane boardPane1, boardPane2;
	private StartPane startPane;
	private RetryPane retryPane;
	private SoundManager soundManager;

	public void start(Stage primaryStage) {
		HBox main = new HBox();
		main.setPrefSize(1280, 720);
		main.setSpacing(10);
		main.setPadding(new Insets(10));

		ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResource("Logo2CP2048.png").toString()));

		main.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

		createGameMaterial();

		EventManager eventManager = new EventManager(controlPart, boardPane1, boardPane2, startPane, retryPane,
				soundManager, primaryStage);
		eventManager.setUpArrowButton();

		VBox numPane = new VBox();
		VBox numPane2 = new VBox();
		VBox dataPane = new VBox();
		VBox retry = new VBox();

		retryPane.getChildren().add(soundManager.getSoundButton());
		controlPart.getChildren().add(soundManager.getSoundButton());
		retry.getChildren().add(retryPane);
		retry.setAlignment(Pos.CENTER);
		retry.setPrefSize(1280, 720);
		retry.setBackground(new Background(new BackgroundFill(Color.CRIMSON, null, null)));
		retry.setSpacing(10);
		retry.setPadding(new Insets(10));

		numPane.setMinSize(480, 720);
		numPane.setMaxSize(480, 720);
		numPane.getChildren().add(boardPane1);
		numPane.setAlignment(Pos.CENTER);

		numPane2.setMinSize(480, 720);
		numPane2.setMaxSize(480, 720);
		numPane2.getChildren().add(boardPane2);
		numPane2.setAlignment(Pos.CENTER);

		dataPane.setMinSize(320, 720);
		dataPane.setMaxSize(320, 720);
		dataPane.setPadding(new Insets(20));
		dataPane.setAlignment(Pos.TOP_CENTER);
		dataPane.setSpacing(10);
		dataPane.getChildren().addAll(imageView, scorePane, controlPart.getRestartButton(), soundManager.getSoundButton());

		main.getChildren().addAll(numPane, dataPane, numPane2);

		Scene scene = new Scene(main);
		HBox start = new HBox();
		start.setPrefSize(1280, 720);
		Image background = new Image(ClassLoader.getSystemResource("background.png").toString());
		start.setBackground(new Background(new BackgroundImage(background, null, null, null, null)));
		start.setSpacing(10);
		start.setPadding(new Insets(10));
		start.setAlignment(Pos.CENTER);
		start.getChildren().add(startPane);
		Scene startScene = new Scene(start);
		Scene retryScene = new Scene(retry);
		
		primaryStage.setScene(startScene);
		primaryStage.setTitle("CP2048");
		primaryStage.show();

		eventManager.setUpAllButton(scene,startScene,dataPane,scorePane,retryScene);
	}

	public void createGameMaterial() {
		scorePane = new ScorePane();
		controlPart = new ControlPart();
		boardPane1 = new BoardPane();
		boardPane2 = new BoardPane();
		startPane = new StartPane();
		retryPane = new RetryPane();
		soundManager = new SoundManager(new SoundButton());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
