package exceptions;


/**
 * Exception thrown if the filter has incorrect parameters
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class IllegalParameterException extends IllegalArgumentException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;
	
	/**
	 * Instantiates a new illegal parameter exception.
	 */
	public IllegalParameterException() 
	{
		super();
	}
	
	/**
	 * Instantiates a new illegal parameter exception.
	 *
	 * @param msg message of error shown
	 */
	public IllegalParameterException(String msg) 
	{
		super(msg);
	}

}
