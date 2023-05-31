package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Bankaccount;

public class Bankdao {
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save(Bankaccount bankaccount ) {
		entityTransaction.begin();
		entityManager.persist(bankaccount);
		entityTransaction.commit();
		
	}
	public List<Bankaccount> fetchall() {
		return entityManager.createQuery("select x from Bankaccount x").getResultList();
		
		
	}
	
	public Bankaccount find(long accno) {
		return entityManager.find(Bankaccount.class, accno);
		
	}
	
	public void update(Bankaccount bankaccount ) {
		entityTransaction.begin();
		entityManager.merge(bankaccount);
		entityTransaction.commit();

}}
