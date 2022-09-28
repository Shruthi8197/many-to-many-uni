package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestInsertStudent {

	public static void main(String[] args) {
		Student student=new Student();
		student.setName("Sangeetha");
		student.setEmail("sang@gamil");
		
		Course course=new Course();
		course.setName("Engineering");
		course.setCost(40000);
		
		Course course1=new Course();
		course1.setName("Medical");
		course1.setCost(400000);
		
		Course course2=new Course();
		course2.setName("Degree");
		course2.setCost(30000);
		
		
		
		List<Course> list=new ArrayList();
		list.add(course);
		list.add(course1);
		list.add(course2);
		student.setCourses(list);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();
		

	}

}
