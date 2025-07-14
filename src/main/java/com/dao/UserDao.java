package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.util.HibarnateUtil;
import com.entity.User;

public class UserDao {
		
	public void saveUser(User user) {
		Transaction tx = null;
		try(Session session = HibarnateUtil.getSessionFactory().openSession()){
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			System.out.println("User saved successfully!");
		}catch(Exception e){
			if(tx != null) tx.rollback();
			e.printStackTrace();				
		}

	}

}
