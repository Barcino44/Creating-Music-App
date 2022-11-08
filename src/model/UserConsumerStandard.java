package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerStandard extends UserConsumer{

	public static final int PLAYLIST_SIZE = 20; 
	public static final int SONGS_SIZE = 100;
	public static final int ROWS_SIZE=6;
	public static final int COLUMNS_SIZE=6;
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
	public String showCodePlayList(PlayList playlist){
		int posAdded=posPlayList(playlist);
		int upperBound=9;
		int lowerBound=0;
		int range=(upperBound-lowerBound)+1;
		String msj="";
		if(posAdded!=-1){
			if(playlists.get(posAdded).getSelectionTypePlayList()==1){
        		for(int i = ROWS_SIZE-1; i>=0; i--){
           			matriz[i][0] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[i][0];
				}
				for (int i=1;i<ROWS_SIZE-1 ;i++ ) {
					for(int j=1; j<COLUMNS_SIZE-1; j++){
						matriz[i][j] =(int)(Math.random()*range)+lowerBound;
						if(i==j){
							msj=msj+matriz[i][j];
						}
					}
				}
				for(int i = ROWS_SIZE-1; i>=0; i--){
           			matriz[i][5] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[i][5];
            	}
			}
			else if(playlists.get(posAdded).getSelectionTypePlayList()==2){
				for(int j = 0; j<=2; j++){
					matriz[0][j] =(int)(Math.random()*range)+lowerBound;
					msj=msj+matriz[0][j];
				}		
				for (int i=1;i<ROWS_SIZE ;i++ ) {
					matriz[i][2] =(int)(Math.random()*range)+lowerBound;
					msj=msj+matriz[i][2];
				}
				for(int j=3; j<=3; j++){
           			matriz[5][j] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[5][j];
            	}
            	for(int i=4;i>=0;i--){
            		matriz[i][3] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[i][3];
            	}
            	for (int j=4;j<COLUMNS_SIZE;j++) {
            		matriz[0][j] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[0][j];
             	}
			}		
		}		
		return msj;
	}
}