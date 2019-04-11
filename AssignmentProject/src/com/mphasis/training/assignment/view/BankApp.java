package com.mphasis.training.assignment.view;

import java.util.Scanner;

import com.mphasis.training.assignment.Account;
import com.mphasis.training.assignment.CurrentAccount;
import com.mphasis.training.assignment.SavingsAccount;

public class BankApp {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Mphasis Bank");
		System.out.println("Which account should create"
				+ " \n 1.Savings \n 2. Current\n 3.exit");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("enter the account details");
			System.out.println("1.accNumber \n 2.Name \n "
					+ "3.opening balance \n 4.current date");
			Account savingAccount=new SavingsAccount(sc.nextLong(),
					sc.next(), sc.nextDouble(), sc.next());
			System.out.println("account created with balance "
					+savingAccount.getBalance());
			do {
			System.out.println("1. Deposit \n 2.Withdraw \n 3.exit");
		 int ch=sc.nextInt();
		 switch(ch) {
		 case 1: System.out.println("enter the amount deposit");
		 System.out.println(savingAccount.deposit(sc.nextInt()));
		 break;
		 case 2: System.out.println("enter the amount to withdraw");
		 System.out.println(savingAccount.withdraw(sc.nextInt()));
		 break;
		 case 3: System.exit(0);
		 default: System.out.println("invalid case");
		 }
			}while(true);
		}else if(choice==2) {
			System.out.println("enter the account details");
			System.out.println("1.accNumber \n 2.Name \n "
					+ "3.opening balance \n 4.current date");
			Account currentAccount=new CurrentAccount(sc.nextLong(),
					sc.next(), sc.nextDouble(), sc.next());
			System.out.println("account created with balance "
					+currentAccount.getBalance());
			do {
			System.out.println("1. Deposit \n 2.Withdraw \n 3.exit");
		 int ch=sc.nextInt();
		 switch(ch) {
		 case 1: System.out.println("enter the amount deposit");
		 System.out.println(currentAccount.deposit(sc.nextInt()));
		 break;
		 case 2: System.out.println("enter the amount to withdraw");
		 System.out.println(currentAccount.withdraw(sc.nextInt()));
		 break;
		 case 3: System.exit(0);
		 default: System.out.println("invalid case");
		 }
			}while(true);
		}else {
			System.out.println("invalid");
			System.exit(0);
		}
		
		
	}

}
