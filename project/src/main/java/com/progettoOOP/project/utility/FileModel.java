package utility;


public class FileModel {
	private String tag;
	private String name;
	private String extension;
	private String id;
	//private String client_modified;
	//private String server_modified;
	//private String rev;
	
	//superclasse di tutti i tipi numerici primitivi
	private Number size; 
	//private String is_downloadable;
	//private String content_hash;
	private String path;
	private boolean shared;
	
	
	
	public FileModel(String tag, String name, String extension, String path, String id, Number size,  boolean shared) {
		this.name = name;
		this.extension = extension;
		this.id = id;
		this.size = size;
		this.path = path;
		this.shared = shared;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public Number getSize() {
		return size;
	}

	public void setSize(Number size) {
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
