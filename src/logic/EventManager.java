package logic;

import gui.BoardPane;
import gui.ControlPane;
import gui.RetryPane;
import gui.ScorePane;
import gui.StartPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;

public class EventManager {

	private ControlPane controlPane;
	private BoardPane boardPane1, boardPane2;
	private BoardManager boardManager1, boardManager2;
	private StartPane startPane;
	private RetryPane retryPane;
	private SoundManager soundManager;
	private Stage primaryStage;
	private Main main;

	public EventManager(ControlPane controlPane, BoardPane boardPane1, BoardPane boardPane2, StartPane startPane,
			RetryPane retryPane, SoundManager soundManager,Stage primaryStage) {

		this.controlPane = controlPane;
		this.boardPane1 = boardPane1;
		this.boardPane2 = boardPane2;
		this.startPane = startPane;
		this.retryPane = retryPane;
		this.primaryStage = primaryStage;

		this.soundManager = soundManager;
		
		this.boardManager1 = new BoardManager(boardPane1);
		this.boardManager2 = new BoardManager(boardPane2);
		
		this.main = main;
	}

	public void setUpArrowButton() {
		controlPane.getUpButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.UP, boardManager1));
		controlPane.getUpButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.UP, boardManager2));
		controlPane.getDownButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.DOWN, boardManager1));
		controlPane.getDownButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.DOWN, boardManager2));
		controlPane.getLeftButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.LEFT, boardManager1));
		controlPane.getLeftButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.LEFT, boardManager2));
		controlPane.getRightButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.RIGHT, boardManager1));
		controlPane.getRightButton().addEventHandler(ActionEvent.ACTION,
				new ArrowButtonEventHandler(Direction.RIGHT, boardManager2));
	}

	public void setupStartPaneStartButton(Scene scene) {
		startPane.getGameStartButton().setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				soundManager.playMainSong();
				primaryStage.setScene(scene);
				boardManager1.generateNewTile();
				boardManager1.generateNewTile();
				boardManager2.generateNewTile();
				boardManager2.generateNewTile();
			}
		});
		
	}
	
	public void setupStartPaneQuitButton() {
		startPane.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});
	}

	public void setupRetryPaneStartButton(Scene startScene,VBox dataPane,ScorePane scorePane) {
		retryPane.getGameStartButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				primaryStage.setScene(startScene);
				boardManager1.resetBoard();
				boardManager2.resetBoard();
				dataPane.getChildren().add(soundManager.getSoundButton());
				scorePane.reset();
				ArrowButtonEventHandler.isDead = false;
				soundManager.stopGameOverSong();
				soundManager.getSoundButton().setSong("mainSong");
			}
		});
	}
	
	public void setupRetryPaneQuitButton() {
		retryPane.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Platform.exit();
				System.exit(0);
			}
		});
	}
	
	public void setupSceneKeyHandler(Scene scene,ScorePane scorePane,Scene retryScene) {
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.DOWN) {
				controlPane.getDownButton().fire();
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
			if (logic.ArrowButtonEventHandler.isDead) {
				retryPane.setYourScore(scorePane.getScore());
				primaryStage.setScene(retryScene);
				soundManager.stopMainSong();
				retryPane.getChildren().add(soundManager.getSoundButton());
				if (soundManager.getSoundButton().isSoundOn()) {
					soundManager.playGameOverSong();
				}
				soundManager.getSoundButton().setSong("gameOverSong");
				
			}
		});
	}
	public ControlPane getControlPane() {
		return controlPane;
	}

	public BoardPane getBoardPane1() {
		return boardPane1;
	}

	public BoardPane getBoardPane2() {
		return boardPane2;
	}

	public BoardManager getBoardManager1() {
		return boardManager1;
	}

	public BoardManager getBoardManager2() {
		return boardManager2;
	}

	public StartPane getStartPane() {
		return startPane;
	}

	public RetryPane getRetryPane() {
		return retryPane;
	}

	public SoundManager getSoundManager() {
		return soundManager;
	}

}
