package springmvctest;

import java.util.ArrayList;
import java.util.List;

public class AccountDatabase {
	
	//Singleton
	private static AccountDatabase instance;
	
	public static AccountDatabase getInstance() {
		if (instance == null)
			instance = new AccountDatabase();
		return instance;
	}
	
	private AccountDatabase() {
	}
	
	// Parametri
	private List<Account> accounts = new ArrayList<Account>();
	private Account signedInAccount;
	
	public boolean registerAccount(Account account) {
		for (int i=0; i < accounts.size(); i++) {
			if (account.equals(accounts.get(i))) return false;
		}
		accounts.add(account);
		return true;
	}
	
	public Account findAccount(String username) {
		for (int i=0; i < accounts.size(); i++) {
			if (username.equals(accounts.get(i).getUsername()))
				return accounts.get(i);
		}
		return null;
	}
	
	public boolean signInAccount(Account account) {
		Account databaseAccount = findAccount(account.getUsername());
		if (databaseAccount == null)
			return false;
		if (!databaseAccount.getPassword().equals(account.getPassword()))
			return false;
		signedInAccount = databaseAccount;
		return true;
	}

	public Account getSignedInAccount() {
		return signedInAccount;
	}
	
	

}
