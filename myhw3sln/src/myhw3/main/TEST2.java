package myhw3.main;

import static org.junit.Assert.*;
import org.junit.Test;
import myhw3.command.Command;
import myhw3.data.Data;
import myhw3.data.Inventory;
import myhw3.data.Video;

public class TEST2 {
	@Test
	public void test1() {
		final Inventory inventory = Data.newInventory();
		final Video v1 = Data.newVideo("K", 2003, "S");
		final Video v2 = Data.newVideo("S", 2002, "K");

		Command c = Data.newAddCmd(inventory, v1, 2);
		assertTrue  ( c.run() );
		assertEquals( 1, inventory.size() );
		assertTrue  (!c.run() );     // cannot run an undoable command twice
		assertTrue  (!Data.newAddCmd(inventory, null, 3).run()); // can't add null!
		assertTrue  (!Data.newAddCmd(inventory, v2, 0).run());   // can't add zero copies!
		assertEquals( 1, inventory.size() );
		assertTrue  ( inventory.undo() );
		assertEquals( 0, inventory.size() );
		assertTrue  (!inventory.undo() );  // nothing to undo!
		assertEquals( 0, inventory.size() );
		assertTrue  ( inventory.redo() );
		assertEquals( 1, inventory.size() );
		assertTrue  (!inventory.redo() );  // nothing to redo!
		assertEquals( 1, inventory.size() );
		assertTrue  ( Data.newAddCmd(inventory, v1, -2).run());   // delete!
		assertEquals( 0, inventory.size() );
		assertTrue  (!Data.newOutCmd(inventory, v1).run());       // can't check out
		assertEquals( 0, inventory.size() );
		assertTrue  ( inventory.undo() );  // should undo the AddCmd, not the OutCmd
		assertEquals( 1, inventory.size() );
		assertTrue  (!Data.newAddCmd(inventory, v1, -3).run());   // can't delete 3
		assertTrue  ( Data.newAddCmd(inventory, v1, -2).run());   // delete 2
		assertEquals( 0, inventory.size() );
		assertTrue  ( inventory.undo() );
		assertEquals( 1, inventory.size() );

		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
		assertTrue  ( Data.newAddCmd(inventory, v1, 2).run());
		assertEquals( "K (2003) : S [4,0,0]", inventory.get(v1).toString() );
		assertTrue  ( Data.newAddCmd(inventory, v1, 2).run());
		assertEquals( "K (2003) : S [6,0,0]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [4,0,0]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );

		assertTrue  ( Data.newOutCmd(inventory, v1).run());
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( Data.newOutCmd(inventory, v1).run());
		assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
		assertTrue  (!Data.newOutCmd(inventory, v1).run());
		assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
		assertTrue  ( inventory.redo() );
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( inventory.redo() );
		assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );

		assertTrue  ( Data.newInCmd(inventory, v1).run() );
		assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );
		assertTrue  ( Data.newInCmd(inventory, v1).run() );
		assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );
		assertTrue  (!Data.newInCmd(inventory, v1).run() );
		assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.redo() );
		assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.redo() );
		assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );

		assertTrue  ( Data.newAddCmd(inventory, v2, 4).run());
		assertEquals( 2, inventory.size() );
		assertTrue  ( Data.newClearCmd(inventory).run());
		assertEquals( 0, inventory.size() );
		assertTrue  ( inventory.undo() );
		assertEquals( 2, inventory.size() );
		assertTrue  ( inventory.redo() );
		assertEquals( 0, inventory.size() );
	}

	@Test
	public void test2() {
		final Inventory inventory = Data.newInventory();
		final Video v1 = Data.newVideo("K", 2003, "S");
		assertTrue  ( Data.newAddCmd(inventory, v1,2).run());
		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
		assertTrue  ( Data.newOutCmd(inventory, v1).run());
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
		assertTrue  ( inventory.redo() );
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( Data.newOutCmd(inventory, v1).run());
		assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
		assertTrue  ( inventory.undo() );
		assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
	}
}
