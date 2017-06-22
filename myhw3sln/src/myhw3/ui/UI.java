package myhw3.ui;

public interface UI {
	/** Displays a menu and calls the menu action corresponding to the user input.
	 *  <ul><li>
	 *    Displays <code>menu.getPrompt(i)</code> for each menu item <code>i</code>.
	 *  </li><li>
	 *    Reads a numeric <code>selection</code> from the user.
	 *  </li><li>
	 *    Calls <code>menu.runAction(selection)</code>.
	 *  </li></ul>
	 */
	public void processMenu(UIMenu menu);

	/** Displays a form and returns an array of validated responses.
	 *  <ul><li>
	 *    Displays <code>form.getPrompt(i)</code> for each form item <code>i</code>.
	 *  </li><li>
	 *    Reads a <code>response</code> from the user, for each form item <code>i</code>, and validates it using <code>form.checkInput(response)</code>.  Only valid responses are accepted.
	 *  </li><li>
	 *    Returns an array of validated responses.
	 *  </li></ul>
	 */
	public String[] processForm(UIForm form);

	/** Displays the message. */
	public void displayMessage(String message);

	/** Displays the error. */
	public void displayError(String message);
}
