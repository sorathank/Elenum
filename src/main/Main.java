package main;

import gui.BoardPane;
import gui.ControlPane;
import gui.ScorePane;
import javafx.application.Application;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
import logic.Location;

public class Main extends Application {
	
	private ControlPane controlPane;
	public static ScorePane scorePane;
	private BoardPane boardPane;
	
	public void start(Stage primaryStage) {
		HBox main = new HBox();
		main.setPrefSize(1280, 720);
		main.setSpacing(10);
		main.setPadding(new Insets(10));
		Label title = new Label("Elenum");
		title.setFont(new Font("Blackadder ITC", 72));
		main.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		AudioClip mainSong = new AudioClip(this.getClass().getResource("/Mission Impossible Recorder.mp3").toString());
		
		scorePane = new ScorePane();
		VBox numPane = new VBox();
		VBox elePane = new VBox();
		VBox dataPane = new VBox();
		controlPane = new ControlPane();
		boardPane = new BoardPane();
		numPane.setPrefSize(480, 720);
		numPane.getChildren().add(boardPane);
		numPane.setAlignment(Pos.CENTER);
		elePane.setPrefSize(480, 720);
		dataPane.setAlignment(Pos.TOP_CENTER);
		dataPane.getChildren().addAll(title, scorePane, controlPane);
		main.getChildren().addAll(numPane, dataPane, elePane);
		Scene scene = new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Elenum");
		primaryStage.show();
//		mainSong.play();

		BoardManager boardManager = new BoardManager(boardPane);

		controlPane.getUpButton().setOnAction(new ArrowButtonEventHandler(Direction.UP, boardManager));
		controlPane.getDownButton().setOnAction(new ArrowButtonEventHandler(Direction.DOWN, boardManager));
		controlPane.getRightButton().setOnAction(new ArrowButtonEventHandler(Direction.RIGHT, boardManager));
		controlPane.getLeftButton().setOnAction(new ArrowButtonEventHandler(Direction.LEFT, boardManager));
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.DOWN) {
				controlPane.getDownButton().fire();
				;
			}
			if (key.getCode() == KeyCode.UP) {
				controlPane.getUpButton().fire();
			}
			if (key.getCode() == KeyCode.LEFT) {
				controlPane.getLeftButton().fire();
			}
			if (key.getCode() == KeyCode.RIGHT) {
				controlPane.getRightButton().fire();
			}
		});

		boardManager.generateNewTile();
		boardManager.generateNewTile();

	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public ScorePane getScorePane() {
		return scorePane;
	}

	public BoardPane getBoardPane() {
		return boardPane;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
