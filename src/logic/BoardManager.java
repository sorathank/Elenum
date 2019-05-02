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
		System.out.println("CHECK");
		switch (direction) {
		case UP:
			System.out.println("Merging");
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				Location lastTileLocation = null;
				
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());
						System.out.println("lastTile" + lastTile);
						System.out.println("eachTile" + eachTile.toString());

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							lastTile = null;
							lastTileLocation = null;
							System.out.println("checkpoint2");

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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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
						System.out.println(lastTile);

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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
			System.out.println("checking");
			int k = 0;
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
				System.out.println(Integer.toString(k));
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						Tile eachTile = (Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX());
						
						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
							System.out.println("can move");
							return true;
						}
						lastTile = eachTile;
						
					}

				}
				k++;
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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
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
