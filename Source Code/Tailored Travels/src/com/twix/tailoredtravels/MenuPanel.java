/**
 * Panel for main menu
 * @author Christopher Pagan
 * @version 1.0
 */

package com.twix.tailoredtravels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MenuPanel extends JPanel {

	private JButton calcRoute, calcDist, addLocation, removeLocation, addUser, removeUser;
	private JLabel welcomeMsg,availMsg;
	private JList<String> locations;
	private JScrollPane scroller;
	private boolean isAdmin;
	private JPanel p1, p2, p3, p4, p5;
	private DatabaseManager dbm;
	
	public MenuPanel(DatabaseManager dbm,String user, boolean admin){
		
		this.dbm = dbm;
		isAdmin = admin;
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		if (isAdmin)
		{
			addLocation = new JButton("Add Location");
			removeLocation = new JButton("Remove Location");			
			addUser = new JButton("Add User");
			removeUser = new JButton("Remove User");
			
			p2.add(addLocation);
			p2.add(removeLocation);
			p3.add(addUser);
			p3.add(removeUser);
			
			addLocation.addActionListener(new AddLocListener());
			removeLocation.addActionListener(new RemLocListener());
			addUser.addActionListener(new AddUserListener());
			removeUser.addActionListener(new RemUserListener());
			
		}
		
		welcomeMsg = new JLabel("Welcome back, " + user + "!");
		p1.add(welcomeMsg);
		availMsg = new JLabel("Available Locations");
		locations = new JList<String>();
		locations.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroller = new JScrollPane(locations);
		calcRoute = new JButton("Calculate Route");
		calcDist = new JButton("Calculate Distance");
		
		calcRoute.addActionListener(new RouteListener());
		calcDist.addActionListener(new DistListener());
		
		p4 = new JPanel();
		p4.add(availMsg);
		p4.add(locations);
		p4.add(scroller);
		p5 = new JPanel();
		p5.add(calcRoute);
		p5.add(calcDist);
		
	}
	
	/**
	 * Finds the list of locations for the user and uses them to fill the JList
	 * @param locations2 list of Locations containing waypoint information.
	 */
	public void populateJList(LinkedList<Waypoint> locations2)
	{
		Vector<String> locs = new Vector<String>();
		for (Waypoint loc : locations2)
			locs.add(loc.getName());
		this.locations.setListData(locs);
	}
	
	/**
	 * Add appropriate components to the main menu.
	 */
	public void addComponents()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(p1);
		
		if(isAdmin)
		{
			add(p2);
			add(p3);
		}
		
		add(p4);
		add(p5);
	}
	
	private class AddLocListener implements ActionListener{
			
			/**
			 * Overwritten method for ActionListener class. 
			 * Prompts for waypoint data and adds it to the system.
			 * @param ae An ActionEvent is created when the user clicks the "Add Location" button
			 */
			public void actionPerformed(ActionEvent ae) {
				
				//dbm.addUserLocation(addLocation)
			}
	}
	
	private class RemLocListener implements ActionListener{
		
		/**
		 * Overwritten method for ActionListener class. 
		 * Prompts for waypoint data and removes it from the system.
		 * @param ae An ActionEvent is created when the user clicks the "Remove Location" button
		 */
		public void actionPerformed(ActionEvent ae) {
			
			LinkedList<Waypoint> waypoints = dbm.getUserLocations();
			String[] waypointNames = new String[waypoints.size()];
			for (int i = 0; i < waypoints.size(); i++)
			{
				waypointNames[i] = waypoints.get(i).getName();
			}
			String remLoc = (String) JOptionPane.showInputDialog(null, "Which location would you like to remove?",
					"Remove Location", JOptionPane.PLAIN_MESSAGE, null, waypointNames, waypointNames[0]);
			System.out.println(remLoc);
			dbm.removeLocation(remLoc);
			}
		}
	
	private class AddUserListener implements ActionListener{
		
		/**
		 * Overwritten method for ActionListener class. 
		 * Prompts for user data and adds it to the system.
		 * @param ae An ActionEvent is created when the user clicks the "Add User" button
		 */
		public void actionPerformed(ActionEvent ae) {
		
		//dbm.addUser(name, password, admin);
		}
	}
	
	private class RemUserListener implements ActionListener{
		
		/**
		 * Overwritten method for ActionListener class. 
		 * Prompts for user data and removes it from the system.
		 * @param ae An ActionEvent is created when the user clicks the "Remove User" button
		 */
		public void actionPerformed(ActionEvent ae) {
			
			//dbm.removeUser(name); //No need for password?
		}
	}
	
	private class RouteListener implements ActionListener{

		
		/**
		 * Overwritten method for ActionListener class. 
		 * Calculates the route given the waypoints the user has selected.
		 * @param ae An ActionEvent is created when the user clicks the "Calculate Route" button
		 */
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	
	public class DistListener implements ActionListener{

		/**
		 * Overwritten method for ActionListener class. 
		 * Prompts for starting and ending waypoint data and finds the distance between them.
		 * @param ae An ActionEvent is created when the user clicks the "Calculate Distance" button
		 */
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}