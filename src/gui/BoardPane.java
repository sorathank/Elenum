package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import logic.Location;

public class BoardPane extends GridPane  {
	private ArrayList<Location> row0,row2,row3,row1;
	private ArrayList<Location> colum0,colum2,colum3,colum1;
	private ArrayList<ArrayList> columnList,rowList;
	
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
	    
	    row0 = new ArrayList<Location>();
	    row1 = new ArrayList<Location>();
	    row2 = new ArrayList<Location>();
	    row3 = new ArrayList<Location>();
	    
	    colum0 = new ArrayList<Location>();
	    colum1 = new ArrayList<Location>();
	    colum2 = new ArrayList<Location>();
	    colum3 = new ArrayList<Location>();
	    
	    for(int i=0 ; i < 4 ; i++) {
	    	row0.add(new Location(0,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row1.add(new Location(1,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row2.add(new Location(2,i));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	row3.add(new Location(3,i));
	    }
	    
	    for(int i=0 ; i < 4 ; i++) {
	    	colum0.add(new Location(i,0));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	colum1.add(new Location(i,1));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	colum2.add(new Location(i,2));
	    }
	    for(int i=0 ; i < 4 ; i++) {
	    	colum3.add(new Location(i,3));
	    }
	    columnList = new ArrayList<ArrayList>();
	    rowList = new ArrayList<ArrayList>();
	    
	    columnList.add(colum0);
	    columnList.add(colum1);
	    columnList.add(colum2);
	    columnList.add(colum3);
	    
	    rowList.add(row0);
	    rowList.add(row1);
	    rowList.add(row2);
	    rowList.add(row3);

	    // get node Example //
	    
	    /* 
	    this.add(a1, 0, 0);
	    a1 = Tile.newRandomTile();
	    if(getNodeByRowColumnIndex(0, 0) instanceof Tile){
	    	Tile tile = (Tile)getNodeByRowColumnIndex(0, 0);
	    	if (tile.getValue() == 2) {
	    		System.out.println("Method Working");
	    	}
	    }
	    */
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
