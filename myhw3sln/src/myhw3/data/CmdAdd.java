package myhw3.data;

import myhw3.command.Command;

/**
 * Implementation of command to add or remove inventory.
 * @see Data
 */
final class CmdAdd implements Command {
	private boolean runOnce;
	private InventorySet inventory;
	private Record oldvalue;
	private Video video;
	private int change;
	CmdAdd(InventorySet inventory, Video video, int change) {
		this.inventory = inventory;
		this.video = video;
		this.change = change;
	}
	public boolean run() {
		if (runOnce) {
			return false;
		}
		runOnce = true;
		//System.out.println(inventory.get(video) + " " + video + " " + change);
		try {
			oldvalue = inventory.addNumOwned(video, change);
			inventory.getHistory().add(this);
			//System.out.println("ok");
			return true;
		} catch (IllegalArgumentException e) {
			//System.out.println("IAE");
			return false;
		} catch (ClassCastException e) {
			//System.out.println("CCE");
			return false;
		}
	}
	public void undo() {
		inventory.replaceEntry(video,oldvalue);
	}
	public void redo() {
		oldvalue = inventory.addNumOwned(video, change);
	}
}
