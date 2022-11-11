package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public abstract class UserConsumer extends User{
	public static final int PLAYLIST_SIZE = 20; 
	public static final int SONGS_SIZE = 100;
	public static final int ROWS_SIZE=6;
	public static final int COLUMNS_SIZE=6;
	private int[][] matriz;
	private int selectionTypePlayList;
	private ArrayList<PlayList> playlists;

	public UserConsumer(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
		this.selectionTypePlayList=selectionTypePlayList;
	}
	public int getSelectionPlayList(){
		return selectionTypePlayList;
	}
	public abstract boolean addPlayList(PlayList playlist);

	public abstract String showCodePlayList(PlayList playlist);
		
}