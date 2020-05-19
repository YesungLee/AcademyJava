import java.util.*;

public class TripleGame {

	public static void main(String[] args) {
		Random num = new Random(); // Random 클래스 선언
		// choice1 : 시스템 선택, choice2 : 상대방 선택
		// result1 : 시스템 결과, result2 : 상대방 결과, result3 : 플레이어 선택, result4 : 최종 결과
		String result1 = "", result2 = "", result3 = "", result4 = "";
		
		// 시스템의 선택
		int choice1 = num.nextInt(49) + 1; // 50개의 구슬 중 랜덤한 숫자를 choice1에 저장
		if (choice1 % 3 == 1) {
			result1 = "어지";
		} else if (choice1 % 3 == 2) {
			result1 = "니";
		} else {
			result1 = "쌈";
		}
		
		// 상대방의 선택
		int choice2 = num.nextInt(3); // 상대방의 선택을 choice2에 저장
		if (choice2 % 3 == 1) {
			result2 = "어지";
		} else if (choice2 % 3 == 2) {
			result2 = "니";
		} else {
			result2 = "쌈";
		}
				
		// 플레이어의 선택
		// 플레이어의 선택을 입력 받기 위한 Scanner 클래스 선언
		Scanner scan = new Scanner(System.in);
		System.out.print("'어지', '니', '쌈' 중 하나를 선택하세요 > ");
		result3 = scan.next(); // 예상되는 결과를 result3의 저장
		
		// 시스템, 상대방, 플레이어의 선택 공개
		System.out.println("랜덤으로 뽑은 구슬의 개수 : " + choice1 + "개");
		System.out.println("시스템의 선택 : " + result1);
		System.out.println("상대방의 선택 : " + result2);
		System.out.println("플레이어의 선택 : " + result3);
		
		// 결과처리
		if (result1.equals(result2)) { // 시스템과 상대방의 선택을 비교
			// 시스템과 상대방의 선택이 동일하면 플레이어의 선택을 한 번 더 비교
			if (result2.equals(result3)) {
				result4 = "시스템 에러"; // 시스템, 상대방, 플레이어의 선택이 모두 동일하면 무승부
			} else {
				result4 = "상대방 승리"; // 시스템과 상대방의 선택만 동일
			}
		} else if (result1.equals(result3)) { // 시스템과 플레이어의 값이 동일하면
			result4 = "플레이어 승리";
		} else if (result2.equals(result3)) { // 상대방과 플레이어의 값이 동일하면
			result4 = "시스템 에러";
		} else {
			result4 = "무승부";
		}
		System.out.println(result4);
	}

}