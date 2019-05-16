package main;

import gui.BoardPane;
import gui.ControlPane;
import gui.RetryPane;
import gui.ScorePane;
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
import logic.ArrowButtonEventHandler;

public class Main extends Application {
	
	private ControlPane controlPane;
	public static ScorePane scorePane;
	private BoardPane boardPane1;
	private BoardPane boardPane2;
	private StartPane startPane;
	private RetryPane retryPane;
	
	public void start(Stage primaryStage) {
		HBox main = new HBox();
		main.setPrefSize(1280, 720);
		main.setSpacing(10);
		main.setPadding(new Insets(10));
		Label title = new Label("Elenum");
		title.setFont(new Font("Blackadder ITC", 72));
		main.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		AudioClip mainSong = new AudioClip(this.getClass().getResource("/Mission Impossible Recorder.mp3").toString());
		AudioClip gameOverSong = new AudioClip(this.getClass().getResource("/gameoversong.mp3").toString());
		createGameMaterial();
		BoardManager boardManager1 = new BoardManager(boardPane1);
		BoardManager boardManager2 = new BoardManager(boardPane2);
		VBox numPane = new VBox();
		VBox elePane = new VBox();
		VBox dataPane = new VBox();
		HBox retry = new HBox();
		retry.getChildren().add(retryPane);
		retry.setAlignment(Pos.CENTER);
		retry.setPrefSize(1280, 720);;
		retry.setSpacing(10);
		retry.setPadding(new Insets(10));
		numPane.setPrefSize(480, 720);
		numPane.getChildren().add(boardPane1);
		numPane.setAlignment(Pos.CENTER);
		elePane.setPrefSize(480, 720);
		elePane.getChildren().add(boardPane2);
		elePane.setAlignment(Pos.CENTER);
		dataPane.setAlignment(Pos.TOP_CENTER);
		dataPane.getChildren().addAll(title, scorePane, controlPane);
		main.getChildren().addAll(numPane, dataPane, elePane);
		Scene scene = new Scene(main);
		HBox start = new HBox();
		start.setPrefSize(1280, 720);
		start.setSpacing(10);
		start.setPadding(new Insets(10));
		start.setAlignment(Pos.CENTER);
		start.getChildren().add(startPane);
		Scene startScene = new Scene(start);
		Scene retryScene = new Scene(retry);
		primaryStage.setScene(startScene);
		primaryStage.setTitle("Elenum");
		primaryStage.show();
		mainSong.setCycleCount(999);
		gameOverSong.setCycleCount(999);
		
		
		
		
		
		startPane.getGameStartButton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				primaryStage.setScene(scene);
				mainSong.play();
				boardManager1.generateNewTile();
				boardManager1.generateNewTile();
				boardManager2.generateNewTile();
				boardManager2.generateNewTile();
			}
		});
		startPane.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});
		retryPane.getGameStartButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				primaryStage.setScene(startScene);
				boardManager1.resetBoard();
				boardManager2.resetBoard();
				scorePane.reset();
				ArrowButtonEventHandler.isDead = false;
				gameOverSong.stop();
			}
		});
		


		controlPane.getUpButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.UP, boardManager1));
		controlPane.getUpButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.UP, boardManager2));
		controlPane.getDownButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.DOWN, boardManager1));
		controlPane.getDownButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.DOWN, boardManager2));
		controlPane.getLeftButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.LEFT, boardManager1));
		controlPane.getLeftButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.LEFT, boardManager2));
		controlPane.getRightButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.RIGHT, boardManager1));
		controlPane.getRightButton().addEventHandler(ActionEvent.ACTION, new ArrowButtonEventHandler(Direction.RIGHT, boardManager2));
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.DOWN) {
				controlPane.getDownButton().fire();
				if (logic.ArrowButtonEventHandler.isDead) {
					retryPane.setYourScore(scorePane.getScore());
					primaryStage.setScene(retryScene);
					mainSong.stop();
					gameOverSong.play();
				}
				;
			}
			if (key.getCode() == KeyCode.UP) {
				controlPane.getUpButton().fire();
				if (logic.ArrowButtonEventHandler.isDead) {
					retryPane.setYourScore(scorePane.getScore());
					primaryStage.setScene(retryScene);
					mainSong.stop();
					gameOverSong.play();
				}
			}
			if (key.getCode() == KeyCode.LEFT) {
				controlPane.getLeftButton().fire();
				if (logic.ArrowButtonEventHandler.isDead) {
					retryPane.setYourScore(scorePane.getScore());
					primaryStage.setScene(retryScene);
					mainSong.stop();
					gameOverSong.play();
				}
			}
			if (key.getCode() == KeyCode.RIGHT) {
				controlPane.getRightButton().fire();
				if (logic.ArrowButtonEventHandler.isDead) {
					retryPane.setYourScore(scorePane.getScore());
					primaryStage.setScene(retryScene);
					mainSong.stop();
					gameOverSong.play();
				}
			}
		});


	}
	public void createGameMaterial() {
		scorePane = new ScorePane();
		controlPane = new ControlPane();
		boardPane1 = new BoardPane();
		boardPane2 = new BoardPane();
		startPane = new StartPane();
		retryPane = new RetryPane();
	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public ScorePane getScorePane() {
		return scorePane;
	}

	public BoardPane getBoardPane1() {
		return boardPane1;
	}
	public BoardPane getBoardPane2() {
		return boardPane2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
