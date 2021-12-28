package filters;

import java.util.ArrayList;

import utility.FileModel;

public class FilterName extends Filter{

	private char first_lett;
	
	public FilterName(char letter) 
	{
		super(); // richiama il costruttore di Filter
		this.first_lett = letter;
	}
	
	// metodo per filtrare i file e le cartelle per iniziale del nome
	@Override
	public ArrayList<FileModel> listFilter() {
		// TODO Auto-generated method stub
		
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			if(x.getName().charAt(0) == this.first_lett)
			{
				lista_filtrata.add(x);
			}
		}
		
		return lista_filtrata;
	}

}
