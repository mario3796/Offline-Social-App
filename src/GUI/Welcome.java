package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame{

	private JButton register,login;
	private GridLayout gl;
	
	public Welcome(String s) {
		super(s);
		myHandler handler=new myHandler();
		register=new JButton("Register");
		register.addActionListener(handler);
		login=new JButton("Log in");
		login.addActionListener(handler);
		gl=new GridLayout(1, 2);
		Container cp=getContentPane();
		cp.setLayout(gl);
		cp.add(register);
		cp.add(login);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
	}
	
	private class myHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object buttonPressed=e.getSource();
			
			if(buttonPressed.equals(register)){
			Registeration r=new Registeration();
			setVisible(false);
			r.setVisible(true);
			}
			
			if(buttonPressed.equals(login)) {
				Login l=new Login();
				setVisible(false);
				l.setVisible(true);
			}
				
		}
			
	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Welcome w=new Welcome("Welcome");
		w.setVisible(true);
	}

}
