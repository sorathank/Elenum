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

	private String url;
	private Direction direction;

	public ArrowButton(String direction) {
		this.setPadding(new Insets(5));
		this.setMaxSize(1, 1);
		setBorder(new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		switch (direction) {
		case "Up":
			this.url = "UpArrow.png";
			this.direction = Direction.UP;
			break;
		case "Down":
			this.url = "DownArrow.png";
			this.direction = Direction.DOWN;
			break;
		case "Right":
			this.url = "RightArrow.png";
			this.direction = Direction.RIGHT;
			break;
		case "Left":
			this.url = "LeftArrow.png";
			this.direction = Direction.LEFT;
			break;

		}

		ImageView icon = new ImageView(new Image(ClassLoader.getSystemResource(url).toString()));
		icon.setScaleX(1);
		icon.setScaleY(1);
		this.getChildren().add(icon);
		this.setGraphic(icon);
	}

	public void highlight() {

		// TODO Changes Background fill

		this.setBackground(new Background(new BackgroundFill(Color.KHAKI, null, null)));

	}

	public void unhighlight() {

		// TODO Changes Background fill
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
	}
	
	
}
