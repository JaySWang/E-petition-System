package dao;

import java.util.ArrayList;
import java.util.List;

import model.Aspect;
import model.User;

public class UserDAO{

	IDAO dao;
	
	
	
	
	
	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	public List<User> getAspects(){
	   List<User> l = new ArrayList();
		 String hql=" select u from User u";

		l = dao.list(hql);
	   
		return l;
	}

	public void setDAO(IDAO idao) {
		this.dao = idao;
	}

	public void create(Aspect a) {
		try{
          dao.create(a);		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}



	public User find(int id) {
		User u = (User) dao.find(User.class, id);
		return u;
	}

	public User getUserByUserName(String userName){
		 String hql=" select u from User u where u.userName=(:userName)";

		User u = (User) (dao.createQuery(hql).setParameter("userName", userName).list().get(0));
		return u;
	}
	
	
	public void update(User u) {
     dao.updata(u);		
	}
}
