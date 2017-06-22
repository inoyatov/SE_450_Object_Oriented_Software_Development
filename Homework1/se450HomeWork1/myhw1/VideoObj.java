package myhw1;

// TODO: complete the methods
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * <p><b>Class Type:</b> Immutable Data Class</p>
 * <p><b>Object Invariant:</b></p>
 *   Title is non-null, no leading or final spaces, not empty string.
 * <p><b>Object Invariant:</b></p>
 *   Year is greater than 1800, less than 5000.
 * <p><b>Object Invariant:</b></p>
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {
	/** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
	private final String title;
	/** <p><b>Invariant:</b> greater than 1800, less than 5000 </p>*/
	private final int    year;
	/** <p><b>Invariant:</b> non-null, no leading or final spaces, not empty string </p>*/
	private final String director;

	/**
	 * Initialize all object attributes.
	 * Title and director are "trimmed" to remove leading and final space.
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	VideoObj(String title, int year, String director) {
		// Complete
		if (
			(title == null)
			|| (title == "")
			|| (title == " ")
			|| (year <= 1800)
			|| (year >= 5000)
			|| (director == null)
			|| (director == "")
			|| (director == " ")
			) {
			throw new IllegalArgumentException();
		}
		this.title = title.trim();
		this.year = year;
		this.director = director.trim(); 
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {
		// Complete
		return director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		// Complete
		return title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {
		// Complete
		return year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	public boolean equals(Object thatObject) {
		// Complete
		if (this == thatObject){
			return true;
		}
		if (!(thatObject instanceof VideoObj)) {
			return false;
		}
		VideoObj that = (VideoObj) thatObject;
		return this.title.equals(that.title) 
				&& this.year == (that.year)
				&& this.director.equals(that.director());
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	public int hashCode() {
		// Complete
		//Bloch algo from pg39 http://fpl.cs.depaul.edu/jriely/450/extras/Chapter3.pdf
		int result = 17;
		result = 37*result + title.hashCode();
		result = 37*result + year;
		result = 37*result + director.hashCode();
		return result;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in
	 * the following order: title, year, director.
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this
	 *  object is less than, equal to, or greater than that object.
	 */
	public int compareTo(VideoObj that) {
		// Complete
		if (this.title == that.title){
			return 1;
		}else if (this.year == that.year){
			return 1;
		}else if(this.director == that.director){
			return 1;
		}else 
			return -1;
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	public String toString() {
		// Complete
		//return "El Mariachi (1996) : Rodriguez";
		//System.out.println(title + " ("+year+") : "+director);
		return title + " ("+year+") : "+director; 
	}
}
