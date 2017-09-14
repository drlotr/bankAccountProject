
public class Account {
	private int actions;
	private double accountBalance;
	private String name;
	private String typeOfAccount;
	private int accountNumber;
	private double interest = 0.06;
	public Account(String name, double accountBalance, String typeOfAccount, int accountNumber) {
		this.accountBalance = accountBalance;
		this.name = name;
		this.typeOfAccount = typeOfAccount;
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setBalance(double r) {
		accountBalance = r;
	}
	public void deposit(double amount) {
		accountBalance = accountBalance + amount;
		System.out.println("Transaction Complete. Balance: $" + accountBalance);
	}
	public double getBalance() {
		return accountBalance;
	}
	public String typeOfAccount() {
		return typeOfAccount;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
}
