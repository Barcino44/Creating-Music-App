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
			"4.Add a premium consumer";

	}
	public void executeOption(int option){
			String userNickname="";
			String userId="";
			String urlProductor="";
			String msj="";
			switch(option){
				case 1:
					System.out.println("Enter the user Nickname");
					userNickname=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					System.out.println("Enter urlProductor");
					urlProductor=reader.next();
					msj=neoTunes.addUserProductArtist(userNickname, userId, urlProductor);
					System.out.println(msj);
				break;
				case 2:
					System.out.println("Enter the user Nickname");
					userNickname=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					System.out.println("Enter urlProductor");
					urlProductor=reader.next();
					msj=neoTunes.addUserProductCreatorContent(userNickname, userId, urlProductor);
					System.out.println(msj);
				break;
				case 3:
					System.out.println("Enter the user Nickname");
					userNickname=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					msj=neoTunes.addUserConsumerPremium(userNickname, userId);
					System.out.println(msj);
				break;
				case 4:
					System.out.println("Enter the user Nickname");
					userNickname=reader.next();
					System.out.println("Enter the user Id");
					userId=reader.next();
					msj=neoTunes.addUserConsumerStandard(userNickname, userId);
					System.out.println(msj);
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

