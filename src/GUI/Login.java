package GUI;

import javax.swing.*;
import App.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
	
	private JLabel username,password;
	private JTextField user_name;
	private JPasswordField pass;
	private JButton login,back;
	
	public Login() {
		
		username=new JLabel("User name");
		password=new JLabel("Password");
		user_name=new JTextField(50);
		pass=new JPasswordField(20);
		login=new JButton("Log in");
		back=new JButton("Back");
		Handler handler=new Handler();
		setTitle("Log in");
		
		Container cp=getContentPane();
		
		cp.add(username);
		cp.add(password);
		cp.add(user_name);
		cp.add(pass);
		cp.add(login);
		cp.add(back);
		
		cp.setLayout(null);
		
		username.setBounds(50, 50, 100, 50);
		password.setBounds(50, 100, 100, 50);
		user_name.setBounds(150, 60, 250, 25);
		pass.setBounds(150, 110, 250, 25);
		login.setBounds(200, 180, 100, 25);
		back.setBounds(10, 240, 100, 25);
		back.addActionListener(handler);
		login.addActionListener(handler);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
 			Object buttonPressed=e.getSource();
			if(buttonPressed.equals(back)){
				Welcome w=new Welcome("Welcome");
				w.setVisible(true);
				setVisible(false);
			}
			
			else{
				User u = new User();
				u=u.login(user_name.getText(), pass.getText());
				if(u!=null)
				{
					setVisible(false);
					MyProfile pf=new MyProfile(u);
					pf.setVisible(true);
				}
				
				else JOptionPane.showMessageDialog(null,"Wrong","No Account", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}


}
