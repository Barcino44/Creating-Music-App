package model;
import java.util.Date;
import java.util.ArrayList;

public class NeoTunes {

 	private ArrayList<User> users;

 	public NeoTunes(String name){
 		users= new ArrayList<User>(10);
 	}

 	public String addUserProductArtist(String username, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorArtist newProductorArtist = new UserProductorArtist(username, id, vinculationDate, url);
		users.add(newProductorArtist);
		msj="New Artist added sucefully";
		return msj;
	}
	public String addUserProductCreatorContent(String username, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorCreatorContent newProductorCreatorContent = new UserProductorCreatorContent(username, id, vinculationDate, url);
		users.add(newProductorCreatorContent);
		msj="New creator content added sucefully";
		return msj;
 	}
 	public String addUserConsumerPremium(String username, String id){
 		String msj="";
		Date vinculationDate = new Date();
		UserConsumerPremium newConsumerPremium = new UserConsumerPremium(username, id, vinculationDate);
		users.add(newConsumerPremium);
		msj="New consumer premium added sucefully";
		return msj;
 	}
 	public String addUserConsumerStandard(String username, String id){
 		String msj="";
		Date vinculationDate = new Date();
		UserConsumerStandard newConsumerEstandard = new UserConsumerStandard(username, id, vinculationDate);
		users.add(newConsumerEstandard);
		msj="New consumer premium added sucefully";
		return msj;
 	}
 	public String addSong(String productorUsername,int selectionTypeGenre, String name, String album, String albumURL, int duration, double ventValue ){
 		String msj="";
 		for (int i=0;i<users.size();i++){
 			if(users.get(i)!=null &&users.get(i) instanceof UserProductorArtist){		
			int playingTimes=0;
			int sellingTimes=0;
			Song newSong = new Song(selectionTypeGenre, name, album, albumURL, duration, ventValue, playingTimes,sellingTimes);
			((UserProductorArtist)(users.get(i))).addSong(newSong);
			msj="The song "+ name + " has been added to the user "+ productorUsername;
			}
		}
 		return msj;
 	}
 	public boolean validateIfArtistExist(String productorUsername){
 		boolean artistExist=false;
 		for (int i=0;i<users.size()&&!artistExist;i++ ) {
 			if(users.get(i)!=null&&users.get(i) instanceof UserProductorArtist){	
				if(((UserProductorArtist)(users.get(i))).getUsername().equals(productorUsername)){
					artistExist=true;
				}
 			}
 		}
 		return artistExist;
 	}
 	public String addPodcast(String productorUsername,int selectionTypeCategory, String name, String description, String url, int duration){
 		String msj="";
 		for (int i=0;i<users.size();i++){
 			if(users.get(i)!=null &&users.get(i) instanceof UserProductorCreatorContent){		
			int playingTimes=0;
			Podcast newPodcast = new Podcast(selectionTypeCategory, name, description, url, duration, playingTimes);
			((UserProductorCreatorContent)(users.get(i))).addPodcast(newPodcast);
			msj="The podcast "+ name + " has been added to the user "+ productorUsername;
			}
		}
 		return msj;
 	}
 	public boolean validateIfCreatorContentExist(String productorUsername){
 		boolean creatorContentExist=false;
 		for (int i=0;i<users.size()&&!creatorContentExist;i++ ) {
 			if(users.get(i)!=null&&users.get(i) instanceof UserProductorCreatorContent){	
				if(((UserProductorCreatorContent)(users.get(i))).getUsername().equals(productorUsername)){
					creatorContentExist=true;
				}
 			}
 		}
 		return creatorContentExist;
 	}
}


