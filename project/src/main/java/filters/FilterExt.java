package filters;

import java.util.ArrayList;
import exceptions.EmptyListExc;
import utility.FileModel;


/**
 * This class is the implementation of {@link Filter} for the filter on file's extension
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FilterExt extends Filter {
	
	/** The extension of the file. */
	private String estensione;
	
	/**
	 * Instantiates a new filter extension
	 *
	 * @param extension the extension
	 * @throws EmptyListExc the list is empty 
	 */
	public FilterExt (String extension) throws EmptyListExc
	{
		super();
		this.estensione = extension;
	}

	/**
	 * List filter.
	 *
	 * @return the filtered ArrayList with all the files containing the extension
	 */
	@Override
	public ArrayList<FileModel> listFilter() {
		
		ArrayList<FileModel> ListaFiltrata = new ArrayList<FileModel>();
		
		for (FileModel i : this.getLista()) 
		{
			
			if (!(i.getTag().equals("folder"))) 
			{
				if ((this.estensione).equals(i.getExtension())) 
				{
				ListaFiltrata.add(i);
				}
			}
		}
		return ListaFiltrata;
	}
}
