package chapter5.coffee;

public class Person {

	private int money;
	private String name;
	
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void buyStarCoffee(StarCoffee coffee, int money) {
		System.out.println(name + "���� " + money + "������ " + coffee.brewing(money));
	}
	
	public void buyBeanCoffee(BeanCoffee coffee, int money) {
		System.out.println(name + "���� " + money + "������ " + coffee.brewing(money));
	}
	
}
