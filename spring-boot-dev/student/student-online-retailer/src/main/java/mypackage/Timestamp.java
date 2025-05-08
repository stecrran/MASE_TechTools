package mypackage;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Component
public class Timestamp {

    private LocalDateTime localDateTime = LocalDateTime.now();
    
 
    public LocalDate getDate() {
        return localDateTime.toLocalDate();
    }

    public LocalTime getTime() {
    	return localDateTime.toLocalTime();
    }

}

