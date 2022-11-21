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
	/**
	 * getPlayingTimesOfPodcast: It represents the number times that the podcasts of the creator content has been played.
	 * @return countPlayingTimesSongs: int - It is the number of times that the podcasts of the creator content has been played.
	 */
	public int getPlayingTimesOfPodcast(){
		int countPlayingTimesSongs=0;
		for (int i=0;i<podcasts.size();i++ ) {
			countPlayingTimesSongs=countPlayingTimesSongs+podcasts.get(i).getPlayingTimes();
		}
		return countPlayingTimesSongs;
	}
}	