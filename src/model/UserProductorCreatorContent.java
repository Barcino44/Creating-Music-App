package model;
import java.util.Date;
import java.util.ArrayList;
public class UserProductorCreatorContent extends UserProductor{

	private ArrayList<Podcast> podcasts;
	
	public UserProductorCreatorContent(String username, String id, Date vinculationDate, String url) {
		super(username, id, vinculationDate, url);
		podcasts=new ArrayList<Podcast>(10);
	}
	public boolean addPodcast(Podcast podcast){
		boolean isAdded=podcasts.add(podcast);
		return isAdded;
	}
}	