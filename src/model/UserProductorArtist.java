package model;
import java.util.Date;
import java.util.ArrayList;
public class UserProductorArtist extends UserProductor{
	
	private ArrayList<Song> songs;

	public UserProductorArtist(String username, String id, Date vinculationDate, String url) {
		super(username, id, vinculationDate,url);
		songs=new ArrayList<Song>(10);
	}
	public boolean addSong(Song song){
		boolean isAdded=songs.add(song);
		return isAdded;
	}
	/**
	 * getPlayingTimesOfSongs: It represents the number times that the songs of the artist has been played.
	 * @return countPlayingTimesSongs: int - It is the number of times that the songs of artist has been played.
	 */
	public int getPlayingTimesOfSongs(){
		int countPlayingTimesSongs=0;
		for (int i=0;i<songs.size();i++ ) {
			countPlayingTimesSongs=countPlayingTimesSongs+songs.get(i).getPlayingTimes();
		}
		return countPlayingTimesSongs;
	}
}
	