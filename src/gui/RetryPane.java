package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Main;

public class RetryPane extends VBox{
	private ImageView gameOver = new ImageView(ClassLoader.getSystemResource("GAMEOVER_copy_1024x1024.jpg").toString());
	private Button retry;
	private Label yourScore;
	public RetryPane() {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.gameOver.setFitHeight(300);
		this.gameOver.setFitWidth(500);
		Label yourScoreString = new Label("Your Score");
		this.yourScore = new Label(String.format("%05d", 0));
		yourScoreString.setFont(new Font(30));
		this.yourScore.setFont(new Font(26));
		this.retry = new Button("Restart");
		this.retry.setFont(new Font("Arial Round MT Bold", 30));
		this.setPrefSize(300, 30);
		this.getChildren().addAll(gameOver,yourScoreString,yourScore,retry);
	}
	public ImageView getGameOver() {
		return gameOver;
	}
	public Button getRetry() {
		return retry;
	}
	public void setYourScore(int score) {
		this.yourScore.setText(String.format("%05d", score));
	}
}
