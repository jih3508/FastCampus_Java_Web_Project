package chapter5;

public class OrderTest {

	public static void main(String[] args) {
		Order order = new Order();
		order.OrderNumber = 201907210001L;
		order.OrderID = "abc123";
		order.OrderDate = "2019�� 7�� 21��";
		order.OrderName = "ȫ���";
		order.OrderItemNumber = "PD0345-12";
		order.address = "����� �������� ���ǵ��� 20����";
		
		System.out.println("�ֹ� ��ȣ: " + order.OrderNumber);
		System.out.println("�ֹ��� ���̵�: " + order.OrderID);
		System.out.println("�ֹ� ��¥: " + order.OrderName);
		System.out.println("�ֹ��� �̸�: " + order.OrderName);
		System.out.println("�ֹ� ��ǰ ��ȣ: " + order.OrderItemNumber);
		System.out.println("��� �ּ�: " + order.address);
	}

}
