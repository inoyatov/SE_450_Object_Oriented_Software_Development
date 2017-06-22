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
		// TODO
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
		// TODO
	}

	@Test
	public void testCompareTo() {
		// TODO
	}

	@Test
	public void testToString() {
		String s = new VideoObj("A",2000,"B").toString();
		assertEquals( "A (2000) : B", s );
		s = new VideoObj(" A ",2000," B ").toString();
		assertEquals( "A (2000) : B", s );
	}
}
