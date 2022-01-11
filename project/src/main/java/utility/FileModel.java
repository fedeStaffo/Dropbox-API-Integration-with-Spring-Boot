package utility;



/**
 * Model of a file in a Dropbox account
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class FileModel {
	
	/** The tag of the file */
	private String tag;
	
	/** The name of the file */
	private String name;
	
	/** The extension of the file */
	private String extension;
	
	/** The id of the file */
	private String id;
	
	/** The date when the file was last edited. */
	private String server_modified;	
	
	/** The size of the file */
	private Number size; //superclass of all the numeric values that are convertible into primitive types
	
	/** The path of the file */
	private String path;
	
	/** Boolean to know if the file is directly shared or indirectly accessible */
	private boolean shared;

	
	/**
	 * FileModel constructor with parameters.
	 *
	 * @param tag the tag of the file
	 * @param name the name of the file
	 * @param extension the extension of the file
	 * @param path the path of the file
	 * @param id the id of the file
	 * @param size the size of the file
	 * @param date the date when the file was last modified
	 * @param shared directly shared or indirectly accessible
	 */
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
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * Gets the tag.
	 *
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Sets the tag.
	 *
	 * @param tag the new tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
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
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the server modified.
	 *
	 * @return the server modified
	 */
	public String getServer_modified() {
		return server_modified;
	}

	/**
	 * Sets the server modified.
	 *
	 * @param server_modified the new server modified
	 */
	public void setServer_modified(String server_modified) {
		this.server_modified = server_modified;
	}
	
	/**
	 * Checks if is shared.
	 *
	 * @return true, if is shared
	 */
	public boolean isShared() {
		return shared;
	}

	/**
	 * Sets the shared.
	 *
	 * @param shared the new shared
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}

	/**
	 * toString method
	 *
	 * @return the string
	 */
	public String toString() {
		return "Tag: "+ tag + "\nName: " + name + "\nExtension: " 
				+ extension + "\nPath: " + path + "\nSize:" + size + "\nDate: " + server_modified + "\nShared: " + shared + "\n\n";
	}

}
