package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerPremium extends UserConsumer{
	private ArrayList<PlayList> playlists;
	private int[][] matriz;
	public static final int ROWS_SIZE = 6;
	public static final int COLUMNS_SIZE = 6;

	public UserConsumerPremium(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
		playlists= new ArrayList<PlayList>(10);
		matriz=new int[ROWS_SIZE][COLUMNS_SIZE];
	}
	public String getName(){
		return super.getUsername();
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
		int pos=-1;
		boolean isFound=false;
		for (int i=0;i<playlists.size()&&!isFound;i++ ) {
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
	public String playAudioInPlaylist(String playlistName,String audioName){
		String msj="";
		int pos=playlistPosByName(playlistName);
		if(playlists.get(pos).searchPosAudioByName(audioName)!=-1){
			// playlists.get(pos).setplayingTimesOfAudio(audioName);
			msj=playlists.get(pos).playAudio(audioName);
		}
	return msj;
	}
	@Override
	public boolean validateIfSongCanbeBought(String songName){
		return true;
	}
	@Override
	public String showMostListenedSongGenre(){
		String msj="";
		int countRock=0;
		int countPop=0;
		int countTrap=0;
		int countHouse=0;
		for (int i=0;i<playlists.size();i++ ) {
			countRock=playlists.get(i).numberTimesListenedRock();
			countPop=playlists.get(i).numberTimesListenedPop();
			countTrap=playlists.get(i).numberTimesListenedTrap();
			countHouse=playlists.get(i).numberTimesListenedHouse();
			if(countRock>countPop&&countRock>countTrap&&countRock>countHouse){
			msj="The most listened song genre is ROCK and it is listened " + countRock + " by the user " + getName();
			}
			else if(countPop>countTrap&&countPop>countHouse){
				msj="The most listened song genre is POP and it was listened " + countPop + "by the user" + getName();
			}
			else if(countTrap>countHouse){
				msj="The most listened song genre is TRAP and it was listened " + countTrap + "by the user" + getName();
			}
			else if(countHouse>countTrap){
			msj="The most listened treasure is HOUSE and it was listened " + countHouse + " by the user " + getName();
			}
			else{
			msj="There are several genre of songs that are the most listened by the user " + getName();
			}
		}
		return msj;
	}
}