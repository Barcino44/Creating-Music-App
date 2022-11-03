package model;

public class Podcast{
	
	private int selectionTypeCategory;
	private String name;
	private String description;
	private String url;
	private int duration;
	private int playingTimes;
	private TypeCategory typeCategory;

	public Podcast(int selectionTypeCategory, String name, String description, String url, int duration, int playingTimes) {
		this.selectionTypeCategory=selectionTypeCategory;
		this.name=name;
		this.description = description;
		this.url=url;
		this.duration=duration;
		this.playingTimes=playingTimes;
		setTypeCategory();
	}
	public int getselectionTypeCategory() {
		return selectionTypeCategory;
	}
	public void setTypeCategory() {
		if(selectionTypeCategory==1){
		typeCategory=TypeCategory.POLITICS;
		}	
		else if (selectionTypeCategory==2){
		typeCategory=TypeCategory.ENTERTAINMENT;		
		}
		else if (selectionTypeCategory==3){
		typeCategory=TypeCategory.VIDEOGAMES;
		}
		else if(selectionTypeCategory==4){
		typeCategory=TypeCategory.FASHION;
		}
	}
	public TypeCategory getTypeCategory(){
		return typeCategory;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description){
		this.description = description; 
	}
	public int getDuration() {
		return duration;
	}
	public int getPlayingTimes() {
		return playingTimes;
	}
	public void setPlayingTimes(int playingTimes){
		this.playingTimes=playingTimes;
	}
}