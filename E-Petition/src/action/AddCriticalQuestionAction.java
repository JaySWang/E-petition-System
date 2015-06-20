package action;



import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.CriticalQuestion;
import model.Proposal;

import service.IProposalService;



public class AddCriticalQuestionAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String topicCQ;
	
	private String situationCQ;
		
	private String actionCQ;
	
	private String goalCQ;
	
	private String valueCQ;
		
	
	
	

	private IProposalService ps;
	

	
	

	



	public String getTopicCQ() {
		return topicCQ;
	}





	public void setTopicCQ(String topicCQ) {
		this.topicCQ = topicCQ;
	}





	public String getSituationCQ() {
		return situationCQ;
	}





	public void setSituationCQ(String situationCQ) {
		this.situationCQ = situationCQ;
	}





	public String getActionCQ() {
		return actionCQ;
	}





	public void setActionCQ(String actionCQ) {
		this.actionCQ = actionCQ;
	}





	public String getGoalCQ() {
		return goalCQ;
	}





	public void setGoalCQ(String goalCQ) {
		this.goalCQ = goalCQ;
	}





	public String getValueCQ() {
		return valueCQ;
	}





	public void setValueCQ(String valueCQ) {
		this.valueCQ = valueCQ;
	}





	public IProposalService getPs() {
		return ps;
	}





	public void setPs(IProposalService ps) {
		this.ps = ps;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String execute() throws Exception {

		
	      Proposal p = (Proposal)this.session().getAttribute("proposal");
          ArgumentScheme as = p.getArgumentScheme();
          
	      for(AspectType at:as.getAspectType()){
	    	  
	    	  String cq = this.request().getParameter(at.getName());
	    	  
	    	  Aspect a = p.getAspects().get(at.getName());
	    	   	addCqs(a,topicCQ);

	      }
  
       
       
       
       
       try{   
 ps.update(p);
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
		
	}



	
}
