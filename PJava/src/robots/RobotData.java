package robots;

public class RobotData {
	private int deltaX;
	private int deltaY;
	
	public RobotData(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public int getDeltaX() {
		return deltaX;
	}
	
	public int getDeltaY() {
		return deltaY;
	}

}
