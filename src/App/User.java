package App;

import java.util.ArrayList;
import File.FileManger;

public class User extends Person{


	public void registery(User u) {
			FileManger fm=new FileManger();
			u.setId(fm.getId()+1);
			fm.register(u);
	}


	public User login(String email,String password) {
		FileManger fm=new FileManger();
		ArrayList<User>users=fm.getUsers();
		for (User u : users) {
			if(u.getEmail_address().equals(email) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}
	
	public ArrayList<User> search(String firstName,String age){
		FileManger fm=new FileManger();
		ArrayList<User>users=fm.getUsers();
		ArrayList<User>wantedUsers=new ArrayList<>();
		for (User u : users) {
			if(u.getF_name().equals(firstName) && u.getAge()==Integer.parseInt(age)){
				wantedUsers.add(u);
			}
		}
		return wantedUsers;
	}
	
	public void writePost(String content,User user){
		Post p=new Post();
		p.setPost_content(content);
		FileManger fm=new FileManger();
		fm.writePost(p,user);
	}
	
	public void addFriend(User u1,User u2){
		FileManger fm=new FileManger();
		fm.addFriend(u1,u2);
	}
	
	public User updateProfile(User u1,User u2){
		FileManger fm=new FileManger();
		return fm.updateProfile(u1, u2);
	}
	
	
}
