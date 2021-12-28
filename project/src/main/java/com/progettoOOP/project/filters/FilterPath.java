package filters;

import java.util.ArrayList;

import utility.FileModel;

public class FilterPath extends Filter {

	private String path;
	
	public FilterPath(String p) 
	{
		super(); // richiama il costruttore di Filter
		this.path = p;
	}
	
	// metodo per filtrare i file e le cartelle per iniziale del nome
	@Override
	public ArrayList<FileModel> listFilter() {
		// TODO Auto-generated method stub
		
		ArrayList<FileModel> lista_filtrata = new ArrayList<FileModel>();
		
		for(FileModel x : this.getLista()) 
		{
			if(!(x.getTag().equals("folder"))) 
			{
				int pos = x.getPath().lastIndexOf("/");
				String path_cut = x.getPath().substring(0, pos);
				//System.out.println(pos);
				//System.out.println(path_cut);
				
				if(path_cut.equals(this.path)) 
				{
					lista_filtrata.add(x);
				}
			}	
		}
		
		return lista_filtrata;
	}

}
