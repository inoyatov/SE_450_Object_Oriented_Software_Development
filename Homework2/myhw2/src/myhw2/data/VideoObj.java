package myhw2.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
	private final String title;
	private final int    year;
	private final String director;

	/**
	 * Initialize all object attributes.
	 */
	VideoObj(String title, int year, String director) {
		this.title = title;
		this.director = director;
		this.year = year;
	}

	public String director() {
		// TODO
		return "director";
	}

	public String title() {
		// TODO
		return "title";
	}

	public int year() {
		// TODO
		return -1;
	}

	public boolean equals(Object thatObject) {
		// TODO
		return false;
	}

	public int hashCode() {
		// TODO
		return -1;
	}

	public int compareTo(Video that) {
		// TODO
		return -1;
	}

	public String toString() {
		// TODO
		return "El Mariachi (1996) : Rodriguez";
	}
}
