package chapter5.coffee;

public class BeanCoffee {
	
	int money;
	
	public String brewing(int money) {
	
		this.money += money;
		if(money == Menu.BAENAMERICANO) {
			return "�� �ٹ� �Ƹ޸�ī�븦 �����߽��ϴ�.";
		}else if(money == Menu.BAENALATTE) {
			return "�� �ٹ� �󶧸� �����߽��ϴ�.";
		}
		else 
			return null;
		
	}

}
