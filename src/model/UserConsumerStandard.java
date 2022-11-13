package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerStandard extends UserConsumer{

	public static final int PLAYLIST_SIZE = 20; 
	public static final int SONGS_SIZE = 100;
	private int[][] matriz;
	private ArrayList<PlayList> playlists;

	public UserConsumerStandard(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
		playlists= new ArrayList<PlayList>(10);
		matriz=new int[ROWS_SIZE][COLUMNS_SIZE];
	}
	@Override
	public boolean addPlayList(PlayList playlist){
		boolean isAdded=false;
		if(PLAYLIST_SIZE>playlists.size()){
			playlists.add(playlist);
			isAdded=true;
		}
		return isAdded;
	}
	public int posPlayList(PlayList playlist){
		int posAdded=-1;
		if(addPlayList(playlist)==true){
			posAdded=playlists.indexOf(playlist);
		}
		return posAdded;
	}
	@Override
	public String showCodePlaylist(PlayList playlist){
		String msj="";
		if(addPlayList(playlist)==true){
			int pos = posPlayList(playlist);
			msj=playlists.get(pos).showCodePlaylist();
		}
		return msj;
	}
	@Override
	public int playlistPosByName(String playlistName){
		boolean isFound=false;
		int pos=-1;
		for (int i=0;i<playlists.size()&&!isFound ;i++ ) {
			if(playlists.get(i).getPlayListName().equals(playlistName)){
				pos=i;
				isFound=true;
			}
		}
		return pos;
	}
	@Override
	public String showInformation(String playlistName){
		String msj="";
		int pos=playlistPosByName(playlistName);
		if(playlists.get(pos).getSelectionTypePlayList()==1){
			msj=playlists.get(pos).showSongsToAdd();
		}
		else if(playlists.get(pos).getSelectionTypePlayList()==2){
			msj=playlists.get(pos).showPodcastsToAdd();	
		}
		else{
			msj=playlists.get(pos).showBothPodcastAndSongs();
		}
		return msj;
	}
	@Override
	public String showCodeAndMatrizWithPlayListName(String playlistName){
		String msj="";
		int pos=playlistPosByName(playlistName);
		if(playlists.get(pos).getPlayListName().equals(playlistName)){
			msj=playlists.get(pos).showMatrizPlaylist()+"\n"+
				playlists.get(pos).showCodePlaylist();
		}
	return msj;
	}
}