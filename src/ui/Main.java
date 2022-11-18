package ui; 

import java.util.Scanner; 
import model.*; 

public class Main{
	
	private Scanner reader; 

	private NeoTunes neoTunes; 

	public Main(){
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.initNeoTunes();

		int option = -1; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

	}


	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());

		option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return "<<-<< <<-<< Welcome >>->> >>->>\n" +
			"1.Add an artist \n" +
			"2.Add an creatorContent \n"+
			"3.Add a premium consumer  \n"+
			"4.Add a standard consumer\n"+
			"5.Add a song\n" +
			"6.Add a podcast\n"+
			"7.Add a PlayList\n"+
			"8.Add audio in Playlist\n"+
			"9.Delete audio in Playlist\n"+
			"10.Share playlist\n"+
			"11.Play an audio according a playlist\n"+
			"12.Buy a song";
	}
	public void executeOption(int option){
			String username="";
			String userId="";
			String urlProductor="";
			int selectionTypeGenre=0;
			String validationGenre="The possible genre of songs are:\n" +
									"1. ROCK\n"+
									"2. POP\n"+
									"3. TRAP\n"+
									"4. HOUSE";
			String nameSong="";
			String albumSong="";
			String albumURLSong="";
			int duration=0;
			double ventValue=0;
			int selectionTypeCategory=0;
			String validationCategory="The possible category of podcast are:\n"+
									  "1. POLITICS\n"+
									  "2. ENTERTAINMENT\n"+
									  "3. VIDEOGAMES\n"+
									  "4. FASHION";
			String namePodcast="";
			String descriptionPodcast="";
			String urlPodcast="";
			String playListName="";
			int selectionTypePlayList=0;
			String validationPlayList="The possible types of PlayList are:\n"+
									  "1.SONGS\n"+
									  "2.PODCAST\n"+
									  "3.BOTH";
			String playlistCode="";
			String usernameToShare="";
			String selectionAudio="";
			String msj="";
			switch(option){
				case 1:
					System.out.println("Enter the user Nickname");
					username=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					System.out.println("Enter urlProductor");
					urlProductor=reader.next();
					msj=neoTunes.addUserProductArtist(username, userId, urlProductor);
					System.out.println(msj);
					break;
				case 2:
					System.out.println("Enter the user Nickname");
					username=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					System.out.println("Enter urlProductor");
					urlProductor=reader.next();
					msj=neoTunes.addUserProductCreatorContent(username, userId, urlProductor);
					System.out.println(msj);
					break;
				case 3:
					System.out.println("Enter the user Nickname");
					username=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					msj=neoTunes.addUserConsumerPremium(username, userId);
					System.out.println(msj);
					break;
				case 4:
					System.out.println("Enter the user Nickname");
					username=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					msj=neoTunes.addUserConsumerStandard(username, userId);
					System.out.println(msj);
					break;
				case 5:
					System.out.println("Enter the artist name");
					username=reader.next();
					if(neoTunes.validateIfArtistExist(username)!=true){
						System.out.println("The artist doesn't exists");
					}
					else{
						System.out.println("Enter the genre of song");
						System.out.println(validationGenre);
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an Integer");
							System.out.println(validationGenre);
						}
						selectionTypeGenre=reader.nextInt();

						while(selectionTypeGenre!=1&&selectionTypeGenre!=2&&selectionTypeGenre!=3&&selectionTypeGenre!=4){
							System.out.println("It is not a genre");
							System.out.println(validationGenre);
							selectionTypeGenre=reader.nextInt();
						}
						System.out.println("Enter the name of the song");
						nameSong=reader.next();
						System.out.println("Enter the album's name of the song");
						albumSong=reader.next();
						System.out.println("Enter the album's url ");
						albumURLSong=reader.next();
						System.out.println("Enter the duration (in seconds) of the song");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an integer");
						}
						duration=reader.nextInt();
						System.out.println("Enter the ventValue");
						while(!reader.hasNextDouble()){
							reader.next();
							System.out.println("Invalid, enter a real");
						}
						ventValue=reader.nextDouble();
						msj=neoTunes.addSong(username, selectionTypeGenre,nameSong,albumSong,albumURLSong,duration,ventValue);
						System.out.println(msj);
					}
					break;
				case 6:
					System.out.println("Enter the creator Content name");
					username=reader.next();
					if(neoTunes.validateIfCreatorContentExist(username)!=true){
						System.out.println("The creator content doesn't exists");
					}
					else{
						System.out.println("Enter the category of the podcast");
						System.out.println(validationCategory);
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an Integer");
							System.out.println(validationCategory);
						}
						selectionTypeCategory=reader.nextInt();

						while(selectionTypeCategory!=1&&selectionTypeCategory!=2&&selectionTypeCategory!=3&&selectionTypeCategory!=4){
							System.out.println("It is not a category");
							System.out.println(validationCategory);
							selectionTypeCategory=reader.nextInt();
						}
						System.out.println("Enter the name of the podcast");
						namePodcast=reader.next();
						System.out.println("Enter the podcast's descriptionPodcast");
						descriptionPodcast=reader.next();
						System.out.println("Enter the podcast's url ");
						urlPodcast=reader.next();
						System.out.println("Enter the duration (in seconds) of the podcast");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an integer");
						}
						duration=reader.nextInt();

						msj=neoTunes.addPodcast(username, selectionTypeCategory,namePodcast,descriptionPodcast, urlPodcast,duration);
						System.out.println(msj);	
					}
					break;
				case 7:
					System.out.println("Enter the name of the user who are going to be added the PlayList");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else{
						System.out.println("Enter the type of PlayList that you want to add");
						System.out.println(validationPlayList);
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an Integer");
							System.out.println(validationPlayList);
						}
						selectionTypePlayList=reader.nextInt();

						while(selectionTypePlayList!=1&&selectionTypePlayList!=2&&selectionTypePlayList!=3){
							System.out.println("It is not a type of playist");
							System.out.println(validationPlayList);
							selectionTypePlayList=reader.nextInt();
						}
						System.out.println("Enter the name of the PlayList");
						playListName=reader.next();
						msj=neoTunes.addPlayListToUser(username,selectionTypePlayList,playListName);
						System.out.println(msj);
					}
					break;
				case 8:
					System.out.println("Enter the name of the user consumer");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else if(neoTunes.validateIfUserConsumerExist(username)!=-1){
						System.out.println("Enter the playlist name");
						playListName=reader.next();
						if(neoTunes.validateIfPlaylistExist(username,playListName)==false){
							System.out.println("The Playlist doesn't exist");
						}
						else if(neoTunes.validateIfPlaylistExist(username,playListName)==true){
							System.out.println("Enter the audio that you want to add\n");
							System.out.println("The possible audios to add are:\n");
							System.out.println(neoTunes.showInformationOfAudios(username,playListName));
							System.out.println(".....................");
							selectionAudio=reader.next();
							System.out.println(".....................");
							if(neoTunes.validateIfSelectedAudioExist(username,playListName,selectionAudio)==false){
								System.out.println("The audio can't be added");
							}
							else{
								msj=neoTunes.addAudiosToPlaylist(username,playListName,selectionAudio);
								System.out.println(msj);
							}
						}
					}
				break;
				case 9:
					System.out.println("Enter the name of the user consumer");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else if(neoTunes.validateIfUserConsumerExist(username)!=-1){
						System.out.println("Enter the playlist name");
						playListName=reader.next();
						if(neoTunes.validateIfPlaylistExist(username,playListName)==false){
							System.out.println("The Playlist doesn't exist");
						}
						else if(neoTunes.validateIfPlaylistExist(username,playListName)==true){
							if(neoTunes.showAudiosAddedInPlaylist(username,playListName).equals("")){
								System.out.println("You have not added an audio in the playlist yet");
							}
							else{
								System.out.println("Enter the audio that you want to delete\n");
								System.out.println("The possible audios to delete are:\n");
								System.out.println(neoTunes.showAudiosAddedInPlaylist(username,playListName));
								System.out.println(".....................");
								selectionAudio=reader.next();
								System.out.println(".....................");
								msj=neoTunes.deleteAudioInPlaylist(username,playListName, selectionAudio);
								System.out.println(msj);
							}
						}
					}
				break;
				case 10:
					System.out.println("Enter the name of the user consumer");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else if(neoTunes.validateIfUserConsumerExist(username)!=-1){
						System.out.println("Enter the playlist name");
						playListName=reader.next();
						if(neoTunes.validateIfPlaylistExist(username,playListName)==false){
							System.out.println("The Playlist doesn't exist");
						}
						else{
							System.out.println("Enter the name of the user which you want to share the song");
							usernameToShare=reader.next();
							if(neoTunes.validateIfUserConsumerExist(usernameToShare)==-1){
								System.out.println("The user to share doesn't exists or it is not a consumer");
							}
							else{	
								msj=neoTunes.showCodeWithMatriz(username,playListName,usernameToShare);
								System.out.println(msj);
							}
						}
					}
					break;
				case 11:
					System.out.println("Enter the name of the user consumer");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else{
						if(neoTunes.validateIfUserConsumerExist(username)!=-1){
						System.out.println("Enter the playlist name");
						playListName=reader.next();
						if(neoTunes.validateIfPlaylistExist(username,playListName)==false){
							System.out.println("The Playlist doesn't exist");
						}
						else{
							if(neoTunes.showAudiosAddedInPlaylist(username,playListName).equals("")){
								System.out.println("You have not added an audio in the playlist yet");
							}
							else{
								System.out.println("Enter the audio that you want to play\n");
								System.out.println("The possible audios to play are:\n");
								System.out.println(neoTunes.showAudiosAddedInPlaylist(username,playListName));
								System.out.println(".....................");
								selectionAudio=reader.next();
								System.out.println(".....................");
								msj=neoTunes.playAudioInPlaylist(username,playListName, selectionAudio);
								System.out.println(msj);
								}
							}
						}
					}
					break;
				case 12:
					System.out.println("Enter the name of the user consumer who is going to buy the song");
					username=reader.next();
					if(neoTunes.validateIfUserConsumerExist(username)==-1){
						System.out.println("The user doesn't exists or is not a consumer");
					}
					else{
						System.out.println("Enter the name of song that you want to buy");
						System.out.println(neoTunes.showSongsToBuy());
						System.out.println(".....................");
						selectionAudio=reader.next();
						System.out.println(".....................");
						if (neoTunes.validateIfSelectedSongExist(selectionAudio)==false){
							System.out.println("The song doesn't exist");
						}
						else{
							msj=neoTunes.buySong(username,selectionAudio);
							System.out.println(msj);
						}
					}
					break;
				case 0: 
					System.out.println("Exit program.");
					break; 

				default: 
					System.out.println("Invalid Option");
					break; 
			}
	}
	public void initNeoTunes(){
		System.out.println("Welcome to NeoTunes your music app, enter a letter to start");
		String name = reader.nextLine(); 
		this.neoTunes = new NeoTunes(name);

	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}

