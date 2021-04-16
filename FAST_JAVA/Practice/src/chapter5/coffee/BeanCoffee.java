package chapter5.coffee;

public class BeanCoffee {
	
	int money;
	
	public String brewing(int money) {
	
		this.money += money;
		if(money == Menu.BAENAMERICANO) {
			return "콩 다방 아메리카노를 구입했습니다.";
		}else if(money == Menu.BAENALATTE) {
			return "콩 다방 라때를 구입했습니다.";
		}
		else 
			return null;
		
	}

}
