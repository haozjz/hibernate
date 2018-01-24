package com.model.Hibernate;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2018年1月23日 下午3:38:58 
* 类说明 
*/
public class TeacherTest {
	private static SessionFactory sf ;
	private static Session session;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 sf = new AnnotationConfiguration().configure().buildSessionFactory();
		 session = sf.openSession();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		session.close();		
		sf.close();
	}

	@Test
	public void test() {
		Teacher t = new Teacher();
//		t.setId(38);  
		t.setName("lis1i1");
		t.setTitle("中级12");
		t.setDate(new Date());
		t.setGrade(Grade.High);
		
		//通过辅助类来 获取sf
//		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//所有的操作都要放在以事务里面
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();

//		HibernateUtil.getSessionFactory().close();
	}

}
