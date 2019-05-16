package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartPane extends Menu {
	private static Button gameStartButton = new Button("Start");
	private static Button quitButton = new Button("Quit");

	public StartPane() {
		super(gameStartButton, quitButton);
		gameStartButton.setPrefSize(300, 30);
		gameStartButton.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
		quitButton.setPrefSize(300, 30);
		quitButton.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(new ImageView(new Image(ClassLoader.getSystemResource("Logo2CP2048.png").toString())));
		this.getChildren().addAll(gameStartButton, quitButton);
	}

	@Override
	public Button getGameStartButton() {
		// TODO Auto-generated method stub
		return gameStartButton;
	}

	@Override
	public Button getQuitButton() {
		// TODO Auto-generated method stub
		return quitButton;
	}

}
