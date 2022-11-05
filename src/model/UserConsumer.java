package model;
import java.util.Date;
public abstract class UserConsumer extends User{

	private int selectionTypePlayList;

	public UserConsumer(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
		this.selectionTypePlayList=selectionTypePlayList;
	}
	public int getSelectionPlayList(){
		return selectionTypePlayList;
	}
	public abstract boolean addPlayList(PlayList playlist);
	public abstract String showCodePlayListSong(PlayList playlist);
}