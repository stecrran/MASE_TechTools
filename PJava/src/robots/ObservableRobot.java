package robots;

import java.util.List;
import java.util.Observable;

abstract class ObservableRobot extends Observable {

	private List<Observer> observers;
	
	public void register(Observer o) {
		observers.add(o);
	}
	
	public void unRegister(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservsers(RobotData robotData) {
		for (Observer observer: observers) {
			observer.update(null, robotData);
		}
	}
}
