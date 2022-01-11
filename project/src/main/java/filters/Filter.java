package filters;

import java.util.ArrayList;
import utility.FileModel;
import exceptions.*;
import utility.GetInfoFromJSON;

/**
 * This class is the abstract superclass from which every filter inherits
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public abstract class Filter {
	
	/** The JSONObject */
	private GetInfoFromJSON dropbox;
	
	/** The ArrayList got from the JSONObject. */
	private ArrayList<FileModel> lista;
	
	/**
	 * Instantiates a new filter.
	 *
	 * @throws EmptyListExc the list is empty
	 */
	public Filter() throws EmptyListExc
	{
		this.dropbox = new GetInfoFromJSON();
		this.lista = dropbox.getInfo();
		
		if(this.lista.toString().equals("[]")) 
		{
			throw new EmptyListExc("Empty JSON database");
		}
		
	}
	
	/**
	 * 
	 * Generic abstract filtering method
	 * 
	 * @return the filtered ArrayList
	 */ 
	public abstract ArrayList<FileModel> listFilter();
	
	/**
	 * Gets the ArrayList
	 *
	 * @return the ArrayList
	 */
	public ArrayList<FileModel> getLista() {
		return lista;
	}

	/**
	 * Sets the ArrayList
	 *
	 * @param lista the new ArrayList
	 */
	public void setLista(ArrayList<FileModel> lista) {
		this.lista = lista;
	}

	
}
