package action;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Aspect;
import model.CriticalQuestion;
import model.Proposal;
import service.ICriticalQuestionService;
import service.IProposalService;



public class AnswerCriticalQuestionAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	
	

	private ICriticalQuestionService cqs;
	







	public ICriticalQuestionService getCqs() {
		return cqs;
	}





	public void setCqs(ICriticalQuestionService cqs) {
		this.cqs = cqs;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String execute() throws Exception {

	
		return SUCCESS;
	}

  public String answerCriticalQuestion() throws Exception {
	  List<Aspect> aspects = (List)this.session().getAttribute("aspects");
	 
	  try {
	  for(Aspect a:aspects){
		  for(CriticalQuestion cq:a.getCriticalQuestions() ){
			  String answerId = cq.getId()+"";
			  String agreeOrNot = this.request().getParameter(answerId);

			
			  cqs.answer(cq.getId(),agreeOrNot);
		  
			  
		     
			  
		  }

	  }
	  }
	  catch(Exception e) {
		  e.printStackTrace();
		  return ERROR;
	  }
		
		this.request().setAttribute("message", "thank you for your answers");
        
		
	  
	return SUCCESS;
}

	
}
