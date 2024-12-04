import model.AccountStatus;
import model.AccountType;
import model.BankAccount;
import model.Customer;

public class TestPrototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setAccountId(1L);
		bankAccount.setBalance(100);
		bankAccount.setCurrency("EUR");
		bankAccount.setStatus(AccountStatus.BLOCKED);
		bankAccount.setType(AccountType.CURRENT_ACCOUNT);
		bankAccount.setCustomer(new Customer(1L, "Cyril"));
		
		
		BankAccount bankAccount3 = bankAccount.clone();
				
		System.out.println(bankAccount);
		System.out.println(bankAccount3);
		
		bankAccount.getCustomer().setName("Marie");
		
		System.out.println(bankAccount);
		System.out.println(bankAccount3);
		
		
		
		
	}
	
	
}
