package Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSlf4j {
	public static void main(String args[]) {

		Logger logger = LoggerFactory.getLogger(Logging.Driver.class);
		logger.debug("Debug message in Driver");
		logger.error("Error message in Driver");
		logger.info("Info message in Driver");
		logger.trace("Trace message in Driver");
		logger.warn("Warn message in Driver");

	}
}