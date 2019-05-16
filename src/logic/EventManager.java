package logic;

import gui.BoardPane;
import gui.ControlPane;
import gui.RetryPane;
import gui.ScorePane;
import gui.StartPane;
import javafx.event.ActionEvent;

public class EventManager {

	private ControlPane controlPane;
	private BoardPane boardPane1, boardPane2;
	private BoardManager boardManager1, boardManager2;
	private StartPane startPane;
	private RetryPane retryPane;
	private SoundManager soundManager;

	public EventManager(ControlPane controlPane, BoardPane boardPane1, BoardPane boardPane2, StartPane startPane,
			RetryPane retryPane, SoundManager soundManager) {

		this.controlPane = controlPane;
		this.boardPane1 = boardPane1;
		this.boardPane2 = boardPane2;

		this.boardManager1 = new BoardManager(boardPane1);
		this.boardManager2 = new BoardManager(boardPane2);
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
