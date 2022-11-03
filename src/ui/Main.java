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
			"3.Add a standard consumer \n"+
			"4.Add a premium consumer\n"+
			"5.Add a song\n" +
			"6.Add a podcast";

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
						System.out.println("Enter the duration of the song");
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
						System.out.println("Enter the duration of the podcast");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an integer");
						}
						duration=reader.nextInt();

						msj=neoTunes.addPodcast(username, selectionTypeCategory,namePodcast,descriptionPodcast, urlPodcast,duration);
						System.out.println(msj);	
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
		System.out.println("Welcome to NeoTunes Game enter a letter to start");
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

