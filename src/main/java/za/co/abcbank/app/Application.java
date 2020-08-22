package za.co.abcbank.app;

import za.co.abcbank.bank.Account;
import za.co.abcbank.bank.Card;
import za.co.abcbank.bank.Statement;
import za.co.abcbank.people.Customer;
import java.util.Scanner;

public class Application {
Application () {}

public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
Customer[] customers = new Customer[1];
Customer customer = null;
Account account = null;
Statement statement = null;
Card card = null;

    for(int z = 0; z < 2; z--) {
    System.out.println("welcome to ABC Bank");
    System.out.println("choose an option from the list below");
    System.out.println("choose 1. for Open Account");
    System.out.println("choose 2. for Deposit");
    System.out.println("choose 3. for Withdraw");
    System.out.println("choose 4. for Check Balance");
    System.out.println("choose 5. for Statements");
    System.out.println("choose 6. for Other Options");
    System.out.println("choose 0. for CANCEL");
    System.out.println("choose the operation you want to perform:");
    int option = scan.nextInt();
	
    if(option == 1){
		for(int i = 0; i < customers.length; i++) {
		customer = new Customer();
		account = new Account();
		card = new Card();
		statement = new Statement();
		customer.creatAccount(scan, account, card);
		customers[i] = customer;
		//customers[i].account.statements = new Statement[10];
		}
		for(int n = 0; n < customers.length; n++){
		System.out.println("---------------------------------------------");
		System.out.println("CUSTOMERS NAME :" + customers[n].firstName);
		System.out.println("ACCOUNT NUMBER :" + customers[n].account.accountNumber);
		System.out.println("ACCOUNT TYPE :" + customers[n].account.accountType);
		System.out.println("CARD NUMBER :" + customers[n].account.card.cardNumber);
		System.out.println("ACCOUNT BALANCE :R" + customers[n].account.balance);
		System.out.println("---------------------------------------------");
		}
	}
	else if(option == 2){
		customer.deposit(customers, scan);
		System.out.println("--------------------------------------------");
	}
	else if(option == 3){
		customer.withdraw(customers, scan);
		System.out.println("--------------------------------------------");
	}
	else if(option == 4){
		customer.checkBalance(customers, scan);
		System.out.println("---------------------------------------------");
	}
	else if(option == 5) {
		customer.statement(scan, customers);
		System.out.println("---------------------------------------------");
	}
	else if(option == 6){
		customer.closeAccount(customers, scan);
		System.out.println("-------------------------------------------");
	}
		else if(option == 0){
		z = z + 100;
	}else{
		System.out.println("Option Not Found. Please try Again.");
		System.out.println();
	}
}
}
}
