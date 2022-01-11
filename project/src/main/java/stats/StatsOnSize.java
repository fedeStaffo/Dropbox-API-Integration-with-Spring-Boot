package stats;

import exceptions.*;
import java.util.ArrayList;
import filters.*;
import utility.FileModel;


/**
 * This class calculates the statistic based on the size of the files 
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class StatsOnSize {

	/** The extension of the file. */
	private String extension;
	
	/** The size of the file. */
	private Number size;
	
	/**
	 * Instantiates a new statistic on size.
	 *
	 * @param extension the extension
	 * @param size the size
	 */
	public StatsOnSize(String extension, Number size) 
	{
		
		this.extension = extension;
		this.size = size; 
	}

	/**
	 * This method makes the computation of the statistic 
	 *
	 * @return a string containing the name and the size of the  
	 * biggest file among the ones with the given extension
	 * @throws EmptyListExc the list is empty
	 */
	public String biggestfileforExt() throws EmptyListExc 
	{
		FilterExt filter = new FilterExt(this.extension);
		ArrayList<FileModel> list = filter.listFilter();
		long size = 0;
		String name = null;
		
		for(FileModel x : list) 
		{
			if(x.getTag().equals("file")) // to avoid working with folders that don't have a size
			{
				if(size <= x.getSize().longValue())
					{
						size = x.getSize().longValue();
						name = x.getName();
					}
			}

		}
		// no file with the wanted extension was found
		if(name == null) return null;
		
		String s = "The biggest " + this.extension + " file is " 
							+ name + " which weight is " + (size*0.000125) + " kilobyte";
		return s;
		
	}
	
	/**
	 * This method makes the computation of the statistic
	 *
	 * @return a string containing the name and the size of the  
	 * smallest file among the ones with the given extension
	 * @throws EmptyListExc the list is empty 
	 */
	public String smallerfileforExt() throws EmptyListExc 
	{
		FilterExt filter = new FilterExt(this.extension);
		ArrayList<FileModel> list = filter.listFilter();
		long size = 0;
		String name = null;
		
		for(FileModel x : list) 
		{
			if(size!=0 && x.getTag().equals("file"))
			{
				if(size >= x.getSize().longValue())
					{
						size = x.getSize().longValue();
						name = x.getName();
					}
			}
			if(size==0 && x.getTag().equals("file")) // first found file
			{
				size = x.getSize().longValue();
				name = x.getName();
			}
			

		}
		if(name == null) return null;
		
		String s = "The smallest " + this.extension + " file is " 
							+ name + " which weight is " + (size*0.000125) + " kilobyte";
		return s;
	}
	
	
	/**
	 * This method makes the computation of the statistic
	 *
	 * @return a string containing the number of all the files bigger  
	 * than the given size, divided for extension
	 * @throws EmptyListExc the list is empty 
	 */
	public String higherDim() throws EmptyListExc 
	{
		FilterBiggerSize x = new FilterBiggerSize(this.size);
		ArrayList<FileModel> lista = x.listFilter();
		Integer c_pdf=0, c_xls=0, c_jpg=0, c_pptx=0, c_doc=0; //counters for the allowed extensions
		
		for(FileModel i : lista) 
		{
			switch(i.getExtension()) 
			{
				case ".pdf": c_pdf++; break;						
				case ".xls": c_xls++; break;
				case ".jpg": c_jpg++; break;
				case ".pptx": c_pptx++; break;
				case ".doc": c_doc++; break;
			}
		}
		
		String s = "I file con dimensione maggiore di " + this.size + " sono:\n" +  c_pdf + " pdf\n" + c_xls + " documenti excel\n"
				+ c_jpg + " immagini jpg\n" + c_pptx + " power point\n" + c_doc + " documenti word";
		return s;
	}
	
	/**
	* This method makes the computation of the statistic
	 *
	 * @return a string containing the number of all the files smaller  
	 * than the given size, divided for extension
	 * @throws EmptyListExc the list is empty
	 */
	public String lowerDim() throws EmptyListExc 
	{
		FilterSmallerSize x = new FilterSmallerSize(this.size);
		ArrayList<FileModel> lista = x.listFilter();
		
		int c_pdf=0, c_xls=0, c_jpg=0, c_pptx=0, c_doc=0; 
		
		for(FileModel i : lista) 
		{
			switch(i.getExtension()) 
			{
				case ".pdf": c_pdf++; break;						
				case ".xls": c_xls++; break;
				case ".jpg": c_jpg++; break;
				case ".pptx": c_pptx++; break;
				case ".doc": c_doc++; break;
			}
		}
		String s = "I file con dimensione maggiore di " + this.size + " sono:\n" +  c_pdf + " pdf\n" + c_xls + " documenti excel\n"
				+ c_jpg + " immagini jpg\n" + c_pptx + " power point\n" + c_doc + " documenti word";
		return s;
	}
	
	
	
	/**
	 * Gets the extension.
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Sets the extension.
	 *
	 * @param extension the new extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Number getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(Number size) {
		this.size = size;
	}
	
}
