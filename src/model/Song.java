package model;
public class Song{
	
	private int selectionTypeGenre;
	private String name;
	private String album;
	private String albumURL;
	private int duration;
	private double ventValue;
	private int playingTimes;
	private int sellingTimes;
	private TypeGenre typeGenre;

	public Song(int selectionTypeGenre, String name, String album, String albumURL, int duration, double ventValue, int playingTimes, int sellingTimes ) {
		this.selectionTypeGenre=selectionTypeGenre;
		this.name=name;
		this.album = album;
		this.albumURL=albumURL;
		this.duration=duration;
		this.ventValue=ventValue;
		this.playingTimes=playingTimes;
		this.sellingTimes=sellingTimes;
		setTypeGenre();
	}
	public int getselectionTypeGenre() {
		return selectionTypeGenre;
	}
	public void setTypeGenre() {
		if(selectionTypeGenre==1){
		typeGenre=TypeGenre.ROCK;
		}	
		else if (selectionTypeGenre==2){
		typeGenre=TypeGenre.POP;		
		}
		else if (selectionTypeGenre==3){
		typeGenre=TypeGenre.TRAP;
		}
		else if(selectionTypeGenre==4){
		typeGenre=TypeGenre.HOUSE;
		}
	}
	public TypeGenre getTypeGenre(){
		return typeGenre;
	}
	public String getName() {
		return name;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album){
		this.album = album; 
	}
	public int getDuration() {
		return duration;
	}
	public double getVentValue(){
		return ventValue; 
	}
	public void setVentValue(double ventValue){
		this.ventValue=ventValue;
	}
	public int getPlayingTimes() {
		return playingTimes;
	}
	public void setPlayingTimes(int playingTimes){
		this.playingTimes=playingTimes;
	}
	public int getSellingTimes() {
		return sellingTimes;
	}
	public void setSellingTimes(int sellingTimes){
		this.sellingTimes=sellingTimes;
	}
}