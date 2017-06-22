package myhw2.data;

import myhw2.command.Command;

/**
 * Implementation of command to add or remove inventory.
 * @see Data
 */
final class CmdAdd implements Command {
	private InventorySet inventory;
	private Video video;
	private int change;
	CmdAdd(InventorySet inventory, Video video, int change) {
		this.inventory = inventory;
		this.video = video;
		this.change = change;
	}
	public boolean run() {
		// TODO
		return false;
	}
}
