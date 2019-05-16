package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class ControlPart extends BorderPane {

	private Button upButton, downButton, leftButton, rightButton, restartButton;

	public ControlPart() {

		this.setPadding(new Insets(10));
		upButton = new ArrowButton("Up");
		downButton = new ArrowButton("Down");
		leftButton = new ArrowButton("Left");
		rightButton = new ArrowButton("Right");
		restartButton = new Button("RESTART");
		restartButton.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
	}

	public Button getRestartButton() {
		return restartButton;
	}

	public Button getUpButton() {
		return upButton;
	}

	public Button getDownButton() {
		return downButton;
	}

	public Button getLeftButton() {
		return leftButton;
	}

	public Button getRightButton() {
		return rightButton;
	}

}
