package myhw2.data;

import myhw2.command.Command;

/**
 * Implementation of command to clear the inventory.
 * @see Data
 */
final class CmdClear implements Command {
	private InventorySet inventory;
	CmdClear(InventorySet inventory) {
		this.inventory = inventory;
	}
	public boolean run() {
		inventory.clear();
		return true;
	}
}
