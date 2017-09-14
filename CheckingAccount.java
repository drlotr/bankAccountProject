
public class CheckingAccount extends Account {
	private int actions = 0;
	private double balance;

	public CheckingAccount(String name, double accountBalance, int accountNumber) {
		super(name, accountBalance, "Checking", accountNumber);
	}
	public void withdraw(double amount) {
		if (actions < 4) {
			balance = balance - amount;
			System.out.println("Transaction Complete. Balance: $" + balance);
			System.out.println("You have " + actions + "used.");
		} else if (actions > 4) {
			balance = balance - amount - 1;
			System.out.println("Transaction Complete With $1 Fine! Balance: $" + balance);
		}
	}
}