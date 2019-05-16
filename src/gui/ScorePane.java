package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ScorePane extends VBox {
	private Label scoreLabel;
	private Label scoreField;
	private int score;

	public ScorePane() {
		this.scoreField = new Label();
		this.scoreLabel = new Label();
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.score = 0;
		this.setPrefHeight(200);
		this.setPrefWidth(180);
		this.scoreLabel.setText("Score");
		scoreLabel.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 44));
		scoreField.setFont(Font.loadFont(ClassLoader.getSystemResource("KenneyPixelSquare.ttf").toString(), 32));
		this.scoreField.setText(String.format("%05d", score));
		this.getChildren().addAll(this.scoreLabel, this.scoreField);
	}

	public void update(int score) {
		this.score += score;
		this.scoreField.setText(String.format("%05d", this.score));
	}

	public void reset() {
		this.score = 0;
		this.scoreField.setText(String.format("%05d", this.score));
	}

	public int getScore() {
		return score;
	}
}
