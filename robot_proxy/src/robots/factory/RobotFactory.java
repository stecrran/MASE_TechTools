package robots.factory;

import java.lang.reflect.Proxy;

import profile.Profile;
import profile.Profiler;
import robots.Robot;
import robots.SimpleRobot;

public class RobotFactory {

	public static Robot createRobot() {
		Robot robot = new SimpleRobot("R2D2");
		if(robot.getClass().isAnnotationPresent(Profile.class)) {
			Profiler profiler = new Profiler(robot);
			
			robot = (Robot) Proxy.newProxyInstance(profiler.getClass().getClassLoader(), new Class[] {Robot.class}, profiler);
		}
		
		
		return robot;
	}
}
