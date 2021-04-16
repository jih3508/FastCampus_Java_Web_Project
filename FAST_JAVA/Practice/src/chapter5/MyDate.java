package chapter5;

public class MyDate {

	private int year;
	private int month;
	private int day;
	
	private boolean isVaild = true;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 1 || month >12) {
			this.isVaild = false;
		}
		else {
			this.month = month;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (day < 0 || day > 31) {
					this.isVaild = false;
				}
				else {
					this.day =day;
				}
				break;
			case 4: case 6: case 9: case 11:
				if (day < 0 || day > 30) {
					this.isVaild = false;
				}
				else {
					this.day = day;
				}
				break;
			case 2:
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 100) {
					if (day <0 || day > 29) {
						this.isVaild = false;
					}
					else {
						this.day =day;
					}
				}
				else {
					if(day <0 || day > 28) {
						this.isVaild = false;
					}
					else {
						this.day =day;
					}
				}
				break;
			default:
				this.isVaild = false;
		}
		this.day = day;
	}

	public MyDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public String isValid() {
		if (isVaild) {
			return "유효한 날짜 입니다.";
		}
		else {
			return "유효하지 않은 날짜 입니다.";
		}
	}
}
