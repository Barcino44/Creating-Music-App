package model;
import java.util.ArrayList;
public class PlayList{
	public static final int ROWS_SIZE=6;
	public static final int COLUMNS_SIZE=6;
	
	private int selectionTypePlayList;
	private String playListName;
	private TypePlayList typePlayList;
	private ArrayList<Audio> audios;
	private int[][] matriz;

	public PlayList(int selectionTypePlayList, String playListName){
		this.selectionTypePlayList=selectionTypePlayList;
		this.playListName=playListName;
		matriz= new int[ROWS_SIZE][COLUMNS_SIZE];
		audios= new ArrayList<Audio>(10);
	}
	public int getSelectionTypePlayList() {
		return selectionTypePlayList;
	}
	public void setTypePlayList() {
		if(selectionTypePlayList==1){
			typePlayList=TypePlayList.SONG;
		}	
		else if (selectionTypePlayList==2){
			typePlayList=TypePlayList.PODCAST;		
		}
		else if (selectionTypePlayList==3){
			typePlayList=TypePlayList.BOTH;
		}
	}
	public TypePlayList getTypePlayList(){
		return typePlayList;
	}
	public String getPlayListName(){
		return playListName;
	}
	/**
	 * fillMatriz: It fills the matriz of the playlist
	 * @return matriz: int[][] - It is the matriz fill.
	 */
	public int[][] fillMatriz(){
		int upperBound=9;
		int lowerBound=1;
		int range=(upperBound-lowerBound)+1;
		for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
				if (matriz[i][j]==0) {
					matriz[i][j]= (int)(Math.random() * range) + lowerBound;
				}
			}
		}	
		return matriz; 
	}
	/**
	 * showMatrizPlaylist: It shows the matriz of the playlist.
	 * @return msj - String: It is the matriz printed.
	 */
	public String showMatrizPlaylist(){
		//Print matriz
		String msj="";
		int[][] matrizFill=fillMatriz();
		 for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
		 		msj=msj+"|"+matrizFill[i][j];
		 		if(j==5){
		 			msj=msj+"\n";
		 		}
		 	}
		 }
	return msj;
	}
	/**
	 * showCodePlaylist: It shows the code of the playlist using the matriz.
	 * @return msj: String - It is the matriz of the playlist.
	 */
	public String showCodePlaylist(){
		String msj="";
		int[][] matrizFill=fillMatriz();
		msj="The playlistCode is: \n";
		if(getSelectionTypePlayList()==1){
	    		for(int i = ROWS_SIZE-1; i>=0; i--){
	           		msj=msj+ matrizFill[i][0];
				}
				for (int i=1;i<ROWS_SIZE-1 ;i++ ) {
					for(int j=1; j<COLUMNS_SIZE-1; j++){
						if(i==j){
							msj=msj+matrizFill[i][j];
						}
					}
				}
				for(int i = ROWS_SIZE-1; i>=0; i--){
            		msj= msj+ matrizFill[i][5];
            	}
            }
			else if(getSelectionTypePlayList()==2){
				for(int j = 0; j<=2; j++){
					msj=msj+matrizFill[0][j];
				}		
				for (int i=1;i<ROWS_SIZE ;i++ ) {
					msj=msj+matrizFill[i][2];
				}
				for(int j=3; j<=3; j++){
            		msj= msj+ matrizFill[5][j];
            	}
            	for(int i=4;i>=0;i--){
            		
            		msj= msj+ matrizFill[i][3];
            	}
            	for (int j=4;j<COLUMNS_SIZE;j++) {
            		msj= msj+ matrizFill[0][j];
             	}
			}
			else{
				for (int i=ROWS_SIZE-1;i>=0;i-- ) {
					for (int j=COLUMNS_SIZE-1;j>=0;j--) {	
						if (((i+j)%2!=0)&&((i+j)!=1)){
							msj=msj+matrizFill[i][j];
						}
					}
				}
			}
	return msj;
	}
	/**
	 * addAudio: It adds an audio in the playlist.
	 * @param  audio: Audio - It represents the audio that is going to be added.
	 * @return boolean.
	 */
	public boolean addAudio(Audio audio){
		return audios.add(audio);
	}
	/**
	 * listAudios: It list the audios of the playlist.
	 * @return msj: String - It represents the list of audios.
	 */
	public String listAudios(){
		String msj="";
		for (int i=0;i<audios.size();i++ ) {
			msj=msj+audios.get(i).getName()+"\n";
		}
		return msj;
	}
	/**
	 * searchPosAudioByName: It search the position of an audio using the name.
	 * @param  audioName: String - It represents the name of the audio.
	 * @return pos: int - It represents the position of the audio.
	 */
	public int searchPosAudioByName(String audioName){
		boolean isFound=false;
		int pos=-1;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i).getName().equals(audioName)){
				pos=i;
				isFound=true;
			}
		}
		return pos;
	}
	/**
	 * deleteAudio: It deletes the audio of a playlist using the name.
	 * @param  audioName: String - It represents the name of the audio.
	 * @return isdelete: boolean.
	 */
	public boolean deleteAudio(String audioName){
		boolean isdelete=false;
		int pos=searchPosAudioByName(audioName);
		audios.remove(pos);
		isdelete=true;
		return isdelete;
	}
	/**
	 * totalTimesListenedAudioInPlayList: It represents the total times of the audios has been play in the playlist.
	 * @return count: int - It represents the number of times that the audios has been played.
	 */
	public int totalTimesListenedAudioInPlayList(){
		int count=1;
		for (int i=0;i<audios.size() ;i++ ) {
			count=count+audios.get(i).getPlayingTimes();
		}
		return count;
	}
	/**
	 * playAudio: It plays an audio in the playlist.
	 * @param audioName: String - It represents the name of the audio.
	 * @return String: It is a message that shows the audio reproduction.
	 */
	public String playAudio(String audioName){
		int count=0;
		int pos=searchPosAudioByName(audioName);
		count=audios.get(pos).getPlayingTimes();
		audios.get(pos).setPlayingTimes(count+1);
		return "Now listening\n"+
				audios.get(pos).getName()+"\n"+
				"The audio has finished";
	}
	/**
	 * showTypeAudiotoPlay: It shows the type of audio that will played.
	 * @param audioName: String - It represents the name of the audio.
	 * @return int: typeAudio: int - It represents one of the possible types of audios.
	 */
	public int showTypeAudiotoPlay(String audioName){
		int typeAudio=-1;
		int pos=searchPosAudioByName(audioName);
		if(audios.get(pos)instanceof Song){
			typeAudio=1;
		}
		else{
			typeAudio=2;
		}
		return typeAudio;
	}
	/**
	 * numberTimesListenedRock: It represents the number of times that the song genre ROCK has been played in the playlist.
	 * @return count: int - It represents the number of times that ROCK has been played. 
	 */
	public int numberTimesListenedRock(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.ROCK){
					count=count+((Song)(audios.get(i))).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedPop: It represents the number of times that the song genre POP has been played in the playlist.
	 * @return count: int - It represents the number of times that POP has been played. 
	 */
	public int numberTimesListenedPop(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.POP){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedTrap: It represents the number of times that the song genre TRAP has been played in the playlist.
	 * @return count: int - It represents the number of times that TRAP has been played. 
	 */
	public int numberTimesListenedTrap(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.TRAP){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedHouse: It represents the number of times that the song genre HOUSE has been played in the playlist.
	 * @return count: int - It represents the number of times that HOUSE has been played. 
	 */
	public int numberTimesListenedHouse(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.HOUSE){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedPolitic: It represents the number of times that the podcast category POLITICS has been played in the playlist.
	 * @return count: int - It represents the number of times that POLITICS has been played. 
	 */
	public int numberTimesListenedPolitic(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Podcast){
				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.POLITICS){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedEntertainment: It represents the number of times that the podcast category ENTERTAINMENT has been played in the playlist.
	 * @return count: int - It represents the number of times that ENTERTAINMENT has been played. 
	 */
	public int numberTimesListenedEntertaiment(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Podcast){
				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.ENTERTAINMENT){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedVideogame: It represents the number of times that the podcast category VIDEOGAMES has been played in the playlist.
	 * @return count: int - It represents the number of times that VIDEOGAMES has been played. 
	 */
	public int numberTimesListenedVideogame(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Podcast){
				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.VIDEOGAMES){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}
	/**
	 * numberTimesListenedFashion: It represents the number of times that the podcast category FASHION has been played in the playlist.
	 * @return count: int - It represents the number of times that FASHION has been played. 
	 */
	public int numberTimesListenedFashion(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Podcast){
				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.FASHION){
					count=count+audios.get(i).getPlayingTimes();
				}	
			}
		}
		return count;
	}

}

