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

	
	public void getUser(int id) {
		
		try (Session session = HibarnateUtil.getSessionFactory().openSession()){
			User user = session.get(User.class, id);
			if(user != null) {
				System.out.println("Id : "  + user.getId());
				System.out.println("Name : " + user.getName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("City: " + user.getCity());
				System.out.println("Gender: " + user.getGender());
				System.out.println("User Data Fetched successfully!");
			}else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(int id) {

		Transaction tx = null;
		try(Session session = HibarnateUtil.getSessionFactory().openSession()){
			tx = session.beginTransaction();
			User user = session.get(User.class, id);
			if(user != null) {
				user.setName("Nishant");
				user.setCity("Pune");
				user.setEmail("nishant@gmail.com");
				user.setPassword("1234");
				session.update(user);
				tx.commit();
				System.out.println("User Data updated successfully!");
			}else {
				System.out.println("User Data not successfully!");
			}
		}catch(Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}				
	}

	public void deleteUser(int id) {
		
		Transaction tx = null;
		try(Session session = HibarnateUtil.getSessionFactory().openSession()){
			tx = session.beginTransaction();
			User user = session.get(User.class, id);
			if(user != null) {
				session.delete(user);				
			}
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
