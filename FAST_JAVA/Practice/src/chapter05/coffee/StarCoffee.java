package chapter05.coffee;

public class StarCoffee {

	int money;
	
	public String brewing(int money) {
	
		this.money += money;
		if(money == Menu.STARAMERICANO) {
			return "��Ÿ �ٹ� �Ƹ޸�ī�븦 �����߽��ϴ�.";
		}else if(money == Menu.STARALATTE) {
			return "��Ÿ �ٹ� �󶧸� �����߽��ϴ�.";
		}
		else 
			return null;
		
	}
}
