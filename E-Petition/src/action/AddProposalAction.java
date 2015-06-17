package action;


import model.Aspect;
import model.Proposal;

import service.IProposalService;



public class AddProposalAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String topic;
	
	private String situation;
		
	private String action;
	
	private String goal;
	
	private String value;
		
	
	
	

	private IProposalService ps;
	

	
	

	public String getTopic() {
		return topic;
	}





	public void setTopic(String topic) {
		this.topic = topic;
	}





	public String getSituation() {
		return situation;
	}





	public void setSituation(String situation) {
		this.situation = situation;
	}





	public String getAction() {
		return action;
	}





	public void setAction(String action) {
		this.action = action;
	}





	public String getGoal() {
		return goal;
	}





	public void setGoal(String goal) {
		this.goal = goal;
	}





	public String getValue() {
		return value;
	}





	public void setValue(String value) {
		this.value = value;
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

		
       Proposal p=new Proposal();
       
   	Aspect aTopic = new Aspect();
	aTopic.setType("topic");
	aTopic.setValue(topic);
	
	Aspect aSituation = new Aspect();
	aSituation.setType("situation");
	aSituation.setValue(situation);
	
	Aspect aAction = new Aspect();
	aAction.setType("action");
	aAction.setValue(action);
	
	Aspect aGoal = new Aspect();
	aGoal.setType("goal");
	aGoal.setValue(goal);
	
	Aspect aValue = new Aspect();
	aValue.setType("value");
	aValue.setValue(value);
	
	
	
	p.setTopic(aTopic);
	p.setSituation(aSituation);
	
	p.setAction(aAction);
	p.setGoal(aGoal);
	p.setValue(aValue);
       
       
       
       
       try{   
 ps.save(p);
       }
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
    	   return ERROR;
       }
       this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}



	
}
