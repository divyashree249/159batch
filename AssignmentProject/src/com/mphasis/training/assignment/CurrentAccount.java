package com.mphasis.training.assignment;

public class CurrentAccount  extends Account{

	public CurrentAccount(long acc_num, String acc_holder_name, double balance, String create_date) {
		super(acc_num, acc_holder_name, balance, create_date);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double withdraw(int amount) {
		if(this.balance==amount) {
			System.out.println("minimun balance 10000 maintain");
		}else if(this.balance > (amount+10000)) {
			balance=balance-amount;
			System.out.println("withdrawn succes   "+balance);
		}else {
			System.out.println("insuffient balance");
		}
		
		return balance;
	}

}
