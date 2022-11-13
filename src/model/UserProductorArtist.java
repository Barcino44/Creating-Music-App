package model;
import java.util.Date;
import java.util.ArrayList;
public class UserProductorArtist extends UserProductor{
	private ArrayList<Song> songs;

	public UserProductorArtist(String username, String id, Date vinculationDate, String url) {
		super(username, id, vinculationDate,url);
		songs=new ArrayList<Song>(10);
		Song newSong1 = new Song(1,"Rosas","jk","yujik",46,56,485,55);
		Song newSong2 = new Song(2,"Mon Amour","62","6",8,77,8,89);
		songs.add(newSong1);
		songs.add(newSong2);
	}
	public boolean addSong(Song song){
		boolean isAdded=songs.add(song);
		return isAdded;
	}
}