package support.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomTestException extends Exception {
	private static final long serialVersionUID = 1L;

	// Logger instance
	private static final Logger logger = LogManager.getLogger(CustomTestException.class);

	// Constructor with error message
	public CustomTestException(String message) {
		super(message);
		logger.error(message); // Log the error message
	}

	// Constructor with error message and cause
	public CustomTestException(String message, Throwable cause) {
		super(message, cause);
		logger.error(message, cause); // Log the error message with cause
	}
}
