package com.formation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.entities.Address;
import com.formation.entities.Contact;
import com.formation.entities.Student;

public class Test {

	public static void main(String[] args) {

		// 1 : Ouverture unit� de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");

		EntityManager em = emf.createEntityManager();

		// 2 : Ouverture transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 3 : Instanciation Objet m�tier
//		Formation formation = new Formation("Hibernate");

		Address address1 = new Address("amour youcef","belfort","dp","90000");
		Student student1 = new Student("dit");
		student1.setStudentAddress(address1);
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		em.persist(student1);
		em.persist(address1);
		// 5 : Fermeture transaction
		tx.commit();

		// 6 : Fermeture unit� de travail JPA
		em.close();
		
		emf.close();
		
		
		System.out.println("ok.....!");
	}
}
