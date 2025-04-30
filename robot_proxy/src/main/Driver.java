package main;

import robots.Robot;
import robots.factory.RobotFactory;

public class Driver {
	
	public static void main(String args[]) {
		Robot robot = RobotFactory.createRobot();
		robot.move(100, 200);
	}

}
