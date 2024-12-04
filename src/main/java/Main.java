import java.io.IOException;
import java.util.List;

import model.BankAccount;
import repository.AccountRepositoryImpl;

public class Main {

	public static void main(String[] args) throws IOException {

		Utils.JsonSerializer<BankAccount> bankAccountJsonSerializer = new Utils.JsonSerializer<>();
		AccountRepositoryImpl accountRepositoryImpl = AccountRepositoryImpl.getInstance();

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				accountRepositoryImpl.populateData();
			}).start();
		}

		List<BankAccount> bankAccounts = accountRepositoryImpl
				.findAll();
		bankAccounts.stream().map(bankAccountJsonSerializer::toJson).forEach(System.out::println);

	}

}
