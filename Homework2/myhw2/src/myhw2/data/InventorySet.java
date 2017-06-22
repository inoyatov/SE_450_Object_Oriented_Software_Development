package myhw2.data;

import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

/**
 * Implementation of Inventory interface.
 * @see Data
 */
final class InventorySet implements Inventory {
	// Chose to use Map of Record, rather than RecordObj, because of
	// Java's broken generic types.  The story is too sad to retell, but
	// involves the fact that Iterable<? extends Record> is not a valid
	// type, and that Iterator<RecordObj> is not a subtype of
	// Iterator<Record>.
	//
	// Seems like the best approach for Java generics is to use the
	// external representation internally and downcast when necessary.
	private final Map<Video,Record> data;

	InventorySet() {
		data = new HashMap<Video,Record>();
	}

	public int size() {
		// TODO
		return 0;
	}

	public Record get(Video v) {
		// TODO
		return null;
	}

	public Iterator<Record> iterator() {
		return Collections.unmodifiableCollection(data.values()).iterator();
	}

	public Iterator<Record> iterator(Comparator<Record> comparator) {
		// Hint: Look at Collections.sort
		// TODO
		return null;
	}

	/**
	 * Add or remove copies of a video from the inventory.
	 * If a video record is not already present (and change is
	 * positive), a record is created.
	 * If a record is already present, <code>numOwned</code> is
	 * modified using <code>change</code>.
	 * If <code>change</code> brings the number of copies to be zero,
	 * the record is removed from the inventory.
	 * @param video the video to be added.
	 * @param change the number of copies to add (or remove if negative).
	 * @throws IllegalArgumentException if video null, change is zero, if attempting to remove more copies than are owned, or if attempting to remove copies that are checked out.
	 */
	void addNumOwned(Video video, int change) {
		// TODO
	}

	/**
	 * Check out a video.
	 * @param video the video to be checked out.
	 * @throws IllegalArgumentException if video has no record or numOut
	 * equals numOwned.
	 */
	void checkOut(Video video) {
		// TODO
	}

	/**
	 * Check in a video.
	 * @param video the video to be checked in.
	 * @throws IllegalArgumentException if video has no record or numOut
	 * non-positive.
	 */
	void checkIn(Video video) {
		// TODO
	}

	/**
	 * Remove all records from the inventory.
	 */
	void clear() {
		// TODO
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Database:\n");
		for (Record r : data.values()) {
			buffer.append("  ");
			buffer.append(r);
			buffer.append("\n");
		}
		return buffer.toString();
	}


	/**
	 * Implementation of Record interface.
	 *
	 * <p>This is a utility class for Inventory.  Fields are mutable and
	 * package-private.</p>
	 *
	 * <p><b>Class Invariant:</b> No two instances may reference the same Video.</p>
	 *
	 * @see Record
	 */
	private static final class RecordObj implements Record {
		Video video;    // the video
		int numOwned;   // copies owned
		int numOut;     // copies currently rented
		int numRentals; // total times video has been rented

		RecordObj(Video video, int numOwned, int numOut, int numRentals) {
			this.video = video;
			this.numOwned = numOwned;
			this.numOut = numOut;
			this.numRentals = numRentals;
		}
		public Video video() {
			return video;
		}
		public int numOwned() {
			return numOwned;
		}
		public int numOut() {
			return numOut;
		}
		public int numRentals() {
			return numRentals;
		}
		public String toString() {
			StringBuilder buffer = new StringBuilder();
			buffer.append(video);
			buffer.append(" [");
			buffer.append(numOwned);
			buffer.append(",");
			buffer.append(numOut);
			buffer.append(",");
			buffer.append(numRentals);
			buffer.append("]");
			return buffer.toString();
		}
	}
}
