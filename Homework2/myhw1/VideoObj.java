package myhw1;

/*<private todo="complete the methods"/>*/
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
	//Solution
	VideoObj(String title, int year, String director) {
		/*<private>*/
		if (  (title == null)
				|| (director == null)
				|| (year <= 1800)
				|| (year >= 5000)) {
			throw new IllegalArgumentException();
		}
		this.title = title.trim();
		this.director = director.trim();
		this.year = year;
		if (  ("".equals(this.title))
				|| ("".equals(this.director))) {
			throw new IllegalArgumentException();
		}
		/*</private>*/
		/*<public>*
		 * this.title = null;
		 * this.year = 0;
		 * this.director = null;
		 *</public>*/
	}

	/**
	 * Return the value of the attribute.
	 */
	//Solution
	public String director() {
		/*<private return='"director"'>*/
		return director;
		/*</private>*/
	}

	/**
	 * Return the value of the attribute.
	 */
	//Solution
	public String title() {
		/*<private return='"title"'>*/
		return title;
		/*</private>*/
	}

	/**
	 * Return the value of the attribute.
	 */
	//Solution
	public int year() {
		/*<private return='-1'>*/
		return year;
		/*</private>*/
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	//Solution
	public boolean equals(Object thatObject) {
		/*<private return="false">*/
		if (!(thatObject instanceof VideoObj)) {
			return false;
		}
		VideoObj that = (VideoObj) thatObject;
//		return title.equals(that.title())
//				&& (year == that.year())
//				&& director.equals(that.director());
		if (!title.equals(that.title())) return false;
		if (year != that.year()) return false;
		if (!director.equals(that.director())) return false;
		return true;
		/*</private>*/
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	//Solution
	public int hashCode() {
		/*<private return="-1">*/
		int result = 17;
		result = 37*result + title.hashCode();
		result = 37*result + year;
		result = 37*result + director.hashCode();
		return result;
		/*</private>*/
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in
	 * the following order: title, year, director.
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this
	 *  object is less than, equal to, or greater than that object.
	 */
	//Solution
	public int compareTo(VideoObj that) {
		/*<private return="-1">*/
		int titleDiff = title.compareTo(that.title());
		if (titleDiff != 0) {
			return titleDiff;
		}
		int yearDiff = Integer.compare (year, that.year());
		if (yearDiff != 0) {
			return yearDiff;
		}
		int directorDiff = director.compareTo(that.director());
		if (directorDiff != 0) {
			return directorDiff;
		}
		return 0;
		/*</private>*/
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	//Solution
	public String toString() {
		/*<private return='"El Mariachi (1996) : Rodriguez"'>*/
		// return title + " (" + year + ") : " + director
		StringBuilder buffer = new StringBuilder();
		buffer.append(title);
		buffer.append(" (");
		buffer.append(year);
		buffer.append(") : ");
		buffer.append(director);
		return buffer.toString();
		/*</private>*/
	}
}
