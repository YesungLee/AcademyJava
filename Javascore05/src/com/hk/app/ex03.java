package com.hk.app;
import java.util.Scanner;
public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "";
		int n, toeic;
		Scanner scan = new Scanner(System.in);
		System.out.print("이수 학점을 입력하세요. > ");
		n = scan.nextInt();
		System.out.print("토익 점수를 입력하세요. > ");
		toeic = scan.nextInt();
		if (n >=140 && toeic >=700) {
			result = "졸업을 축하합니다.";
		} else if (n >=140 || toeic <700) {
			result = "아쉽지만 수료하셨습니다.";
		} else {
			result = "졸업이 불가합니다.";
		}
		System.out.println(result);
	}

}
