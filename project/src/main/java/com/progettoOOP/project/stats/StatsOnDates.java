package stats;

import java.util.ArrayList;
import filters.FilterExt;
import utility.FileModel;

public class StatsOnDates {
	
	private String ext;
	
	public StatsOnDates(String extension) {
		this.ext = extension;
	}
	
	public void mostRecentFile() 
	{
		FilterExt filter = new FilterExt(this.ext);
		ArrayList<FileModel> list = filter.listFilter();	
		int yearmax = 0;
		int monthmax = 0;
		int daymax = 0;
		String name = null;
		
		for (FileModel i : list) {
			
			int year = Integer.parseInt(i.getServer_modified().substring(0, 4));
			int month = Integer.parseInt(i.getServer_modified().substring(5, 7));
			int day = Integer.parseInt(i.getServer_modified().substring(8, 10));
			
			if (year >= yearmax) {
				
				if  (month >= monthmax) {
					
						if (day >= daymax) {
						
						yearmax = Integer.parseInt(i.getServer_modified().substring(0, 4));
					    monthmax = Integer.parseInt(i.getServer_modified().substring(5, 7));
						daymax = Integer.parseInt(i.getServer_modified().substring(8, 10)); 
					    name = i.getName();
					    
					}
					
				}
				
			}
			
		}
		
	System.out.println("The most recent " + this.ext + " file is " + name 
			+ " modified on the: " + yearmax + "-" + monthmax + "-" + daymax );
	}
	
	public void leastRecentFile() 
	{
		FilterExt filter = new FilterExt(this.ext);
		ArrayList<FileModel> list = filter.listFilter();	
		int yearmin = 0;
		int monthmin = 0;
		int daymin = 0;
		String name = null;
		
		for (FileModel i : list) {
			
			int year = Integer.parseInt(i.getServer_modified().substring(0, 4));
			int month = Integer.parseInt(i.getServer_modified().substring(5, 7));
			int day = Integer.parseInt(i.getServer_modified().substring(8, 10));
			
			if(yearmin==0 && monthmin==0 && daymin==0 && name==null) 
			{
				yearmin = year;
				monthmin = month;
				daymin = day;
				name = i.getName();
			}
			else 
			{
				if (year <= yearmin) {
					
					if  (month <= monthmin) {
						
							if (day <= daymin) {
							
							yearmin = Integer.parseInt(i.getServer_modified().substring(0, 4));
						    monthmin = Integer.parseInt(i.getServer_modified().substring(5, 7));
							daymin = Integer.parseInt(i.getServer_modified().substring(8, 10)); 
						    name = i.getName();
						    
						}
						
					}
					
				}
			}
			
		}
		
	System.out.println("The least recent " + this.ext + " file is " + name 
			+ " modified on the: " + yearmin + "-" + monthmin + "-" + daymin );
		
	
	
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	

}
