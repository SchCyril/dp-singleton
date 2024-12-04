package model;

public class BankAccount implements Cloneable {
	private long accountId;
	private double balance;
	private String currency;
	private AccountType type;
	private AccountStatus status;
	private Customer customer;

	public BankAccount() {
		super();
	}

	public BankAccount(long accountId, double balance, String currency, AccountType type, AccountStatus status) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.currency = currency;
		this.type = type;
		this.status = status;
	}
	
	
	

	public BankAccount(long accountId, double balance, String currency, AccountType type, AccountStatus status,
			Customer customer) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.currency = currency;
		this.type = type;
		this.status = status;
		this.customer = customer;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", balance=" + balance + ", currency=" + currency + ", type="
				+ type + ", status=" + status + ", customer=" + customer + "]";
	}

	@Override
	public BankAccount clone() throws CloneNotSupportedException {
		BankAccount bankAccount = (BankAccount) super.clone();
		bankAccount.setCustomer(this.customer.clone());
		return bankAccount;
	}

	public static class AccountBuilder {
		private BankAccount bankAccount = new BankAccount();

		public AccountBuilder accountId(long id) {
			bankAccount.accountId = id;
			return this;
		}

		public AccountBuilder currency(String currency) {
			bankAccount.currency = currency;
			return this;
		}

		public AccountBuilder balance(double balance) {
			bankAccount.balance = balance;
			return this;
		}

		public AccountBuilder type(AccountType type) {
			bankAccount.type = type;
			return this;
		}

		public AccountBuilder status(AccountStatus status) {
			bankAccount.status = status;
			return this;
		}

		public BankAccount build() {
			return this.bankAccount;
		}

	}

}
