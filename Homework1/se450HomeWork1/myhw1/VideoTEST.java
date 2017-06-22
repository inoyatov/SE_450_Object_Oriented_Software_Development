package myhw1;
import static org.junit.Assert.*;
import org.junit.Test;

// TODO: complete the tests
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

	@Test
	public void testConstructorExceptionDirector() {
		// Complete
		try {
			new VideoObj("X", 2002, null);
			fail ();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 2002, "");
			fail();
		} catch (IllegalArgumentException e) { }
		try {
			new VideoObj("X", 2002, " ");
			fail();
		} catch (IllegalArgumentException e) { }
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

	@Test
	public void testEquals() {
		// Complete
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;

		VideoObj v1 = new VideoObj(title1, year, director1);
		VideoObj v2 = new VideoObj(title2, year, director2);

		assertEquals(v1, v2);

	}

	@Test
	public void testCompareTo() {
		// Complete
		String title1 = "XX";
		String director1 = "XY";
		String title2 = " XX ";
		String director2 = " XY ";
		int year = 2002;
		
		VideoObj v1 = new VideoObj(title1, year, director1);
		VideoObj v2 = new VideoObj(title2, year, director2);
		VideoObj v3 = new VideoObj("Test", 2016, "crebolledo");
		
		assertTrue(v1.title().equals(v2.title()));
		assertTrue(v1.year() == v2.year());
		assertTrue(v1.director().equals(v2.director()));
		
		assertFalse(v1.title().equals(v3.title()));
		assertFalse(v1.year() == v3.year());
		assertFalse(v1.director().equals(v3.director()));
		

	}

	@Test
	public void testToString() {
		String s = new VideoObj("A",2000,"B").toString();
		assertEquals( "A (2000) : B", s );
		s = new VideoObj(" A ",2000," B ").toString();
		assertEquals( "A (2000) : B", s );
	}
}
