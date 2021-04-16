package chapter5;

public class OrderTest {

	public static void main(String[] args) {
		Order order = new Order();
		order.OrderNumber = 201907210001L;
		order.OrderID = "abc123";
		order.OrderDate = "2019년 7월 21일";
		order.OrderName = "홍길순";
		order.OrderItemNumber = "PD0345-12";
		order.address = "서울시 영등포구 여의도동 20번지";
		
		System.out.println("주문 번호: " + order.OrderNumber);
		System.out.println("주문자 아이디: " + order.OrderID);
		System.out.println("주문 날짜: " + order.OrderName);
		System.out.println("주문자 이름: " + order.OrderName);
		System.out.println("주문 상품 번호: " + order.OrderItemNumber);
		System.out.println("배송 주소: " + order.address);
	}

}
