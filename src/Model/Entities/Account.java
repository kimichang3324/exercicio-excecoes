package Model.Entities;

import Model.Exceptions.NoBalanceWithDrawException;
import Model.Exceptions.NoLimitWithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double mounth) {
		balance += mounth;
	}
	
	public void withdraw(Double mounth) {
		if (balance < mounth) {
			throw new NoBalanceWithDrawException("O valor que você quer sacar excede o valor contido na sua conta", 0044);
		}
		if (mounth > withdrawLimit) {
			throw new NoLimitWithdrawException(String.format("O valor inserido excede o valor mínimo para saque, que é de R$ %.2f", withdrawLimit), 0045);
		}
		
		balance -= mounth;
	}
	
	@Override
	public String toString() {
		return "New balance: "
				+ balance;
	}
}
