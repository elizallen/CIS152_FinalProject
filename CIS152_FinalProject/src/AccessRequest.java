/**************************************************************
* Name        : AccessRequest
* Author      : Elizabeth Allen
* Created     : 12/7/2022
* Course      : CIS 152 - Data Structures
* Version     : 1.0
* OS          : Windows 10
* IDE		  : Eclipse 2021-06
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program is the AccessRequest class.
* 				Input: Accepts inputs for the AccessRequest class.
*               Output: Prints attributes and methods as called. 
* Academic Honesty: I attest that this is my original work. I have not used 
* unauthorized source code, either modified or unmodified. I have not given 
* other fellow student(s) access to my program.         
***************************************************************/


import java.util.LinkedList;

public class AccessRequest {

	private Employee employee;
	private String priority;
	private LinkedList<String> floorList = new LinkedList<String>();
		
	public AccessRequest(String pri, Employee emp, LinkedList<String> floorList) {
		setEmployee(emp);
		setPriority(pri);
		setFloorList(floorList);
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getPriority() {
		return priority;
	}

	public LinkedList<String> getFloorList() {
		return floorList;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setFloorList(LinkedList<String> floorList) {
		this.floorList = floorList;
	}

	@Override
	public String toString() {
		return priority + " : " + employee + " Floors: " + floorList;
	}

}