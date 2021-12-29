package exceptions;

public class IllegalParameterException extends IllegalArgumentException {

	private static final long serialVersionUID = 2L;
	
	public IllegalParameterException() 
	{
		super();
	}
	
	public IllegalParameterException(String msg) 
	{
		super(msg);
	}

}
