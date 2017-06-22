package myhw2.data;

import myhw2.command.Command;

/**
 * A static class for accessing data objects.
 */
public class Data {
	private Data() {}
	/**
	 * Returns a new Inventory.
	 */
	static public final Inventory newInventory() {
		return new InventorySet();
	}

	/**
	 * Factory method for Video objects.
	 * Title and director are "trimmed" to remove leading and final space.
	 * @throws IllegalArgumentException if Video invariant violated.
	 */
	static public Video newVideo(String title, int year, String director) {
		/*<private return="null">*/
		if (  (title == null)
				|| (director == null)
				|| (year <= 1800)
				|| (year >= 5000)) {
			throw new IllegalArgumentException();
		}
		title = title.trim();
		director = director.trim();
		if (  ("".equals(title))
				|| ("".equals(director))) {
			throw new IllegalArgumentException();
		}
		return new VideoObj(title, year, director);
		/*</private>*/
	}

	/**
	 * Returns a command to add or remove copies of a video from the inventory.
	 * <p>The returned command has the following behavior:</p>
	 * <ul>
	 * <li>If a video record is not already present (and change is
	 * positive), a record is created.</li>
	 * <li>If a record is already present, <code>numOwned</code> is
	 * modified using <code>change</code>.</li>
	 * <li>If <code>change</code> brings the number of copies to be less
	 * than one, the record is removed from the inventory.</li>
	 * </ul>
	 * @param video the video to be added.
	 * @param change the number of copies to add (or remove if negative).
	 * @throws IllegalArgumentException if <code>inventory</code> not created by a call to <code>newInventory</code>.
	 */
	static public Command newAddCmd(Inventory inventory, Video video, int change) {
		if (!(inventory instanceof InventorySet))
			throw new IllegalArgumentException();
		return new CmdAdd((InventorySet) inventory, video, change);
	}

	/**
	 * Returns a command to check out a video.
	 * @param video the video to be checked out.
	 * @throws IllegalArgumentException if <code>inventory<code> not created by a call to <code>newInventory</code>.
	 */
	static public Command newOutCmd(Inventory inventory, Video video) {
		/*<private return="null">*/
		if (!(inventory instanceof InventorySet))
			throw new IllegalArgumentException();
		return new CmdOut((InventorySet) inventory, video);
		/*</private>*/
	}

	/**
	 * Returns a command to check in a video.
	 * @param video the video to be checked in.
	 * @throws IllegalArgumentException if <code>inventory<code> not created by a call to <code>newInventory</code>.
	 */
	static public Command newInCmd(Inventory inventory, Video video) {
		/*<private return="null">*/
		if (!(inventory instanceof InventorySet))
			throw new IllegalArgumentException();
		return new CmdIn((InventorySet) inventory, video);
		/*</private>*/
	}

	/**
	 * Returns a command to remove all records from the inventory.
	 * @throws IllegalArgumentException if <code>inventory<code> not created by a call to <code>newInventory</code>.
	 */
	static public Command newClearCmd(Inventory inventory) {
		if (!(inventory instanceof InventorySet))
			throw new IllegalArgumentException();
		return new CmdClear((InventorySet) inventory);
	}
}
