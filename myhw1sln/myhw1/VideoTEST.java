package myhw1;
import static org.junit.Assert.*;
import org.junit.Test;

/*<private todo="complete the tests"/>*/
public class VideoTEST {
	@Test
	public void testConstructorAndAttributes() {
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		assertSame(title1, v1.title());
		assertEquals(year, v1.year());
		assertSame(director1, v1.director());

		VideoObj v2 = new VideoObj(title2, year, director2);
		assertEquals(title1, v2.title());
		assertEquals(director1, v2.director());
	}

	@Test
	public void testConstructorExceptionYear() {
		try {
			new VideoObj("X", 1800, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 5000, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 1801, "Y");
			new VideoObj("X", 4999, "Y");
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void testConstructorExceptionTitle() {
		try {
			new VideoObj(null, 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj(" ", 2002, "Y");
			fail();
		} catch (IllegalArgumentException e) { }
	}

	//Solution
	@Test
	public void testConstructorExceptionDirector() {
		/*<private>*/
		try {
			new VideoObj("X", 2002, null);
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 2002, "");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 2002, " ");
			fail();
		} catch (IllegalArgumentException e) { }
		/*</private>*/
	}

	@Test
	public void testHashCode() {
		assertEquals
		(-875826552,
				new VideoObj("None", 2009, "Zebra").hashCode());
		assertEquals
		(-1391078111,
				new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	//Solution
	@Test
	public void testEquals() {
		/*<private>*/
		String title = "A";
		int year = 2009;
		String director = "Zebra";
		VideoObj a = new VideoObj(title,year,director);
		assertTrue( a.equals(a) );
		assertTrue( a.equals( new VideoObj(title, year, director) ) );
		assertTrue( a.equals( new VideoObj(new String(title), year, director) ) );
		assertTrue( a.equals( new VideoObj(title, year, new String(director)) ) );
		assertFalse( a.equals( new VideoObj(title+"1", year, director) ) );
		assertFalse( a.equals( new VideoObj(title, year+1, director) ) );
		assertFalse( a.equals( new VideoObj(title, year, director+"1") ) );
		assertFalse( a.equals( new Object() ) );
		assertFalse( a.equals( null ) );
		/*</private>*/
	}

	//Solution
	@Test
	public void testCompareTo() {
		/*<private>*/
		String title = "A", title2 = "B";
		int year = 2009, year2 = 2010;
		String director = "Zebra", director2 = "Zzz";
		VideoObj a = new VideoObj(title,year,director);
		VideoObj b = new VideoObj(title2,year,director);
		assertTrue( a.compareTo(b) < 0 );
		assertTrue( a.compareTo(b) == -b.compareTo(a) );
		assertTrue( a.compareTo(a) == 0 );

		b = new VideoObj(title,year2,director);
		assertTrue( a.compareTo(b) < 0 );
		assertTrue( a.compareTo(b) == -b.compareTo(a) );

		b = new VideoObj(title,year,director2);
		assertTrue( a.compareTo(b) < 0 );
		assertTrue( a.compareTo(b) == -b.compareTo(a) );

		b = new VideoObj(title2,year2,director2);
		assertTrue( a.compareTo(b) < 0 );
		assertTrue( a.compareTo(b) == -b.compareTo(a) );

		try {
			a.compareTo(null);
			fail();
		} catch ( NullPointerException e ) {}
		catch ( ClassCastException e ) {}
		catch ( IllegalArgumentException e ) {}
		/*</private>*/
	}

	@Test
	public void testToString() {
		String s = new VideoObj("A",2000,"B").toString();
		assertEquals( "A (2000) : B", s );
		s = new VideoObj(" A ",2000," B ").toString();
		assertEquals( "A (2000) : B", s );
	}
}
