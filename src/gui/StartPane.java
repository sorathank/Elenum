package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartPane extends VBox {
	private Button StartButton;
	private Button QuitButton;
	public StartPane() {
		String start ="Start";
		this.StartButton = new Button(start);
		this.StartButton.setPrefSize(100, 30);
		this.StartButton.setFont(new Font("Arial Round MT Bold", 20));
		this.QuitButton = new Button("Quit");
		this.QuitButton.setPrefSize(100, 30);
		this.QuitButton.setFont(new Font("Arial Round MT Bold", 20));
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.getChildren().addAll(StartButton,QuitButton);
	}
	public Button getStartButton() {
		return StartButton;
	}
	public Button getQuitButton() {
		return QuitButton;
	}
}
