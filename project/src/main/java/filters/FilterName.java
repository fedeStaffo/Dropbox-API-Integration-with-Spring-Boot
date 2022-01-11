package filters;

import java.util.ArrayList;
import exceptions.EmptyListExc;
import utility.FileModel;

/**
 * This class is the implementation of {@link Filter} for the filter on file's name
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FilterName extends Filter{

	/** The first letter of the file's name */
	private char first_lett;
	
	/**
	 * Instantiates a new filter name.
	 *
	 * @param letter the letter
	 * @throws EmptyListExc the list is empty 
	 */
	public FilterName(char letter) throws EmptyListExc 
	{
		super(); 
		this.first_lett = letter;
	}
	
	/**
	 * List filter.
	 *
	 * @return the filtered ArrayList with all the files starting with the letter
	 */
	
	@Override
	public ArrayList<FileModel> listFilter() {
	
		
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			// checks if the first letter of file's name is equal to the letter in input
			if(x.getName().charAt(0) == (this.first_lett))
			{
				lista_filtrata.add(x);
			}
		}
		
		return lista_filtrata;
	}

}
