package model;
import java.util.Date;
import java.util.ArrayList;

public class NeoTunes {

 	private ArrayList<User> users;
 	private ArrayList<Audio>audios;   

 	public NeoTunes(String name){
 		users= new ArrayList<User>(10);
 		audios=new ArrayList<Audio>(10);
 		Song newSong1 = new Song(1,"El_sol_no_regresa","Flores de alquiler","www.floresdealquiler.com",300,56,0,55);  //Free use song                                                                                        
		Song newSong2 = new Song(1,"De_musica_ligera","cancion animal","www.cancionAnimal.com",8,77,0,89);	//Free use song
		Podcast newPodcast1 = new Podcast(1,"El_Miedo_Al_Exito","Ven y te cuento de este maravilloso juego","www.JuanitoElGamer.com",46,0);  //Free use podcast
		Podcast newPodcast2 = new Podcast(3,"La_verdad_detras_de_los_ingenieros","Larga vida a los ingenieros","www.verdadIngeniera.com",8,0); //Free use podcast
		audios.add(newSong1);
		audios.add(newSong2);
		audios.add(newPodcast1);
		audios.add(newPodcast2);
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
				((UserProductorArtist)(users.get(i))).addSong(newSong);
				audios.add(newSong);
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
				audios.add(newPodcast);
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
 		return playListExist;
 	} 
 	public String showInformationOfAudios(String consumerUsername,String playListName){
 	 	String msj="";
 	 	int posUser=validateIfUserConsumerExist(consumerUsername);
 	 	for (int i=0;i<audios.size() ;i++ ) {
 	 		if(((UserConsumer)(users.get(posUser))).getTypePlaylist(playListName)==1){
				if(audios.get(i) instanceof Song){
					msj=msj+audios.get(i).getName()+"\n";
				}
			}
			else if(((UserConsumer)(users.get(posUser))).getTypePlaylist(playListName)==2){
				if(audios.get(i) instanceof Podcast){
					msj=msj+audios.get(i).getName()+"\n";
				}
			}
			else{
				msj=msj+audios.get(i).getName()+"\n";
			}			 
		}
 	 	return msj;
 	}
 	public boolean validateIfSelectedAudioExist(String consumerUsername,String playlistName,String selectedAudio){
 		boolean exist=false;
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		for (int i=0;i<audios.size() ;i++ ) {
 			if(((UserConsumer)(users.get(posUser))).getTypePlaylist(playlistName)==1){
 				if(audios.get(i) instanceof Song){
					if(audios.get(i).getName().equals(selectedAudio)){ 	
						exist=true;
					}
				}
			}
			else if(((UserConsumer)(users.get(posUser))).getTypePlaylist(playlistName)==2){
				if(audios.get(i) instanceof Podcast){
					if(audios.get(i).getName().equals(selectedAudio)){ 	
						exist=true;
					}
				}
			}
			else{
				if(audios.get(i).getName().equals(selectedAudio)){ 	
					exist=true;
				}
			}
		}
		return exist;
	}

	public String addAudiosToPlaylist(String consumerUsername, String playlistName, String selectedAudio){
		String msj="";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i).getName().equals(selectedAudio)){
				Audio newAudiotoPlayList=(audios.get(i));//.getselectionTypeCategory(),audios.get(i).getName(),audios.get(i).getDescription(),audios.get )
				if(((UserConsumer)(users.get(posUser))).addAudiotoPlayList(playlistName,newAudiotoPlayList)==true){
					msj="The audio "+selectedAudio+" was added successfully to the playlist "+playlistName+" of the consumer " + consumerUsername;
				}
			}
		}
		return msj;
	}

	public String showAudiosAddedInPlaylist(String consumerUsername, String playlistName){
		String msj="";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		msj=(((UserConsumer)(users.get(posUser))).showAudiosAddedInPlaylist(playlistName));
		return msj;
	}
	public String deleteAudioInPlaylist(String consumerUsername, String playlistName, String audioName){
		String msj="The audio "+audioName +" cannot be deleted to the playlist "+ playlistName+ " of the consumer "+consumerUsername;
		int posUser=validateIfUserConsumerExist(consumerUsername);
		if(((UserConsumer)(users.get(posUser))).deleteAudioInPlaylist(playlistName,audioName)==true){
			msj="The audio "+audioName+" has been deleted to the playlist "+playlistName+" of the consumer "+ consumerUsername;
		}
		return msj;
	}

	public String playAudioInPlaylist(String consumerUsername, String playlistName, String selectedAudio){
		String msj="";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		if((((UserConsumer)(users.get(posUser))).playAudioInPlaylist(playlistName,selectedAudio)!=""))
			msj=(((UserConsumer)(users.get(posUser))).playAudioInPlaylist(playlistName,selectedAudio));
		else{
			msj="The audio cannot be played";
		}
		return msj;
	}

 	public String showCodeWithMatriz(String consumerUsername, String playListName, String consumerUsernameToShare){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj="\n"+((UserConsumer)(users.get(posUser))).showCodeAndMatrizWithPlayListName(playListName)+"\n"+
 		"Playlist share successfully to the user "+ consumerUsernameToShare;
 		return msj;
 	}
}


