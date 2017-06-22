package myproject.ui;

import java.util.ArrayList;
import java.util.List;

public final class UIFormBuilder {
	private final List<UIForm.Pair> menu = new ArrayList<UIForm.Pair>();
	public void add(String prompt, UIFormTest test) {
		menu.add(new UIForm.Pair(prompt, test));
	}
	public UIForm toUIForm(String heading) {
		if (null == heading)
			throw new IllegalArgumentException();
		if (menu.size() < 1)
			throw new IllegalStateException();
		UIForm.Pair[] array = new UIForm.Pair[menu.size()];
		for (int i = 0; i < menu.size(); i++)
			array[i] = menu.get(i);
		return new UIForm(heading, array);
	}
}
