/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{   
		try {
			emptyList.remove(0);}
			catch(IndexOutOfBoundsException e) {
		}
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(-1);
		}catch (IndexOutOfBoundsException e) {
		}
        
		try {
			list1.remove(6);
		}catch (IndexOutOfBoundsException e) {
		}
		
		String b = shortList.remove(0);
		assertEquals("Remove: check b is correct ", "A" ,b);
		assertEquals("Remove: check element 0 is correct ", "B", shortList.get(0));
		assertEquals("Remove: check size is correct ", 1 , shortList.size());
		
		try {
			shortList.remove(-2);
		}catch (IndexOutOfBoundsException e) {
		}
        
		try {
			shortList.remove(8);
		}catch (IndexOutOfBoundsException e) {
		}

		int c = longerList.remove(0);
		assertEquals("Remove: check c is correct ", 0 ,c);
		assertEquals("Remove: check element 0 is correct ", (Integer)1 , longerList.get(0));
		assertEquals("Remove: check size is correct ", 9 , longerList.size());
		
		try {
			longerList.remove(-3);
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			longerList.remove(13);
		}catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		//for empty
		
		boolean c=emptyList.add(43);
		assertEquals("Check last",  (Integer)43, emptyList.get(0));
		try {
			emptyList.add(null);
			fail("Null point exception");
		}
		catch (NullPointerException e) {
		
		}
	  
		//list 1
		
		boolean a=list1.add(5);
		assertEquals("Check last", (Integer)5 , list1.get(3));
		try {
			list1.add(null);
			fail("Null point exception");
		}
		catch (NullPointerException e) {
		
		}
		
		// test short list, first contents, then out of bounds
		
		boolean d=shortList.add("C");
		assertEquals("Check last", "C" , shortList.get(2));
		try {
			shortList.add(null);
			fail("Null point exception");
		}
		catch (NullPointerException e) {
		
		}
		
		
		// test longer list contents
	
		// test off the end of the longer array
		boolean b=longerList.add(52);
		assertEquals("Check last", (Integer)52 , longerList.get(10));
		try {
			longerList.add(null);
			fail("Null point exception");
		}
		catch (NullPointerException e) {
		
		}
		
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		emptyList.add(52);
		assertEquals("Check size", 1 , emptyList.size() );
		shortList.add(2,"C");
		assertEquals("Check size", 3 , shortList.size() );
		longerList.add(3,62);
		assertEquals("Check size", 11 , longerList.size() );
		shortList.remove(0);
		assertEquals("Check size", 2 , shortList.size() );
		longerList.remove(3);
		assertEquals("Check size", 10 , longerList.size() );
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			emptyList.add(0, null);
		} catch (NullPointerException e) {
			
		}
		
		/*try {
			emptyList.add(1, 5);
		} catch (IndexOutOfBoundsException e) {
			
		}*/
		
		//list 1
		
		list1.add(0,2);
		assertEquals("Check first", (Integer)2 , list1.get(0));
		assertEquals("Check first", (Integer)65 , list1.get(1));
		
		list1.add(1,23);
		assertEquals("Check first", (Integer)2 , list1.get(0));
		assertEquals("Check second", (Integer)23 , list1.get(1));
		assertEquals("Check third", (Integer)65 , list1.get(2));
		
		try {
			list1.add(0, null);
		} catch (NullPointerException e) {
			
		}
		try {
			list1.add(-1,54);
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			list1.add(7,54);
		}catch (IndexOutOfBoundsException e) {
		}
		
		//short list 
		
		shortList.add(0,"C");
		assertEquals("Check first", "C" , shortList.get(0));
		assertEquals("Check first", "A" , shortList.get(1));
		
		shortList.add(1,"C");
		assertEquals("Check first", "C" , shortList.get(0));
		assertEquals("Check second", "C" , shortList.get(1));
		assertEquals("Check third","A", shortList.get(2));
		
		try {
			shortList.add(0, null);
		} catch (NullPointerException e) {
			
		}
		try {
			shortList.add(-1,"C");
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.add(4,"C");
		}catch (IndexOutOfBoundsException e) {
		}
        
		//LONGER LIST
		
		longerList.add(0,32);
		assertEquals("Check first", (Integer)32 , longerList.get(0));
		assertEquals("Check first", (Integer)0 , longerList.get(1));
		
		longerList.add(3,76);
		assertEquals("Check fourth", (Integer)76 , longerList.get(3));
		assertEquals("Check fifth", (Integer)2 , longerList.get(4));
		assertEquals("Check third",(Integer)1, longerList.get(2));
		
		try {
			longerList.add(0, null);
		} catch (NullPointerException e) {
			
		}
		try {
			longerList.add(-2,62);
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			longerList.add(12,62);
		}catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		int a = list1.set(1,42);
		assertEquals("Set: check a is correct ", 21, a);
		assertEquals("Set: check element 0 is correct ", (Integer)42, list1.get(1));
		
		
		// TODO: Add more tests here
		try {
			list1.set(-1,42);
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			list1.set(3,42);
		}catch (IndexOutOfBoundsException e) {
		}
        
		try {
			list1.set(0, null);
		}catch(NullPointerException e) {}
		
		String b = shortList.set(1,"d");
		assertEquals("Remove: check b is correct ", "B" ,b);
		assertEquals("Remove: check element 0 is correct ", "d", shortList.get(1));
		
		try {
			shortList.set(-1,"e");
		}catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.set(2,"e");
		}catch (IndexOutOfBoundsException e) {
		}
        
		try {
			shortList.set(0, null);
		}catch(NullPointerException e) {}
        

		int C = longerList.set(5,42);
		assertEquals("Set: check c is correct ", 5, C);
		assertEquals("Remove: check element 5 is correct ", (Integer)42, longerList.get(5));
		
		
		try {
			longerList.set(-1,42);
		}catch (IndexOutOfBoundsException e) {
		}
        
		try {
			longerList.set(10,42);
		}catch (IndexOutOfBoundsException e) {
		}
        
		
		try {
			longerList.set(0, null);
		}catch(NullPointerException e) {}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
