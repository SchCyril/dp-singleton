package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.AccountStatus;
import model.AccountType;
import model.BankAccount;
import model.BankDirector;

public class AccountRepositoryImpl implements AccountRepository {

	// Singleton
	private final static AccountRepositoryImpl accountRepositoryImpl;

	static {
		accountRepositoryImpl = new AccountRepositoryImpl();
	}

	private AccountRepositoryImpl() {
	}

	private Map<Long, BankAccount> bankAccountsMap = new HashMap<>();
	private long accountCount = 0;

	public BankAccount save(BankAccount bankAccount) {

		Long accoundId;
		synchronized (this) {
			accoundId = ++accountCount;
		}
		
		bankAccount.setAccountId(accoundId);
		synchronized (this) {
			bankAccountsMap.put(accoundId, bankAccount);
		}
		
		return bankAccount;

	}

	public List<BankAccount> findAll() {
		return bankAccountsMap.values().stream().toList();
	}

	public Optional<BankAccount> findById(long id) {
		BankAccount account = bankAccountsMap.get(id);
		if (account == null) {
			return Optional.empty();
		} else {
			return Optional.of(account);
		}
	}

	public List<BankAccount> searchAccount(Predicate<BankAccount> predicate) {
		return bankAccountsMap.values().stream().filter(predicate).collect(Collectors.toList());
	}

	public BankAccount update(BankAccount bankAccount) {
		return bankAccountsMap.put(accountCount, bankAccount);
	}

	public void deleteById(long id) {
		bankAccountsMap.remove(id);

	}

	public void populateData() {
		for (int i = 0; i < 10; i++) {
			BankAccount account = BankDirector.accountBuilder().balance(1000 + Math.random() * 9000)
					.currency(Math.random() > 0.5 ? "EUR" : "USD")
					.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
					.status(Math.random() > 0.5 ? AccountStatus.CREATED : AccountStatus.ACTIVATED).build();
			save(account);

		}
		System.out.println("---------------------");
		System.out.println(Thread.currentThread().getName());
		System.out.println("Account Count = " + accountCount);
		System.out.println("Size: " + bankAccountsMap.values().size());
		System.out.println("---------------------");
	}

	// Singleton
	public synchronized static AccountRepositoryImpl getInstance() {

//		if(accountRepositoryImpl==null) {
//			System.out.println("fffff");
//			accountRepositoryImpl = new AccountRepositoryImpl();
//			//accountRepositoryImpl.populateData();
//		}
		return accountRepositoryImpl;
	}

}
