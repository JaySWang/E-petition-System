package action;



import java.util.List;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.CriticalQuestion;
import model.Proposal;

import service.IAspectService;
import service.ICriticalQuestionService;
import service.IProposalService;



public class CriticalQuestionAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		
	
	
	

	
    private IAspectService as;
	private ICriticalQuestionService cqs;
	

	




	
	public ICriticalQuestionService getCqs() {
		return cqs;
	}





	public void setCqs(ICriticalQuestionService cqs) {
		this.cqs = cqs;
	}





	public IAspectService getAs() {
		return as;
	}





	public void setAs(IAspectService as) {
		this.as = as;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String execute() throws Exception {

		


		return SUCCESS;
	}



	
	public String addCriticalQuestion() throws Exception {

		 try{   
	      Proposal p = (Proposal)this.session().getAttribute("proposal");
          List<Aspect> aspects = p.getAspects();          
	      for(Aspect a:aspects){
	    	  
	    	  String cq = this.request().getParameter(a.getType());
	    	  
	    	  if(cq!=""){
	    	   	addCqs(a,cq);
	    	  }
	      }
  
       
       this.session().setAttribute("aspects", aspects);
       
       

       }
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
    	   return ERROR;
       }
       this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}





	private void addCqs(Aspect a,String qustions) {


	   String[] questions =	qustions.split("/");
	   
	   for(String q : questions){
		   CriticalQuestion cq = new CriticalQuestion();
		   cq.setValue(q);
		   a.addCriticalQuestion(cq);
	   }
		as.update(a);
	}



	 public String answerCriticalQuestion() throws Exception {
		  List<Aspect> aspects = (List)this.session().getAttribute("aspects");
		 
		  try {
		  for(Aspect a:aspects){
			  for(CriticalQuestion cq:a.getCriticalQuestions() ){
				  String answerId = cq.getId()+"";
				  String agreeOrNot = this.request().getParameter(answerId);

				
				  cqs.answer(cq,agreeOrNot);
			  
				  
			     
				  
			  }

		  }
	      this.session().setAttribute("aspects", aspects);

		  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  return ERROR;
		  }
			
			this.request().setAttribute("message", "thank you for your answers");
	        
			
		  
		return SUCCESS;
	}

}
