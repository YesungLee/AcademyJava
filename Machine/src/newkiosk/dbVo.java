package newkiosk;

public class dbVo {

	   int no;
	   String menu;

	   public dbVo() {

	   }

	   public dbVo(int no, String menu) {
	      this.no = no;
	      this.menu = menu;
	   }

	   public int getNo() {
	      return no;
	   }

	   public void setNo(int no) {
	      this.no = no;
	   }

	   public String getMenu() {
	      return menu;
	   }

	   public void setMenu(String menu) {
	      this.menu = menu;
	   }

	}