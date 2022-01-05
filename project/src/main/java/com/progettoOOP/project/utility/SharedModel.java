package utility;


/**
 * Model of a counter for all the allowed extensions and their total sum
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class SharedModel {

	/** The total of extensions. */
	private String tot;
	
	/** An extension allowed. */
	private String extension1;
	
	/** An extension allowed. */
	private String extension2;
	
	/** An extension allowed. */
	private String extension3;
	
	/** An extension allowed. */
	private String extension4;
	
	/** An extension allowed. */
	private String extension5;
	
	/**
	 * Instantiates a new shared model.
	 *
	 * @param tot the total
	 * @param pdf the number of ".pdf"
	 * @param xls the number of ".xls"
	 * @param jpg the number of ".jpg"
	 * @param pptx the number of ".pptx"
	 * @param doc the number of ".doc"
	 */
	public SharedModel(String tot, String pdf, String xls, String jpg, String pptx, String doc) 
	{
		this.tot = "Condivisi per cartella: " + tot;
		this.setExtension1(".pdf: " + pdf);
		this.setExtension2(".xls: " + xls);
		this.setExtension3(".jpg: " + jpg);
		this.setExtension4(".pptx: " + pptx);
		this.setExtension5(".doc: " + doc);
		
	}


	/**
	 * Gets the extension 1.
	 *
	 * @return the extension 1
	 */
	public String getExtension1() {
		return extension1;
	}



	/**
	 * Sets the extension 1.
	 *
	 * @param extension1 the new extension 1
	 */
	public void setExtension1(String extension1) {
		this.extension1 = extension1;
	}



	/**
	 * Gets the extension 2.
	 *
	 * @return the extension 2
	 */
	public String getExtension2() {
		return extension2;
	}



	/**
	 * Sets the extension 2.
	 *
	 * @param extension2 the new extension 2
	 */
	public void setExtension2(String extension2) {
		this.extension2 = extension2;
	}



	/**
	 * Gets the extension 3.
	 *
	 * @return the extension 3
	 */
	public String getExtension3() {
		return extension3;
	}



	/**
	 * Sets the extension 3.
	 *
	 * @param extension3 the new extension 3
	 */
	public void setExtension3(String extension3) {
		this.extension3 = extension3;
	}



	/**
	 * Gets the extension 4.
	 *
	 * @return the extension 4
	 */
	public String getExtension4() {
		return extension4;
	}



	/**
	 * Sets the extension 4.
	 *
	 * @param extension4 the new extension 4
	 */
	public void setExtension4(String extension4) {
		this.extension4 = extension4;
	}



	/**
	 * Gets the extension 5.
	 *
	 * @return the extension 5
	 */
	public String getExtension5() {
		return extension5;
	}


	/**
	 * Sets the extension 5.
	 *
	 * @param extension5 the new extension 5
	 */
	public void setExtension5(String extension5) {
		this.extension5 = extension5;
	}


	/**
	 * Gets the tot.
	 *
	 * @return the tot
	 */
	public String getTot() {
		return tot;
	}

	/**
	 * Sets the tot.
	 *
	 * @param tot the new tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}



	
}
