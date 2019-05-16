package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public abstract class Menu extends VBox {

	private Button gameStartButton, quitButton;

	public Menu(Button gameStartButton, Button quitButton) {
		this.gameStartButton = gameStartButton;
		this.quitButton = quitButton;
	}

	public abstract Button getGameStartButton();

	public abstract Button getQuitButton();
}
