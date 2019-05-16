package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Main;

public class RetryPane extends Menu{
	private ImageView gameOver = new ImageView(ClassLoader.getSystemResource("GameOver.png").toString());
	private static Button gameStartButton = new Button("Restart");
	private static Button quitButton = new Button("Quit");
	private Label yourScore,yourScoreString;
	
	public RetryPane() {
		super(gameStartButton,quitButton);
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.gameOver.setFitHeight(300);
		this.gameOver.setFitWidth(500);
		this.yourScoreString = new Label("Your Score");
		this.yourScore = new Label(String.format("%05d", 0));
		
		this.yourScoreString.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 32));
		this.yourScore.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
		this.yourScoreString.setTextFill(Color.WHITE);
		this.yourScore.setTextFill(Color.WHITE);
		
		gameStartButton.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
		quitButton.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 30));
		this.setPrefSize(300, 30);
		this.getChildren().addAll(gameOver,yourScoreString,yourScore,gameStartButton,quitButton);
		gameStartButton.setPrefSize(200, 30);
		quitButton.setPrefSize(200, 30);
	}
	public ImageView getGameOver() {
		return gameOver;
	}
	
	public void setYourScore(int score) {
		this.yourScore.setText(String.format("%05d", score));
	}
	public Button getGameStartButton() {
		return gameStartButton;
	}
	public Button getQuitButton() {
		return quitButton;
	}
}
