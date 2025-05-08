package mypackage;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ShoppingSession {
	
	private String displayTimestampMode;
	
	@Autowired
	public ShoppingSession(ApplicationArguments args) {
		if(args.containsOption("displayTimestampMode")) {
			displayTimestampMode = args.getOptionValues("displayTimestampMode").get(0);
		}
		else {
			displayTimestampMode = "none";
		}
	}

	@Value("#{timestamp.date}")
	private LocalDate startDate;
	
	@Value("#{timestamp.time}")
	private LocalTime startTime;
	
	public void displayStartDateTime() {
		System.out.println("Start Date: " + startDate);
		System.out.println("Start Time: " + startTime);
		if (displayTimestampMode.equals("date") || displayTimestampMode.equals("both")){
			System.out.printf("Shopping session start date: %s\n", startDate);
		}
		if (displayTimestampMode.equals("time") || displayTimestampMode.equals("both")) {
			System.out.printf("Shopping session start time: %s\n", startTime);
		}
	}
	

	
	
}
