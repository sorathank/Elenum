package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class ScorePane extends VBox{
	private javafx.scene.control.TextField label;
	private javafx.scene.control.TextField score;
	
	public ScorePane(int score) {
		this.setPadding(new Insets(10));
		this.setPrefHeight(90);
		this.setPrefWidth(160);
		this.label.setText("Score");
		this.score.setText("00000");
		this.getChildren().addAll(this.label,this.score);
	}
	public void update(int score) {
		this.score.setText(String.format("%05d", score));
	}
}
