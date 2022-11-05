package model;
import java.util.Date;
import java.util.ArrayList;
import java.lang.Math;
public class UserConsumerPremium extends UserConsumer{
	public static final int ROWS_SIZE=6;
	public static final int COLUMNS_SIZE=6;
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
	public String showCodePlayListSong(PlayList playlist){
		int posAdded=posPlayList(playlist);
		int upperBound=9;
		int lowerBound=0;
		int range=(upperBound-lowerBound)+1;
		String msj="";
		if(posAdded!=-1){
			if(playlists.get(posAdded).getSelectionTypePlayList()==1){
        		for(int j = COLUMNS_SIZE-1; j>=0; j--){
           			matriz[5][j] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[5][j];
				}
				for (int i=0;i<ROWS_SIZE ;i++ ) {
					for(int j=0; i<COLUMNS_SIZE; i++){
						matriz[i][j] = (int)(Math.random()*range)+lowerBound;
						if(i==j){
							msj=msj+matriz[i][j];
						}
					}
				}
				for(int j = COLUMNS_SIZE-1; j>=0; j--){
           			matriz[5][j] = (int)(Math.random()*range)+lowerBound;
            		msj= msj+ matriz[5][j];
            	}
			}
		}		
		return msj;
	}
}