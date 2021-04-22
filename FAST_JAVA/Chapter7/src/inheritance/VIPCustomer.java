package inheritance;

public class VIPCustomer extends Customer{
	
	double salesRatio;
	private int agentID;
	
	public VIPCustomer() {
		
		super(); 
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		//System.out.println("VIPCustomer() 호출");
	}
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
		//System.out.println("VIPCustomer() 호출");
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}
	
	
}
