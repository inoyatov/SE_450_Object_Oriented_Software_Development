package myproject.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * A swing implementation of {@link Animator}, using a {@link JFrame}
 * to display the animation.  The {@link JFrame} is created and
 * displayed by the constructor.
 *
 * Calls to <code>update()</code> result in a call to
 * <code>painter.paint()</code>.  This is executed in the swing
 * thread while the main thread is paused for <code>delay</code>
 * milliseconds.
 */
public class SwingAnimator implements Animator {
	// The following fields are manipulated by the main program thread
	private int delay;

	// The following fields are manipulated by the swing thread
	private JFrame frame; // Swing representation of an OS window
	private ContentPane content; // A paintable component
	private boolean disposed = false; // If true, then die

	/**
	 * Creates and displays a {@link JFrame} for the animation.
	 * @param name  The name to be displayed on the graphical window.
	 * @param width The width of the display, in pixels.
	 * @param height The height of the display, in pixels.
	 * @param delay Time to pause after an update, in milliseconds.
	 */
	public SwingAnimator(final SwingAnimatorPainter painter, final String name, final int width, final int height, int delay) {
		this.delay = delay;
		// Create a graphics window and display it
		SwingUtilities.invokeLater(() -> {
			content = new ContentPane(painter, width, height); // A paintable component for content
			frame = new JFrame();  // An OS window
			frame.setTitle(name);  // The title of the Frame
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // End program if Frame is closed
			frame.setContentPane(content); // Associate the content with the Frame
			frame.pack(); // Fix the layout of the Frame
			frame.setVisible(true); // Display the Frame
		});
	}

	/**
	 * Throw away this visualization.
	 */
	public void dispose() {
		SwingUtilities.invokeLater(() -> {
			frame.dispose();
			disposed = true;
		});
	}

	/**
	 * Calls to <code>update</code> are executed in the swing thread,
	 * while the main thread is paused for <code>delay</code>
	 * milliseconds.
	 */
	public void update(final Observable model, Object ignored) {
		if (disposed)
			throw new IllegalStateException();

		// Redraw the window
		//   content.repaint() causes a call to content.paint(g)
		//   where g is an appropriate graphics argument.
		SwingUtilities.invokeLater(() -> content.repaint());

		// Delay the main thread
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {}
	}

	/**
	 * A component for painting.
	 * All code is executed in the swing thread.
	 */
	private static class ContentPane extends JPanel {
		private static final long serialVersionUID = 2008L;
		private int width;
		private int height;
		private SwingAnimatorPainter painter;

		ContentPane(SwingAnimatorPainter painter, int width, int height) {
			this.painter = painter;
			this.width = width;
			this.height = height;
			setPreferredSize(new Dimension(width, height));
			setDoubleBuffered(true);
			setOpaque(true);
			setBackground(Color.WHITE);
		}

		public void paint(Graphics g) {
			// This test is necessary because the swing thread may call this
			// method before the simulation calls SwingAnimator.update()
			if (painter != null ) {
				// The clearRect is necessary, since JPanel is lightweight
				g.clearRect(0, 0, width, height);
				painter.paint(g);
			}
		}
	}
}
