package robots;

import java.util.Observable;

public interface Observer {
	
	void update(Observer observer, Object data);
	
}
