/**
 * <b>Track class</b>
 * <p>
 * Represents a track object of the album.
 * <p>
 * Quality is equal to (Actual Times Listened to * TrackNumber)
 * <p>
 * The number of listens for the first track is static because it is the same value
 * used for all tracks in calculating quality. Only needs to be passed value once.
 * @author James Wen
 */
public class Track implements Comparable<Track>{
	private String trackName;
	private long quality;
	private int trackNumber;
	private long numberTimesListened;
	
	/**
	 * Track
	 * <p>
	 * Constructor
	 * <p>
	 * @param trackNumber - track number
	 * @param trackName - name of the track
	 * @param numberTimesListened - number of listens
	 */
	public Track(int trackNumber, String trackName, long numberTimesListened) {
		this.trackNumber = trackNumber;
		this.trackName = trackName;
		this.numberTimesListened = numberTimesListened;
		this.quality = (numberTimesListened * trackNumber);
	}
	
	/**
	 * getName
	 * <p>
	 * @param - the track name.
	 */
	public String getName() {
		return trackName;
	}
	/**
	 * getQuality
	 * <p>
	 * @return - quality of track object
	 */
	public long getQuality() {
		return quality;
	}
	/**
	 * getTrackNumber
	 * <p>
	 * @return - trackNumber
	 */
	public long getTrackNumber() {
		return trackNumber;
	}
	/**
	 * compareTo
	 * <p>
	 * Used for the Comparable interface and sort method of Arrays/Collections class
	 * <p>
	 * Sorted and compared through quality
	 */
	public int compareTo(Track otherTrack){
	    if(quality>otherTrack.quality)  
	      return -1;
	    if(otherTrack.quality==quality)
			return (trackNumber > otherTrack.getTrackNumber()) ? 1 : -1;
	    else
	    	return 1;
	}
}//End of Track class