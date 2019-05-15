package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import logic.Location;

public class BoardPane extends GridPane  {
	private ArrayList<Location> row0,row2,row3,row1;
	private ArrayList<Location> column0,column2,column3,column1;
	private ArrayList<ArrayList> columnList,rowList;
	
	public BoardPane() {
		this.setMinSize(300, 300);
		this.setMaxSize(300, 300);
		//this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
	    this.setGridLinesVisible(false);
	    this.setBorder(new Border(new BorderStroke(Color.BROWN,BorderStrokeStyle.SOLID , new CornerRadii(3), null)));
	    this.getStylesheets().add("game.css");
	    this.getStyleClass().add("game-grid-cell");
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
	    
	    row0 = new ArrayList<Location>();
	    row1 = new ArrayList<Location>();
	    row2 = new ArrayList<Location>();
	    row3 = new ArrayList<Location>();
	    
	    column0 = new ArrayList<Location>();
	    column1 = new ArrayList<Location>();
	    column2 = new ArrayList<Location>();
	    column3 = new ArrayList<Location>();
	    
	    for(int i=0 ; i < 4 ; i++) {
	    	row0.add(new Location(i,0));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row1.add(new Location(i,1));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row2.add(new Location(i,2));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row3.add(new Location(i,3));
	    }
	    
	    for(int i=0 ; i < 4 ; i++) {
	    	column0.add(new Location(0,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	column1.add(new Location(1,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	column2.add(new Location(2,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	column3.add(new Location(3,i));
	    }
	    columnList = new ArrayList<ArrayList>();
	    rowList = new ArrayList<ArrayList>();
	    
	    columnList.add(column0);
	    columnList.add(column1);
	    columnList.add(column2);
	    columnList.add(column3);
	    
	    rowList.add(row0);
	    rowList.add(row1);
	    rowList.add(row2);
	    rowList.add(row3);

//	    Tile a1 = Tile.newTile(2);
//	    Tile a2 = Tile.newTile(2);
//	    Tile a3 = Tile.newTile(2);
//	    Tile a4 = Tile.newTile(2);
//	    Tile a5 = Tile.newTile(4);
//	    Tile a6 = Tile.newTile(2);
//	    Tile a7 = Tile.newTile(2);
//	    Tile a8 = Tile.newTile(2);
//	    this.add(a1, 2, 0);
//	    this.add(a2, 2, 1);
//	    this.add(a3, 2, 2);
//	    this.add(a4, 2, 3);
//	    this.add(a5, 3, 0);
//	    this.add(a6, 1, 1);
//	    this.add(a7, 1, 2);
//	    this.add(a8, 1, 3);
	    // get node Example //
	    
	    
	}
	
	public ArrayList<ArrayList> getColumnList() {
		return columnList;
	}

	public ArrayList<ArrayList> getRowList() {
		return rowList;
	}

	public Node getNodeByRowColumnIndex (final int row, final int column) {
	    Node result = null;
	    ObservableList<Node> childrens = this.getChildren();

	    for (Node node : childrens) {
	        if(this.getRowIndex(node) != null &&this.getRowIndex(node) == row && this.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
	}
	
	public void removeNodeByRowColumnIndex (final int row, final int column) {
	    Node result = null;
	    ObservableList<Node> childrens = this.getChildren();

	    for (Node node : childrens) {
	        if(this.getRowIndex(node) != null &&this.getRowIndex(node) == row && this.getColumnIndex(node) == column) {
	            this.getChildren().remove(node);
	            break;
	        }
	    }
	}
}
