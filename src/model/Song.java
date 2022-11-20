package model;
public class Song extends Audio{
	
	private int selectionTypeGenre;
	private String album;
	private double ventValue;
	private int sellingTimes;
	private TypeGenre typeGenre;

	public Song(int selectionTypeGenre, String name, String album, String url, int duration, double ventValue, int playingTimes, int sellingTimes) {
		super(name, url, duration, playingTimes);
		this.selectionTypeGenre=selectionTypeGenre;
		this.album = album;
		this.ventValue=ventValue;
		this.sellingTimes=sellingTimes;
		setTypeGenre();
	}
	public int getSelectionTypeGenre() {
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
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album){
		this.album = album; 
	}
	public double getVentValue(){
		return ventValue; 
	}
	public void setVentValue(double ventValue){
		this.ventValue=ventValue;
	}
	public int getSellingTimes() {
		return sellingTimes;
	}
	public void setSellingTimes(int sellingTimes){
		this.sellingTimes=sellingTimes;
	}
	public String getName(){
		return super.getName();
	}
	public int getPlayingTimes(){
		return super.getPlayingTimes();
	}
}