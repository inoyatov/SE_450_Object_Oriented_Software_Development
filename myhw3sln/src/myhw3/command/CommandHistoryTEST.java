package myhw3.command;

import static org.junit.Assert.*;
import org.junit.Test;

public class CommandHistoryTEST {
	@Test
	public void testEmptyExceptions() {
		CommandHistoryObj h = new CommandHistoryObj();
		assertSame(null, h.topUndoCommand());
		assertSame(null, h.topRedoCommand());
		assertFalse(h.undo());
		assertFalse(h.redo());
	}

	private void checkStacks(CommandHistoryObj h, Command topUndo, Command topRedo) {
		assertSame(topUndo, h.topUndoCommand());
		assertSame(topRedo, h.topRedoCommand());
	}

	@Test
	public void topIsSetByAddUndoAndRedo() {
		CommandHistoryObj h = new CommandHistoryObj();

		class CmdSuccess implements Command {
			public boolean run() { return true; }
			public void undo() { }
			public void redo() { }
		}

		Command x1 = new CmdSuccess();
		Command x2 = new CmdSuccess();
		Command x3 = new CmdSuccess();

		h.add(x1);          checkStacks(h, x1,   null);
		h.undo();  checkStacks(h, null, x1);
		h.redo();  checkStacks(h, x1,   null);

		h.add(x2);          checkStacks(h, x2,   null);
		h.undo();  checkStacks(h, x1,   x2);
		h.undo();  checkStacks(h, null, x1);
		h.redo();  checkStacks(h, x1,   x2);
		h.redo();  checkStacks(h, x2,   null);

		h.undo();  checkStacks(h, x1,   x2);
		h.add(x3);          checkStacks(h, x3,   null);
		h.undo();  checkStacks(h, x1,   x3);
		h.undo();  checkStacks(h, null, x1);
		h.redo();  checkStacks(h, x1,   x3);
		h.redo();  checkStacks(h, x3,   null);

		h = new CommandHistoryObj();
		h.add(x1);          checkStacks(h, x1,   null);
		h.add(x2);          checkStacks(h, x2,   null);
		h.undo();  checkStacks(h, x1,   x2);
		h.redo();  checkStacks(h, x2,   null);
		h.add(x3);          checkStacks(h, x3,   null);
		h.undo();  checkStacks(h, x2,   x3);
		h.undo();  checkStacks(h, x1,   x2);
	}

	// these must be fields so that they can be changed by the instances
	// of the inner class TestThatMethodsArePerformed.
	private boolean didRun;
	private boolean didUndo;
	private boolean didRedo;

	@Test
	public void methodsArePerformed() {
		CommandHistoryObj h = new CommandHistoryObj();

		class MockCommand implements Command {
			// Using "CommandHistoryTEST.this" to make references to
			// outer class instance explicit
			public boolean run() {
				CommandHistoryTEST.this.didRun = true;
				return true;
			}
			public void undo() {
				CommandHistoryTEST.this.didUndo = true;
			}
			public void redo() {
				CommandHistoryTEST.this.didRedo = true;
			}
		}

		Command x = new MockCommand();

		didRun = didUndo = didRedo = false;
		h.add(x);
		assertTrue(!didRun && !didUndo && !didRedo);

		didRun = didUndo = didRedo = false;
		h.undo();
		assertTrue(!didRun && didUndo && !didRedo);

		didRun = didUndo = didRedo = false;
		h.redo();
		assertTrue(!didRun && !didUndo && didRedo);
	}
}
