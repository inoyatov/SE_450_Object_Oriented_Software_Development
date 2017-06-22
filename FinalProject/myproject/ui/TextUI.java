package myproject.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public final class TextUI implements UI {
	final BufferedReader in;
	final PrintStream out;

	public TextUI() {
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public void displayMessage(String message) {
		out.println(message);
	}

	public void displayError(String message) {
		out.println(message);
	}

	private String getResponse() {
		String result;
		try {
			result = in.readLine();
		} catch (IOException e) {
			throw new UIError(); // re-throw UIError
		}
		if (result == null) {
			throw new UIError(); // input closed
		}
		return result;
	}

	public void processMenu(UIMenu menu) {
		out.println(menu.getHeading());
		out.println("Enter choice by number:");

		for (int i = 1; i < menu.size(); i++) {
			out.println("  " + i + ". " + menu.getPrompt(i));
		}

		String response = getResponse();
		int selection;
		try {
			selection = Integer.parseInt(response, 10);
			if ((selection < 0) || (selection >= menu.size()))
				selection = 0;
		} catch (NumberFormatException e) {
			selection = 0;
		}

		menu.runAction(selection);
	}

	public String[] processForm(UIForm form) {
		// TODO
		return null;
	}
}
