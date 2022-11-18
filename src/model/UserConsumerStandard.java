package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerStandard extends UserConsumer implements Announciable{

	public static final int PLAYLIST_SIZE = 20; 
	public static final int SONGS_SIZE = 90;
	private int boughtSongs;
	private int[][] matriz;
	private ArrayList<PlayList> playlists;

	public UserConsumerStandard(String username, String id, int boughtSongs, Date vinculationDate) {
		super(username, id, vinculationDate);
		this.boughtSongs=boughtSongs;
		playlists= new ArrayList<PlayList>(10);
		matriz=new int[ROWS_SIZE][COLUMNS_SIZE];
	}

	public int getBoughtSongs(){
		return boughtSongs;
	}
	public void setBougthSongs(int boughtSongs){
		this.boughtSongs=boughtSongs;
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
	public int getTypePlaylist(String playlistName){
		int number=-1;
		int pos=playlistPosByName(playlistName);
			if(playlists.get(pos).getSelectionTypePlayList()==1){
				number=1;
			}
			else if(playlists.get(pos).getSelectionTypePlayList()==2){
				number=2;	
			}
			else{
				number=3;
			}
		return number;
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
	@Override
	public boolean addAudiotoPlayList(String playlistName, Audio audio){
		boolean isAdded=false;
		int pos=playlistPosByName(playlistName);
		isAdded=playlists.get(pos).addAudio(audio);
		return isAdded;
	}
	@Override 
	public String showAudiosAddedInPlaylist(String playlistName){
		String msj="";
		int pos=playlistPosByName(playlistName);
		msj=playlists.get(pos).listAudios();
		return msj;
	}
	@Override
	public boolean deleteAudioInPlaylist(String playlistName,String audioName){
		boolean exist=false;
		int pos=playlistPosByName(playlistName);
		if(playlists.get(pos).searchPosAudioByName(audioName)!=-1){
			if(playlists.get(pos).deleteAudio(audioName)==true){
				exist=true;
			}
		}
		return exist;
	}
	@Override
	public String playAd(){
		String msj="Wait....\n"+
					"Playing ad\n";
		int randomicAdd=(int)(Math.random()*4+1);
		if(randomicAdd==1){
			msj=msj+"Nike - Just Do It\n"+
				"The ad has finished\n";

		}
		else if(randomicAdd==2){
			msj=msj+"Coca-Cola - Open Happiness\n"+
				"The ad has finished\n";
		}
		else{
			msj=msj+"M&Ms - Melts in Your Mouth, Not in Your Hands\n"+
				"The ad has finished\n";
		}
		return msj;
	}
	@Override
	public String playAudioInPlaylist(String playlistName,String audioName){
		String msj="";							
		int pos=playlistPosByName(playlistName);
		if(playlists.get(pos).searchPosAudioByName(audioName)!=-1){
			playlists.get(pos).playingTimesOfAudio(audioName);        
			if((playlists.get(pos).totalTimesOfPlaylist()%3==0&&playlists.get(pos).showTypeAudiotoPlay(audioName)==1)||(playlists.get(pos).showTypeAudiotoPlay(audioName)==2)){
				msj=playAd()+"\n"+
				playlists.get(pos).playAudio(audioName);
			}
			else{
				msj=playlists.get(pos).playAudio(audioName);
			}
		}
	return msj;
	}
	@Override
	public boolean validateIfSongCanbeBought(String songName){
		boolean isBought=false;
		int count=getBoughtSongs();
		if(SONGS_SIZE>count){
			setBougthSongs(count+1);
			isBought=true;
		}
		return isBought;

	}
}