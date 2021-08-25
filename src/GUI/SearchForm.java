package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import App.User;
import File.FileManger;

public class SearchForm extends JFrame{
	
	private JLabel name,age;
	private JButton search,back;
	private JTextField userAge,userName;
	private JList<String>userList;
	private DefaultListModel<String>list;
	User user1;

	public SearchForm(User u) {
		setTitle("Search");
		name=new JLabel("Name");
	    age=new JLabel("Age");
	    userName=new JTextField(50);
	    userAge=new JTextField(20);
	    search=new JButton("Search");
	    back=new JButton("Back");
	    Handler myhandler=new Handler();
	    user1=u;
	    
	    Container cp=getContentPane();
	
	    cp.add(name);
	    cp.add(age);
	    cp.add(userName);
	    cp.add(userAge);
	    cp.add(search);
	    cp.add(back);

	    cp.setLayout(null);
	
	    name.setBounds(50, 50, 100, 50);
	    age.setBounds(50, 100, 100, 50);
	    userName.setBounds(150, 60, 250, 25);
	    userAge.setBounds(150, 110, 250, 25);
	    search.setBounds(50, 180, 100, 25);
	    back.setBounds(50, 300, 100, 25);
	    back.addActionListener(myhandler);
	    search.addActionListener(myhandler);

	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 400);
	}
	
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object buttonPressed=e.getSource();
			if(buttonPressed.equals(back)){
				setVisible(false);
				MyProfile pf=new MyProfile(user1);
				pf.setVisible(true);
			}
			else if(buttonPressed.equals(search)){
				User u=new User();
				ArrayList<User>users=u.search(userName.getText(), userAge.getText());
				
                list = new DefaultListModel<>();                
				for (int i = 0; i < users.size(); i++) {
					list.addElement(users.get(i).getF_name()+" "+users.get(i).getL_name());
				}
				userList=new JList<>(list);
				
                Container cp = getContentPane();
                cp.add(userList);
                userList.setBounds(200, 180, 200, 100);
                userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                Handler1 handler=new Handler1();
                userList.addListSelectionListener(handler);
			}
		}
		
	}
	
	private class Handler1 implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			FileManger fm=new FileManger();
			String selected=userList.getSelectedValue();
			User user2=fm.getUserProfile(selected);
				setVisible(false);
				UserProfile pf=new UserProfile(user1,user2);
				pf.setVisible(true);
				}
		
	}
	
	
}
