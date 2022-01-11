package filters;

import java.util.ArrayList;
import exceptions.EmptyListExc;
import utility.FileModel;

/**
 * This class is the implementation of {@link Filter} for the filter on file's path
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FilterPath extends Filter {

	/** The path of the file */
	private String path;
	
	/**
	 * Instantiates a new filter path.
	 *
	 * @param path the path
	 * @throws EmptyListExc the list is empty 
	 */
	public FilterPath(String path) throws EmptyListExc 
	{
		super();  // to call the constructor of the abstract class Filter
		this.path = path;
	}
	
	/**
	 * List filter.
	 *
	 * @return the filtered ArrayList with all the files containing the path
	 */
	
	@Override
	public ArrayList<FileModel> listFilter() {
		
		
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			if(!(x.getTag().equals("folder"))) 
			{
				int pos = x.getPath().lastIndexOf("/"); // gets the position of the last folder separator
				
				String path_cut = x.getPath().substring(0, pos); // gets the path without file's name
				
				if(path_cut.equals(this.path)) 
				{
					lista_filtrata.add(x);
				}
			}	
		}
		
		return lista_filtrata;
	}

}
