package myproject.model.swing;

/**
 * A translator from relative model space to screen graphics.
 */
abstract class Translator {
	double tX;
	double tY;
	double tWidth;
	double tHeight;
	double tScaleFactor;
	Translator(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
		this.tX = tX;
		this.tY = tY;
		this.tWidth = tWidth;
		this.tHeight = tHeight;
		this.tScaleFactor = tScaleFactor;
	}
	int scale(double arg) {
		return (int) Math.ceil(arg * tScaleFactor);
	}
	abstract int getX(double x, double y, double width, double height);
	abstract int getY(double x, double y, double width, double height);
	abstract int getWidth(double width, double height);
	abstract int getHeight(double width, double height);
}

class TranslatorWE extends Translator {
	TranslatorWE(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
		super(tX, tY, tWidth, tHeight, tScaleFactor);
	}
	int getX(double x, double y, double width, double height) { return scale(tX+x); }
	int getY(double x, double y, double width, double height) { return scale(tY+y); }
	int getWidth(double width, double height) { return scale(width); }
	int getHeight(double width, double height)  { return scale(height); }
}

class TranslatorEW extends Translator {
	TranslatorEW(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
		super(tX, tY, tWidth, tHeight, tScaleFactor);
	}
	int getX(double x, double y, double width, double height) { return scale(tX+tWidth-x-width); }
	int getY(double x, double y, double width, double height) { return scale(tY+tHeight-y-height); }
	int getWidth(double width, double height) { return scale(width); }
	int getHeight(double width, double height)  { return scale(height); }
}

class TranslatorNS extends Translator {
	TranslatorNS(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
		super(tX, tY, tWidth, tHeight, tScaleFactor);
	}
	int getX(double x, double y, double width, double height) { return scale(tX+y); }
	int getY(double x, double y, double width, double height) { return scale(tY+x); }
	int getWidth(double width, double height) { return scale(height); }
	int getHeight(double width, double height)  { return scale(width); }
}

class TranslatorSN extends Translator {
	TranslatorSN(double tX, double tY, double tWidth, double tHeight, double tScaleFactor) {
		super(tX, tY, tWidth, tHeight, tScaleFactor);
	}
	int getX(double x, double y, double width, double height) { return scale(tX+tHeight-y-height); }
	int getY(double x, double y, double width, double height) { return scale(tY+tWidth-x-width); }
	int getWidth(double width, double height) { return scale(height); }
	int getHeight(double width, double height)  { return scale(width); }
}

