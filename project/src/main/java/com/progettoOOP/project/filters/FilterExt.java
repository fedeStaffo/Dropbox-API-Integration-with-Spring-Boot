package filters;

import java.util.ArrayList;
import utility.FileModel;
//import utility.GetInfoFromJSON;

public class FilterExt extends Filter {
	
	private String estensione;
	
	public FilterExt (String ext)
	{
		super();
		this.estensione = ext;
	}

	@Override
	public ArrayList<FileModel> listFilter() {
		
		//GetInfoFromJSON x = new GetInfoFromJSON();
		//ArrayList<FileModel> ListaFile = x.getInfo();
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
