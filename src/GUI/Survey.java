package GUI;

import javax.swing.*;

import GUI.SearchForm.Handler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Survey extends JFrame{
	JLabel J1 =new JLabel("What is your Name ?");
	JLabel J2 =new JLabel("How old are you ?");
	JLabel J3 =new JLabel("Is there any problems you found in our project ?");
	JLabel J4 =new JLabel("Could you be specific in those Problems");
	JLabel J5 =new JLabel("Do you have any other feedbacks ?");
	JButton B1 = new JButton("Submit");
	JButton B2 = new JButton("Exit");
	JTextField a1 = new JTextField();
	JTextField a2 = new JTextField();
	JTextField a3 = new JTextField();
	JTextField a4 = new JTextField();
	JTextField a5 = new JTextField();
	
	public Survey() {
		setVisible(true);
		setSize(500,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Survey");
		setLayout(null);
		setResizable(false);
		
		J1.setBounds(5, 10, 200, 30);
		a1.setBounds(300, 10, 170, 30);
		J2.setBounds(5, 50, 150, 30);
		a2.setBounds(300, 50, 170, 30);
		J3.setBounds(5, 90, 270, 30);
		a3.setBounds(300, 90, 170, 30);
		J4.setBounds(5, 130, 270, 30);
		a4.setBounds(300, 130, 170, 30);
		J5.setBounds(5, 170, 270, 30);
		a5.setBounds(300, 170, 170, 30);
		B1.setBounds(100,220,100,30);
		B2.setBounds(250, 220, 75, 30);
		
		add(J1);
		add(a1);
		add(J2);
		add(a2);
		add(J3);
		add(a3);
		add(J4);
		add(a4);
		add(J5);
		add(a5);
		add(B1);
		add(B2);
		
		Handler h=new Handler();
		
		B1.addActionListener(h);
		B2.addActionListener(h);

	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == B1){
				 
			    if(a1.getText().equals("") || a2.getText().equals("") || a3.getText().equals("")||a4.getText().equals("")|| a5.getText().equals("")) {
			        
			        JOptionPane.showMessageDialog(null, "Please Fill all Qusetions !");
			    }else {
			        B1.setEnabled(true);
			        JOptionPane.showMessageDialog(null, "Thank You For you Support !", "Confirm" ,JOptionPane.OK_OPTION);
			        System.exit(0);
			    }
			
			
			
		}else if(e.getSource() == B2){
			System.exit(0);
		}

			
		}
		
	}


}
