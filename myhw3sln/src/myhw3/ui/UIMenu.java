package myhw3.ui;

/**
 * @see UIMenuBuilder
 */
public final class UIMenu {
	private final String heading;
	private final Pair[] menu;

	static final class Pair {
		final String prompt;
		final UIMenuAction action;

		Pair(String prompt, UIMenuAction action) {
			this.prompt = prompt;
			this.action = action;
		}
	}

	UIMenu(String heading, Pair[] menu) {
		this.heading = heading;
		this.menu = menu;
	}
	public int size() {
		return menu.length;
	}
	public String getHeading() {
		return heading;
	}
	public String getPrompt(int i) {
		return menu[i].prompt;
	}
	public void runAction(int i) {
		menu[i].action.run();
	}
}
