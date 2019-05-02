package logic;

import java.util.ArrayList;

import gui.BoardPane;
import gui.Tile;

public class BoardManager {

	private BoardPane boardPane;

	public BoardManager(BoardPane boardPane) {
		this.boardPane = boardPane;
	}

	public void mergeTile(Direction direction) {
		if (!avalibleToMove(direction))
			return;
		switch (direction) {
		case UP:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				Location lastTileLocation = null;
				
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							lastTile = null;
							lastTileLocation = null;

						} else {
							lastTile = eachTile;
							lastTileLocation = eachTileLocation;
						}
					}

				}
			}

		case DOWN:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				Location lastTileLocation = null;
				
				for (int i = 3; i > -1; i--) {
					Location eachTileLocation = eachColumn.get(i);
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							lastTile = null;
							lastTileLocation = null;
						} else {
							lastTile = eachTile;
							lastTileLocation = eachTileLocation;
							
						}
					}

				}
			}
			
		case RIGHT:
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				Tile lastTile = null;
				Location lastTileLocation = null;
				
				for (int i = 3; i > -1; i--) {
					Location eachTileLocation = eachRow.get(i);
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							lastTile = null;
							lastTileLocation = null;
						} else {
							lastTile = eachTile;
							lastTileLocation = eachTileLocation;
							
						}
					}

				}
			}
			
		case LEFT:
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				Tile lastTile = null;
				Location lastTileLocation = null;
				
				for (Location eachTileLocation : eachRow) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							lastTile = null;
							lastTileLocation = null;

						} else {
							lastTile = eachTile;
							lastTileLocation = eachTileLocation;
						}
					}

				}
			}

		}
	}

	
	
	public Boolean avalibleToMove(Direction direction) {

		switch (direction) {
		case UP:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());
						
						if ((lastTile.getValue() == eachTile.getValue())) {
							return true;
						}
						lastTile = eachTile;
						
					}

				} 
			}
			return false;

		case DOWN:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							return true;
						}
						lastTile = eachTile;
						
					}

				}
			}
			return false;
		case LEFT:
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				Tile lastTile = null;
				for (Location eachTileLocation : eachRow) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							return true;
						}
						lastTile = eachTile;
					}

				}
			}
			return false;
		case RIGHT:
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				Tile lastTile = null;
				for (Location eachTileLocation : eachRow) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());

						if ((lastTile.getValue() == eachTile.getValue())) {
							return true;
						}
						lastTile = eachTile;
					}

				}
			}
			return false;
		default:
			return false;

		}

	}
}
