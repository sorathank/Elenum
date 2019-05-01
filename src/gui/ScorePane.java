package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class ScorePane extends VBox{
	private TextField label;
	private TextField scoreField;
	private int score;
	
	public ScorePane() {
		
		this.setPadding(new Insets(10));
		this.score = 0;
		this.setPrefHeight(90);
		this.setPrefWidth(160);
		this.label.setText("Score");
		this.scoreField.setText(String.format("%05d",score));
		this.getChildren().addAll(this.label,this.scoreField);
	}
	public void update(int score) {
		this.scoreField.setText(String.format("%05d", score));
	}
}
