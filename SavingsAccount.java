
public class SavingsAccount extends Account {
	private double savingsBalance;
	private double interest = 0.06;
	public SavingsAccount(String name, double accountBalance, int accountNumber) {
		super(name, accountBalance, "Savings", accountNumber);
		savingsBalance = accountBalance;
	}
	public void interest(double args) {
		savingsBalance = savingsBalance + savingsBalance * 0.06;
	}
	public void withdrawSavings(double withdrawal) {
		savingsBalance = this.savingsBalance - withdrawal;
		System.out.println("Transaction Complete. Balance: $: " + savingsBalance);
	}
	public void addInterest() {
		savingsBalance = savingsBalance + savingsBalance * interest;
		System.out.println("Transaction Complete. Balance: $: " + savingsBalance);
	}
}

