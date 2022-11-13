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
		Song newSong1 = new Song(1,"Numb","jk","yujik",46,56,485,55);
		Song newSong2 = new Song(2,"De musica Ligera","62","6",8,77,8,89);
		audios.add(newSong1);
		audios.add(newSong2);
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
	public String showSongsToAdd(){
		String msj="";
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i) instanceof Song){
				msj=msj+audios.get(i).getName()+"\n";
			}			 
		}
	return msj;
	}
	public String showPodcastsToAdd(){
		String msj="";
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i) instanceof Podcast){
				msj=msj+audios.get(i).getName()+"\n";
			}			 
		}
	return msj;
	} 
	public String getCodePlaylist(){
		return showCodePlaylist();
	}
	public String showBothPodcastAndSongs(){
		String msj="";
		for (int i=0;i<audios.size() ;i++ ) {
			msj=msj+audios.get(i).getName()+"\n";
		}
	return msj;
	}
}

