package model;

public abstract class Audio{

	private String name;
	private String url;
	private int duration;
	private int playingTimes;

	public Audio(String name, String url, int duration, int playingTimes) {
		this.name=name;
		this.url=url;
		this.duration=duration;
		this.playingTimes=playingTimes;
	}
	public String getName(){
		return name;
	}
	public void setName(String username){
		this.name=name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String id) {
		this.url = url;
	}
	public int getDuration(){
		return duration;
	}
	public int getPlayingTimes(){
		return playingTimes;
	}
	public void setPlayingTimes(int playingTimes){
		this.playingTimes=playingTimes;
	}
}