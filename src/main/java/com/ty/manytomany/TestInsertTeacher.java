package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInsertTeacher {

	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setName("Usha R");
		teacher.setGender("Female");

		Subject subject = new Subject();
		subject.setName("Social");
		subject.setDuration("6months");

		Subject subject1 = new Subject();
		subject1.setName("Science");
		subject1.setDuration("8months");

		Subject subject2 = new Subject();
		subject2.setName("Hindi");
		subject2.setDuration("4months");

		List<Subject> list = new ArrayList();
		list.add(subject);
		list.add(subject1);
		list.add(subject2);
		teacher.setSubjects(list);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityTransaction.commit();

	}

}
