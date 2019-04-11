package com.mphasis.training.assignment;

public  class Account {
	
	private long acc_num;
	private String acc_holder_name;
	protected double balance;
	private String create_date;
	public Account(long acc_num, String acc_holder_name, double balance, String create_date) {
		super();
		this.acc_num = acc_num;
		this.acc_holder_name = acc_holder_name;
		this.balance = balance;
		this.create_date = create_date;
	}
	
	public double getBalance() {
		return balance;
	}

	public  double withdraw(int amount) {
		if(this.balance==amount) {
			System.out.println("minimun balance 1000 maintain");
		}else if(this.balance > (amount+1000)) {
			balance=balance-amount;
			System.out.println("withdrawn succes   "+balance);
		}else {
			System.out.println("insuffient balance");
		}
		
		return balance;
	}
	
	public double deposit(int amount) {
		if((amount%100 )== 0) {
		balance=balance+amount;
		System.out.println("deposited. balance is "+balance);
		}else {
			System.out.println("only 100 multiples can deposit");
		}
		return balance;
	}
	
}
