import java.util.*;

public class AccountsTester {
	private static String name;
	private static double balance;
	private static String accountType;
	private static int enteredAccountNumber;
	private static int createdAccountNumber = 100;
	private static String action;
	private static int accountWithdraws = 0;
	private static double depositAmmount;
	private static double withdrawAmount;
	private static int m;
	private static ArrayList<CheckingAccount> checkingArrayList = new ArrayList<CheckingAccount>();
	private static ArrayList<SavingsAccount> savingsArrayList = new ArrayList<SavingsAccount>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean createOrAccess = true;
		while (createOrAccess == true) {
			System.out.print("Type A to access existing account. Type B to create account. \n");
			action = scnr.next();
			if (action.equals("B")) {
				System.out.print("Name: ");
				name = scnr.next();
				System.out.print("Account Type (Savings or Checking): ");
				accountType = scnr.next();
				System.out.print("Initial Balance: ");
				balance = scnr.nextDouble();
				createdAccountNumber = createdAccountNumber + 1;
				System.out.println("Account Number: " + createdAccountNumber);
				if (accountType.equals("Savings")) {
					savingsArrayList.add(new SavingsAccount(name, balance, createdAccountNumber));
				} else if (accountType.equals("Checking")) {
					checkingArrayList.add(new CheckingAccount(name, balance, createdAccountNumber));
				} else {
					System.out.println("Invalid Account Type.");
				}
			} else if (action.equals("A")) {
				System.out.print("Enter Account Number: ");
				enteredAccountNumber = scnr.nextInt();
				System.out.print("Enter Account Type: ");
				accountType = scnr.next();
				if (accountType == "Checking") {
					for (int i = 0; i < checkingArrayList.size(); i++) {
						if (checkingArrayList.get(i).getAccountNumber() == enteredAccountNumber) {
							balance = checkingArrayList.get(i).getBalance();
							accountType = checkingArrayList.get(i).typeOfAccount();
							name = checkingArrayList.get(i).getName();
							m = i;
						}
					}
				} else if (accountType == "Savings") {
					for (int i = 0; i < savingsArrayList.size(); i++) {
						if (savingsArrayList.get(i).getAccountNumber() == enteredAccountNumber) {
							balance = savingsArrayList.get(i).getBalance();
							accountType = savingsArrayList.get(i).typeOfAccount();
							name = savingsArrayList.get(i).getName();
							m = i;
						}
					}
				}
				menu();
			}
		}
	}

	public static void menu() {
		Scanner scnr = new Scanner(System.in);
		boolean quit = false;
		while (quit == false) {
			System.out.println("D)eposit	W)ithdraw	M)onth end	Q)uit");
			System.out.print("");
			if (scnr.nextLine().equals("D") && accountType.equals("Checking")) {
				System.out.print("Deposit Amount: ");
				depositAmmount = scnr.nextDouble();
				checkingArrayList.get(m).deposit(depositAmmount);

			} else if (scnr.nextLine().equals("D") && accountType.equals("Savings")) {
				System.out.print("Deposit Amount: ");
				depositAmmount = scnr.nextDouble();
				savingsArrayList.get(m).deposit(depositAmmount);

			} else if (scnr.nextLine().equals("W")) {
				System.out.print("Withdraw Amount: ");
				withdrawAmount = scnr.nextDouble();

				if (accountType.equals("Checking")) {
					checkingArrayList.get(m).withdraw(withdrawAmount);
				} else if (accountType.equals("Savings")) {
					savingsArrayList.get(m).withdrawSavings(withdrawAmount);
				}

			} else if (scnr.nextLine().equals("M")) {
				if (accountType.equals("Savings")) {
					savingsArrayList.get(m).addInterest();
				}
			} else if (scnr.nextLine().equals("Q")) {
				System.out.println("Have a nice day!");
				quit = true;
			}
		}
	}
}