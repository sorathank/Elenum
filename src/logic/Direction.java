package logic;
import javafx.scene.input.KeyCode;;;
public enum Direction {
	
	UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0);
	
	private final int y;
	private final int x;
	
	
	
	private Direction(int x,int y) {
		this.x = x;
		this.y = y;
	}



	public int getY() {
		return y;
	}



	public int getX() {
		return x;
	}
	
}
	

