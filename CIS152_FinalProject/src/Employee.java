/**************************************************************
* Name        : Employee
* Author      : Elizabeth Allen
* Created     : 12/7/2022
* Course      : CIS 152 - Data Structures
* Version     : 1.0
* OS          : Windows 10
* IDE		  : Eclipse 2021-06
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program is the Employee class.
* 				Input: Accepts inputs for the Employee class.
*               Output: Prints attributes and methods as called. 
* Academic Honesty: I attest that this is my original work. I have not used 
* unauthorized source code, either modified or unmodified. I have not given 
* other fellow student(s) access to my program.         
***************************************************************/

public class Employee {
	
	private String empFirstName;
	private String empLastName;
	private String empID;
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, String Id) {
		setEmpFirstName(fName);
		setEmpLastName(lName);
		setEmpID(Id);
	}
			
	public String getEmpFirstName() {
		return empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}

	@Override
	public String toString() {
		return empID + " " + empLastName + " " + empFirstName;
	}

}
