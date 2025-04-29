package robots;

public class Driver {

	public static void main(String[] args) {
		SimpleRobot simpleRobot = new SimpleRobot("SimpleJack");
//		simpleRobot.move(2, 3);
        RobotObserver observer = new RobotObserver();
        
        simpleRobot.addObserver(observer);

        simpleRobot.move(5, 10);
        simpleRobot.move(3, -2);

        System.out.println("Total observed movement: x = " + observer.getTotalX() 
            + ", y = " + observer.getTotalY());
		
	}
}
