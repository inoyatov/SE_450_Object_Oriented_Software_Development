package myhw3.data;

import myhw3.command.Command;

/**
 * Implementation of command to check in a video.
 * @see Data
 */
final class CmdIn implements Command {
	private InventorySet inventory;
	private Record oldvalue;
	private Video video;
	CmdIn(InventorySet inventory, Video video) {
		this.inventory = inventory;
		this.video = video;
	}
	// Solution
	public boolean run() {
		/*<private return="false">*/
		if (oldvalue != null) {
			return false;
		}
		try {
			oldvalue = inventory.checkIn(video);
			inventory.getHistory().add(this);
			return true;
		} catch (ClassCastException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
		/*</private>*/
	}
	// Solution
	public void undo() {
		/*<private>*/
		inventory.replaceEntry(video, oldvalue);
		/*</private>*/
	}
	// Solution
	public void redo() {
		/*<private>*/
		oldvalue = inventory.checkIn(video);
		/*</private>*/
	}
}
