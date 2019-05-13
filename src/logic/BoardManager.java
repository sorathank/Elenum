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
							System.out.println("23");
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
			break;
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
			break;
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
			break;
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
			break;
		}
	}

	public Boolean avalibleToMove(Direction direction) {

		switch (direction) {
		case UP:
			System.out.println("checking");
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				Tile lastTile = null;
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
			}
			break;
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
			break;
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
			break;
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
			break;
		}
		return false;
	}

	public void move(Direction direction) {
		switch (direction) {
		case UP:
			if (avalibleToMove(Direction.UP)) {
				mergeTile(Direction.UP);
				int columnNumber = 0;
				for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
					ArrayList<Tile> tile = new ArrayList<Tile>();
					for (Location eachLocation : eachColumn) {
						if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
								eachLocation.getX()) instanceof Tile) {
							tile.add(
									(Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX()));
							boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
						}
					}
					int i = 0;
					if (tile.size() != 0) {
						for (Tile eachTile : tile) {
							boardPane.add(eachTile, columnNumber, i);
							i++;
						}
					}
					columnNumber++;
				}
			}
			break;
		case DOWN:
			if (avalibleToMove(Direction.DOWN)) {
				mergeTile(Direction.DOWN);
				int columnNumber = 0;
				for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
					ArrayList<Tile> tile = new ArrayList<Tile>();
					for (Location eachLocation : eachColumn) {
						if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
								eachLocation.getX()) instanceof Tile) {
							tile.add(
									(Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX()));
							boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
						}
					}
					int i = 3;
					if (tile.size() != 0) {
						for (Tile eachTile : tile) {
							boardPane.add(eachTile, columnNumber, i);
							i--;
						}
					}
					columnNumber++;

				}
			}
			break;
		case LEFT:
			if (avalibleToMove(Direction.LEFT)) {
				mergeTile(Direction.LEFT);
				int rowNumber = 0;
				for (ArrayList<Location> eachRow : boardPane.getRowList()) {
					ArrayList<Tile> tile = new ArrayList<Tile>();
					for (Location eachLocation : eachRow) {
						if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
								eachLocation.getX()) instanceof Tile) {
							tile.add(
									(Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX()));
							boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
						}
					}
					int i = 0;
					if (tile.size() != 0) {
						for (Tile eachTile : tile) {
							boardPane.add(eachTile, i, rowNumber);
							i++;
						}
					}
					rowNumber++;
				}
			}
		case RIGHT:
			if (avalibleToMove(Direction.RIGHT)) {
				mergeTile(Direction.RIGHT);
				int rowNumber = 0;
				for (ArrayList<Location> eachRow : boardPane.getRowList()) {
					ArrayList<Tile> tile = new ArrayList<Tile>();
					for (Location eachLocation : eachRow) {
						if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
								eachLocation.getX()) instanceof Tile) {
							tile.add(
									(Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX()));
							boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
						}
					}
					int i = 3;
					if (tile.size() != 0) {
						for (Tile eachTile : tile) {
							boardPane.add(eachTile, i, rowNumber);
							i--;
						}
					}
					rowNumber++;
				}
			}
		}
	}
}
