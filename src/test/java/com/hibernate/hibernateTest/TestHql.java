package com.hibernate.hibernateTest;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.aaron.util.HibernateUtil;
import com.hibernate.entity.Dept;
import com.hibernate.entity.Emp;

import junit.framework.TestCase;

public class TestHql extends TestCase {
	//查询
	public void testHql1(){
		Session session = HibernateUtil.getSession();
		String sql = "from Emp";
		Query q = session.createQuery(sql);
		List list = q.list();
		System.out.println(list);
		
		HibernateUtil.closeSession();
		
	}
	
	//条件查询
	public void test2(){
		Session session = HibernateUtil.getSession();
		String sql = "from Emp where empSal = ?";
		Query q = session.createQuery(sql);
		q.setParameter(0, 31);
		List list = q.list();
		System.out.println(list);
		
		HibernateUtil.closeSession();
	}
	
	//模糊查询                    
	public void test3(){
		Session session = HibernateUtil.getSession();
		String sql = "from Emp where empName like  ?";
		Query q = session.createQuery(sql);
		q.setParameter(0, "J%");
		List list = q.list();
		System.out.println(list);
		
		HibernateUtil.closeSession();
	}

	//日期查询
	public void test4(){
			Session session = HibernateUtil.getSession();
			String sql = "from Emp where empName like :Name";
			Query query = session.createQuery(sql);
			query.setParameter("Name", "A%");
			List list = query.list();
			System.out.println(list);
			
			HibernateUtil.closeSession();
		}
	
	public void test5(){
		Session session = HibernateUtil.getSession();
		String sql = "from HqlTest where birthday = :date";
		Query query = session.createQuery(sql);
		SimpleDateFormat sd = new SimpleDateFormat("");
		query.setParameter("date", "2018-08-07");
		List list = query.list();
		System.out.println(list);
		
		HibernateUtil.closeSession();
	}
	
	//查询 记录 count(*)
	public void test6(){
		Session session = HibernateUtil.getSession();
		String sql = "select count(*) from Emp";
		Query query = session.createQuery(sql);
		Long n = (Long)query.uniqueResult();
		System.out.println(n);
		
		HibernateUtil.closeSession();
	}
	
	//分页查询          ————列出此页数据
	public void test7(){
		int cur = 1;  //当前页
		int size = 2;	//每页几条
		
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Emp");
		
		query.setFirstResult((cur-1)*size); //跳过的行数--I当前页的第一条
		query.setMaxResults(size);	//每页的条数
		
		List list = query.list();
		System.out.println(list);
	}
	
	//只查 姓名 薪水
	//当查询结果不是对象，以object 列为数组给出
		//[[Ljava.lang.Object;@f5ac9e4, [Ljava.lang.Object;@123ef382,
	public void test8(){
		String sql = "select empName, empSal from Emp";  //from 类
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery(sql);
		List<Object[]> list = q.list();		//放在集合中的数组
		
		for (Object[] row : list) {
			System.out.println(row[0] + "---" + row[1]);
		}
		
		System.out.println(list);//如果此种书写，会给出数组
	}
	
	//多条件动态查询      0,1,13,23
	//初始做法    自己拼接sql
	public void test9(){
		Session session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(Emp.class);
		c.add(Restrictions.or(
				Restrictions.eq("empAge", 21),
				Restrictions.or(
						Restrictions.like("empName", "A%"), 
						Restrictions.eq("empNo", 1))
				));
		
		List list = c.list();
		System.out.println(list);
		
	}
	
	//子查询
	public void testzi(){
		String sql = "from TDAreainfo where (select id from TDAreainfo where id = 110102)";
	}
	
	//多表查询_内连接
	public void testMutil(){
		String sql = "from Emp e inner join e.dept";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		
		for (Object[] object : list) {
			Emp aa = (Emp)object[0];
			Dept bb = (Dept)object[1];
			System.out.println(aa + "---" + bb);
		}
	}
	
	//多表查询_左外联
	public void testLeftJoin(){
		String sql = "from Emp e left join e.dept";			//HQL 语句
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		
		for (Object[] object : list) {
			Emp aa = (Emp)object[0];
			Dept bb = (Dept)object[1];
			System.out.println(aa + "---" + bb);
		}
	}
	
	//原生sql查询
	public void testSql(){
		String sql = "select e.empName, e.empSal from emp e where empSal > ?";	//相比较于原 EMP
		Session session = HibernateUtil.getSession();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, 10000);
		List<Object[]> list = q.list();
		
		for (Object[] object : list) {
			String name = (String)object[0];
			double sal = (Double)object[1];
			System.out.println(name + "---" + sal);
		}
	}
	
}
