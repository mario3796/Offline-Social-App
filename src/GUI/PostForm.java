package GUI;

import javax.swing.*;

import App.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostForm extends JFrame{

	private JButton post,back;
	private TextArea postArea;
	private FlowLayout fl;
	User user1;
	
	public PostForm(User u) {
		setTitle("Post");
		Container cp=getContentPane();
		fl=new FlowLayout();
		cp.setLayout(fl);
		postArea=new TextArea(15,50);
		cp.add(postArea);
		
		this.user1=u;
		
		post=new JButton("Post");
		cp.add(post);
		Handler myhandler=new Handler();
		post.addActionListener(myhandler);
		
		back=new JButton("Back");
		cp.add(back);
		back.addActionListener(myhandler);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400, 400);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonPressed=e.getSource();
			if(buttonPressed.equals(post)){
				user1.writePost(postArea.getText(),user1);
			}
			
			else if(buttonPressed.equals(back)){
				setVisible(false);
				MyProfile pf=new MyProfile(user1);
				pf.setVisible(true);
			}
		}
		
	}

}
