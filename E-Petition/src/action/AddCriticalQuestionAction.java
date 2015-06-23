package action;



import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.CriticalQuestion;
import model.Proposal;

import service.IAspectService;
import service.IProposalService;



public class AddCriticalQuestionAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		
	
	
	

	
    private IAspectService as;
	
	

	




	
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

		 try{   
	      Proposal p = (Proposal)this.session().getAttribute("proposal");
                    
	      for(Aspect a:p.getAspects()){
	    	  
	    	  String cq = this.request().getParameter(a.getType());
	    	  
	    	   	addCqs(a,cq);

	      }
  
       
       
       
       

       }
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
    	   return ERROR;
       }
       this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}





	private void addCqs(Aspect a,String topic) {


	   String[] questions =	topic.split("/");
	   
	   for(String q : questions){
		   CriticalQuestion cq = new CriticalQuestion();
		   cq.setValue(q);
		   a.addCriticalQuestion(cq);
	   }
		as.update(a);
	}



	
}
