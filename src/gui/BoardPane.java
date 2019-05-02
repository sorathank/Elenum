package gui;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class BoardPane extends GridPane  {

	private static final int COLUM_AMOUNT = 4;
	private static final int ROW_AMOUNT = 4;
	private ArrayList<Tile> tileList;
	private Tile a1,a2,a3,a4,a5;
	
	public BoardPane() {
		this.setMinSize(300, 300);
		this.setMaxSize(300, 300);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
	    this.setGridLinesVisible(true);
	    final int numCols = 4 ;
	    final int numRows = 4 ;
	    this.setVgap(10);
	    this.setHgap(10);
	        for (int i = 0; i < numCols; i++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setPercentWidth(100/numCols);
	            this.getColumnConstraints().add(colConst);
	        }
	        for (int i = 0; i < numRows; i++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setPercentHeight(100 / numRows);
	            this.getRowConstraints().add(rowConst);         
	        }
		
	}
}
