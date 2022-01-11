package filters;

import java.util.ArrayList;
import exceptions.EmptyListExc;
import utility.FileModel;

/**
 * This class is the implementation of {@link Filter} for the filter on file's size
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FilterBiggerSize extends Filter {

	/** The size used for comparison */
	private Number size;
	
	/**
	 * Instantiates a new filter bigger size.
	 *
	 * @param dimension the dimension 
	 * @throws EmptyListExc the list is empty 
	 */
	public FilterBiggerSize(Number dimension) throws EmptyListExc 
	{
		super(); 
		this.size = dimension;
	}
	
	/**
	 * List filter.
	 *
	 * @return the filtered ArrayList with all the files with bigger size than the value used for comparison
	 */
	@Override
	public ArrayList<FileModel> listFilter() {
		
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			if(x.getTag().equals("file")) // to check if the element is a file
			{
				
				if(x.getSize().longValue() > this.size.longValue()) 
				{
					lista_filtrata.add(x);
				}
			}
		}
		return lista_filtrata;
	}
}
