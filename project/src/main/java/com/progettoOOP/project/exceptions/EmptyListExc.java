package exceptions;

public class EmptyListExc extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmptyListExc() 
	{
		super();
	}
	
	public EmptyListExc(String msg) 
	{
		super(msg);
	}

	
}
