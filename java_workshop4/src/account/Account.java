package account;

public class Account {
	
	// Field 
	private String account;
	private int balance;
	private double interesRate;
	
	// 생성자 
	public Account() {}
	public Account(String account, int balance, double interesRate) {
		this.account = account;
		this.balance = balance;
		this.interesRate = interesRate;
	}
	
	// getter setter 
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public double getInteresRate() {
		return interesRate;
	}
	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}
	
	// 이자정보
	public double calculateInterest() {
		return getBalance() * (interesRate / 100);
	}
	
	// 입금정보
	public void deposit(int money) {
		balance = getBalance() + money; 
	}
	
	// 출금정보
	public void withdraw(int money) {
		balance = getBalance() - money;
	}
	
	// account 모든정보출력
	public void accountInfo() {
		System.out.print("계좌번호: " + getAccount() + 
						   " 잔액: " + getBalance() + 
						   " 이자율: " + getInteresRate() + "%");
	}
	
	
}
