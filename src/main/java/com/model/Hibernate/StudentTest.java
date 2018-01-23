package com.model.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(11);
		student.setAge(2);
		student.setName("s1");
		
		Configuration cfg = new Configuration();
		SessionFactory sf =    cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		
		//通过辅助类来 获取sf
//		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//所有的操作都要放在以事务里面
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		sf.close();
//		HibernateUtil.getSessionFactory().close();
		
	}
}
