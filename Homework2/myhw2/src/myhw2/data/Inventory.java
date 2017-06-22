package myhw2.data;

import java.util.Comparator;
import java.util.Iterator;

/**
 * A collection of Records.
 * Records can only be created and destroyed using the Inventory.
 * @see Data
 */
public interface Inventory extends Iterable<Record> {
	/**
	 *  Return the number of Records.
	 */
	public int size();

	/**
	 *  Return the record for a given Video; if not present, return <code>null</code>.
	 */
	public Record get(Video v);

	/**
	 *  Return an iterator over Records in the Inventory.
	 *  <p>The iterator returns objects that implement the Record interface.</p>
	 *  <p>Any attempt to remove objects using the iterator should
	 *  result in an <code>UnsupportedOperationException</code>.</p>
	 *  <p>The Record order is unspecified</p>
	 */
	public Iterator<Record> iterator();

	/**
	 *  Return an iterator over the Inventory, sorted accoring the
	 *  Comparator.
	 *  <p>The iterator returns objects that implement the
	 *  <code>Record</code> interface.</p>
	 *  <p>Any attempt to remove objects using the iterator should
	 *  result in an <code>UnsupportedOperationException</code>.</p>
	 *  <p>The iteration order is determined by the comparator (least first).</p>
	 *  <p>The comparator may assume that its arguments implement
	 *  <code>Record</code>.</p>
	 *  @param comparator determines the order of the records returned.
	 */
	public Iterator<Record> iterator(Comparator<Record> comparator);

	/**
	 * Returns the inventory as a string; one record per line.
	 */
	public String toString();
}
