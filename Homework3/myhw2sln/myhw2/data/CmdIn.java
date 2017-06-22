package myhw2.data;

import myhw2.command.Command;

/**
 * Implementation of command to check in a video.
 * @see Data
 */
final class CmdIn implements Command {
	private InventorySet inventory;
	private Video video;
	CmdIn(InventorySet inventory, Video video) {
		this.inventory = inventory;
		this.video = video;
	}
	public boolean run() {
		try {
			inventory.checkIn(video);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
