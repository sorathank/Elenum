package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.Direction;

public class ArrowButton extends Button {
	
	private Direction direction;

	public ArrowButton(String direction) {
		
		switch (direction) {
		case "Up":
			this.direction = Direction.UP;
			break;
		case "Down":
			this.direction = Direction.DOWN;
			break;
		case "Right":
			this.direction = Direction.RIGHT;
			break;
		case "Left":
			this.direction = Direction.LEFT;
			break;

		}

		
	}

	
	
}
