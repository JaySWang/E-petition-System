package dao;

import java.util.ArrayList;
import java.util.List;

import model.Aspect;

public class AspectDAO{

	IDAO dao;
	
	
	
	
	
	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	public List<Aspect> getAspects(){
	   List<Aspect> l = new ArrayList();
		 String hql=" select a from Aspect a";

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



	public Aspect find(int id) {
		Aspect a = (Aspect) dao.find(Aspect.class, id);
		return a;
	}

	public void update(Aspect a) {
     dao.updata(a);		
	}
}
