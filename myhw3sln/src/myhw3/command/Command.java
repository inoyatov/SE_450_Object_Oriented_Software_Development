package myhw3.command;

/**
 * An UndoableCommand may be run at most once.
 */
public interface Command {
	/**
	 * Do the command.
	 * @return true if command succeeds, false otherwise
	 */
	public boolean run ();
	/**
	 * Undo the command.
	 */
	public void undo ();
	/**
	 * Redo the command.
	 */
	public void redo ();
}
