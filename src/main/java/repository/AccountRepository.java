package repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import model.BankAccount;

public interface AccountRepository {
	BankAccount save(BankAccount bankAccount);
	List<BankAccount> findAll();
	Optional<BankAccount> findById(long id);
	List<BankAccount> searchAccount(Predicate<BankAccount> predicate);
	BankAccount update(BankAccount bankAccount);
	void deleteById(long id);
}
