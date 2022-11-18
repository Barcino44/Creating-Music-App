package model;
import java.util.Date;
public abstract class UserConsumer extends User{
	public static final int ROWS_SIZE=6;
	public static final int COLUMNS_SIZE=6;

	public UserConsumer(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
	}

	public abstract boolean addPlayList(PlayList playlist);

	public abstract String showCodePlaylist(PlayList playlist);

	// public boolean validateIfPlaylistExist(String playlistName){
	// 	boolean playlistExist=false;
	// 	for (int i=0;i<playlists.size()&&!playlistExist ;i++ ) {
	// 		if(playlists.get(i).getPlayListName().equals(playlistName)){
	// 			playlistExist=true;
	// 			System.out.println(playlistExist);
	// 		}
	// 	}
	// 	return playlistExist;
	// }
	public abstract int playlistPosByName(String playlistName);
	public abstract String showCodeAndMatrizWithPlayListName(String playlistName);
	public abstract String showAudiosAddedInPlaylist(String playlistName);
	public abstract int getTypePlaylist(String playlistName);
	public abstract boolean addAudiotoPlayList(String playlistName, Audio audio);
	public abstract boolean deleteAudioInPlaylist(String playlistName,String audioName);
	public abstract String playAudioInPlaylist(String playlistName, String audioName);
	public abstract boolean validateIfSongCanbeBought(String songName);
	public abstract String showMostListenedSongGenre();
	//public abstract String 
	//{
	//public abstract String showCodeWithPlayListName(String playlistName);
	// 	String msj="";
	// 	int pos=playlistPosByName(playlistName);
	// 	if(playlists.get(pos).getSelectionTypePlayList()==1){
	// 		msj=playlists.get(pos).showSongsToAdd();
	// 	}
	// 	else if(playlists.get(pos).getSelectionTypePlayList()==2){
	// 		msj=playlists.get(pos).showPodcastsToAdd();	
	// 	}
	// 	else{
	// 		msj=playlists.get(pos).showBothPodcastAndSongs();
	// 	}
	// 	return msj;
	// }
}

		
//public abstract String showCodePlayList(PlayList playlist);
	