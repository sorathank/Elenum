package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartPane extends Menu {
	private static Button gameStartButton = new Button("Start");
	private static Button quitButton = new Button("Quit");
	public StartPane() {
		super(gameStartButton,quitButton);
		gameStartButton.setPrefSize(100, 30);
		gameStartButton.setFont(new Font("Arial Round MT Bold", 20));
		quitButton.setPrefSize(100, 30);
		quitButton.setFont(new Font("Arial Round MT Bold", 20));
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(gameStartButton,quitButton);
	}

}
