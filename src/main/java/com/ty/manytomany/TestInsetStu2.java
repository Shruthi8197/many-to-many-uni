package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInsetStu2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student2=new Student();
		student2.setName("Nisha");
		student2.setEmail("nisha@gmail");
		
		Course course=entityManager.find(Course.class, 1);
		Course course1=entityManager.find(Course.class, 3);
		
		List<Course> list=new ArrayList();
		list.add(course);
		list.add(course1);
		student2.setCourses(list);
		
		entityTransaction.begin();
		entityManager.persist(student2);
		entityManager.persist(course);
		entityManager.persist(course1);
		entityTransaction.commit();
		

	}

}
