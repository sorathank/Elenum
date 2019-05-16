package logic;

import main.Main;

import gui.RetryPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Main;

public class ArrowButtonEventHandler implements EventHandler<ActionEvent> {

	private Direction direction;
	private BoardManager boardManager;
	public static boolean isDead;

	public ArrowButtonEventHandler(Direction direction, BoardManager boardManager) {
		// TODO Auto-generated constructor stub
		this.direction = direction;
		this.boardManager = boardManager;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		boardManager.move(direction);
		if (!boardManager.avalibleToMove(Direction.DOWN) && !boardManager.avalibleToMove(Direction.UP)
				&& !boardManager.avalibleToMove(Direction.RIGHT) && !boardManager.avalibleToMove(Direction.LEFT)) {
			isDead = true;
		}
	}
}
