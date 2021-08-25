package GUI;

import javax.swing.*;

import App.Post;
import App.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Wall extends JFrame{

	private JTextField userPost;
	private JTextArea post_content;
	private FlowLayout fl;
	private JButton back;
	User user1;
	
	public Wall(ArrayList<Post>posts,User user1) {
		
		ArrayList<JTextField>userposts=new ArrayList<>();
		ArrayList<JTextArea>contents=new ArrayList<>();
		
		fl=new FlowLayout();
		Container cp=getContentPane();
		cp.setLayout(fl);
		
		setTitle("Wall");
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		for (int i = 0; i < posts.size(); i++) {
			userPost=new JTextField(posts.get(i).getUserPost(),15);
			userPost.setEditable(false);
			post_content=new JTextArea(posts.get(i).getPost_content(),2,40);
			post_content.setEditable(false);
			userposts.add(userPost);
			contents.add(post_content);
		}
		
		for (int i = 0; i < posts.size(); i++) {
			cp.add(userposts.get(i));
			cp.add(contents.get(i));
		}
		
		Handler myhandler=new Handler();
		back=new JButton("Back");
		cp.add(back);
		back.addActionListener(myhandler);
		
		this.user1=user1;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 700);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MyProfile p=new MyProfile(user1);
			p.setVisible(true);
			setVisible(false);
		}
		
	}
}
