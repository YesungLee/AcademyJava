import java.util.Scanner;
public class LeapYear{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int year;
		year = scan.nextInt();
		
		// year가 4의 배수이면서 100의 배수가 아니거나, 4의 배수이면서 400의 배수일 때
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.println("1");
			} else {
				System.out.println("0");
		}
	}
}