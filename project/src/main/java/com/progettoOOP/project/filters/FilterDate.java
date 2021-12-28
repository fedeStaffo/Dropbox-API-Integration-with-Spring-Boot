package filters;

import java.util.ArrayList;
import utility.FileModel;


public class FilterDate extends Filter {
	
	private String data;
	
	public FilterDate (String data) {
		super();
		this.data = data;
	}
	
	public ArrayList<FileModel> listFilter()
	{
		
		ArrayList<FileModel> ListaFiltrata = new ArrayList<>();
		
		for (FileModel i : this.getLista()) 
		{
			
			if (!(i.getTag().equals("folder"))) 
			{
				
				if((this.data).equals(i.getServer_modified().substring(0, 10))) 
				{
					ListaFiltrata.add(i);
				}
				
			}
		}
		
		return ListaFiltrata;
	}
}
