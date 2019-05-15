package logic;

import java.util.ArrayList;
import java.util.Random;

import gui.ArrowButton;
import gui.BoardPane;
import gui.Tile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;

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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							Main.scorePane.update(lastTile.getValue() * 2);
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
							Main.scorePane.update(lastTile.getValue() * 2);
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

						if ((lastTile != null) && (lastTile.getValue() == eachTile.getValue())) {
							lastTile.setValue(lastTile.getValue() * 2);
							boardPane.removeNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX());
							Main.scorePane.update(lastTile.getValue() * 2);
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
							Main.scorePane.update(lastTile.getValue() * 2);
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

		ArrayList<Tile> tileList = new ArrayList<Tile>();

		switch (direction) {

		case UP:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				tileList.clear();
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						tileList.add((Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX()));

					} else
						tileList.add(null);
				}
				for (int index = 1; index < 4; index++) {

					if (tileList.get(index) != null) {
						if (tileList.get(index - 1) == null) {
							return true;
						} else if (tileList.get(index - 1).getValue() == tileList.get(index).getValue()) {
							return true;
						}
					}

				}
			}
			return false;

		case DOWN:
			for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
				tileList.clear();
				for (Location eachTileLocation : eachColumn) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						tileList.add((Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX()));

					} else
						tileList.add(null);
				}
				for (int index = 1; index < 4; index++) {

					if (tileList.get(index - 1) != null) {
						if (tileList.get(index) == null) {
							return true;
						} else if (tileList.get(index).getValue() == tileList.get(index - 1).getValue()) {
							return true;
						}
					}
				}
			}
			return false;
		case LEFT:
			System.out.println("Left checking");
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				tileList.clear();
				for (Location eachTileLocation : eachRow) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						tileList.add((Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX()));

					} else
						tileList.add(null);
				}
				for (int index = 1; index < 4; index++) {

					if (tileList.get(index) != null) {
						if (tileList.get(index - 1) == null) {
							return true;
						} else if (tileList.get(index - 1).getValue() == tileList.get(index).getValue()) {
							return true;
						}
					}

				}
			}
			return false;
		case RIGHT:
			for (ArrayList<Location> eachRow : boardPane.getRowList()) {
				tileList.clear();
				for (Location eachTileLocation : eachRow) {
					if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
							eachTileLocation.getX()) instanceof Tile) {
						tileList.add((Tile) boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(),
								eachTileLocation.getX()));

					} else
						tileList.add(null);
				}
				for (int index = 1; index < 4; index++) {

					if (tileList.get(index - 1) != null) {
						if (tileList.get(index) == null) {
							return true;
						} else if (tileList.get(index - 1).getValue() == tileList.get(index).getValue()) {
							return true;
						}
					}

				}
			}
			return false;
		}
		return false;
	}

	public void move(Direction direction) {
		if (avalibleToMove(direction)) {
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
								tile.add((Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
										eachLocation.getX()));
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
						ArrayList<Tile> tileList = new ArrayList<Tile>();
						for (Location eachLocation : eachColumn) {
							if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
									eachLocation.getX()) instanceof Tile) {
								tileList.add((Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
										eachLocation.getX()));
								boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
							}
						}
						int i = 4 - tileList.size();
						if (tileList.size() != 0) {
							for (Tile eachTile : tileList) {
								boardPane.add(eachTile, columnNumber, i);
								i++;
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
								tile.add((Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
										eachLocation.getX()));
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
				break;
			case RIGHT:
				if (avalibleToMove(Direction.RIGHT)) {
					mergeTile(Direction.RIGHT);
					int rowNumber = 0;
					for (ArrayList<Location> eachRow : boardPane.getRowList()) {
						ArrayList<Tile> tile = new ArrayList<Tile>();
						for (Location eachLocation : eachRow) {
							if (boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
									eachLocation.getX()) instanceof Tile) {
								tile.add((Tile) boardPane.getNodeByRowColumnIndex(eachLocation.getY(),
										eachLocation.getX()));
								boardPane.removeNodeByRowColumnIndex(eachLocation.getY(), eachLocation.getX());
							}
						}
						int i = 4 - tile.size();
						if (tile.size() != 0) {
							for (Tile eachTile : tile) {
								boardPane.add(eachTile, i, rowNumber);
								i++;
							}
						}
						rowNumber++;
					}
				}
			}
			this.generateNewTile();
		}
	}

	public void setButtonEvent(ArrowButton button) {

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void generateNewTile() {
		ArrayList<Location> emptyBoxList = new ArrayList<Location>();
		for (ArrayList<Location> eachColumn : boardPane.getColumnList()) {
			for (Location eachTileLocation : eachColumn) {
				if (boardPane.getNodeByRowColumnIndex(eachTileLocation.getY(), eachTileLocation.getX()) == null) {
					emptyBoxList.add(eachTileLocation);
				}
			}
		}
		Random random = new Random();
		int index = random.nextInt(emptyBoxList.size());
		System.out.println(index);
		boardPane.add(Tile.newRandomTile(), emptyBoxList.get(index).getX(), emptyBoxList.get(index).getY());

	}
}
