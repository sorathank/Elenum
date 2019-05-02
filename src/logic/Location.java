package logic;

public class Location {
	private final int x;
	private final int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location offset(Direction direction) {
		return new Location(x + direction.getX(), y + direction.getY());
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Location{" + "x=" + x + ", y=" + y + '}';
	}

	public boolean isValidFor(int gridSize) {
		return x >= 0 && x < gridSize && y >= 0 && y < gridSize;
	}
}
