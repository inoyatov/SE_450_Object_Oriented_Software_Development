package myhw3.command;
import java.util.Stack;

public final class CommandHistoryObj implements CommandHistory {
	Stack<Command> undoStack = new Stack<Command>();
	Stack<Command> redoStack = new Stack<Command>();

	// Solution
	public void add(Command cmd) {
		/*<private>*/
		undoStack.push(cmd);
		redoStack.clear();
		/*</private>*/
	}
	
	// Solution
	public boolean undo() {
		boolean result = !undoStack.empty();
		if (result) {
			/*<private>*/
			Command c = undoStack.pop();
			redoStack.push(c);
			c.undo();
			/*</private>*/
		}
		return result;
	}

	// Solution
	public boolean redo() {
		boolean result = !redoStack.empty();
		if (result) {
			/*<private>*/
			Command c = redoStack.pop();
			undoStack.push(c);
			c.redo();
			/*</private>*/
		}
		return result;
	}

	// For testing
	Command topUndoCommand() {
		if (undoStack.empty())
			return null;
		else
			return undoStack.peek();
	}
	// For testing
	Command topRedoCommand() {
		if (redoStack.empty())
			return null;
		else
			return redoStack.peek();
	}
}
