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
}