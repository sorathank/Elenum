package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Menu extends VBox {

	private Button gameStartButton,quitButton;
	
	public Menu(Button gameStartButton,Button quitButton) {
		this.gameStartButton = gameStartButton;
		this.quitButton = quitButton;
	}
	
	public Button getGameStartButton() {
		return this.gameStartButton;
	}
	
	public Button getQuitButton() {
		return this.quitButton;
	}
}
