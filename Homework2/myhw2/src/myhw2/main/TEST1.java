package myhw2.main;

import static org.junit.Assert.*;
import org.junit.Test;
import myhw2.command.Command;
import myhw2.data.Data;
import myhw2.data.Inventory;
import myhw2.data.Record;
import myhw2.data.Video;

// TODO:
// write an integration test that tests the data classes.
// add in some videos, check out, check in, delete videos, etc.
// check that errors are reported when necessary.
// check that things are going as expected.
public class TEST1 {
	private Inventory inventory = Data.newInventory();
	private void expect(Video v, String s) {
		assertEquals(s,inventory.get(v).toString());
	}
	private void expect(Record r, String s) {
		assertEquals(s,r.toString());
	}
	@Test
	public void test1() {
		Command clearCmd = Data.newClearCmd(inventory);
		clearCmd.run();

		Video v1 = Data.newVideo("Title1", 2000, "Director1");
		assertEquals(0, inventory.size());
		assertTrue(Data.newAddCmd(inventory, v1, 5).run());
		assertEquals(1, inventory.size());
		assertTrue(Data.newAddCmd(inventory, v1, 5).run());
		assertEquals(1, inventory.size());
		// System.out.println(inventory.get(v1));
		expect(v1,"Title1 (2000) : Director1 [10,0,0]");

		Video v2 = Data.newVideo("Title2", 2001, "Director2");
		assertTrue(Data.newAddCmd(inventory, v2, 1).run());
		assertEquals(2, inventory.size());
		expect(v2,"Title2 (2001) : Director2 [1,0,0]");

		assertFalse(Data.newAddCmd(inventory, null, 5).run());
		assertEquals(2, inventory.size());

		// TODO
	}
}
