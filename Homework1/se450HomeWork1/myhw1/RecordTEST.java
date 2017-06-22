package myhw1;
import static org.junit.Assert.*;
import org.junit.Test;

public class RecordTEST {
	@Test
	public void testCopy() {
		// be sure to test that copy returns a NEW reference!
		VideoObj video = new VideoObj( "A", 2000, "B" );
		Record r1 = new Record( video, 20, 10, 300 );
		Record r2 = r1.copy();
		assertTrue( r1 != r2 );
		assertTrue( r1.toString().equals(r2.toString()) );
	}
}
