package myproject.ui;

public class UIFactory {
	private UIFactory() {}
	static private UI UI = new PopupUI();
	//static private UI UI = new TextUI();
	static public UI ui () {
		return UI;
	}
}
