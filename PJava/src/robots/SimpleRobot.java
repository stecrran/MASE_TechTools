package robots;

import java.util.Observable;

public class SimpleRobot extends Observable implements Robot {
	
	private String name;

	public SimpleRobot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void move(int x, int y) {
		System.out.println("Robot " + getName() + " is moving " + "x = " + x + " and y = " + y);
		RobotData robotData = new RobotData(x, y);
		setChanged();
		notifyObservers(robotData);
		
		
	}

}
