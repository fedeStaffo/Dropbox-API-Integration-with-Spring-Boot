package stats;

import exceptions.*;
import java.util.ArrayList;
import utility.FileModel;
import utility.SharedModel;
import filters.*;


/**
 * This class calculates the statistic based on the number of shared files 
 * for extension and for folder
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class StatsOnSharedFiles {

	/** The extension for which we want to know the number of shared files */
	private String extension;
	
	/** The path used to choose the folder for the statistic. */
	private String path;

	/**
	 * Instantiates a new statistic on shared files.
	 *
	 * @param extension the extension
	 * @param path the path
	 */
	public StatsOnSharedFiles(String extension, String path) 
	{
		
		this.extension = extension;
		this.path = path;
	}
	
	
	/**
	 * This method makes the computation of the statistic, counting how many shared files
	 * with the wanted extension are present
	 *
	 * @return the number of shared files for extension
	 * @throws EmptyListExc the list is empty 
	 */
	public String sharedforExt () throws EmptyListExc 
	{
	
		int cont = 0;
		FilterExt filter = new FilterExt(this.extension);
		ArrayList<FileModel> list = filter.listFilter();
		
		for(FileModel x : list) 
		{
			if(x.isShared()) 
			{
				cont++;
			}
		}
		
		if (cont==0) 
		{
			return null;
		}
		else 
		{
			return  "The number of " + this.extension + " files shared is: " + String.valueOf(cont);
		}
		
		
	}
	
	
	/**
	 * This method makes the computation of the statistic, counting how many shared files 
	 * are present in the chosen folder and dividing them for extension
	 *
	 * @return a {@link SharedModel} containing the total of shared files and the number 
	 * of their respective extensions
	 * @throws EmptyListExc the list is empty 
	 */
	public SharedModel sharedforFolder() throws EmptyListExc 
	{
	
		int cont = 0; // total number of shared files in a folder
		FilterPath filter = new FilterPath(this.path);
		ArrayList<FileModel> list = filter.listFilter();
		int c_pdf=0, c_xls=0, c_jpg=0, c_pptx=0, c_doc=0; 
		for(FileModel x : list) 
		{
			if(x.isShared()) 
			{
				cont++;
				
				String e = x.getExtension();
				switch(e) 
				{
					case ".pdf": c_pdf++; break;						
					case ".xls": c_xls++; break;
					case ".jpg": c_jpg++; break;
					case ".pptx": c_pptx++; break;
					case ".doc": c_doc++; break;
				}
					
			}
		}
		
		return new SharedModel(String.valueOf(cont), String.valueOf(c_pdf), String.valueOf(c_xls),
				String.valueOf(c_jpg), String.valueOf(c_pptx), String.valueOf(c_doc));
		
	}
	
	
	
	
	/**
	 * Gets the extension.
	 *
	 * @return the extension
	 */
	public String getExt() {
		return extension;
	}
	
	/**
	 * Sets the extension.
	 *
	 * @param extension the new extension
	 */
	public void setExt(String extension) {
		this.extension = extension;
	}
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}	
}
