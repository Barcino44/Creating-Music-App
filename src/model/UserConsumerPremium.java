package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerPremium extends UserConsumer{
	private ArrayList<PlayList> playlists;
	private int[][] matriz;

	public UserConsumerPremium(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
		playlists= new ArrayList<PlayList>(10);
		matriz=new int[ROWS_SIZE][COLUMNS_SIZE];
	}
	@Override
	public boolean addPlayList(PlayList playlist){
		boolean isAdded=playlists.add(playlist);
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
		int pos=posPlayList(playlist);
		msj=playlists.get(pos).showCodePlaylist();
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
		if(pos!=-1){
		if(playlists.get(pos).getTypePlayList()==TypePlayList.SONG){
			msj=playlists.get(pos).showSongsToAdd();
		}
		else if(playlists.get(pos).getTypePlayList()==TypePlayList.PODCAST){
			msj=playlists.get(pos).showPodcastsToAdd();	
		}
		else{
			msj=playlists.get(pos).showBothPodcastAndSongs();
		}
	}
		System.out.println(pos);
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