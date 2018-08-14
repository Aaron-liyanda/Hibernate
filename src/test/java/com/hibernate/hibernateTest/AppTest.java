package com.hibernate.hibernateTest;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Dept;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

	Configuration conf;//配置
	SessionFactory sf;//管理数据库连接
	Session session;//一个连接
	Transaction tx;//事务     在增 删 改中开事务，不开的话数据库不存盘，   查询 不开
	
    public void testAdd()
    {
       conf = new Configuration().configure();
       sf = conf.buildSessionFactory();
       session = sf.openSession();
       tx = session.beginTransaction();
       
       try {
		Dept dept = new Dept();
			dept.setDeptNo(1);
		   dept.setName("Aaron");
		   dept.setLocation("changsha");
		   session.save(dept);
		   tx.commit();
		} catch (HibernateException e) {
			 e.printStackTrace();
				tx.rollback();
		}
       
    }
    
    public void testFind(){
    	conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        
        Dept dept = (Dept) session.get(Dept.class, 1);
        System.out.println(dept);
    }
    
    public void testFindAll(){
    	conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        
        Query q = session.createQuery("from Dept");//Dept 是类名
        List list = q.list();
        System.out.println(list);
        session.close();
        
    }
    
    public void testUpdate(){
    	conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        
        Dept dept = null;
		try {
			dept = (Dept) session.get(Dept.class, 1);
			dept.setLocation("---");
			session.save(dept);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		}
        System.out.println(dept);
    }
    
    public void testDelete(){
    	conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        
        Dept dept = null;
		try {
			dept = (Dept) session.get(Dept.class, 1);
			session.delete(dept);
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		}
    }
}
