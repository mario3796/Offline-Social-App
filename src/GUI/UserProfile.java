package GUI;

import javax.swing.*;

import App.User;
import File.FileManger;
import GUI.SearchForm.Handler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame{
	
	private JTextField fullName,email,gender,age;
	private JLabel Full_name,Email,Gender,Age,picture;
	private JButton home,addfriend;
	User user1,user2;
	
	public UserProfile(User user1, User user2) {
		setTitle("Profile");
		Container cp=getContentPane();
		cp.setLayout(null);
		this.fullName=new JTextField();
		this.email=new JTextField();
		this.age=new JTextField();
		this.gender=new JTextField();
		Handler myhandler=new Handler();
		
		this.user1=user1;
		this.user2=user2;
		
		this.fullName.setText(user2.getF_name()+" "+user2.getL_name());
		this.email.setText(user2.getEmail_address());
		this.gender.setText(user2.getGender());
		this.age.setText(""+user2.getAge());
		
		this.Full_name=new JLabel("Full Name");
		this.Email=new JLabel("Email");
		this.Age=new JLabel("Age");
		this.Gender=new JLabel("Gender");
			
		addfriend=new JButton("Add Friend");
		cp.add(addfriend);
		addfriend.setBounds(200, 480, 100, 25);
		addfriend.addActionListener(myhandler);
		
		home=new JButton("Home");
		home.setBounds(200, 600, 100, 25);
		cp.add(home);
		home.addActionListener(myhandler);

		cp.add(this.fullName);
		cp.add(this.email);
		cp.add(this.age);
		cp.add(this.gender);
		
		cp.add(this.Full_name);
		cp.add(this.Email);
		cp.add(this.Age);
		cp.add(this.Gender);
		
		this.Full_name.setBounds(70, 260, 60, 25);
		this.fullName.setBounds(150, 260, 200, 25);
		this.Email.setBounds(70, 310, 60, 25);
		this.email.setBounds(150, 310, 200, 25);
		this.Age.setBounds(70, 360, 60, 25);
		this.age.setBounds(150, 360, 200, 25);
		this.Gender.setBounds(70, 410, 60, 25);
		this.gender.setBounds(150, 410, 200, 25);
		
		this.fullName.setEditable(false);
		this.email.setEditable(false);
		this.age.setEditable(false);
		this.gender.setEditable(false);
		
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
			if(buttonPressed.equals(home)){
				MyProfile pf=new MyProfile(user1);
				pf.setVisible(true);
				setVisible(false);
			}
			else if(buttonPressed.equals(addfriend)){
				user1.addFriend(user1,user2);
			}
		}
		
	}
}
