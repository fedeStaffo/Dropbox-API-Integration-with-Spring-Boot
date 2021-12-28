package stats;

import java.util.ArrayList;

import filters.FilterExt;
import utility.FileModel;

public class StatsOnSize {

	private String ext;
	
	public StatsOnSize(String extension) 
	{
		this.ext = extension;
	}

	public void biggerfileforExt() 
	{
		FilterExt filter = new FilterExt(this.ext);
		ArrayList<FileModel> list = filter.listFilter();
		long size = 0;
		String name = null;
		
		for(FileModel x : list) 
		{
			if(x.getTag().equals("file"))
			{
				if(size <= x.getSize().longValue())
					{
						size = x.getSize().longValue();
						name = x.getName();
					}
			}

		}
		
		System.out.println("The biggest " + this.ext + " file is " 
							+ name + " which weight is " + (size*0.000125) + " kilobyte");
	}
	
	public void smallerfileforExt() 
	{
		FilterExt filter = new FilterExt(this.ext);
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
			if(size==0 && x.getTag().equals("file")) 
			{
				size = x.getSize().longValue();
				name = x.getName();
			}
			

		}
		
		System.out.println("The smallest " + this.ext + " file is " 
							+ name + " which weight is " + (size*0.000125) + " kilobyte");
	}
	
	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	
}
