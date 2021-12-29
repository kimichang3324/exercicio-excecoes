package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Entities.Account;
import Model.Exceptions.NoBalanceWithDrawException;
import Model.Exceptions.NoLimitWithdrawException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data.");
			System.out.print("Number: " );
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withdrawValue = sc.nextDouble();
			account.withdraw(withdrawValue);
			System.out.print(account);
		}
		catch(NoLimitWithdrawException e) {
			System.out.println("Erro! " + e.getMessage());
		}
		catch(NoBalanceWithDrawException e) {
			System.out.println("Erro! " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Você inseriu um caractere - ou uma sequencia - que não foi reconhecido pelo sistema: " + e.getMessage());
		}
		
		
		sc.close();
	}
}
