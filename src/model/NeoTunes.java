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
		msj="New consumer standard added sucefully";
		return msj;
 	}
 	public String addSong(String productorUsername,int selectionTypeGenre, String name, String album, String albumURL, int duration, double ventValue ){
 		String msj="";
 		for (int i=0;i<users.size();i++){
 			if(users.get(i)!=null &&users.get(i) instanceof UserProductorArtist){		
				int playingTimes=0;
				int sellingTimes=0;
				Song newSong = new Song(selectionTypeGenre, name, album, albumURL, duration, ventValue, playingTimes,sellingTimes);
				if(((UserProductorArtist)(users.get(i))).addSong(newSong)==true){
					msj="The song "+ name + " has been added to the user "+ productorUsername;
					System.out.println((((UserProductorArtist)(users.get(i))).addSong(newSong)));
				}
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
 	public int validateIfUserConsumerExist(String consumerUsername){
 		int consumerPos=-1;
 		for (int i=0;i<users.size();i++ ) {
 			if(users.get(i)!=null){	
 				if(users.get(i) instanceof UserConsumer){
					if(((UserConsumer)(users.get(i))).getUsername().equals(consumerUsername)){
						consumerPos=i;
					}
 				}
 			}
 		}
 		return consumerPos;
 	}
 	public String addPlayListToUser(String consumerUsername, int selectionPlayList, String playListName){
 		String msj="The playList cannot be added";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		PlayList newPlayList = new PlayList(selectionPlayList,playListName);
		((UserConsumer)(users.get(posUser))).addPlayList(newPlayList);
 			if(((UserConsumer)(users.get(posUser))).addPlayList(newPlayList)==true){
 				msj="New playList added\n"+
 				(((UserConsumer)(users.get(posUser))).showCodePlaylist(newPlayList));
			}	
 	return msj;
 	}

 	public boolean validateIfPlaylistExist(String consumerUsername,String playListName){
 		boolean playListExist=false;
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		if(((UserConsumer)(users.get(posUser))).playlistPosByName(playListName)!=-1){
 			playListExist=true;
 		}
 		System.out.println(playListExist);
 		return playListExist;
 	} 
 	public String showInformationOfAudios(String consumerUsername,String playListName){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj=((UserConsumer)(users.get(posUser))).showInformation(playListName);
 		return msj;
 	}
 	public String showCodeWithMatriz(String consumerUsername, String playListName, String consumerUsernameToShare){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj="\n"+((UserConsumer)(users.get(posUser))).showCodeAndMatrizWithPlayListName(playListName)+"\n"+
 		"Playlist share successfully to the user"+ consumerUsernameToShare;
 		return msj;
 	}
 	//public String addAudiosToPlaylist(String consumerUsername, String playListCode, int selectionAudioToadd){	//}
}


