package myhw1;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;


// TODO: complete the methods
/**
 * An Inventory implemented using a <code>HashMap&lt;Video,Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * <p><b>Class Type:</b> Mutable Collection of Records</p>
 * <p><b>Object Invariant:</b></p>
 *   Every key and value in the map is non-<code>null</code>.
 * <p><b>Object Invariant:</b></p>
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {
	/** <p><b>Invariant:</b> <code>_data != null</code> </p>*/
	private final Map<VideoObj,Record> data = new HashMap<VideoObj,Record>();

	InventorySet() { }

	/**
	 * Return the number of Records.
	 */
	public int size() {
		// Completed
		return data.size();
	}

	/**
	 *  Return a copy of the record for a given Video; if not present, return <code>null</code>.
	 */
	public Record get(VideoObj v) {
		// Completed 
		if (data.containsKey(v)){
			Record r = data.get(v);
			return r.copy();
		}
		else{
			return null;
		}
	}

	/**
	 * Return a copy of the records as a collection.
	 * Neither the underlying collection, nor the actual records are returned.
	 */
	public Collection<Record> toCollection() {
		// Recall that an ArrayList is a Collection.
		// Check
		ArrayList<Record> tC = new ArrayList<Record>(data.size());
		for (Record r : data.values()){
			tC.add(r.copy());
		}
		return tC;
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
	 * @throws IllegalArgumentException if video null, change is zero,
	 *  if attempting to remove more copies than are owned, or if
	 *  attempting to remove copies that are checked out.
	 * <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void addNumOwned(VideoObj video, int change) {
		// Check
		if (video == null) { throw new IllegalArgumentException(); } 
		else if (change == 0) { throw new IllegalArgumentException(); }
		
		Record r = data.get(video);
		
		if (r == null && change <= 0) { throw new IllegalArgumentException(); } 
		else if (r == null) {
			data.put(video, new Record(video, change, 0, 0));
		} else if (r.numOwned + change < r.numOut) {
			throw new IllegalArgumentException();
		} else if (r.numOwned+change < 1) {
			data.remove(video);
		} else {
			r.numOwned += change;
		}
		
	}

	/**
	 * Check out a video.
	 * @param video the video to be checked out.
	 * @throws IllegalArgumentException if video has no record or numOut
	 * equals numOwned.
	 * <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void checkOut(VideoObj video) {
		// Check
		Record r = data.get(video);
		
		if (r == null){
			throw new IllegalArgumentException();
		}else if (r.numOut == r.numOwned){
			throw new IllegalArgumentException();
		}		
		
		r.numOut += 1;
		r.numRentals +=1;
	}

	/**
	 * Check in a video.
	 * @param video the video to be checked in.
	 * @throws IllegalArgumentException if video has no record or numOut
	 * non-positive.
	 * <p><b>Postcondition:</b> changes the record for the video</p>
	 */
	public void checkIn(VideoObj video) {
		// Completed
		Record r = data.get(video);
		if (r == null){
			throw new IllegalArgumentException();
		}else if (r.numOut <= 0){
			throw new IllegalArgumentException();
		}		
		
		r.numOut -= 1;
	}

	/**
	 * Remove all records from the inventory.
	 * <p><b>Postcondition:</b> <code>size() == 0</code></p>
	 */
	public void clear() {
		// Completed
		data.clear();
	}

	/**
	 * Return the contents of the inventory as a string.
	 */
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
}
