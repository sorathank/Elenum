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

public class ArrowButton extends Button {

	private String arrowDirection, url;

	public ArrowButton(String direction) {
		this.setPadding(new Insets(5));
		this.setMaxSize(1, 1);
		setBorder(new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.arrowDirection = direction;
		switch (arrowDirection) {
		case "Up":
			this.url = "UpArrow.png";
			break;
		case "Down":
			this.url = "DownArrow.png";
			break;
		case "Right":
			this.url = "RightArrow.png";
			break;
		case "Left":
			this.url = "LeftArrow.png";
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
