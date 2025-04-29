package Logging;

import org.apache.log4j.*;


public class DriverLog4j {
	
	public static void main(String[] args) {
	    Logger logger = Logger.getLogger(String.valueOf(DriverLog4j.class));

	    logger.debug("Debug message in Driver");
	    logger.error("Error message in Driver");
	    logger.fatal("Fatal message in Driver");
	    logger.info("Info message in Driver");
	    logger.trace("Trace message in Driver");
	    logger.warn("Warn message in Driver");
	}

}