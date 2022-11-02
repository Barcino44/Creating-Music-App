package model;
import java.util.Date;
public abstract class UserProductor extends User{

	private String url;

	public UserProductor(String username, String id, Date vinculationDate, String url) {
		super(username, id, vinculationDate);
		this.url=url;
	}
}