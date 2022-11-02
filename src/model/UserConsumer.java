package model;
import java.util.Date;
public abstract class UserConsumer extends User{

	public UserConsumer(String username, String id, Date vinculationDate) {
		super(username, id, vinculationDate);
	}
}