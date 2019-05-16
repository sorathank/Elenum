package gui;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.Location;

public class Tile extends Label {

	private int value;
	private Location location;
	private Boolean isMerged;
	private static final int TILE_SIZE = 65;

	public static Tile newRandomTile() {
		int value = new Random().nextDouble() < 0.9 ? 2 : 4;
		return new Tile(value);
	}

	public static Tile newTile(int value) {
		return new Tile(value);
	}

	private Tile(int value) {

		this.value = value;
		this.isMerged = false;
		this.setMaxSize(TILE_SIZE, TILE_SIZE);
		this.setMinSize(TILE_SIZE, TILE_SIZE);
		setPrefSize(TILE_SIZE, TILE_SIZE);
		setAlignment(Pos.CENTER);
		setText(Integer.toString(value));
		getStylesheets().add("game.css");
		getStyleClass().addAll("game-label", "game-tile-" + value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		getStyleClass().add("game-tile-" + value);
		setText(Integer.toString(value));
		this.value = value;
	}

	public Boolean getIsMerged() {
		return isMerged;
	}

	public String toString() {
		return Integer.toString(this.value);
	}
}
