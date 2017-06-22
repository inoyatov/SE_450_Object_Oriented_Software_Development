package myhw3.main;

import myhw3.data.Data;
import myhw3.ui.UI;

class Main {
	public static void main(String[] args) {
		UI ui = null;

		if (args.length > 0) {
			if ("GUI".equalsIgnoreCase(args[0])) {
				ui = new myhw3.ui.PopupUI();
			} else if ("TEXT".equalsIgnoreCase(args[0])) {
				ui = new myhw3.ui.TextUI();
			} else {
				System.out.println("Argument must be GUI or TEXT");
				System.exit(1);
			}
		} else {
			if (Math.random() <= 0.5) {
				ui = new myhw3.ui.TextUI();
			} else {
				ui = new myhw3.ui.PopupUI();
			}
		}
		Control control = new Control(Data.newInventory(), ui);
		control.run();
	}
}
