package myproject.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;
import myproject.util.Animator;

/**
 * An example to model for a simple visualization.
 * The model contains roads organized in a matrix.
 * See {@link #Model(AnimatorBuilder, int, int)}.
 */
public class Model extends Observable {
	private List<Agent> agents;
	private Animator animator;
	private boolean disposed;
	private double time;

	/** Creates a model to be visualized using the <code>builder</code>.
	 *  If the builder is null, no visualization is performed.
	 *  The number of <code>rows</code> and <code>columns</code>
	 *  indicate the number of {@link Light}s, organized as a 2D
	 *  matrix.  These are separated and surrounded by horizontal and
	 *  vertical {@link Road}s.  For example, calling the constructor with 1
	 *  row and 2 columns generates a model of the form:
	 *  <pre>
	 *     |  |
	 *   --@--@--
	 *     |  |
	 *  </pre>
	 *  where <code>@</code> is a {@link Light}, <code>|</code> is a
	 *  vertical {@link Road} and <code>--</code> is a horizontal {@link Road}.
	 *  Each road has one {@link Car}.
	 *
	 *  <p>
	 *  The {@link AnimatorBuilder} is used to set up an {@link
	 *  Animator}.
	 *  {@link AnimatorBuilder#getAnimator()} is registered as
	 *  an observer of this model.
	 *  <p>
	 */
	public Model(AnimatorBuilder builder, int rows, int columns) {
		if (rows < 0 || columns < 0 || (rows == 0 && columns == 0)) {
			throw new IllegalArgumentException();
		}
		if (builder == null) {
			builder = new NullAnimatorBuilder();
		}
		this.agents = new ArrayList<Agent>();
		setup(builder, rows, columns);
		this.animator = builder.getAnimator();
		super.addObserver(animator);
	}

	/**
	 * Run the simulation for <code>duration</code> model seconds.
	 */
	public void run(double duration) {
		if (disposed)
			throw new IllegalStateException();
		for (int i=0; i<duration; i++) {
			time++;
			// iterate through a copy because agents may change during iteration...
			for (Agent a : agents.toArray(new Agent[0])) {
				a.run(time);
			}
			super.setChanged();
			super.notifyObservers();
		}
	}

	/**
	 * Throw away this model.
	 */
	public void dispose() {
		animator.dispose();
		disposed = true;
	}

	/**
	 * Construct the model, establishing correspondences with the visualizer.
	 */
	private void setup(AnimatorBuilder builder, int rows, int columns) {
		List<Road> roads = new ArrayList<Road>();
		Light[][] intersections = new Light[rows][columns];

		// Add Lights
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				intersections[i][j] = new Light();
				builder.addLight(intersections[i][j], i, j);
				agents.add(intersections[i][j]);
			}
		}

		// Add Horizontal Roads
		boolean eastToWest = false;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<=columns; j++) {
				Road l = new Road();
				builder.addHorizontalRoad(l, i, j, eastToWest);
				roads.add(l);
			}
			eastToWest = !eastToWest;
		}

		// Add Vertical Roads
		boolean southToNorth = false;
		for (int j=0; j<columns; j++) {
			for (int i=0; i<=rows; i++) {
				Road l = new Road();
				builder.addVerticalRoad(l, i, j, southToNorth);
				roads.add(l);
			}
			southToNorth = !southToNorth;
		}

		// Add Cars
		for (Road l : roads) {
			Car car = new Car();
			agents.add(car);
			l.accept(car);
		}
	}
}
