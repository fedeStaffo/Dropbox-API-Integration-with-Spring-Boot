package stats;

import exceptions.*;
import java.util.ArrayList;
import filters.FilterExt;
import utility.*;


/**
 * This class calculates the statistic on the date when the file was last edited
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class StatsOnDates {
	
	/** The extension of the file*/
	private String extension;
	
	/**
	 * Instantiates a new statistic on dates.
	 *
	 * @param extension the extension
	 */
	public StatsOnDates(String extension) {
		
		
		this.extension = extension;
		
	}
	
	/**
	 * This method makes the computation of the statistic
	 *
	 * @return a {@link DataModel} which contains the name of the most recent edited file 
	 * and the date when he was last edited
	 * @throws EmptyListExc the list is empty 
	 */
	public DataModel mostRecentFile() throws EmptyListExc 
	{
		FilterExt filter = new FilterExt(this.extension);
		ArrayList<FileModel> list = filter.listFilter();	
		int yearmax = 0;
		int monthmax = 0;
		int daymax = 0;
		String name = null;
		
		for (FileModel i : list) {
			
			//converts the first four letters of the String "date" into an Integer which stands for the year 
			int year = Integer.parseInt(i.getServer_modified().substring(0, 4)); 
			//converts the other letters of the String "date" into an Integer which stands for the month 
			int month = Integer.parseInt(i.getServer_modified().substring(5, 7));
			//converts the other letters of the String "date" into an Integer which stands for the day 
			int day = Integer.parseInt(i.getServer_modified().substring(8, 10));
			
			if (year > yearmax) // if the year is bigger the file was obviously edited later 
			{
				yearmax = year;
				monthmax = month;
				daymax = day;
				name = i.getName();
			}
			
			if (year==yearmax)// if the years are equals, months and days have to be compared
			{
				if  (month >= monthmax) {
					
						if (day >= daymax) {
						
							yearmax = year;
							monthmax = month;
							daymax = day;
							name = i.getName();
					    
					}
					
				}
				
			}
			
			else break; // break if the year is smaller
		}
		
	
		return new DataModel(yearmax,monthmax,daymax,name);
	}
	
	/**
	 * This method makes the computation of the statistic
	 *
	 * @return a {@link DataModel} which contains the name of the least recent edited file 
	 * and the date when he was last edited
	 * @throws EmptyListExc the list is empty
	 */
	public DataModel leastRecentFile() throws EmptyListExc 
	{
		FilterExt filter = new FilterExt(this.extension);
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
				if (year < yearmin) // if the year is smaller the file was obviously edited before
				{
					yearmin = year;
					monthmin = month;
					daymin = day;
					name = i.getName();
				}
				if (year==yearmin) // if the years are equals, months and days have to be compared 
				{
							
					if  (month <= monthmin) {
						
							if (day <= daymin) {
							
							yearmin = Integer.parseInt(i.getServer_modified().substring(0, 4));
						    monthmin = Integer.parseInt(i.getServer_modified().substring(5, 7));
							daymin = Integer.parseInt(i.getServer_modified().substring(8, 10)); 
						    name = i.getName();
						    
						}
						
					}
					
				}
				
				else break; // break if the year is bigger 
			}
			
		}
		
	
		
		return new DataModel(yearmin,monthmin,daymin, name);
	
	
	}

	/**
	 * Gets the extension
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Sets the extension
	 *
	 * @param extension the new extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	

}
