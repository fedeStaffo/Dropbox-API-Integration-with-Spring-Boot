package tests;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import utility.*; 



/**
 * This class tests the output of the JSON database
 * 
 * @author Porfiri Pierandrea
 * @author Staffolani Federico
 */
class TestJSON {

	/** The GetInfoFromJSON. */
	private GetInfoFromJSON dropbox;
	
	/** The lists. */
	private ArrayList<FileModel> lista1, lista2;
	
	/**
	 * Initializes variables.
	 *
	 * @throws Exception the general exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dropbox = new GetInfoFromJSON();
		lista1 = dropbox.getInfo();
		lista2 = dropbox.getInfo();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the general exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test 1: checks if the JSON database is not empty
	 */
	@Test
	void test1() {
		
		assertNotEquals(lista1.toString(), "[]");
	}
	
	/**
	 * Test 2: checks if the JSON generated are different
	 */
	@Test
	void test2() {
		
		assertEquals(lista1.toString(), lista2.toString());
	}

}
