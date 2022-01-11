package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filters.*;
import utility.FileModel;


/**
 * This class tests the output of the filters
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
class TestFilters {

	/** The dim. */
	private Number dim;
	
	/** The data. */
	private String data;
	
	/** The path. */
	private String path;
	
	/** The letter. */
	private char letter;
	
	/** The extension. */
	private String ext;
	
	/** The test FilterDate. */
	private FilterDate fd;
	
	/** The test FilterExt. */
	private FilterExt fe;
	
	/** The test FilterPath. */
	private FilterPath fp;
	
	/** The test FilterBiggerSize. */
	private FilterBiggerSize bs;
	
	/** The test FilterSmallerSize. */
	private FilterSmallerSize ss;
	
	/** The test FilterName. */
	private FilterName fn;
	
	/** The lists for the tests. */
	private ArrayList<FileModel> lista1, lista2, lista3, lista4, lista5, lista6;
	
	/**
	 * Initializes variables.
	 *
	 * @throws Exception the general exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dim = 10000;
		data = "2021-12-27";
		path = "/Solo mia/sottocartella";
		letter = 'G';
		ext = ".pdf";
	
		fd = new FilterDate(data);
		lista1 = fd.listFilter();
		fe = new FilterExt(ext);
		lista2= fe.listFilter();
		fp = new FilterPath(path);
		lista3 = fp.listFilter();
		bs = new FilterBiggerSize(dim);
		lista4 = bs.listFilter(); 
		ss = new FilterSmallerSize(dim);
		lista5 = ss.listFilter();
		fn = new FilterName(letter);
		lista6 = fn.listFilter();
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the general exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	// tests if filtered lists are empty
	/**
	 * Test date.
	 */
	@Test
	void testDate() {
		assertNotEquals(lista1.toString(),"[]");
	}
	
	/**
	 * Test extension.
	 */
	@Test
	void testExt() {
		assertNotEquals(lista2.toString(),"[]");
	}
	
	/**
	 * Test path.
	 */
	@Test
	void testPath() {
		assertNotEquals(lista3.toString(),"[]");
	}
	
	/**
	 * Test bigger size.
	 */
	@Test
	void testBiggerSize() {
		assertNotEquals(lista4.toString(),"[]");
	}
	
	/**
	 * Test smaller size.
	 */
	@Test
	void testSmallerSize() {
		assertNotEquals(lista5.toString(),"[]");
	}
	
	/**
	 * Test name.
	 */
	@Test
	void testName() {
		assertNotEquals(lista6.toString(),"[]");
	}

}