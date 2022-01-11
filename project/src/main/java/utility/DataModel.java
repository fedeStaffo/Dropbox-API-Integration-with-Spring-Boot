package utility;

/**
 * Model of a date and the name of a Dropbox file, to which
 * the date is associated 
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
public class DataModel {

	/** The year of the date */
	private int year;
	
	/** The month of the date */
	private int month;
	
	/** The day of the date */
	private int day;
	
	/** The name of the file */
	private String name;
	
	/**
	 * Instantiates a new data model.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @param name the name
	 */
	public DataModel(int year, int month, int day, String name) 
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.name = name;
	}
	
	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Sets the day.
	 *
	 * @param day the new day
	 */
	public void setDay(int day) {
		this.day = day;
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
	
	
}
