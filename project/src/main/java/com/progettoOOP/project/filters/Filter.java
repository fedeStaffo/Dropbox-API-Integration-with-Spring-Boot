package filters;

import java.util.ArrayList;
import utility.FileModel;
import exceptions.*;
import utility.GetInfoFromJSON;

public abstract class Filter {
	
	private GetInfoFromJSON dropbox;
	private ArrayList<FileModel> lista;
	
	public Filter() throws EmptyListExc
	{
		this.dropbox = new GetInfoFromJSON();
		if(this.dropbox == null) 
		{
			throw new EmptyListExc("Empty JSON database");
		}
		else 
		{
			this.lista = dropbox.getInfo();
		}
	}
	
	// generica funzione di filtraggio
	public abstract ArrayList<FileModel> listFilter();
	
	public ArrayList<FileModel> getLista() {
		return lista;
	}

	public void setLista(ArrayList<FileModel> lista) {
		this.lista = lista;
	}

	
}
