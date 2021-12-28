package utility;


public class FileModel {
	private String tag;
	private String name;
	private String extension;
	private String id;	
	private String server_modified;
	private Number size; // Number: superclasse di tutti i tipi numerici primitivi
	private String path;
	private boolean shared;

	
	
	
	public FileModel(String tag, String name, String extension, String path, String id, Number size, String date, boolean shared) {
		
		this.tag = tag;
		this.name = name;
		this.extension = extension;
		this.id = id;
		this.size = size;
		this.path = path;
		this.server_modified = date;
		this.shared = shared;
	}
	
	// getter & setter
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Number getSize() {
		return size;
	}

	public void setSize(Number size) {
		this.size = size;
	}

	public String getServer_modified() {
		return server_modified;
	}

	public void setServer_modified(String server_modified) {
		this.server_modified = server_modified;
	}
	
	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String toString() {
		return "Tag: "+ tag + "\nName: " + name + "\nExtension: " 
				+ extension + "\nPath: " + path + "\nSize:" + size + "\nDate: " + server_modified + "\nShared: " + shared + "\n\n";
	}
	
}
