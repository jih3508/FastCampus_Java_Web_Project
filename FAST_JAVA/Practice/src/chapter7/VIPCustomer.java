package chapter7;

public class VIPCustomer extends Customer{
	
	double salesRatio;
	private int agentID;
	
	public VIPCustomer() {
		
		super(); 
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		this.agentID = 00000;
		
		//System.out.println("VIPCustomer() 호출");
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		this.agentID = agentID;
		
		//System.out.println("VIPCustomer() 호출");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}
	
	
}
