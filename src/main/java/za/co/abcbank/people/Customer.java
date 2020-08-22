 package za.co.abcbank.people;

import java.util.Scanner;
import za.co.abcbank.bank.Account;
import za.co.abcbank.bank.Statement;
import za.co.abcbank.bank.Card;

public class Customer {
public Customer () {}

  public String firstName;
  public String lastName;
  public String gander;
  public String phoneNumber;
  public String email;
  public String idNumber;
  public String dateOfBirth;
  public Account account;
  public int num = 0;

	public void creatAccount(Scanner scan, Account account, Card card) {
                System.out.print("Enter First Name :");
                this.firstName = scan.nextLine();
                this.firstName = scan.nextLine();
                System.out.print("Enter Last Name :");
                this.lastName = scan.nextLine();
                System.out.print("Enter Gander :");
                this.gander = scan.nextLine();
                System.out.print("Enter Your Phone Number :");
                this.phoneNumber = scan.nextLine();
                System.out.print("Enter Your email :");
                this.email = scan.nextLine();
                System.out.print("Enter Your id Number :");
                this.idNumber = scan.nextLine();
                System.out.print("Enter Your Date of Birth :");
                this.dateOfBirth = scan.nextLine();
                System.out.print("Enter your Account Number :");
                account.accountNumber =scan.nextLong();
                System.out.print("Enter Account Type :");
                account.accountType = scan.nextLine();
                account.accountType = scan.nextLine();
                System.out.print("Card Number :");
                card.cardNumber = scan.nextLong();
                System.out.print("Pin :");
                card.pin = scan.nextInt();
                account.card = card;
                this.account = account;
        }
        public void deposit(Customer[] customers, Scanner scan) {
		double amountDep = 0;
		double balance = 0;
                for(int a = 0; a < customers.length; a++){
			     Statement statement = new Statement();
                        System.out.print("Enter Account Number :");
                        long accountNumber = scan.nextLong();
			System.out.print("Enter Pin :");
			int pin = scan.nextInt();
                        if(customers[a].account.accountNumber == accountNumber && customers[a].account.card.pin == pin){
                        System.out.print("Enter Amount:R");
                        amountDep = scan.nextDouble();
                        if(amountDep >= 0) {
                        customers[a].account.balance = customers[a].account.balance + amountDep;
                        balance = customers[a].account.balance;
			statement.type = "DEPOSIT";
			statement.date = "10/05/2020";
            statement.amount = amountDep;
			System.out.println("Transaction successful. Current Balance: R" + balance);
                        customers[a].account.statements[num++] = statement;
                        }else{
                        System.out.println("ERROR");
                        }
                        }else{
                        System.out.println("Account not found");
                        }
                }
        }
	public void withdraw(Customer[] customers, Scanner scan){
		Statement statement = new Statement();
		double amountWith = 0;
                for(int a = 0; a < customers.length; a++){
			System.out.print("Enter account Number :");
			long accountNumber = scan.nextLong();
                        System.out.print("Enter PIN : ");
                        int pin = scan.nextInt();
                        if(customers[a].account.card.pin == pin && customers[a].account.accountNumber == accountNumber){
                        System.out.print("Enter Amount : R");
                        amountWith = scan.nextDouble();
            if(customers[a].account.balance >= amountWith && amountWith >= 0){
                        customers[a].account.balance = customers[a].account.balance - amountWith;
			statement.type = "WITHDRAWAL";
			statement.date = "10/05/2020";
			statement.amount = amountWith;
			customers[a].account.statements[num++] = statement;
			System.out.println("PLEASE COLLECT YOUR MONEY.");
                        a=a+10;
                        }else{
                        System.out.println("INSUFFICIENT AMOUNT");
                        }
                        }else{
                        System.out.println("Account Not Found.");
                        }
                }
        }
	public void checkBalance(Customer[] customers, Scanner scan){
                for(int a = 0; a < customers.length; a++){
                        System.out.print("Enter Account Number :");
                        long accountNumber = scan.nextLong();
                        System.out.print("Enter Pin :");
                        int pin = scan.nextInt();
			           if(customers[a].account.accountNumber == accountNumber && customers[a].account.card.pin == pin){
                        System.out.println("Balance :R" + customers[a].account.balance);
                        }else{
                        System.out.println("Account Not Found");
                        }
                }
        }
        public void closeAccount(Customer[] customers, Scanner scan) {
                for(int a = 0; a < customers.length; a++) {
                        System.out.print("Enter Account Number :");
                        long accountNumber = scan.nextLong();
                        System.out.print("Enter Pin :");
                        int pin = scan.nextInt();
                        if(customers[a].account.accountNumber == accountNumber && customers[a].account.card.pin == pin){
                        for(int m = 0; m < customers.length; m++) {
			System.out.println("choose 1. to close existing account");
			System.out.println("choose 2. to apply for a loan");
			System.out.print("option : ");
			int option = scan.nextInt();
			if(option == 1) {
                        System.out.println("Close Existing Account.");
                        customers[a] = null;
                        System.out.println("Your Account has Been Successfully Close.");
                        }
                        else if(option == 2) {
			System.out.println("service not available at the moment");
			}
			}
			}else{
                        System.out.println("Account Not found.");
                        }
                }
          }
	public void statement(Scanner scan, Customer[] customers) {
			for(int a = 0; a < customers.length; a++) {
			System.out.print("Enter Account Number :");
			long accountNumber = scan.nextLong();
			System.out.print("Enter Pin :");
			int pin = scan.nextInt();
			if(customers[a].account.accountNumber == accountNumber && customers[a].account.card.pin == pin){
                for(int i =0; i < num; i++) {
                System.out.println("Date : " + customers[a].account.statements[i].date);
                System.out.println("Type : " + customers[a].account.statements[i].type);
                System.out.println("Amount : " + customers[a].account.statements[i].amount);
                }
    			a=100;
			}
			else{
			System.out.println("Account Not Found");
			}
		}
	}
}
