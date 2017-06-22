package myproject.ui;

/**
 * @see UIFormBuilder
 */
public final class UIForm {
	private final String heading;
	private final Pair[] form;

	static final class Pair {
		final String prompt;
		final UIFormTest test;

		Pair(String prompt, UIFormTest test) {
			this.prompt = prompt;
			this.test = test;
		}
	}

	UIForm(String heading, Pair[] menu) {
		this.heading = heading;
		this.form = menu;
	}
	public int size() {
		return form.length;
	}
	public String getHeading() {
		return heading;
	}
	public String getPrompt(int i) {
		return form[i].prompt;
	}
	public boolean checkInput(int i, String input) {
		if (null == form[i])
			return true;
		return form[i].test.run(input);
	}
}
