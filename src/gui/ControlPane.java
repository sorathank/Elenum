package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ControlPane extends BorderPane {
	
	private Button upButton,downButton,leftButton,rightButton;
	public static final String UP = "Up";
	public static final String DOWN = "Down";
	public static final String LEFT = "Left";
	public static final String RIGHT = "Right";
	public ControlPane() {
		
		this.setPadding(new Insets(10));
		this.setPrefSize(160, 160);
		upButton = new ArrowButton(UP);
		downButton = new ArrowButton(DOWN);
		leftButton = new ArrowButton(LEFT);
		rightButton = new ArrowButton(RIGHT);
		this.setTop(upButton);
		this.setLeft(leftButton);
		this.setRight(rightButton);
		this.setBottom(downButton);
		
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
