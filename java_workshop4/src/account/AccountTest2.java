package account;

public class AccountTest2 {

	public static void main(String[] args) {
		// 5개의 Account 형 객체 배열 선언
		Account[] account = new Account[5];
		// for문을 이용하여 Account 객체를 배열에 생성
		for(int i = 0; i < account.length; i++) {
			String acc = "221-0101-211" + (i + 1);
			account[i] = new Account(acc, 100000, 4.5);
		}
		// for문을 이용하여 Account 정보 출력
		for (Account accounts : account) {
			accounts.accountInfo();
			System.out.println();
		}
		System.out.println();
		// for문을 이용하여 이자율을 변경하고 이자를 화면에 출력
		for(int i = 0; i < account.length; i++) {
			account[i].setInteresRate(3.7);
			account[i].accountInfo();
			System.out.printf(" 이자: %.0f원\n", account[i].calculateInterest());
		}
	}
}
