package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class RetryPane extends VBox{
	private ImageView gameOver = new ImageView(ClassLoader.getSystemResource("/GAMEOVER_copy_1024x1024.jpg").toString());
	private Button retry;
	public RetryPane() {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.gameOver.setFitHeight(500);
		this.gameOver.setFitWidth(500);
		this.retry = new Button("Restart");
		this.retry.setFont(new Font("Arial Round MT Bold", 30));
		this.setPrefSize(100, 30);
		this.getChildren().addAll(gameOver,retry);
	}
	public ImageView getGameOver() {
		return gameOver;
	}
	public Button getRetry() {
		return retry;
	}
}
