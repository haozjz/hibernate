package com.model.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(38);
		t.setName("lis1i1");
		t.setTitle("�м�12");
	
//		SessionFactory sf = new   AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sf.openSession();
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		//ͨ���������� ��ȡsf
//		Session session = HibernateUtil.getAnnotationSessionFactory();
		
		//���еĲ�����Ҫ��������������
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		
		sf.close();
//		HibernateUtil.getAnnotationSessionFactory().close();
		
	}
}
