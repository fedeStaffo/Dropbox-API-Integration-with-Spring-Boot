package stats;

import java.util.ArrayList;

import utility.FileModel;
import filters.*;

public class StatsOnSharedFiles {

	private String ext;
	private String path;

	public StatsOnSharedFiles(String e, String p) 
	{
		this.ext = e;
		this.path = p;
	}
	
	
	public int sharedforExt () 
	{
	
		int cont = 0;
		FilterExt filter = new FilterExt(this.ext);
		ArrayList<FileModel> list = filter.listFilter();
		
		for(FileModel x : list) 
		{
			if(x.isShared()) 
			{
				cont++;
			}
		}
		
		return cont;
	}
	
	
	public int sharedforFolder() 
	{
	
		int cont = 0;
		FilterPath filter = new FilterPath(this.path);
		ArrayList<FileModel> list = filter.listFilter();
		
		for(FileModel x : list) 
		{
			if(x.isShared()) 
			{
				cont++;
			}
		}
		
		return cont;
	}
	
	
	
	
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}	
}
