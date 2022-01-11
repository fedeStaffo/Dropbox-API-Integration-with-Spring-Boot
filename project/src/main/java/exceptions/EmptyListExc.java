package exceptions;


/**
 * Exception thrown if the list of files is empty
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class EmptyListExc extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new empty list exception.
	 */
	public EmptyListExc(){
		super();
	}

	/**
	 * Instantiates a new empty list exception.
	 *
	 * @param msg message of error shown
	 */
	public EmptyListExc(String msg){
		super(msg);
	}
	
}
