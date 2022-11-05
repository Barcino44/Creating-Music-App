package model;
import java.util.Date;
public abstract class User{
	
	private String username;
	private String id;
	private Date vinculationDate=new Date();
	
	public User(String username, String id, Date vinculationDate) {
		this.username=username;
		this.id = id;
		this.vinculationDate=vinculationDate;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getVinculationDate(){
		return vinculationDate;
	}
}