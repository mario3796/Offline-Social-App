package GUI;

import javax.swing.*;

import App.User;
import File.FileManger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfile extends JFrame{

	private TextField fullName,email,gender,age;
	private JLabel Full_name,Email,Gender,Age,picture;
	private JButton logout,search,post,update,wall,friendReq,survey;
	User user1;

	public MyProfile(User u) {
		setTitle("Profile");
		Container cp=getContentPane();
		cp.setLayout(null);
		fullName=new TextField();
		email=new TextField();
		age=new TextField();
		gender=new TextField();
		Handler myhandler=new Handler();
		user1=u;
		
		fullName.setText(u.getF_name()+" "+u.getL_name());
		email.setText(u.getEmail_address());
		gender.setText(u.getGender());
		age.setText(""+u.getAge());
		
		this.Full_name=new JLabel("Full Name");
		this.Email=new JLabel("Email");
		this.Age=new JLabel("Age");
		this.Gender=new JLabel("Gender");
		
		logout=new JButton("Log out");
		cp.add(logout);
		logout.setBounds(200, 600, 100, 25);
		logout.addActionListener(myhandler);
		
		search=new JButton("Search");
		cp.add(search);
		search.setBounds(200, 480, 100, 25);
		search.addActionListener(myhandler);
		
		post=new JButton("Post");
		cp.add(post);
		post.setBounds(350, 480, 100, 25);
		post.addActionListener(myhandler);
		
		update=new JButton("Edit Profile");
		cp.add(update);
		update.setBounds(50, 480, 100, 25);
		update.addActionListener(myhandler);
		
		wall=new JButton("Wall");
		cp.add(wall);
		wall.setBounds(350, 540, 100, 25);
		wall.addActionListener(myhandler);
		
		friendReq=new JButton("Request");
		cp.add(friendReq);
		friendReq.setBounds(50, 540, 100, 25);
		friendReq.addActionListener(myhandler);
		
		survey=new JButton("Deactivate");
		cp.add(survey);
		survey.setBounds(200, 540, 100, 25);
		survey.addActionListener(myhandler);
		
		cp.add(fullName);
		cp.add(email);
		cp.add(age);
		cp.add(gender);
		
		cp.add(this.Full_name);
		cp.add(this.Email);
		cp.add(this.Age);
		cp.add(this.Gender);
		
		Full_name.setBounds(70, 260, 60, 25);
		fullName.setBounds(150, 260, 200, 25);
		this.Email.setBounds(70, 310, 60, 25);
		email.setBounds(150, 310, 200, 25);
		this.Age.setBounds(70, 360, 60, 25);
		age.setBounds(150, 360, 200, 25);
		this.Gender.setBounds(70, 410, 60, 25);
		gender.setBounds(150, 410, 200, 25);
		
		fullName.setEditable(false);
		email.setEditable(false);
		age.setEditable(false);
		gender.setEditable(false);
		
		picture=new JLabel();
		picture.setIcon(new ImageIcon(getClass().getResource("/GUI/image.jpg")));
		picture.setBounds(150, 40, 200, 200);
		cp.setLayout(null);
		cp.add(picture);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 700);
		setResizable(false);
		}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonPressed=e.getSource();
			if(buttonPressed.equals(logout)){
				Welcome w=new Welcome("Welcome");
				w.setVisible(true);
				setVisible(false);
			}
			else if(buttonPressed.equals(search)){
				SearchForm sf=new SearchForm(user1);
				sf.setVisible(true);
				setVisible(false);
			}
			else if(buttonPressed.equals(post)){
				PostForm pf=new PostForm(user1);
				pf.setVisible(true);
				setVisible(false);
			}
			else if(buttonPressed.equals(update)){
				Update u=new Update(user1);
				u.setVisible(true);
				setVisible(false);
			}
			
			else if(buttonPressed.equals(wall)){
				FileManger fm=new FileManger();
				Wall w=new Wall(fm.readPost(),user1);
				w.setVisible(true);
				setVisible(false);
			}
			
			else if(buttonPressed.equals(friendReq)){
				FileManger fm=new FileManger();
				Request r=new Request(fm.readFreindReq(user1),user1);
				r.setVisible(true);
				setVisible(false);
			}
			
			else if(buttonPressed.equals(survey)){
				new Survey().setVisible(true);
			}
			

		}
		
	}
	}