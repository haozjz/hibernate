package com.model.Hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2018年1月23日 下午4:07:48 
* 类说明 
*/
public class StudentTest {
	static SessionFactory sf ;
	static Session session ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//通过辅助类来 获取sf
		//	Session session = HibernateUtil.getSessionFactory().openSession();
				
		Configuration cfg = new Configuration();
		 sf =    cfg.configure().buildSessionFactory();
		 session = sf.openSession();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sf.close();
		//HibernateUtil.getSessionFactory().close();
	}

	@Test
	public void test() {
		Student student = new Student();
		student.setId(11);
		student.setAge(2);
		student.setName("s1");
		
		//所有的操作都要放在以事务里面
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();	

	}

}
