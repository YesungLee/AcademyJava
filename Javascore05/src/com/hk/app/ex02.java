package com.hk.app;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 > ");
		int n = scan.nextInt();
		String result = "";
		if (n % 3 == 0) {
			result = "3의 배수이다.";
		} else {
			result = "3의 배수가 아니다.";
		}
		System.out.println(result);
	}

}
