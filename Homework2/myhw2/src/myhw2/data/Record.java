package myhw2.data;

/**
 * <p>Public view of an inventory record.</p>
 *
 * <p>Records are mutable, but cannot be changed outside the package.</p>
 *
 * <p>This interface should not be implemented outside the package.</p>
 *
 * <p><code>equals</code> and <code>hashCode</code> delegate to the
 * underlying Video object.</p>
 * @see Data
 */
public interface Record {
	/**
	 * Returns the video.
	 * <p><b>Invariant:</b> <code>video() != null</code>.</p>
	 */
	public Video video();
	/**
	 * Returns the number of copies of the video that are in the inventory.
	 * <p><b>Invariant:</b> <code>numOwned() > 0</code>.</p>
	 */
	public int numOwned();
	/**
	 * Returns the number of copies of the video that are currently checked out.
	 * <p><b>Invariant:</b> <code>numOut() <= numOwned()</code>.</p>
	 */
	public int numOut();
	/**
	 * Returns the total number of times this video has ever been checked out.
	 * <p><b>Invariant:</b> <code>numRentals() >= numOut()</code>.</p>
	 */
	public int numRentals();
	/**
	 *  Return a string representation of the object in the following format:
	 * <code>"video [numOwned,numOut,numRentals]"</code>.
	 */
	public String toString();
}
