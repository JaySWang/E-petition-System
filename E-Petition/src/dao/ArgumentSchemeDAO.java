package dao;

import java.util.ArrayList;
import java.util.List;

import model.ArgumentScheme;
import model.Proposal;


public class ArgumentSchemeDAO{

	IDAO dao;
	
	
	
	
	
	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	public List<ArgumentScheme> geArgumentSchemes(){
	   List<ArgumentScheme> l = new ArrayList();
		 String hql=" select s from ArgumentScheme s";

		l = dao.list(hql);
	   
		return l;
	}

	public void setDAO(IDAO idao) {
		this.dao = idao;
	}

	public void create(ArgumentScheme as) {
		try{
          dao.create(as);		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}



	public ArgumentScheme find(int id) {
		ArgumentScheme as = (ArgumentScheme) dao.find(ArgumentScheme.class, id);
		return as;
	}

	public void update(ArgumentScheme as) {
     dao.updata(as);		
	}

	public ArgumentScheme findByName(String sName) {
		
		String hql="select s from ArgumentScheme s where s.name=(:name)";

		List<ArgumentScheme> argumentSchemes=this.getDao().createQuery(hql).setParameter("name", sName).list();
		
		if(argumentSchemes.size()>0)
			return argumentSchemes.get(0);
		
		
		return null;
	}
}
