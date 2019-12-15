import java.awt.Event;
import java.util.EventObject;

public class TTTEvent extends EventObject{
	private int x;
	private int y;
	private boolean isPlayer1;
	private TTTEnum status; //status of the game
	
	public boolean isPlayer1() {
		return isPlayer1;
	}

	public void setPlayer1(boolean isPlayer1) {
		this.isPlayer1 = isPlayer1;
	}

	public TTTEvent(TTTModel source, int x, int y, boolean turn, TTTEnum status) {
		super(source);
		this.x = x;
		this.y = y;
		this.isPlayer1 = turn;
		this.status = status;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TTTEnum getStatus() {
		return status;
	}

	public void setStatus(TTTEnum status) {
		this.status = status;
	}
}
