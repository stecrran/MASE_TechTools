package robots;

import java.util.Observable;
import java.util.Observer;

public class RobotObserver implements Observer {
	private static int totalX = 0;
	private static int totalY = 0;

	@Override
	public void update(Observable o, Object data) {
		RobotData movement = (RobotData) data;
		totalX += movement.getDeltaX();
		totalY += movement.getDeltaY();
		
		System.out.println("RobotObserver has observed movement of x=" + movement.getDeltaX() + " and y=" + movement.getDeltaY());
		
	}
	
	public static int getTotalX() {
		return totalX;
	}
	
	public static int getTotalY() {
		return totalY;
	}

}
