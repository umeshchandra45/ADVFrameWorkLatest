package support.exceptions;

public class CustomTestErrorRuntime extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

    // Constructor with error message and cause
    public CustomTestErrorRuntime(String message, Throwable cause) {
        super(message, cause);
        cause.printStackTrace();
    }

}
