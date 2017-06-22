package myhw2.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class VideoTEST {
	
	@Test
	public void testHashCode() {
		assertEquals
		(-875826552,
				new VideoObj("None", 2009, "Zebra").hashCode());
		assertEquals
		(-1391078111,
				new VideoObj("Blah", 1954, "Cante").hashCode());
	}

	// TODO: complete the tests
}
