/**************************************************************
* Name        : SecurityGUI
* Author      : Elizabeth Allen
* Created     : 12/7/2022
* Course      : CIS 152 - Data Structures
* Version     : 1.0
* OS          : Windows 10
* IDE		  : Eclipse 2021-06
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program is the SecurityGUI class.
* 				Input: Accepts user input through the GUI.
*               Output: Prints attributes and methods as called. 
* Academic Honesty: I attest that this is my original work. I have not used 
* unauthorized source code, either modified or unmodified. I have not given 
* other fellow student(s) access to my program.         
***************************************************************/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SecurityGUI implements ActionListener {

	JFrame secFrame = new JFrame();
	JLabel empID = new JLabel("Employee ID");
	JLabel lname = new JLabel("Last Name");
	JLabel fname = new JLabel("First Name");
	JTextField employeeID = new JTextField();
	JTextField firstName = new JTextField();
	JTextField lastName = new JTextField();	
	JTextArea displayEmp = new JTextArea();
	JLabel secTitle = new JLabel("Select access options: ");
	JCheckBox newEmp = new JCheckBox("New");
	JCheckBox currentEmp = new JCheckBox("Current");
	JCheckBox f1 = new JCheckBox("Floor 1");
	JCheckBox f2 = new JCheckBox("Floor 2");
	JCheckBox dept1 = new JCheckBox("Entrance");
	JCheckBox dept2 = new JCheckBox("Security");
	JCheckBox dept3 = new JCheckBox("IT");
	JButton subButton = new JButton("Submit Request");
	JButton clrButton = new JButton("Clear");
	JButton dsplyButton = new JButton("Display Requests");
	
	//Priority Queue for security requests submitted through GUI
	private PriorityQueue<String> securityRequestQueue = new PriorityQueue<>();
	
	//Date stamp for priority requests
	private Date dateStamp = new Date();
	
	public SecurityGUI(){

		empID.setBounds(30,20,80,25);
		lname.setBounds(30,60,80,25);
		fname.setBounds(30,100,80,25);

		employeeID.setBounds(120,20,120,25);
		firstName.setBounds(120,60,120,25);
		lastName.setBounds(120,100,120,25);
		
		newEmp.setBounds(30,140,50,20);
		
		displayEmp.setBounds(290,20,455,300);
		
		secTitle.setBounds(30,170,200,25);
					
		f1.setBounds(100,195,100,20);
		f2.setBounds(100,280,100,20);
		
		dept1.setBounds(125,215,100,20);
		dept2.setBounds(125,250,100,20);
		dept3.setBounds(125,305,100,20);

		subButton.setBounds(30,400,150,30);

		clrButton.setBounds(200,400,80,30);
		
		dsplyButton.setBounds(300,400,150,30);
		
		f1.addActionListener(this);
		f2.addActionListener(this);
		
		clrButton.addActionListener(this);
		
		secFrame.add(empID);
		secFrame.add(lname);
		secFrame.add(fname);
		secFrame.add(employeeID);
		secFrame.add(firstName);
		secFrame.add(lastName);
		secFrame.add(f1);
		secFrame.add(f2);
		secFrame.add(newEmp);
		secFrame.add(dept1);
		secFrame.add(dept2);
		secFrame.add(dept3);
		secFrame.add(clrButton);
		secFrame.add(subButton);
		secFrame.add(secTitle);
		secFrame.add(displayEmp);
		secFrame.add(dsplyButton);
		
		//Using submit button will activate this method
		subButton.addActionListener(event -> addEmployeeRequest());
		
		//Using display button will activate this method
		dsplyButton.addActionListener(event -> displaySecurityRequests());
		
		secFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		secFrame.setSize(800,500);
		
		secFrame.setLayout(null);
		
		secFrame.setVisible(true);	

	}
		
		
	private void addEmployeeRequest() {
		
		String empPri;
		
		//Employee object created through text fields
		Employee emp = new Employee(firstName.getText(), lastName.getText(), employeeID.getText());
						
		//Setting correct priority, based on checking box (or not check box) for "New"
		if(newEmp.isSelected()) {
			//"A" sets the priority for a new employee.
			empPri = "A" + ":" + dateStamp;
		}
		else {
			//"C" sets the priority for a current employee.
			empPri = "C" + ":" + dateStamp;
		}
		
		//Captures list of floors to be assigned to employee
		LinkedList<String> floorLinkedList = new LinkedList<>();
		
		//Floors
		if(dept1.isSelected()) {
			floorLinkedList.add("Entrance");
		}
		if(dept2.isSelected()) {	
			floorLinkedList.add("Security");
		}
		if(dept3.isSelected()) {
			floorLinkedList.add("IT");
		}
		
			
		//Access Request object
		AccessRequest accReq = new AccessRequest(empPri, emp, floorLinkedList);	
		
		securityRequestQueue.add(accReq.toString());
		
		displayEmp.setText(accReq.toString());
				
	}
	
	
	private void displaySecurityRequests() {
		
		displayEmp.setText("");
		
		for(String req : securityRequestQueue) {
			displayEmp.append(req + "\n");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == f1) {
			if(f1.isSelected()) {
				dept1.setSelected(true);
				dept2.setSelected(true);
			}
			else {
				dept1.setSelected(false);
				dept2.setSelected(false);
			}
		}
		
		if(e.getSource() == f2) {
			if(f2.isSelected()) {
				dept3.setSelected(true);
			}
			else {
				dept3.setSelected(false);
			}
		}
		
		if(e.getSource() == clrButton) {
			employeeID.setText("");
			firstName.setText("");
			lastName.setText("");
			f1.setSelected(false);
			f2.setSelected(false);
			dept1.setSelected(false);
			dept2.setSelected(false);
			dept3.setSelected(false);
		}
		
	}
	
}
