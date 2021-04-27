package Chapter10;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.year * 356 + this.month * 12 + this.day + 
				(year / 4 - year / 100 + year / 400);
	}



	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate date = (MyDate)obj;
			if (date.year == this.year && date.month == this.month && date.day == this.day) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		MyDate date1 = new MyDate(2021, 4, 27);
		MyDate date2 = new MyDate(2021, 4, 27);
		
		System.out.println(date1.equals(date2));
		System.out.println(date1.hashCode());
	}
}
