package model;
import java.util.Date;
import java.util.ArrayList;

public class NeoTunes {

 	private ArrayList<User> users;
 	private ArrayList<Audio>audios;   

 	public NeoTunes(String name){
 		users= new ArrayList<User>(10);
 		audios=new ArrayList<Audio>(10);
 		Song newSong1 = new Song(2  ,"El_sol_no_regresa","Flores de alquiler","www.floresdealquiler.com",300,56,0,0);  //Free use song                                                                                        
		Song newSong2 = new Song(1,"De_musica_ligera","cancion animal","www.cancionAnimal.com",350,70,0,0);	//Free use song
		Podcast newPodcast1 = new Podcast(1,"El_miedo_al_exito","Son pocas las personas que se enfrentan a este miedo","www.AdiosAlMiedo.com",2000,0);  //Free use podcast
		Podcast newPodcast2 = new Podcast(4,"La_verdad_detras_de_los_ingenieros","Larga vida a los ingenieros","www.verdadIngeniera.com",1500,0); //Free use podcast
		audios.add(newSong1);
		audios.add(newSong2);
		audios.add(newPodcast1);
		audios.add(newPodcast2);
 	}
 	/**
 	 * validateIfAnUserAlreadyExist: It validates if a user already exist.
 	 * @param username: String - It represents the name of the user. 
 	 * @return userExist: boolean - It validates if a user with this name already exist. 
 	 */
 	public boolean validateIfAnUserAlreadyExist(String username){
 		boolean userExist=false;
 		for (int i=0;i<users.size();i++ ) {
 			if(users.get(i).getUsername().equals(username)){
 				userExist=true;
 			}
 		}
 		return userExist;
 	}
 	/**
 	 * addUserProductorArtist: It adds an artist.
 	 * @param  username: String - It represents the name of the user.
 	 * @param  id: String - It represents the id of the user.
 	 * @param  url: String - It represents the url of the user artist.
 	 * @return msj: String - It is a confirmation that show that the artist could be added.
 	 */
 	public String addUserProductArtist(String username, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorArtist newProductorArtist = new UserProductorArtist(username, id, vinculationDate, url);
		users.add(newProductorArtist);
		msj="New Artist added sucefully";
		return msj;
	}
	/**
	 * addUserProductorCreatorContent: It adds a creator content.
	 * @param  username: String - It represents the name of the user.
 	 * @param  id: String - It represents the id of the user.
 	 * @param  url: String - It represents the url of the user artist.
	 * @return msj: String - It is a confirmation that show that the creator content could be added.
	 */
	public String addUserProductCreatorContent(String username, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorCreatorContent newProductorCreatorContent = new UserProductorCreatorContent(username, id, vinculationDate, url);
		users.add(newProductorCreatorContent);
		msj="New creator content added sucefully";
		return msj;
 	}
 	/**
 	 * addUserConsumerPremium: It adds a consumer premium.
 	 * @param  username: String - It represents the name of the user.
 	 * @param  id: String - It represents the id of the user.
 	 * @return msj: String - It is a confirmation that show that the consumer premium could be added.
 	 */
 	public String addUserConsumerPremium(String username, String id){
 		String msj="";
		Date vinculationDate = new Date();
		UserConsumerPremium newConsumerPremium = new UserConsumerPremium(username, id, vinculationDate);
		users.add(newConsumerPremium);
		msj="New consumer premium added sucefully";
		return msj;
 	}
 	/**
 	 * addUserConsumerStandard: It adds a consumerStandard.
 	 * @param  username: String - It represents the name of the user.
 	 * @param  id: String - It represents the id of the user.
 	 * @return msj: String - It is a confirmation that show that the consumer standard could be added.
 	 */
 	public String addUserConsumerStandard(String username, String id){
 		String msj="";
		Date vinculationDate = new Date();
		int bougthSongs=0;
		UserConsumerStandard newConsumerEstandard = new UserConsumerStandard(username, id, bougthSongs, vinculationDate);
		users.add(newConsumerEstandard);
		msj="New consumer standard added sucefully";
		return msj;
 	}
 	/**
 	 * addSong: It adds a song.
 	 * @param  productorUsername:  String - It represents the name of the productor (in this case artist).
 	 * @param  selectionTypeGenre: int - It represents the selection of genre of song.
 	 * @param  name: String - It epresents the name of the song.
 	 * @param  album: String - It represents the album of the song.
 	 * @param  albumURL: String - It represents the url of album of the song.
 	 * @param  duration: int - It represents the duration of the song.
 	 * @param  ventValue: double - It represents the vent value of the song.
 	 * @return msj: String - It is a confirmation that shows that the song could be added.
 	 */
 	public String addSong(String productorUsername,int selectionTypeGenre, String name, String album, String albumURL, int duration, double ventValue ){
 		String msj="";
 		for (int i=0;i<users.size();i++){
 			if(users.get(i) instanceof UserProductorArtist){
				if(users.get(i).getUsername().equals(productorUsername)){		
					int playingTimes=0;
					int sellingTimes=0;
					Song newSong = new Song(selectionTypeGenre, name, album, albumURL, duration, ventValue, playingTimes,sellingTimes);
					((UserProductorArtist)(users.get(i))).addSong(newSong);
					audios.add(newSong);
					msj="The song "+ name + " has been added to the user "+ productorUsername;
				}
			}	
		}
 		return msj;
 	}
 	/**
 	 * validateIfArtistExist: It validates if an artist exist.
 	 * @param  productorUsername: String - It represents the name of the productor (in this case artist).
 	 * @return artistExist: boolean - It shows if the artist exist.
 	 */
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
 	/**
 	 * addPodcast: It adds a podcast.
 	 * @param productorUsername:  String - It represents the name of the productor (in this case creator content).
 	 * @param  selectionTypeCategory: int - It represents the selection of category of podcast.
 	 * @param  name: String - It represents the name of the podcast.
 	 * @param  description: String - It represents the description of the podcast.
 	 * @param  url: String - It represents the url of the podcast.
 	 * @param  duration: int - It represents the duration of the podcast.
 	 * @return msj: String - It is a confirmation that shows that the song could be added.
 	 */
 	public String addPodcast(String productorUsername,int selectionTypeCategory, String name, String description, String url, int duration){
 		String msj="";
 		for (int i=0;i<users.size();i++){
 			if(users.get(i)!=null &&users.get(i) instanceof UserProductorCreatorContent){
 				if(users.get(i).getUsername().equals(productorUsername)){		
					int playingTimes=0;
					Podcast newPodcast = new Podcast(selectionTypeCategory, name, description, url, duration, playingTimes);
					((UserProductorCreatorContent)(users.get(i))).addPodcast(newPodcast);
					audios.add(newPodcast);
					msj="The podcast "+ name + " has been added to the user "+ productorUsername;
				}
			}
		}
 		return msj;
 	}
 	/**
 	 * validateIfCreatorContentExist: It validates if creator content exist.
 	 * @param  productorUsername: String - It represents the name of the productor (in this case creator content).
 	 * @return creatorContentExist: boolean - It validates if the creator content exist.
 	 */
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
 	/**
 	 * validateIfConsumerExist: It validates if a user consumer exist.
 	 * @param  consumerUsername: String - It represents the name of the consumer.
 	 * @return consumerPos: int - it represents the position of the consumer in the arraylist.
 	 */
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
 	/**
 	 * addPlaylistToUser: It adds a playlist to a user consumer.
 	 * @param  consumerUsername: String - It represents the name of the user consumer.
 	 * @param  selectionPlayList: int - It represents the selection of playlist that the user wants to add.
 	 * @param  playListName: String - It represents the name of the playlist.
 	 * @return msj: String - It is a confirmation (with code) that shows that the playlist could be added.
 	 */
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
 	/**
 	 * validateIfPlaylistExist: It validates if a playlist exist.
 	 * @param  consumerUsername: String - It represents the name of the user consumer. 
 	 * @param  playListName: String - It represents the name of the playlist.
 	 * @return playlistExist: boolean - It validates if a playlist exist.
 	 */
 	public boolean validateIfPlaylistExist(String consumerUsername,String playListName){
 		boolean playListExist=false;
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		if(((UserConsumer)(users.get(posUser))).playlistPosByName(playListName)!=-1){
 			playListExist=true;
 		}
 		return playListExist;
 	}
 	/**
 	 * showInformationOfAudios: It shows the possible audios to add in the playlist.
 	 * @param  consumerUsername: String - It represents the name of the user consumer. 
 	 * @param  playListName: String - It represents the name of the playlist.
 	 * @return msj: String - It represents the possible audios to add in the playlist.
 	 */
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
 	/**
 	 * validateIfSelectedAudioExist: It validates if a selected audio exist.
 	 * @param  consumerUsername: String - It represents the name of the user consumer.
 	 * @param  playlistName: String - It represents the name of the playlist.
 	 * @param  selectedAudio: String - It represents the user's selection of audio.  
 	 * @return exist: boolean - It validates if the user's selection of audio exist. 
 	 */
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
	/**
	 * addAudioToPlaylist: It adds an audio in a playlist.	
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @param  playlistName: String - It represents the name of the playlist.
	 * @param  selectedAudio: String - It represents the user's selection of audio. 
	 * @return msj: String - It is a confirmation that shows that the playlist could be added.
	 */
	public String addAudiosToPlaylist(String consumerUsername, String playlistName, String selectedAudio){
		String msj="";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i).getName().equals(selectedAudio)){
				Audio newAudiotoPlayList=(audios.get(i));
				if(((UserConsumer)(users.get(posUser))).addAudiotoPlayList(playlistName,newAudiotoPlayList)==true){
					msj="The audio "+selectedAudio+" was added successfully to the playlist "+playlistName+" of the consumer " + consumerUsername;
				}
			}
		}
		return msj;
	}
	/**
	 * showAudiosAddedInPlaylist: It shows the audios added in a playlist.	
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @param  playlistName: String - It represents the name of the playlist.
	 * @return msj: String - It represents the audios added in the playlist.
	 */
	public String showAudiosAddedInPlaylist(String consumerUsername, String playlistName){
		String msj="";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		msj=(((UserConsumer)(users.get(posUser))).showAudiosAddedInPlaylist(playlistName));
		return msj;
	}
	/**
	 * deleteAudioInPlaylist: It deletes an audio in a playlist.
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @param  playlistName: String - It represents the name of the playlist.
	 * @param  audioName: String - It represents the name of the audio.
	 * @return msj: String - It is a confirmation that shows that the audio could be deleted.
	 */
	public String deleteAudioInPlaylist(String consumerUsername, String playlistName, String audioName){
		String msj="The audio "+audioName +" cannot be deleted to the playlist "+ playlistName+ " of the consumer "+consumerUsername;
		int posUser=validateIfUserConsumerExist(consumerUsername);
		if(((UserConsumer)(users.get(posUser))).deleteAudioInPlaylist(playlistName,audioName)==true){
			msj="The audio "+audioName+" has been deleted to the playlist "+playlistName+" of the consumer "+ consumerUsername;
		}
		return msj;
	}
	/**
	 * playAudioInPlaylist: It plays an audio in a playlist.	
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @param  playlistName: String - It represents the name of the playlist.
	 * @param  selectedAudio: String - It represents the user's selection of audio. 
	 * @return msj: String - It is a message that shows that the audio is being played.
	 */
	public String playAudioInPlaylist(String consumerUsername, String playlistName, String selectedAudio){
		String msj="The audio cannot be played";
		int posUser=validateIfUserConsumerExist(consumerUsername);
		msj=(((UserConsumer)(users.get(posUser))).playAudioInPlaylist(playlistName,selectedAudio));
		return msj;
	}
	/**
	 * showCodeWithMatriz: It shows the code and the matriz of a playlist.
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @param  playListName: String - It represents the name of the playlist.
	 * @param  consumerUsernameToShare: String - It represents the name of the user who the playlist will be share.
	 * @return msj: String - It represents the matriz and the code of a playlist.
	 */
 	public String showCodeWithMatriz(String consumerUsername, String playListName, String consumerUsernameToShare){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj="\n"+((UserConsumer)(users.get(posUser))).showCodeAndMatrizWithPlayListName(playListName)+"\n"+
 		"Playlist share successfully to the user "+ consumerUsernameToShare;
 		return msj;
 	}
 	/**
 	 * showSongsToBuy: It shows the possible songs to add.
 	 * @return msj: String - It represents the possible songs to add.
 	 */
 	public String showSongsToBuy(){
 		String msj="";
 		for (int i=0;i<audios.size();i++) {
 			if(audios.get(i) instanceof Song){
 				msj=msj+"\n"+audios.get(i).getName();
 			}
 		}
 		return msj;
 	}
 	/**
 	 * validateIfSelectedSongExist: It validates if the song selected by user exist.
 	 * @param  nameSong: String - It represents the selection of the song.
 	 * @return songExist: boolean - It validates if the song exist.
 	 */
 	public boolean validateIfSelectedSongExist(String nameSong){
 		boolean songExist=false;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i)instanceof Song){
 				if(audios.get(i).getName().equals(nameSong)){
 					songExist=true;
 				}
 			}
 		}
 		return songExist;
 	}
 	/**
 	 * buySong: It buys a song.
 	 * @param  consumerUsername: String - It represents the name of the user consumer.
 	 * @param  nameSong: String - It represents the selection of the song.
 	 * @return msj: String - It is a confirmation that shows that the song could be bought.
 	 */
 	public String buySong(String consumerUsername, String nameSong){
 		String msj="The song cannot be bought";
 		int count=0;
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		if(((UserConsumer)(users.get(posUser))).validateIfSongCanbeBought(nameSong)==true){
 			for (int i=0;i<audios.size();i++ ) {
 				if(audios.get(i)instanceof Song){
 					if(audios.get(i).getName().equals(nameSong)){
 						count=(((Song)(audios.get(i))).getSellingTimes());
 						((Song)(audios.get(i))).setSellingTimes(count+1);
 						msj="The song "+nameSong+" has been bought by the user "+consumerUsername;
 					}
 				}
 			}	
 		}
  	return msj;
 	}
 	/**
 	 * totalRepreductionAudios: It represents the total reproductions of audios in the platform.
 	 * @return msj: String - It shows the number of audios played in the platform. 
 	 */
 	public String totalReproductionAudios(){
 		String msj="";
 		int count=0;
 		for (int i=0;i<audios.size();i++) {
 			count=count+audios.get(i).getPlayingTimes();
 			msj="The quantity of audios played in the platform are "+ count;
 		}
 		return msj;
 	}
 	/**
 	 * showMostListenedSongGenreInUser: It represents the most listened song genre of an user.
 	 * @param  consumerUsername: String - It represents the name of the user consumer.
 	 * @return msj: String - It represents the most listened genre of song of an user and its times listened.
 	 */
 	public String showMostListenedSongGenreInUser(String consumerUsername){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj=((UserConsumer)(users.get(posUser))).showMostListenedSongGenre();
 		return msj;
 	}
 	/**
 	 * countTimesListenedRockInPlatform: It represents the number of times listened the song genre ROCK in the platform.
 	 * @return count: int - It represents the number of times listened ROCK.
 	 */
 	public int countTimesListenedRockInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Song){
 				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.ROCK){
 					count=count+((Song)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedPopInPlatform: It represents the number of times listened the song genre POP in the platform.
 	 * @return count: int - It represents the number of times listened POP.
 	 */
 	public int countTimesListenedPopInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Song){
 				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.POP){
 					count=count+((Song)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedTrapInPlatform: It represents the number of times listened the song genre TRAP in the platform.
 	 * @return count: int - It represents the number of times listened TRAP.
 	 */
 	public int countTimesListenedTrapInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Song){
 				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.TRAP){
 					count=count+((Song)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedHouseInPlatform: It represents the number of times listened the song genre HOUSE in the platform.
 	 * @return count: int - It represents the number of times listened HOUSE.
 	 */
 	public int countTimesListenedHouseInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Song){
 				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.HOUSE){
 					count=count+((Song)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * showMostListenedSongGenreInPlatform: It represents the most listened song genre in platform.
 	 * @return msj: String - It represents the most listened song genre in the platform with his times.
 	 */
 	public String showMostListenedSongGenreInPlatform(){
 		String msj="";
		int countRock=countTimesListenedRockInPlatform();
		int countPop=countTimesListenedPopInPlatform();
		int countTrap=countTimesListenedTrapInPlatform();
		int countHouse=countTimesListenedHouseInPlatform();
		if(countRock>countPop&&countRock>countTrap&&countRock>countHouse){
		msj="The most listened song genre is ROCK and it is listened " + countRock + " times in the platform";
		}
		else if(countPop>countTrap&&countPop>countHouse){
			msj="The most listened song genre is POP and it was listened " + countPop + " times in the platform";
		}
		else if(countTrap>countHouse){
			msj="The most listened song genre is TRAP and it was listened " + countTrap + " times in the platform";
		}
		else if(countHouse>countTrap){
		msj="The most listened song is HOUSE and it was listened " + countHouse + " times in the platform";
		}
		else{
		msj="There are several genre of songs that are the most listened in the platform";
		}
		return msj;
	}
	/**
	 * showMostListenedPodcastCategoryInUser: It represents the most listened podcast category of an user.
	 * @param  consumerUsername: String - It represents the name of the user consumer.
	 * @return msj: String - It represents the most listened category of podcast of an user and its times listened.
	 */
	public String showMostListenedPodcastCategoryInUser(String consumerUsername){
 		String msj="";
 		int posUser=validateIfUserConsumerExist(consumerUsername);
 		msj=((UserConsumer)(users.get(posUser))).showMostListenedPodcastCategory();
 		return msj;
 	}
 	/**
 	 * countTimesListenedPoliticsInPlatform: It represents the number of times listened the podcast category POLITICS in the platform.
 	 * @return count: int - It represents the number of times listened POLITICS.
 	 */
 	 public int countTimesListenedPoliticsInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Podcast){
 				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.POLITICS){
 					count=count+((Podcast)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedEntertainmentInPlatform: It represents the number of times listened the podcast category ENTERTAINMENT in the platform.
 	 * @return count: int - It represents the number of times listened ENTERTAINMENT.
 	 */
 	public int countTimesListenedEntertainmentInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Podcast){
 				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.ENTERTAINMENT){
 					count=count+((Podcast)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedVideogamesInPlatform: It represents the number of times listened the podcast category VIDEOGAMES in the platform.
 	 * @return count: int - It represents the number of times listened VIDEOGAMES.
 	 */
 	public int countTimesListenedVideogamesInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Podcast){
 				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.VIDEOGAMES){
 					count=count+((Podcast)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * countTimesListenedFashionInPlatform: It represents the number of times listened the podcast category FASHION in the platform.
 	 * @return count: int - It represents the number of times listened FASHION.
 	 */
 	public int countTimesListenedFashionInPlatform(){
 		int count=0;
 		for (int i=0;i<audios.size();i++ ) {
 			if(audios.get(i) instanceof Podcast){
 				if(((Podcast)(audios.get(i))).getTypeCategory()==TypeCategory.FASHION){
 					count=count+((Podcast)(audios.get(i))).getPlayingTimes();
 				}
 			}
 		}
 		return count;
 	}
 	/**
 	 * showMostListenedPodcastCategoryInPlatform: It shows the most listened podcast category in the platform.
 	 * @return msj: String - It represents the most listened podcast category in the platform with his times.
 	 */
 	public String showMostListenedPodcastCategoryInPlatform(){
 		String msj="";
		int countPolitics=countTimesListenedPoliticsInPlatform();
		int countEntertainment=countTimesListenedEntertainmentInPlatform();
		int countVideogames=countTimesListenedVideogamesInPlatform();
		int countFashion=countTimesListenedHouseInPlatform();
		if(countPolitics>countEntertainment&&countPolitics>countVideogames&&countPolitics>countFashion){
			msj="The most listened podcast category is POLITICS and it is listened " + countPolitics + " times in the platform";
		}
		else if(countEntertainment>countVideogames&&countEntertainment>countFashion){
			msj="The most listened podcast category is ENTERTAINMENT and it was listened " + countEntertainment + " times in the platform";
		}
		else if(countVideogames>countFashion){
			msj="The most listened podcast category is VIDEOGAMES and it was listened " + countVideogames + " times in the platform";
		}
		else if(countFashion>countVideogames){
			msj="The most listened podcast category is FASHION and it was listened " + countFashion + " times in the platform";
		}
		else{
			msj="There are several categories of podcasts that are the most listened in the platform";
		}
		return msj;
	}
	/**
	 * showTop5Artist: It shows the top 5 of artist according the number of reproductions of his songs.
	 * @return msj: String - It represents the top 5 of artist.
	 */
	public String showTop5Artist(){
		String msj="";
		int top1NumberOfPlayingTimes=0;
		int top2NumberOfPlayingTimes=0;
		int top3NumberOfPlayingTimes=0;
		int top4NumberOfPlayingTimes=0;
		int top5NumberOfPlayingTimes=0;
		String artistName1="";
		String artistName2="";
		String artistName3="";
		String artistName4="";
		String artistName5="";
		for (int i=0;i<users.size() ;i++ ) {
			if(users.get(i)instanceof UserProductorArtist){
				if(((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs() > top1NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = top1NumberOfPlayingTimes;
		            top1NumberOfPlayingTimes = ((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs();
		            artistName5 = artistName4;
		            artistName4 = artistName3;
		            artistName3 = artistName2;
		            artistName2= artistName1; 
		            artistName1 =users.get(i).getUsername(); 
            	} 	
       	 		else if(((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs()> top2NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = ((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs(); 
		            artistName5 = artistName4;
		            artistName4 = artistName3;
		            artistName3 = artistName2;
		            artistName2= users.get(i).getUsername();
            	}
			    else if(((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs() > top3NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= ((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs(); 
		            artistName5 = artistName4;
		            artistName4 = artistName3;
		            artistName3 = users.get(i).getUsername();

			    } 
      	   		else if((( UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs() > top4NumberOfPlayingTimes){
                	top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
               		top4NumberOfPlayingTimes= ((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs(); 
               	 	artistName5 = artistName4;
                	artistName4 = users.get(i).getUsername();
                }
         		else if(((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs() > top5NumberOfPlayingTimes){
               	 	top5NumberOfPlayingTimes = ((UserProductorArtist)(users.get(i))).getPlayingTimesOfSongs();
                	artistName5 = users.get(i).getUsername();
            	}
            }
        }
    	msj=
	        "Top 1."+artistName1 + ", its songs has been played " + top1NumberOfPlayingTimes+"\n"+
	        "Top 2."+artistName2 + ", its songs has been played " + top2NumberOfPlayingTimes+"\n"+
	        "Top 3."+artistName3 + ", its songs has been played " + top3NumberOfPlayingTimes+"\n"+
	        "Top 4."+artistName4 + ", its songs has been played " + top4NumberOfPlayingTimes+"\n"+
	        "Top 5."+artistName5 + ", its songs has been played " + top5NumberOfPlayingTimes;
	    return msj;
      }
    /**
     * showTop5Artist: It shows the top 5 of creators contents according the number of reproductions of his songs.
	 * @return msj: String - It represents the top 5 of creator contents.
     */
    public String showTop5CreatorContent(){
		String msj="";
		int top1NumberOfPlayingTimes=0;
		int top2NumberOfPlayingTimes=0;
		int top3NumberOfPlayingTimes=0;
		int top4NumberOfPlayingTimes=0;
		int top5NumberOfPlayingTimes=0;
		String creatorContentName1="";
		String creatorContentName2="";
		String creatorContentName3="";
		String creatorContentName4="";
		String creatorContentName5="";
		for (int i=0;i<users.size() ;i++ ) {
			if(users.get(i)instanceof UserProductorCreatorContent){
				if(((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast() > top1NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = top1NumberOfPlayingTimes;
		            top1NumberOfPlayingTimes = ((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast();
		            creatorContentName5 = creatorContentName4;
		            creatorContentName4 = creatorContentName3;
		            creatorContentName3 = creatorContentName2;
		            creatorContentName2= creatorContentName1; 
		            creatorContentName1 =users.get(i).getUsername(); 
            	} 	
       	 		else if(((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast()> top2NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = ((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast(); 
		            creatorContentName5 = creatorContentName4;
		            creatorContentName4 = creatorContentName3;
		            creatorContentName3 = creatorContentName2;
		            creatorContentName2= users.get(i).getUsername();
            	}
			    else if(((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast() > top3NumberOfPlayingTimes){
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= ((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast(); 
		            creatorContentName5 = creatorContentName4;
		            creatorContentName4 = creatorContentName3;
		            creatorContentName3 = users.get(i).getUsername();

			    } 
      	   		else if((( UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast() > top4NumberOfPlayingTimes){
                	top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
               		top4NumberOfPlayingTimes= ((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast(); 
               	 	creatorContentName5 = creatorContentName4;
                	creatorContentName4 = users.get(i).getUsername();
                }
         		else if(((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast() > top5NumberOfPlayingTimes){
               	 	top5NumberOfPlayingTimes = ((UserProductorCreatorContent)(users.get(i))).getPlayingTimesOfPodcast();
                	creatorContentName5 = users.get(i).getUsername();
            	}
            }
        }
    	msj=
	        "Top 1."+creatorContentName1 + ", its podcasts has been played " + top1NumberOfPlayingTimes+"\n"+
	        "Top 2."+creatorContentName2 + ", its podcasts has been played " + top2NumberOfPlayingTimes+"\n"+
	        "Top 3."+creatorContentName3 + ", its podcasts has been played " + top3NumberOfPlayingTimes+"\n"+
	        "Top 4."+creatorContentName4 + ", its podcasts has been played " + top4NumberOfPlayingTimes+"\n"+
	        "Top 5."+creatorContentName5 + ", its podcasts has been played " + top5NumberOfPlayingTimes;
	    return msj;
    }
    /**
     * showTop10Song: It represents the top 10 of songs according the number of reproductions.
     * @return msj: String - It represents the top 10 of songs.
     */
   		public String showTop10Song(){
		String msj="";
		int top1NumberOfPlayingTimes=0;
		int top2NumberOfPlayingTimes=0;
		int top3NumberOfPlayingTimes=0;
		int top4NumberOfPlayingTimes=0;
		int top5NumberOfPlayingTimes=0;
		int top6NumberOfPlayingTimes=0;
		int top7NumberOfPlayingTimes=0;
		int top8NumberOfPlayingTimes=0;
		int top9NumberOfPlayingTimes=0;
		int top10NumberOfPlayingTimes=0;
		String songName1="";
		String songName2="";
		String songName3="";
		String songName4="";
		String songName5="";
		String songName6="";
		String songName7="";
		String songName8="";
		String songName9="";
		String songName10="";
		TypeGenre typeGenreSong1=null;
		TypeGenre typeGenreSong2=null;
		TypeGenre typeGenreSong3=null;
		TypeGenre typeGenreSong4=null;
		TypeGenre typeGenreSong5=null;
		TypeGenre typeGenreSong6=null;
		TypeGenre typeGenreSong7=null;
		TypeGenre typeGenreSong8=null;
		TypeGenre typeGenreSong9=null;
		TypeGenre typeGenreSong10=null;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getPlayingTimes() > top1NumberOfPlayingTimes){
					top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
					top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
					top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
					top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
					top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = top1NumberOfPlayingTimes;
		            top1NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName10=songName9;
					songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=songName5;
					songName5=songName4;
					songName4=songName3;
					songName3=songName2;
					songName2=songName1;
					songName1=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=typeGenreSong5;
					typeGenreSong5=typeGenreSong4;
					typeGenreSong4=typeGenreSong3;
					typeGenreSong3=typeGenreSong2;
					typeGenreSong2=typeGenreSong1;
					typeGenreSong1=((Song)(audios.get(i))).getTypeGenre();    
            	} 	
       	 		else if(((Song)(audios.get(i))).getPlayingTimes()> top2NumberOfPlayingTimes){
		            top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName10=songName9;
					songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=songName5;
					songName5=songName4;
					songName4=songName3;
					songName3=songName2;
					songName2=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=typeGenreSong5;
					typeGenreSong5=typeGenreSong4;
					typeGenreSong4=typeGenreSong3;
					typeGenreSong3=typeGenreSong2;
					typeGenreSong2=((Song)(audios.get(i))).getTypeGenre();
            	}
			    else if(((Song)(audios.get(i))).getPlayingTimes() > top3NumberOfPlayingTimes){
		            top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= ((Song)(audios.get(i))).getPlayingTimes(); 
		            songName10=songName9;
		            songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=songName5;
					songName5=songName4;
					songName4=songName3;
					songName3=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=typeGenreSong5;
					typeGenreSong5=typeGenreSong4;
					typeGenreSong4=typeGenreSong3;
					typeGenreSong3=((Song)(audios.get(i))).getTypeGenre();

			    } 
      	   		else if(((Song)(audios.get(i))).getPlayingTimes() > top4NumberOfPlayingTimes){
                	top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
                	top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
               		top4NumberOfPlayingTimes= ((Song)(audios.get(i))).getPlayingTimes(); 
               		songName10=songName9;
               		songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=songName5;
					songName5=songName4;
					songName4=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=typeGenreSong5;
					typeGenreSong5=typeGenreSong4;
					typeGenreSong4=((Song)(audios.get(i))).getTypeGenre();
                }
         		else if(((Song)(audios.get(i))).getPlayingTimes() > top5NumberOfPlayingTimes){
               	 	top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
               	 	top5NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
                	songName10=songName9;
                	songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=songName5;
					songName5=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=typeGenreSong5;
					typeGenreSong5=((Song)(audios.get(i))).getTypeGenre();
            	}
            	else if (((Song)(audios.get(i))).getPlayingTimes() > top6NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName9=songName8;
					songName8=songName7;
					songName7=songName6;
					songName6=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=typeGenreSong6;
					typeGenreSong6=((Song)(audios.get(i))).getTypeGenre();

            	}
            	else if (((Song)(audios.get(i))).getPlayingTimes() > top7NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName10=songName9;
		            songName9=songName8;
					songName8=songName7;
					songName7=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=typeGenreSong7;
					typeGenreSong7=((Song)(audios.get(i))).getTypeGenre();

            	}
            	else if (((Song)(audios.get(i))).getPlayingTimes() > top8NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName10=songName9;
		            songName9=songName8;
					songName8=((Song)(audios.get(i))).getName();
					typeGenreSong10=typeGenreSong9;
					typeGenreSong9=typeGenreSong8;
					typeGenreSong8=((Song)(audios.get(i))).getTypeGenre();
            	}
            	else if (((Song)(audios.get(i))).getPlayingTimes() > top9NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
		            songName10=songName9;
		            songName9=((Song)(audios.get(i))).getName();
		            typeGenreSong10=typeGenreSong9;
		            typeGenreSong9=((Song)(audios.get(i))).getTypeGenre();
            	}
            	else if (((Song)(audios.get(i))).getPlayingTimes() > top10NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = ((Song)(audios.get(i))).getPlayingTimes();
            		songName10=((Song)(audios.get(i))).getName();
            		typeGenreSong10=((Song)(audios.get(i))).getTypeGenre();
            	}
            }
        }
    	msj=
	        "Top 1."+songName1 + ", the song has been played " + top1NumberOfPlayingTimes+" its genre is "+typeGenreSong1+"\n"+
	        "Top 2."+songName2 + ", the song has been played " + top2NumberOfPlayingTimes+" its genre is "+typeGenreSong2+"\n"+
	        "Top 3."+songName3 + ", the song has been played " + top3NumberOfPlayingTimes+" its genre is "+typeGenreSong3+"\n"+
	        "Top 4."+songName4+ ", the song has been played " + top4NumberOfPlayingTimes+" its genre is "+typeGenreSong4+"\n"+
	        "Top 5."+songName5 + ", the song has been played " + top5NumberOfPlayingTimes+" its genre is "+typeGenreSong5+"\n"+
	        "Top 6."+songName6 + ", the song has been played " + top5NumberOfPlayingTimes+" its genre is "+typeGenreSong6+"\n"+
	        "Top 7."+songName7 + ", the song has been played " + top5NumberOfPlayingTimes+" its genre is "+typeGenreSong7+"\n"+
	        "Top 8."+songName8 + ", the song has been played " + top5NumberOfPlayingTimes+" its genre is "+typeGenreSong8+"\n"+
	        "Top 9."+songName9 + ", the songs has been played " + top5NumberOfPlayingTimes+" its genre is " +typeGenreSong9+"\n"+
	        "Top 10."+songName10 + ", the songs has been played " + top5NumberOfPlayingTimes+" its genre is "+typeGenreSong10;
	    return msj;
	}
	/**
	 * showTop10Podcast: It represents the top 10 of podcasts according the number of reproductions.
     * @return msj: String - It represents the top 10 of podcasts.
	 */
	public String showTop10Podcast(){
		String msj="";
		int top1NumberOfPlayingTimes=0;
		int top2NumberOfPlayingTimes=0;
		int top3NumberOfPlayingTimes=0;
		int top4NumberOfPlayingTimes=0;
		int top5NumberOfPlayingTimes=0;
		int top6NumberOfPlayingTimes=0;
		int top7NumberOfPlayingTimes=0;
		int top8NumberOfPlayingTimes=0;
		int top9NumberOfPlayingTimes=0;
		int top10NumberOfPlayingTimes=0;
		String podcastName1="";
		String podcastName2="";
		String podcastName3="";
		String podcastName4="";
		String podcastName5="";
		String podcastName6="";
		String podcastName7="";
		String podcastName8="";
		String podcastName9="";
		String podcastName10="";
		TypeCategory typeCategoryPodcast1=null;
		TypeCategory typeCategoryPodcast2=null;
		TypeCategory typeCategoryPodcast3=null;
		TypeCategory typeCategoryPodcast4=null;
		TypeCategory typeCategoryPodcast5=null;
		TypeCategory typeCategoryPodcast6=null;
		TypeCategory typeCategoryPodcast7=null;
		TypeCategory typeCategoryPodcast8=null;
		TypeCategory typeCategoryPodcast9=null;
		TypeCategory typeCategoryPodcast10=null;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Podcast){
				if(((Podcast)(audios.get(i))).getPlayingTimes() > top1NumberOfPlayingTimes){
					top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
					top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
					top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
					top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
					top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = top1NumberOfPlayingTimes;
		            top1NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName10=podcastName9;
					podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=podcastName5;
					podcastName5=podcastName4;
					podcastName4=podcastName3;
					podcastName3=podcastName2;
					podcastName2=podcastName1;
					podcastName1=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=typeCategoryPodcast5;
					typeCategoryPodcast5=typeCategoryPodcast4;
					typeCategoryPodcast4=typeCategoryPodcast3;
					typeCategoryPodcast3=typeCategoryPodcast2;
					typeCategoryPodcast2=typeCategoryPodcast1;
					typeCategoryPodcast1=((Podcast)(audios.get(i))).getTypeCategory();    
            	} 	
       	 		else if(((Podcast)(audios.get(i))).getPlayingTimes()> top2NumberOfPlayingTimes){
		            top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= top2NumberOfPlayingTimes;
		            top2NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName10=podcastName9;
					podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=podcastName5;
					podcastName5=podcastName4;
					podcastName4=podcastName3;
					podcastName3=podcastName2;
					podcastName2=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=typeCategoryPodcast5;
					typeCategoryPodcast5=typeCategoryPodcast4;
					typeCategoryPodcast4=typeCategoryPodcast3;
					typeCategoryPodcast3=typeCategoryPodcast2;
					typeCategoryPodcast2=((Podcast)(audios.get(i))).getTypeCategory();
            	}
			    else if(((Podcast)(audios.get(i))).getPlayingTimes() > top3NumberOfPlayingTimes){
		            top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
		            top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
		            top4NumberOfPlayingTimes= top3NumberOfPlayingTimes;
		            top3NumberOfPlayingTimes= ((Podcast)(audios.get(i))).getPlayingTimes(); 
		            podcastName10=podcastName9;
		            podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=podcastName5;
					podcastName5=podcastName4;
					podcastName4=podcastName3;
					podcastName3=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=typeCategoryPodcast5;
					typeCategoryPodcast5=typeCategoryPodcast4;
					typeCategoryPodcast4=typeCategoryPodcast3;
					typeCategoryPodcast3=((Podcast)(audios.get(i))).getTypeCategory();

			    } 
      	   		else if(((Podcast)(audios.get(i))).getPlayingTimes() > top4NumberOfPlayingTimes){
                	top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
                	top5NumberOfPlayingTimes = top4NumberOfPlayingTimes;
               		top4NumberOfPlayingTimes= ((Podcast)(audios.get(i))).getPlayingTimes(); 
               		podcastName10=podcastName9;
               		podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=podcastName5;
					podcastName5=podcastName4;
					podcastName4=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=typeCategoryPodcast5;
					typeCategoryPodcast5=typeCategoryPodcast4;
					typeCategoryPodcast4=((Podcast)(audios.get(i))).getTypeCategory();
                }
         		else if(((Podcast)(audios.get(i))).getPlayingTimes() > top5NumberOfPlayingTimes){
               	 	top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = top5NumberOfPlayingTimes;
               	 	top5NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
                	podcastName10=podcastName9;
                	podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=podcastName5;
					podcastName5=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=typeCategoryPodcast5;
					typeCategoryPodcast5=((Podcast)(audios.get(i))).getTypeCategory();
            	}
            	else if (((Podcast)(audios.get(i))).getPlayingTimes() > top6NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = top6NumberOfPlayingTimes;
		            top6NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=podcastName6;
					podcastName6=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=typeCategoryPodcast6;
					typeCategoryPodcast6=((Podcast)(audios.get(i))).getTypeCategory();

            	}
            	else if (((Podcast)(audios.get(i))).getPlayingTimes() > top7NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = top7NumberOfPlayingTimes;
		            top7NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName10=podcastName9;
		            podcastName9=podcastName8;
					podcastName8=podcastName7;
					podcastName7=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=typeCategoryPodcast7;
					typeCategoryPodcast7=((Podcast)(audios.get(i))).getTypeCategory();

            	}
            	else if (((Podcast)(audios.get(i))).getPlayingTimes() > top8NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = top8NumberOfPlayingTimes;
		            top8NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName10=podcastName9;
		            podcastName9=podcastName8;
					podcastName8=((Podcast)(audios.get(i))).getName();
					typeCategoryPodcast10=typeCategoryPodcast9;
					typeCategoryPodcast9=typeCategoryPodcast8;
					typeCategoryPodcast8=((Podcast)(audios.get(i))).getTypeCategory();
            	}
            	else if (((Podcast)(audios.get(i))).getPlayingTimes() > top9NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = top9NumberOfPlayingTimes;
		            top9NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
		            podcastName10=podcastName9;
		            podcastName9=((Podcast)(audios.get(i))).getName();
		            typeCategoryPodcast10=typeCategoryPodcast9;
		            typeCategoryPodcast9=((Podcast)(audios.get(i))).getTypeCategory();
            	}
            	else if (((Podcast)(audios.get(i))).getPlayingTimes() > top10NumberOfPlayingTimes) {
            		top10NumberOfPlayingTimes = ((Podcast)(audios.get(i))).getPlayingTimes();
            		podcastName10=((Podcast)(audios.get(i))).getName();
            		typeCategoryPodcast10=((Podcast)(audios.get(i))).getTypeCategory();
            	}
            }
        }
    	msj=
	        "Top 1."+podcastName1 + ", the podcast has been played " + top1NumberOfPlayingTimes+" its category is "+typeCategoryPodcast1+"\n"+
	        "Top 2."+podcastName2 + ", the podcast has been played " + top2NumberOfPlayingTimes+" its category is "+typeCategoryPodcast2+"\n"+
	        "Top 3."+podcastName3 + ", the podcast has been played " + top3NumberOfPlayingTimes+" its category is "+typeCategoryPodcast3+"\n"+
	        "Top 4."+podcastName4 + ", the podcast has been played " + top4NumberOfPlayingTimes+" its category is "+typeCategoryPodcast4+"\n"+
	        "Top 5."+podcastName5 + ", the podcast has been played " + top5NumberOfPlayingTimes+" its category is "+typeCategoryPodcast5+"\n"+
	        "Top 6."+podcastName6 + ", the podcast has been played " + top5NumberOfPlayingTimes+" its category is "+typeCategoryPodcast6+"\n"+
	        "Top 7."+podcastName7 + ", the podcast has been played " + top5NumberOfPlayingTimes+" its category is "+typeCategoryPodcast7+"\n"+
	        "Top 8."+podcastName8 + ", the podcast has been played " + top5NumberOfPlayingTimes+" its category is "+typeCategoryPodcast8+"\n"+
	        "Top 9."+podcastName9 + ", the podcasts has been played " + top5NumberOfPlayingTimes+" its category is " +typeCategoryPodcast9+"\n"+
	        "Top 10."+podcastName10 + ", the podcasts has been played " + top5NumberOfPlayingTimes+" its category is "+typeCategoryPodcast10;
	    return msj;
	}
	/**
	 * countNumberOfSellingsRock: It represents the number sales of song genre ROCK in the platform.
	 * @return count: int - It represents the number of sales of ROCK.
	 */
	public int countNumberOfSellingsRock(){
		int count=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.ROCK){
					count=count+((Song)(audios.get(i))).getSellingTimes();
				}
			}
		}
		return count;
	}
	/**
	 * countNumberOfSellingsPop: It represents the number sales of song genre POP in the platform.
	 * @return count: int - It represents the number of sales of POP.
	 */
	public int countNumberOfSellingsPop(){
		int count=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.POP){
					count=count+((Song)(audios.get(i))).getSellingTimes();
				}
			}
		}
		return count;
	}
	/**
	 * countNumberOfSellingsTrap: It represents the number sales of song genre TRAP in the platform.
	 * @return count: int - It represents the number of sales of TRAP.
	 */
	public int countNumberOfSellingsTrap(){
		int count=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.TRAP){
					count=count+((Song)(audios.get(i))).getSellingTimes();
				}
			}
		}
		return count;
	}
	/**
	 * countNumberOfSellingsHouse: It represents the number sales of song genre HOUSE in the platform.
	 * @return count: int - It represents the number of sales of HOUSE.
	 */
	public int countNumberOfSellingsHouse(){
		int count=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.HOUSE){
					count=count+((Song)(audios.get(i))).getSellingTimes();
				}
			}
		}
		return count;
	}
	/**
	 * totalGainSellingRock: It represents the total gain of the sellings of ROCK.
	 * @return totalGain: double - It represents the total gain of ROCK.
	 */
	public double totalGainSellingRock(){
		double totalGain=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.ROCK){
					totalGain=totalGain+(((Song)(audios.get(i))).getSellingTimes()*((Song)(audios.get(i))).getVentValue());
				}
			}
		}
		return totalGain;
	}
	/**
	 * totalGainSellingPop: It represents the total gain of the sellings of POP.
	 * @return totalGain: double - It represents the total gain of POP.
	 */
	public double totalGainSellingPop(){
		double totalGain=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.POP){
					totalGain=totalGain+(((Song)(audios.get(i))).getSellingTimes()*((Song)(audios.get(i))).getVentValue());
				}
			}
		}
		return totalGain;
	}
	/**
	 * totalGainSellingTrap: It represents the total gain of the sellings of TRAP.
	 * @return totalGain: double - It represents the total gain of TRAP.
	 */
	public double totalGainSellingTrap(){
		double totalGain=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.TRAP){
					totalGain=totalGain+(((Song)(audios.get(i))).getSellingTimes()*((Song)(audios.get(i))).getVentValue());
				}
			}
		}
		return totalGain;
	}
	/**
	 * totalGainSellingHouse: It represents the total gain of the sellings of HOUSE.
	 * @return totalGain: double - It represents the total gain of HOUSE.
	 */
	public double totalGainSellingHouse(){
		double totalGain=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getTypeGenre()==TypeGenre.HOUSE){
					totalGain=totalGain+(((Song)(audios.get(i))).getSellingTimes()*((Song)(audios.get(i))).getVentValue());
				}
			}
		}
		return totalGain;
	}
	/**
	 * showTotalGainAndNumberOfSales: It shows the total gain and the selling times of every genre of songs.
	 * @return String - It shows the total gain and selling times of every genre of songs. 
	 */
	public String showTotalGainAndNumberOfSales(){
		return "The number of sales of the genre ROCK is "+countNumberOfSellingsRock()+", and the total gain is"+totalGainSellingRock()+"\n"+
			   "The number of sales of the genre POP is "+countNumberOfSellingsPop()+", and the total gain is "+totalGainSellingPop()+"\n"+
			   "The number of sales of the genre TRAP is "+countNumberOfSellingsTrap()+", and the total gain is "+totalGainSellingTrap()+"\n"+
			   "The number of sales of the genre HOUSE is "+countNumberOfSellingsHouse()+", and the total gain is "+totalGainSellingHouse();
	}
	/**
	 * posMostSellingSong: It represents the position of most selling song in the platform. 
	 * @return pos: int - It is most position of the most selling song.
	 */
	public int posMostSellingSong(){
		int pos=-1;
		int mostSellingSong=0;
		for (int i=0;i<audios.size() ;i++ ) {
			if(audios.get(i)instanceof Song){
				if(((Song)(audios.get(i))).getSellingTimes()>mostSellingSong){
					mostSellingSong=((Song)(audios.get(i))).getSellingTimes();
					pos=i;
				}
			}
		}
		return pos;
	}
	/**
	 * showMostSellingSong: It shows the most selling song in the platform with the total gain.
	 * @return msj: It is the information of most selling song.
	 */
	public String showMostSellingSong(){
		String msj="No song has been purchased yet";
		int pos=posMostSellingSong();
		if(pos!=-1){
			msj="The most selling song is "+audios.get(pos).getName()+"\n"+
			"The quantity of units solds are: " +((Song)(audios.get(pos))).getSellingTimes()+"\n" + 
			"The total gain by this sales are " +((Song)(audios.get(pos))).getSellingTimes()* ((Song)(audios.get(pos))).getVentValue();
		}
		return msj;
	}	
}

