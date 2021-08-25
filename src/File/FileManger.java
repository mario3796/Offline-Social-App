package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import App.Post;
import App.User;

public class FileManger {

	static final String usersFile="E:\\NetBeansProjects\\Pl_project\\src\\File\\Register.txt";
	static final String postFile="E:\\NetBeansProjects\\Pl_project\\src\\File\\Post.txt";
	static final String friendRequest="E:\\NetBeansProjects\\Pl_project\\src\\File\\FriendRequest.txt";
	
	public void register(User u){
		File f=new File(usersFile);
		PrintWriter pr;
		try {
			pr = new PrintWriter(new FileOutputStream(f,true));
			pr.append(u.getF_name()+"~"+u.getL_name()+"~"+u.getEmail_address()+"~"+
			u.getPassword()+"~"+u.getAge()+"~"+u.getGender()+"~"+u.getId()+"~\n");
			pr.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
		
		public ArrayList<User> getUsers(){
			File f=new File(usersFile);
			ArrayList<User>users=new ArrayList<>();
			try {
				Scanner input=new Scanner(f);
				while(input.hasNext()){
					User u=new User();
					String line=input.nextLine();
					String[]seprated=line.split("~");
					u.setF_name(seprated[0]);
					u.setL_name(seprated[1]);
					u.setEmail_address(seprated[2]);
					u.setPassword(seprated[3]);
					u.setAge(Integer.parseInt(seprated[4]));
					u.setGender(seprated[5]);
					u.setId(Long.parseLong(seprated[6]));
					users.add(u);
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return users;
		}
		
		public long getId(){
			File f=new File(usersFile);
			User u=new User();
			long max=0;
			try {
				Scanner input=new Scanner(f);
				while(input.hasNext()){
					String line=input.nextLine();
					String[]seprated=line.split("~");
					u.setId(Long.parseLong(seprated[6]));
					if(max<u.getId())
						max=u.getId();
				}
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return max;
		}
		
		public void writePost(Post p,User u){
			File f=new File(postFile);
			PrintWriter pw=null;
			p.setUserPost(u.getF_name()+" "+u.getL_name());
			try {
				pw=new PrintWriter(new FileOutputStream(f,true));
				pw.append(p.getUserPost()+"~"+p.getPost_content()+"\n");
				pw.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				pw.close();
			}
		}
		
		public User getUserProfile(String selected){
			File f=new File(usersFile);
			String[]sep=selected.split(" ");
			Scanner input;
			String[]seprated;
			String line;
			try {
				input = new Scanner(f);
				while(input.hasNext()){
					line=input.nextLine();
					seprated=line.split("~");
					User u=new User();
					u.setF_name(seprated[0]);
					u.setL_name(seprated[1]);
					u.setEmail_address(seprated[2]);
					u.setPassword(seprated[3]);
					u.setAge(Integer.parseInt(seprated[4]));
					u.setGender(seprated[5]);
					u.setId(Long.parseLong(seprated[6]));
					if(u.getF_name().equals(sep[0]) && u.getL_name().equals(sep[1]))
						return u;
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public void addFriend(User user1,User user2){
			try {
				File f=new File(friendRequest);
				PrintWriter pw=new PrintWriter(new FileOutputStream(f,true));
				pw.append(user1.getId()+"~"+user2.getId()+"\n");
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public User updateProfile(User u1,User u2){
			File f=new File(usersFile);
			String[]seprated;
			String line;
			ArrayList<User>users=new ArrayList<>();
			try {
				Scanner input = new Scanner(f);
				while(input.hasNext()){
					line=input.nextLine();
					seprated=line.split("~");
					User u=new User();
					u.setF_name(seprated[0]);
					u.setL_name(seprated[1]);
					u.setEmail_address(seprated[2]);
					u.setPassword(seprated[3]);
					u.setAge(Integer.parseInt(seprated[4]));
					u.setGender(seprated[5]);
					u.setId(Long.parseLong(seprated[6]));
					users.add(u);
				}
				
				for (int i = 0; i < users.size(); i++) {
					if( (u1.getEmail_address().equals(users.get(i).getEmail_address()) ) 
							&& ( u1.getPassword().equals(users.get(i).getPassword()) ) ){
						users.remove(i);
						users.add(u2);
					}
				}
				
				input.close();
					PrintWriter pw=new PrintWriter(f);
					for (int i = 0; i < users.size(); i++) {
						pw.print(users.get(i).getF_name()+"~"+users.get(i).getL_name()+"~"+
					users.get(i).getEmail_address()+"~"+users.get(i).getPassword()+"~"+
								users.get(i).getAge()+"~"+users.get(i).getGender()+"~"+users.get(i).getId()+"~\n");
					}
					pw.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return u2;

		}

		public ArrayList<Post> readPost() {
			File f=new File(postFile);
			ArrayList<Post>posts=new ArrayList<>();
			try {
				String line;
				String[]seprated;
				Scanner input=new Scanner(f);
				while(input.hasNext()){
					line=input.nextLine();
					Post p=new Post();
					seprated=line.split("~");
					p.setUserPost(seprated[0]);
					p.setPost_content(seprated[1]);
					posts.add(p);
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return posts;
		}
		
		public ArrayList<User>readFreindReq(User user1){
			File f=new File(friendRequest);
			try {
				ArrayList<User>users=new ArrayList<>();
				Scanner input=new Scanner(f);
				String line;
				ArrayList<Long>requested=new ArrayList<>();
				ArrayList<Long>adder=new ArrayList<>();
				
				ArrayList<User>adders=new ArrayList<>();
				
				String[]seprated;
				while (input.hasNext()) {
					line=input.nextLine();
					seprated=line.split("~");
					adder.add(Long.parseLong(seprated[0]));
					requested.add(Long.parseLong(seprated[1]));
				}
				
				f=new File(usersFile);
				input=new Scanner(f);
				while(input.hasNext()){
					line=input.nextLine();
					seprated=line.split("~");
					User u=new User();
					u.setF_name(seprated[0]);
					u.setL_name(seprated[1]);
					u.setEmail_address(seprated[2]);
					u.setPassword(seprated[3]);
					u.setAge(Integer.parseInt(seprated[4]));
					u.setGender(seprated[5]);
					u.setId(Long.parseLong(seprated[6]));
					users.add(u);
				}
				
				for (int i = 0; i < users.size(); i++) {
					for (int j = 0; j < requested.size(); j++) {
					if(user1.getId()==requested.get(j) && users.get(i).getId()==adder.get(j)){
						adders.add(users.get(i));
						}
					}
				}
				
				return adders;
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
		
}
