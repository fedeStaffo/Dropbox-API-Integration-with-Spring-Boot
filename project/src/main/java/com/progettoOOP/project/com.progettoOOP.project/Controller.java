package com.progettoOOP.project;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import utility.*;
import exceptions.*;
import filters.*;
import stats.*;

/**
 * This class is the controller of the possible routes for the server
 * 
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
@RestController
public class Controller {

	/**
	 * Route to get all the files and folders from the Dropbox account
	 *
	 * @return ArrayList of FileModel
	 */
	@GetMapping("data")
	public ArrayList<FileModel> getallData() {
		GetInfoFromJSON dropbox = new GetInfoFromJSON();
		ArrayList<FileModel> alldata = dropbox.getInfo();
		return alldata;
	}

	/**
	 * Route to calculate the statistic on the date of editing of all the files in
	 * the Dropbox account
	 *
	 * @param extension the extension
	 * @return DataModel of the most recent file
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/dates/mostrecent/{extension}")
	public DataModel getStatsOnDates1(@PathVariable String extension) throws EmptyListExc {

		DataModel x = new StatsOnDates(extension).mostRecentFile();

		if (x.getDay() != 0) {
			return x;
		} else {
			throw new IllegalParameterException();
		}
	}

	/**
	 * Route to calculate the statistic on the date of editing of all the files in
	 * the Dropbox account
	 *
	 * @param extension the extension
	 * @return DataModel of the least recent file
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/dates/leastrecent/{extension}")
	public DataModel getStatsOnDates2(@PathVariable String extension) throws EmptyListExc {

		DataModel x = new StatsOnDates(extension).leastRecentFile();

		if (x.getDay() != 0) {
			return x;
		} else {
			throw new IllegalParameterException();
		}
	}

	/**
	 * Route to calculate the statistic on the size of all the files in the Dropbox
	 * account
	 *
	 * @param extension the extension
	 * @return String with the name and the size of the biggest file among the ones
	 *         with the given extension
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/size/biggestfile/{extension}")
	public String getStatsOnSize1(@PathVariable String extension) throws EmptyListExc {

		StatsOnSize s = new StatsOnSize(extension, 0);
		String x = s.biggestfileforExt();
		if (x == null) {
			throw new IllegalParameterException();
		} else {
			return x;
		}
	}

	/**
	 * Route to calculate the statistic on the size of all the files in the Dropbox
	 * account
	 *
	 * @param extension the extension
	 * @return String with the name and the size of the smallest file among the ones
	 *         with the given extension
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/size/smallestfile/{extension}")
	public String getStatsOnSize2(@PathVariable String extension) throws EmptyListExc {

		StatsOnSize s = new StatsOnSize(extension, 0);
		String x = s.smallerfileforExt();
		if (x == null) {
			throw new IllegalParameterException();
		} else {
			return x;
		}
	}

	/**
	 * Route to calculate the statistic on the size of all the files in the Dropbox
	 * account
	 *
	 * @param size the size used for comparison
	 * @return String containing the number of all the files bigger than the given
	 *         size, divided for extension
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/size/higherdim/{size}")
	public String getStatsOnSize3(@PathVariable Integer size) throws EmptyListExc {

		StatsOnSize s = new StatsOnSize(null, size);
		String x = s.higherDim();
		if (s.getSize().intValue() <= 0) {
			throw new IllegalParameterException();
		} else {
			return x;
		}

	}

	/**
	 * Route to calculate the statistic on the size of all the files in the Dropbox
	 * account
	 *
	 * @param size the size used for comparison
	 * @return String containing the number of all the files smaller than the given
	 *         size, divided for extension
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/size/lowerdim/{size}")
	public String getStatsOnSize4(@PathVariable Integer size) throws EmptyListExc {

		StatsOnSize s = new StatsOnSize(null, size);
		String x = s.lowerDim();
		if (s.getSize().intValue() <= 0) {
			throw new IllegalParameterException();
		} else {
			return x;
		}
	}

	/**
	 * Route to calculate the statistic on the quantity of shared files per
	 * extension in a Dropbox account
	 *
	 * @param extension the extension
	 * @return String with number of shared files for the extension
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/shared/extension/{extension}")
	public String getStatsOnSharedFiles(@PathVariable String extension) throws EmptyListExc {

		StatsOnSharedFiles s = new StatsOnSharedFiles(extension, null);
		String x = s.sharedforExt();
		if (x == null) {
			throw new IllegalParameterException();
		} else {
			return x;
		}
	}

	/**
	 * Route to calculate the statistic on the quantity of shared files per folder
	 * in a Dropbox account
	 *
	 * @param path the path of the folder
	 * @return SharedModel with the total of shared files and the number of their
	 *         respective extensions
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("stats/shared/folder")
	public SharedModel getStatsOnSharedFolders(@RequestParam(name = "path") String path) throws EmptyListExc {

		SharedModel x = new StatsOnSharedFiles(null, path).sharedforFolder();

		if (!(x.getTot().equals("Condivisi per cartella: " + 0))) {
			return x;
		} else {
			throw new IllegalParameterException();
		}
	}

	/**
	 * Exception handler
	 *
	 * @param exception the exception
	 * @return Error message
	 */
	@ExceptionHandler(IllegalParameterException.class)
	public String exceptionHandler(IllegalParameterException exception) {
		return "Invalid parameter, please try again";
	}

	/**
	 * Route to get all the filtered data based on the files' extensions
	 *
	 * @param extension the extension
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/ext/{extension}")
	public ArrayList<FileModel> getFilterExt(@PathVariable String extension) throws EmptyListExc {
		FilterExt f = new FilterExt(extension);
		return f.listFilter();
	}

	/**
	 * Route to get all the filtered data based on the date the files were last
	 * modified on
	 *
	 * @param date the date
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/date/{date}")
	public ArrayList<FileModel> getFilterDate(@PathVariable String date) throws EmptyListExc {
		FilterDate g = new FilterDate(date);
		return g.listFilter();
	}

	/**
	 * Route to get all the filtered data based on the first letter of the files'
	 * names
	 *
	 * @param letter the first letter of the file's name
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/name/{letter}")
	public ArrayList<FileModel> getFilterName(@PathVariable char letter) throws EmptyListExc {
		FilterName e = new FilterName(letter);
		return e.listFilter();
	}

	/**
	 * Route to get all the filtered data based on the files' paths
	 *
	 * @param path the path
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/path")
	public ArrayList<FileModel> getFilterPath(@RequestParam(name = "path") String path) throws EmptyListExc {
		FilterPath e = new FilterPath(path);
		return e.listFilter();
	}
	
	/**
	 * Route to get all the filtered data based on the file's size
	 *
	 * @param size the size used for comparison
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/size/bigger/{size}")
	public ArrayList<FileModel> getFilterBiggerSize(@PathVariable Number size) throws EmptyListExc {
		FilterBiggerSize e = new FilterBiggerSize(size);
		return e.listFilter();
	}
	
	/**
	 * Route to get all the filtered data based on the file's size
	 *
	 * @param size the size used for comparison
	 * @return ArrayList of FileModel
	 * @throws EmptyListExc the list is empty
	 */
	@GetMapping("/filter/size/smaller/{size}")
	public ArrayList<FileModel> getFilterSmallerSize(@PathVariable Number size) throws EmptyListExc {
		FilterSmallerSize e = new FilterSmallerSize(size);
		return e.listFilter();
	}

}
