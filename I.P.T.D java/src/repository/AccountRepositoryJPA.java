package repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Account;

public class AccountRepositoryJPA implements AccountRepository {

	private static final String PERSISTANCE_UNIT_NAME = "IPTD";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("IPTD");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(Account account) {

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(account);
		et.commit();

		System.out.println("Account added");

	}

	@Override
	public Optional<Account> read(long id) {

		Account accountAC = null;
		EntityTransaction et = em.getTransaction();

		et.begin();
		accountAC = em.find(Account.class, id);
		et.commit();

		System.out.println("Account read");

		return Optional.ofNullable(accountAC);
	}

	@Override
	public List<Account> readAll() {

		EntityTransaction et = em.getTransaction();

		System.out.println("Read all Accounts");
		et.begin();
		List<Account> accounts = (List<Account>) em.createQuery("SELECT a FROM Account a").getResultList();
		et.commit();
		
		return accounts;
	}

	@Override
	public Account updateAccount(Account account) {

		EntityTransaction et = em.getTransaction();

		et.begin();
		Account mergedAccount = em.merge(account);
		et.commit();

		return mergedAccount;
	}

	@Override
	public void delete(Account account) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(account);
		et.commit();
		
	}

}
