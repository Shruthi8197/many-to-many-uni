package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInsertTeacher2 {

	public static void main(String[] args) {
		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher teacher=new Teacher();
		teacher.setName("Shylaja");
		teacher.setGender("Female");
		
		Subject subject=entityManager.find(Subject.class, 2);
		Subject subject1=entityManager.find(Subject.class, 3);
		
		List<Subject> list=new ArrayList();
		list.add(subject);
		list.add(subject1);
		teacher.setSubjects(list);
		
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityTransaction.commit();
	}

}
