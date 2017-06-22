package myproject.model;

import myproject.util.Animator;

/**
 * An interface for building a {@link Animator} for this {@link Model}.
 */
public interface AnimatorBuilder {
	/**
	 *  Returns the {@link Animator}.
	 *  This method may be called only once; subsequent calls throw an
	 *  {@link IllegalStateException}.
	 */
	public Animator getAnimator();
	/**
	 *  Add the {@link Light} to the display at position <code>i,j</code>.
	 */
	public void addLight(Light d, int i, int j);
	/**
	 *  Add the horizontal {@link Road} to the display, west of position <code>i,j</code>.
	 *  If <code>eastToWest</code> is true, then road position 0 is the eastmost position.
	 *  If <code>eastToWest</code> is false, then road position 0 is the westmost position.
	 */
	public void addHorizontalRoad(Road l, int i, int j, boolean eastToWest);
	/**
	 *  Add the vertical {@link Road} to the display, north of position <code>i,j</code>.
	 *  If <code>southToNorth</code> is true, then road position 0 is the southmost position.
	 *  If <code>southToNorth</code> is false, then road position 0 is the northmost position.
	 */
	public void addVerticalRoad(Road l, int i, int j, boolean southToNorth);
}

/**
 * Null object for {@link AnimatorBuilder}.
 */
class NullAnimatorBuilder implements AnimatorBuilder {
	public Animator getAnimator() { return new NullAnimator(); }
	public void addLight(Light d, int i, int j) { }
	public void addHorizontalRoad(Road l, int i, int j, boolean eastToWest) { }
	public void addVerticalRoad(Road l, int i, int j, boolean southToNorth) { }
}

/**
 * Null object for {@link Animator}.
 */
class NullAnimator implements Animator {
	public void update(java.util.Observable o, Object arg) { }
	public void dispose() { }
}
