import java.io.IOException;
import java.util.Arrays;

/**
 * <b>albumProcessor class</b>
 * <p>
 * Processes the Spotify zipfsong problem input and fills an array with the 
 * tracks and then prints the top tracks of the album. 
 * <p>
 * File choosing of a text file with the album input was used during development
 * and testing.
 * <p>
 * Kattio was used to speed up the input and parsing process as the Scanner class 
 * is too slow.
 * @author James Wen
 */

public class albumProcessor {
	public static void main(String[] args) throws IOException{
			albumProcessor spotify = new albumProcessor ();
			spotify.albumProcess();
	}
	private Track[] album;
	private int numToSelect;
	long startTime;
	long lastTime;
	/**
	 * albumProcessor
	 * <p>
	 * Constructor
	 */
	public albumProcessor() {
	}
	/**
	 * albumProcess
	 * <p>
	 * Process the Spotify zipfsong problem input.
	 * <p>
	 * Fills the album array and prints the top quality tracks in the album.
	 * @throws IOException
	 */
	public void albumProcess()throws IOException{
		//Kattio IO System utilized for input processing
		Kattio io = new Kattio(System.in, System.out);
		
		//Initialization and declaration of variables to be used in track processing
		long timesListened = 0;
		String trackName;
		Track tempPlaceHolder;
		//Parses first line (number of tracks and number of tracks to be selected)
		int numTracks = io.getInt();
		numToSelect = io.getInt();
		album = new Track[numTracks];
		
		//Tracks are processed and put into an array
		for (int j = 0; j < numTracks; j++) {
			timesListened = io.getLong();
			trackName = io.getWord();
			tempPlaceHolder = new Track(j+1, trackName, timesListened);
			album[j] = tempPlaceHolder;
		}
		
		//Sort tracks in descending order
		Arrays.sort(album);
		//Prints top tracks
		for(int j = 0; j < numToSelect; j++) {
			io.print(album[j].getName());
			if(j != numToSelect - 1) {
				io.print('\n');
			}
		}
		io.close();
	}
}// End of albumProcessor class