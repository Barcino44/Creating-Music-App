package model;

public class Podcast extends Audio{
	private int selectionTypeCategory;
	private String description;
	private TypeCategory typeCategory;

	public Podcast(int selectionTypeCategory, String name, String description, String url, int duration, int playingTimes) {
		super(name, url, duration, playingTimes);
		this.selectionTypeCategory=selectionTypeCategory;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description){
		this.description = description; 
	}
}