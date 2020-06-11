package project;

public class MainProcess {
	start Start;
	admin Admin;
	order Order;

	public static void main(String[] args) {

		// 메인클래스 실행
		MainProcess main = new MainProcess();
		main.Start = new start(); // start 실행
		main.Start.setMain(main); // start 클래스에 메인 클래스보내기
	}

	// admin으로 이동
	public void showAdmin() {
		Start.dispose(); // start 창 닫기
		this.Admin = new admin(); // 관리자 페이지로 이동
	}

	// order로 이동
	public void showOrder() {
		Start.dispose(); // start 창 닫기
		this.Order = new order(); // 관리자 페이지로 이동
	}

}
