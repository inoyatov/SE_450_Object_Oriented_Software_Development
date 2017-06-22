package myhw3.command;

/**
 * An unbounded list of commands with undo/redo capability.
 *
 * <p>Logically, the functionality is described in terms of two stacks:
 * <code>undoable</code> and <code>redoable</code>, both initially empty.</p>
 */
public interface CommandHistory {
	/**
	 * Add command <code>undoable</code> and clear <code>redoable</code>.
	 * @param cmd the command to be run.
	 */
	public void add(Command cmd);

	/**
	 * Pop command from <code>undoable</code>, undo it, then push it
	 * onto <code>redoable</code>.
	 */
	public boolean undo();

	/**
	 * Pop command from <code>redoable</code>, redo it, then push it
	 * onto <code>undoable</code>.
	 */
	public boolean redo();
}
