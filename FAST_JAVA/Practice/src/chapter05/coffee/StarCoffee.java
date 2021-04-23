package chapter05.coffee;

public class StarCoffee {

	int money;
	
	public String brewing(int money) {
	
		this.money += money;
		if(money == Menu.STARAMERICANO) {
			return "스타 다방 아메리카노를 구입했습니다.";
		}else if(money == Menu.STARALATTE) {
			return "스타 다방 라때를 구입했습니다.";
		}
		else 
			return null;
		
	}
}
