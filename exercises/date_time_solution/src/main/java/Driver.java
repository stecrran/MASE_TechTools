
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Driver {

	public static void main(String[] args) {


		// Part 1  Working with Date
		
		LocalDate dateNow = LocalDate.now();
		
		System.out.printf("Date now: %s %n", dateNow);
		
		System.out.printf("Date 10 days earlier: %s %n", dateNow.minusDays(10));
		
		System.out.printf("Date 1 day from now: %s %n", dateNow.plusDays(1));
		

		// Part 2 Working with Time
		
		LocalTime timeNow = LocalTime.now();
		
		System.out.printf("Time now: %s %n", timeNow);
		
		System.out.printf("Time 3 hours earlier: %s %n", timeNow.minusHours(3));
		
		System.out.printf("Time 3 hours in the future: %s %n", timeNow.plusHours(3));
		

		// Part 3 Working with Date Time 
		
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		

		System.out.printf("Date Time now: %s %n", dateTimeNow);
		
		System.out.printf("Date Time 30 hours earlier: %s %n", dateTimeNow.minusHours(30));
		
		System.out.printf("Time 30 hours in the future: %s %n", dateTimeNow.plusHours(30));
		
		
		// Part 4  Working with Temporal adjustors

		
		LocalDate localDate = LocalDate.now();
		Locale locale = Locale.getDefault();

		 
		Month month = localDate.getMonth();
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();

		        
		System.out.printf ("%n%nxxxxxxxxxxxxxxxxxxToday is: %s %n",
				localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek().getDisplayName(TextStyle.NARROW, locale));

		
		System.out.printf("The current month is: %s %n",
				month.getDisplayName(TextStyle.FULL, locale));
		
		
		
		System.out.printf("First day of this month was: %s%n",
				localDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().name());
		
		
		System.out.printf("Last day of this month will be: %s%n",
				localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek().name());
		
		
		System.out.printf("Last Monday was: %s%n",
				localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
		
		
		System.out.printf("Next Friday is: %s%n ",
				localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		
		
		
		
		
		
		System.out.printf("First Monday of this month was: %s%n",
				localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));

		
		
		System.out.printf("Last Friday of this month will be: %s%n",
				localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

		
		System.out.printf("First day of the next month will be: %s%n", 
				localDate.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek().name());

		
		System.out.printf("First day of this year was: %s%n",
				localDate.with(TemporalAdjusters.firstDayOfYear()).getDayOfWeek().name());
		
		
		System.out.printf("Last day of this year will be: %s%n",
				localDate.with(TemporalAdjusters.lastDayOfYear()).getDayOfWeek().name());		
		
		
		
	}

}
