package dao;

import java.util.ArrayList;
import java.util.List;

import model.CriticalQuestion;

public class CriticalQuestionDAO{

	IDAO dao;
	
	
	
	
	
	public IDAO getDao() {
		return dao;
	}

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	public List<CriticalQuestion> getCriticalQuestions(){
	   List<CriticalQuestion> l = new ArrayList();
		 String hql=" select cq from CriticalQuestion cq";

		l = dao.list(hql);
	   
		return l;
	}

	public void setDAO(IDAO idao) {
		this.dao = idao;
	}

	public void create(CriticalQuestion cq) {
		try{
          dao.create(cq);		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}



	public CriticalQuestion find(int id) {
		CriticalQuestion cq = (CriticalQuestion) dao.find(CriticalQuestion.class, id);
		return cq;
	}

	public void update(CriticalQuestion cq) {
     dao.updata(cq);		
	}
}
