package service;

import model.CriticalQuestion;

public interface ICriticalQuestionService {

	public void save(CriticalQuestion cq);


	public CriticalQuestion getCriticalQuestionById(int id);


	public void answer(CriticalQuestion cq,String agreeOrNot);

	
	public void update(CriticalQuestion cq);

}
