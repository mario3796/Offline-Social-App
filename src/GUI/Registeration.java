package GUI;

import javax.swing.*;
import App.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registeration extends JFrame{
	private JLabel f_name,l_name,gender,email_address,password,age;
	private JButton signup,back;
	private JTextField fname,lname,email,myage;
	private JPasswordField pf;
	private JRadioButton male,female;
	private ButtonGroup bg;
	
	public Registeration() {
		Container cp=getContentPane();
		setTitle("Registeration");
		f_name=new JLabel("First Name");
		l_name=new JLabel("Last Name");
		email_address=new JLabel("Email Address");
		password=new JLabel("Password");
		age=new JLabel("Age");
		gender=new JLabel("Gender");
		
		myHandler handler=new myHandler();
		
		fname=new JTextField(50);
		lname=new JTextField(50);
		email=new JTextField(50);
		myage=new JTextField(10);
		pf=new JPasswordField(20);
		bg=new ButtonGroup();
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		bg.add(male);
		bg.add(female);
		back=new JButton("Back");
		
		signup=new JButton("Sign up");
		
		cp.add(f_name);
		cp.add(l_name);
		cp.add(email_address);
		cp.add(password);
		cp.add(age);
		cp.add(gender);
		
		cp.add(fname);
		cp.add(lname);
		cp.add(email);
		cp.add(pf);
		cp.add(myage);
		cp.add(male);
		cp.add(female);
		
		cp.add(signup);
		cp.add(back);
		
		signup.addActionListener(handler);
		back.addActionListener(handler);
		
		cp.setLayout(null);
		f_name.setBounds(80, 20, 100, 50);
		l_name.setBounds(80, 70, 100, 50);
		email_address.setBounds(80, 120, 100, 50);
		password.setBounds(80, 170, 100, 50);
		age.setBounds(80, 220, 100, 50);
		gender.setBounds(80, 270, 100, 50);
		
		fname.setBounds(200,35,250,20);
		lname.setBounds(200, 85, 250, 20);
		email.setBounds(200, 135, 250, 20);
		pf.setBounds(200, 185, 250, 20);
		myage.setBounds(200, 235, 250, 20);
		male.setBounds(200,285,90,30);
		female.setBounds(300, 285, 90, 30);
		
		signup.setBounds(200, 380, 90, 30);
		back.setBounds(30, 430, 90, 30);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
	}
	
	private class myHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonPressed=e.getSource();
			if(buttonPressed.equals(signup)){
				if(fname.getText().equals("") || lname.getText().equals("") ||
						email.getText().equals("") || myage.getText().equals("") || pf.getText() .equals("")
						 || !(male.isSelected() || female.isSelected()) ){
					JOptionPane.showMessageDialog(null,"Wrong","Invalid", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					User u=new User();
					u.setF_name(fname.getText());
					u.setL_name(lname.getText());
					u.setEmail_address(email.getText());
					u.setAge(Integer.parseInt(myage.getText()));
					u.setPassword(pf.getText());
					if(male.isSelected())
						u.setGender(male.getText());
					else u.setGender(female.getText());
					u.registery(u);
					JOptionPane.showMessageDialog(null, "Success");
					fname.setText("");
					lname.setText("");
					pf.setText("");
					myage.setText("");
					email.setText("");
					new Welcome("Welcome").setVisible(true);
					setVisible(false);
				}
				
				
			}
					
					else{
						Welcome w=new Welcome("Welcome");
						w.setVisible(true);
						setVisible(false);
					}

		}
		
	}


}