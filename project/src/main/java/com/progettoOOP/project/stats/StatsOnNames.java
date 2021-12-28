package stats;

import java.util.ArrayList;
import utility.FileModel;
import filters.*;

public class StatsOnNames {
	
	private char initial;
	
	public StatsOnNames (char i) {
		
		this.initial = i;
	}

	public void orderNames()
	{
		FilterName filter = new FilterName(this.initial);
		ArrayList<FileModel> lista = filter.listFilter();
		
		System.out.println("Files starting with " + initial + "are:");
			
		for (FileModel i : lista) {
			
			System.out.println(i.getName());
			
			}
		
		}
	
	}
