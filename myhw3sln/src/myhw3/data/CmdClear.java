package myhw3.data;

import java.util.Map;
import myhw3.command.Command;

/**
 * Implementation of command to clear the inventory.
 * @see Data
 */
final class CmdClear implements Command {
	private InventorySet inventory;
	private Map<Video,Record> oldvalue;
	CmdClear(InventorySet inventory) {
		this.inventory = inventory;
	}
	public boolean run() {
		if (oldvalue != null) {
			return false;
		}
		oldvalue = inventory.clear();
		inventory.getHistory().add(this);
		return true;
	}
	public void undo() {
		inventory.replaceMap(oldvalue);
	}
	public void redo() {
		oldvalue = inventory.clear();
	}
}
