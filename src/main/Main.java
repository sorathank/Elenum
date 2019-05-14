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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.ArrowButtonEventHandler;
import logic.BoardManager;
import logic.Direction;
import logic.Location;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		HBox main = new HBox();
		main.setPrefSize(1280, 720);
		main.setSpacing(10);
		main.setPadding(new Insets(10));
		Label title = new Label("Elenum");
		title.setFont(new Font("Blackadder ITC", 72));
		AudioClip mainSong = new AudioClip(this.getClass().getResource("/Mission Impossible Recorder.mp3").toString());
		ScorePane scorePane = new ScorePane();
		VBox numPane = new VBox();
		VBox elePane = new VBox();
		VBox dataPane = new VBox();
		ControlPane controlPane = new ControlPane();
		BoardPane boardPane = new BoardPane();
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
		mainSong.play();
		
		BoardManager boardManager = new BoardManager(boardPane);
		
		controlPane.getUpButton().setOnAction(new ArrowButtonEventHandler(Direction.UP,boardManager));
		controlPane.getDownButton().setOnAction(new ArrowButtonEventHandler(Direction.DOWN,boardManager));
		controlPane.getRightButton().setOnAction(new ArrowButtonEventHandler(Direction.RIGHT,boardManager));
		controlPane.getLeftButton().setOnAction(new ArrowButtonEventHandler(Direction.LEFT,boardManager));
		
		boardManager.generateNewTile();
		
		
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
