package GUI;

import javax.swing.*;
import App.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame{
	
	private JLabel f_name,l_name,email_address,password,age;
	private JButton update;
	private JTextField fname,lname,email,myage;
	private JPasswordField pass;
	User user;
	
	public Update(User u) {
		
		Container cp=getContentPane();
		
		fname=new JTextField(50);
		lname=new JTextField(50);
		email=new JTextField(50);
		myage=new JTextField(10);
		pass=new JPasswordField(20);
		
		user=u;

		f_name=new JLabel("First Name");
		l_name=new JLabel("Last Name");
		email_address=new JLabel("Email Address");
		password=new JLabel("Password");
		age=new JLabel("Age");
		
		update=new JButton("Update");
		
		cp.add(f_name);
		cp.add(l_name);
		cp.add(email_address);
		cp.add(password);
		cp.add(age);
		
		cp.add(update);
		
		cp.add(fname);
		cp.add(lname);
		cp.add(email);
		cp.add(myage);
		cp.add(pass);
		
		cp.setLayout(null);
		f_name.setBounds(80, 20, 100, 50);
		l_name.setBounds(80, 70, 100, 50);
		email_address.setBounds(80, 120, 100, 50);
		password.setBounds(80, 170, 100, 50);
		age.setBounds(80, 220, 100, 50);
		
		fname.setBounds(200,35,250,20);
		lname.setBounds(200, 85, 250, 20);
		email.setBounds(200, 135, 250, 20);
		pass.setBounds(200, 185, 250, 20);
		myage.setBounds(200, 235, 250, 20);
		
		Handler myhandler=new Handler();
		
		update.setBounds(200, 285, 90, 30);
		update.addActionListener(myhandler);
				
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			User updateduser=new User();
			
			if(fname.getText().equals("") || lname.getText().equals("") ||
					email.getText().equals("") || myage.getText().equals("") || pass.getText() .equals("")){
				JOptionPane.showMessageDialog(null,"Wrong","Invalid", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				updateduser.setF_name(fname.getText());
				updateduser.setL_name(lname.getText());
				updateduser.setEmail_address(email.getText());
				updateduser.setPassword(pass.getText());
				updateduser.setAge(Integer.parseInt(myage.getText()));
				updateduser.setGender(user.getGender());
				updateduser.setId(user.getId());
				User newuser=user.updateProfile(user,updateduser);
				MyProfile p=new MyProfile(newuser);
				p.setVisible(true);
				setVisible(false);
			}
		}
		
	}

}
