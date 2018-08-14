package com.hibernate.hibernateTest;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;
import com.hibernate.entity.TEmp;
import com.hibernate.entity.TProject;

import junit.framework.TestCase;

public class CascadeTest extends TestCase{
	
	Configuration conf;//配置
	SessionFactory sf;//管理数据库连接
	Session session;//一个连接
	Transaction tx;//事务     在增 删 改中开事务，不开的话数据库不存盘，   查询 不开
	
	public void testMany2One(){
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        
        Emp emp = (Emp) session.get(Emp.class, 1);
        System.out.println(emp);
	}
	
	public void testOne2Many(){
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        
        Dept dept = (Dept) session.get(Dept.class, 3);
        System.out.println(dept);
        System.out.println(dept.getList());
	}
	
	public void testAddEmp(){
		 	conf = new Configuration().configure();
	       sf = conf.buildSessionFactory();
	       session = sf.openSession();
	       tx = session.beginTransaction();
		
		try {
			Dept dept = new Dept();
			dept.setName("recruitment");
			dept.setLocation("San Francisco");
			
			Emp emp1 = new Emp(null, "Aaron", 20000.0, 21);
			Emp emp2 = new Emp(null, "Jack", 10000.0, 21);
			
			dept.getList().add(emp1);
			dept.getList().add(emp2);
			
			session.save(dept);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	public void testMany2Many(){
		
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        
        System.out.println("-----------emp id=1 -------------------");
        
        TEmp temp = (TEmp) session.get(TEmp.class, 1);
        System.out.println(temp);
        System.out.println(temp.getPros());
        
        System.out.println("-----------pro id=2 -------------------");
        
        TProject tpro = (TProject) session.get(TProject.class, 2);
        System.out.println(tpro);
        System.out.println(tpro.getEmps());
        
	}
	
	public void testDeleteMany(){
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        
        try {
			TProject pro = (TProject) session.get(TProject.class, 3);
			session.delete(pro);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
        
        
	}
	
	public void testAddMany(){
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        
        try {
        	TEmp emp1 = new TEmp("123", 12);
        	TEmp emp2 = new TEmp("456", 45);
        	TEmp emp3 = new TEmp("789", 78);
        	
        	TProject pro = new TProject();
        	pro.setProName("hadoop");
        	pro.setProReward(7000);
        	pro.getEmps().add(emp1);
        	pro.getEmps().add(emp2);
        	pro.getEmps().add(emp3);
        	
			session.save(pro);
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	public void testUpdateMany(){
		conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        
        try {
        	
        	TProject pro = (TProject) session.get(TProject.class, 4);
        	pro.setProName("hadoop");
        	pro.setProReward(70000);
        	
			session.save(pro);
			tx.commit();
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
