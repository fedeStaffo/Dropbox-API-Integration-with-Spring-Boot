package filters;

import java.util.ArrayList;
import utility.FileModel;
import utility.GetInfoFromJSON;

public abstract class Filter {
	
	private GetInfoFromJSON dropbox;
	private ArrayList<FileModel> lista;
	
	public Filter() 
	{
		this.dropbox = new GetInfoFromJSON();
		this.lista = dropbox.getInfo();
	}
	
	// controlla se l'argomento passato è corretto altrimenti lancia il messaggio di eccezione
	public boolean checkFilter(FileModel file) throws IllegalArgumentException {
		throw new IllegalArgumentException("Filter parameters are not correct");
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
