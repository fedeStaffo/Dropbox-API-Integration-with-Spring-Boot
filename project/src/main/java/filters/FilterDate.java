package filters;

import java.util.ArrayList;
import exceptions.EmptyListExc;
import utility.FileModel;


/**
 * This class is the implementation of {@link Filter} for the filter on file's date
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FilterDate extends Filter {
	
	/** The date of the file or the folder */
	private String date;
	
	/**
	 * Instantiates a new filter date
	 *
	 * @param date the date
	 * @throws EmptyListExc the list is empty 
	 */
	public FilterDate (String date) throws EmptyListExc {
		super();
		this.date = date;
	}
	
	/**
	 * List filter.
	 *
	 * @return the filtered ArrayList with all files and folders containing the date
	 */
	public ArrayList<FileModel> listFilter()
	{
		
		ArrayList<FileModel> ListaFiltrata = new ArrayList<>();
		
		for (FileModel i : this.getLista()) 
		{
			
			if (!(i.getTag().equals("folder"))) 
			{
				
				// checks if the input date is equal to the JSONObject one and checks only YYYY-MM-DD  
				if((this.date).equals(i.getServer_modified().substring(0, 10)))
				{
					ListaFiltrata.add(i);
				}
				
			}
		}
		
		return ListaFiltrata;
	}
}
