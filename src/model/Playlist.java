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
	public boolean addAudio(Audio audio){
		return audios.add(audio);
	}
	public String listAudios(){
		String msj="";
		for (int i=0;i<audios.size();i++ ) {
			msj=msj+audios.get(i).getName()+"\n";
		}
		return msj;
	}
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
	public boolean deleteAudio(String audioName){
		boolean isdelete=false;
		int pos=searchPosAudioByName(audioName);
		audios.remove(pos);
		isdelete=true;
		return isdelete;
	}
	public void setplayingTimesOfAudio(String audioName){
		int pos=searchPosAudioByName(audioName);
		System.out.println("Antes "+audios.get(pos).getPlayingTimes());
		int count=audios.get(pos).getPlayingTimes();
		audios.get(pos).setPlayingTimes(count+1);
		System.out.println("Despues " +audios.get(pos).getPlayingTimes());
	}
	public int totalTimesOfPlaylist(){
		int count=0;
		for (int i=0;i<audios.size() ;i++ ) {
			count=count+audios.get(i).getPlayingTimes();
		}
		return count;
	}
	public String playAudio(String audioName){
		int pos=searchPosAudioByName(audioName);
		return "Now listening\n"+
				audios.get(pos).getName()+"\n"+
				"The audio has finished";

	}
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

	public int numberTimesListenedRock(){
		int count=0;
		for (int i=0;i<audios.size();i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getSelectionTypeGenre()==1){
					count=count+((Song)(audios.get(i))).getPlayingTimes();
					System.out.println(count);
				}	
			}
		}
		return count;
	}

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

	// public String showSongsToAdd(){
	// 	String msj="";
	// 	for (int i=0;i<audios.size() ;i++ ) {
	// 		if(audios.get(i) instanceof Song){
	// 			msj=msj+audios.get(i).getName()+"\n";
	// 			System.out.println(audios.get(i).getName());
	// 		}			 
	// 	}
	// return msj;
	// }
	// public String showPodcastsToAdd(){
	// 	String msj="";
	// 	for (int i=0;i<audios.size() ;i++ ) {
	// 		if(audios.get(i) instanceof Podcast){
	// 			msj=msj+audios.get(i).getName()+"\n";
	// 		}			 
	// 	}
	// return msj;
	// } 
	// public String showBothPodcastAndSongs(){
	// 	String msj="";
	// 	for (int i=0;i<audios.size() ;i++ ) {
	// 		msj=msj+audios.get(i).getName()+"\n";
	// 	}
	// return msj;
	// }
}

