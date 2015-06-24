package service;

import dao.CriticalQuestionDAO;
import model.CriticalQuestion;

public class CriticalQuestionServiceImpl implements ICriticalQuestionService {

	
	CriticalQuestionDAO cdao;
	
	
	
	
	
	public CriticalQuestionDAO getCdao() {
		return cdao;
	}

	public void setCdao(CriticalQuestionDAO cdao) {
		this.cdao = cdao;
	}

	@Override
	public void save(CriticalQuestion cq) {
		cdao.create(cq);		
	}


	@Override
	public CriticalQuestion getCriticalQuestionById(int id) {

		
		return cdao.find(id);
	}

	@Override
	public void answer(CriticalQuestion cq,String agreeOrNot) {

		if(agreeOrNot.equalsIgnoreCase("agree")){
			cq.setAgree(cq.getAgree()+1);
			
		}
		else if(agreeOrNot.equalsIgnoreCase("disagree")){
			cq.setDisagree(cq.getDisagree()+1);

		}else if(agreeOrNot.equalsIgnoreCase("na")){
			cq.setNa(cq.getNa()+1);

		}
		
	update(cq);
		
		
	}

	@Override
	public void update(CriticalQuestion cq) {
     cdao.update(cq);		
	}





}
