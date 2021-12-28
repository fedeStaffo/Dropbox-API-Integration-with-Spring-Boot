package filters;

import java.util.ArrayList;

import utility.FileModel;

public class FilterSmallerSize extends Filter{

	private Number size;
	
	public FilterSmallerSize(Number dim) 
	{
		super(); // richiama il costruttore di Filter
		this.size = dim;
	}
	
	@Override
	public ArrayList<FileModel> listFilter() {
		// TODO Auto-generated method stub
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			if(x.getTag().equals("file")) // controlla se l'elemento è un file
			{
				if(x.getSize().longValue() < this.size.longValue()) // filtra i file con dimensione < dim
				{
					lista_filtrata.add(x);
				}
			}
		}
		return lista_filtrata;
	}
}
