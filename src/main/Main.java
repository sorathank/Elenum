package main;

import gui.ControlPane;
import gui.ScorePane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	public void start(Stage primaryStage) {
		HBox main = new HBox();
		main.setPrefSize(1280, 720);
		main.setSpacing(10);
		main.setPadding(new Insets(10));
		javafx.scene.control.Label title = new javafx.scene.control.Label("Elenum");
		title.setFont(new Font("Blackadder ITC", 72));
		ScorePane scorePane = new ScorePane();
		VBox grid1 = new VBox();
		VBox grid2 = new VBox();
		VBox dataPane = new VBox();
		ControlPane controlPane = new ControlPane();
		controlPane.setPrefSize(320, 320);
		grid1.setPrefSize(480, 720);
		grid2.setPrefSize(480, 720);
		dataPane.setAlignment(Pos.TOP_CENTER);
		dataPane.getChildren().addAll(title, scorePane, controlPane);
		main.getChildren().addAll(grid1, dataPane, grid2);
		Scene scene = new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Elenum");
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
