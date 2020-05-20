import java.util.Scanner;

public class Clock {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int h, m;
		h = scan.nextInt();
		m = scan.nextInt();
		
		if (m < 45) {
			if (h >= 1) {
				m = m + 15;
				h = h - 1;
			} else {
				m = m + 15;
				h = 23;
			}
		} else {
			m = m -45;
		}
		System.out.println(h + " " + m);
	}
}