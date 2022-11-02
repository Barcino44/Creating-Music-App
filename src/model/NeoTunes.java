package model;
import java.util.Date;
import java.util.ArrayList;

public class NeoTunes {

 	private ArrayList<User> users;

 	public NeoTunes(String name){
 		users= new ArrayList<User>(10);
 	}

 	public String addUserProductArtist(String nickname, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorArtist newProductorArtist = new UserProductorArtist(nickname, id, vinculationDate, url);
		users.add(newProductorArtist);
		msj="New Artist added sucefully";
		return msj;
	}
	public String addUserProductCreatorContent(String nickname, String id, String url){
		String msj="";
		Date vinculationDate = new Date();
		UserProductorCreatorContent newProductorCreatorContent = new UserProductorCreatorContent(nickname, id, vinculationDate, url);
		users.add(newProductorCreatorContent);
		msj="New creatorContent added sucefully";
		return msj;
 	}
 	public String addUserConsumerPremium(String nickname, String id){
 		String msj="";
		Date vinculationDate = new Date();
		UserConsumerPremium newConsumerPremium = new UserConsumerPremium(nickname, id, vinculationDate);
		users.add(newConsumerPremium);
		msj="New consumer premium added sucefully";
		return msj;
 	}
 	public String addUserConsumerStandard(String nickname, String id){
 		String msj="";
		Date vinculationDate = new Date();
		UserConsumerStandard newConsumerEstandard = new UserConsumerStandard(nickname, id, vinculationDate);
		users.add(newConsumerEstandard);
		msj="New consumer premium added sucefully";
		return msj;
 	}

 }


