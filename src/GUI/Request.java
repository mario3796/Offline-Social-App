package GUI;

import javax.swing.*;
import App.User;
import GUI.SearchForm.Handler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Request extends JFrame{

	private JButton accept,reject,back;
	private JTextField username; 
	private FlowLayout fl;
	private ArrayList<JButton>accepts;
	private ArrayList<JButton>rejects;
	private ArrayList<JTextField>names;
	ArrayList<User>users;
	User user1;
	
	public Request(ArrayList<User>users,User user1) {
		setTitle("Friend Request");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		accepts=new ArrayList<>();
		rejects=new ArrayList<>();
		names=new ArrayList<>();
		
		this.users=users;
		this.user1=user1;
		
		Container cp=getContentPane();
		fl=new FlowLayout();
		cp.setLayout(fl);
		
		for (int i = 0; i < users.size(); i++) {
			username=new JTextField(users.get(i).getF_name()+" "+users.get(i).getL_name(), 25);
			username.setEditable(false);
			accept=new JButton("Accept");
			reject=new JButton("Reject");
			names.add(username);
			accepts.add(accept);
			rejects.add(reject);
		}
		
		for (int i = 0; i < users.size(); i++) {
			cp.add(names.get(i));
			cp.add(accepts.get(i));
			cp.add(rejects.get(i));
		}
		
		for (int i = 0; i < users.size(); i++) {
			Handler myhandler=new Handler();
			accepts.get(i).addActionListener(myhandler);
			rejects.get(i).addActionListener(myhandler);
		}
		
		Handler myhandler=new Handler();
		back=new JButton("Back");
		cp.add(back);
		back.addActionListener(myhandler);
		
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object buttonPressed=e.getSource();
			
			for (int i = 0; i < accepts.size(); i++) {
			if(buttonPressed.equals(accepts.get(i))){
				accepts.get(i).setVisible(false);
				rejects.get(i).setVisible(false);
				names.get(i).setVisible(false);
			}
			
			else if(buttonPressed.equals(rejects.get(i))){
				accepts.get(i).setVisible(false);
				rejects.get(i).setVisible(false);
				names.get(i).setVisible(false);
			}
			
		}
			
			if(buttonPressed.equals(back)){
				MyProfile p=new MyProfile(user1);
				p.setVisible(true);
				setVisible(false);
			}
		
	}

	}
}
