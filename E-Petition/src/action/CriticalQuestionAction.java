package action;



import java.util.Enumeration;
import java.util.List;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.CriticalQuestion;
import model.Proposal;

import service.IArgumentSchemeService;
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
	
    private IArgumentSchemeService ass;
	




	
	public IArgumentSchemeService getAss() {
		return ass;
	}





	public void setAss(IArgumentSchemeService ass) {
		this.ass = ass;
	}





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


	
	
	
	
	public String addCriticalQuestionTemplate() throws Exception {

		 try{   
			 ArgumentScheme as = (ArgumentScheme)this.session().getAttribute("argumentScheme");
         List<AspectType> aspectTypes = as.getAspectTypes();          
	      for(AspectType at:aspectTypes){
	    	  
	    	  
	    	   // in JSP,names of the input just contain the first word before " "
	    	   
	    	    String[] names = at.getName().split(" ");
	    		String cq = request().getParameter(names[0]);
	    	
	    	
	    	  
	    	  if(cq!=""){
	    	   	addCqts(at,cq);
	    	  }
	    	  
	    	  
	    	  
	      }
 
      as.setAspectTypes(aspectTypes);
      ass.update(as);
      
      

      }
      catch(Throwable t){
t.printStackTrace();

return ERROR;
      }
      this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}

	
	
	private void addCqts(AspectType at,String qustions) {


		   String[] questions =	qustions.split("/");
		   
		   for(String q : questions){
			   CriticalQuestion cq = new CriticalQuestion();
			   cq.setValue(q);
			   at.addCriticalQuestionTemplate(cq);
		   }
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
