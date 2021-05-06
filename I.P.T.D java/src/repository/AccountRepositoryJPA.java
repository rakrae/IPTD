package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Account;

public class AccountRepositoryJPA implements AccountRepository {

	private static final String PERSISTANCE_UNIT_NAME = "IPTD";

	@Override
	public void add(Account account) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(account);
		et.commit();

		em.close();
		emf.close();
		
		System.out.println("Account added");

	}

	@Override
	public Optional<Account> read(long id) {

		Account accountAC = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
	
		EntityTransaction et = em.getTransaction();

		et.begin();
		accountAC = em.find(Account.class, id);
		et.commit();
		
		em.close();
		emf.close();
		
		System.out.println("Account read");

		return Optional.ofNullable(accountAC);
	}

	@Override
	public List<Account> readAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		System.out.println("Read all Accounts");
		
		et.begin();
		List<Account> accounts = new ArrayList<>();
		
		TypedQuery<Account> query = em.createNamedQuery("readAllAccounts", Account.class);
		accounts = query.getResultList();
		
		et.commit();
		
		em.close();
		emf.close();
		
		return accounts;
	}

	@Override
	public Account updateAccount(Account account) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		
		EntityTransaction et = em.getTransaction();

		et.begin();
		Account mergedAccount = em.merge(account);
		et.commit();

		em.close();
		emf.close();
		
		return mergedAccount;
	}

	@Override
	public void delete(Account account) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Delete account: " + account.getId());
		et.begin();
		if(!em.contains(account)) {
			account = em.merge(account);
		}
		em.remove(account);
		et.commit();
		
		em.close();
		emf.close();
	}

}
