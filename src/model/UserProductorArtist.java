package model;
import java.util.Date;
import java.util.ArrayList;
public class UserProductorArtist extends UserProductor implements Comparable<UserProductorArtist>{
	private ArrayList<Song> songs;

	public UserProductorArtist(String username, String id, Date vinculationDate, String url) {
		super(username, id, vinculationDate,url);
		songs=new ArrayList<Song>(10);
	}
	public boolean addSong(Song song){
		boolean isAdded=songs.add(song);
		return isAdded;
	}
	public int getPlayingTimesOfSongs(){
		int countPlayingTimesSongs=0;
		for (int i=0;i<songs.size();i++ ) {
			countPlayingTimesSongs=countPlayingTimesSongs+songs.get(i).getPlayingTimes();
		}
		return countPlayingTimesSongs;
	}
	@Override
	public int compareTo(UserProductorArtist userProductorArtist) {
 		int result=0;
    	if (this.getPlayingTimesOfSongs()>userProductorArtist.getPlayingTimesOfSongs()) {
    		result=1;
    	}
		else if (this.getPlayingTimesOfSongs()<userProductorArtist.getPlayingTimesOfSongs()){
   		   result=-1;
		}
	return result;
	}
}
	