package utility;


public class FileModel {
	private String tag;
	private String name;
	private String extension;
	private String id;	
	private Number size; // Number: superclasse di tutti i tipi numerici primitivi
	private String path;

	
	
	
	public FileModel(String tag, String name, String extension, String path, String id, Number size) {
		
		this.tag = tag;
		this.name = name;
		this.extension = extension;
		this.id = id;
		this.size = size;
		this.path = path;
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

	public String toString() {
		return "Tag: "+ tag + "\nName: " + name + "\nExtension: " 
			+ extension + "\nPath: " + path + "\nSize:" +size+ "\n\n";
	}
	
}
