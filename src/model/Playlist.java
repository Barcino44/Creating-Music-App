package model;
public class PlayList{
	
	private int selectionTypePlayList;
	private String playListName;
	private TypePlayList typePlayList;

	public PlayList(int selectionTypePlayList, String playListName){
		this.selectionTypePlayList=selectionTypePlayList;
		this.playListName=playListName;
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
}