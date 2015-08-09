package action;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.StaleObjectStateException;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import evaluation.Evaluation;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.CriticalQuestion;
import model.Proposal;

import service.IAspectService;
import service.ICriticalQuestionService;
import service.IProposalService;
import tools.HtmlEncode;



public class ProposalAction extends BaseAction {


	private IProposalService ps;
	private IAspectService as;
	private ICriticalQuestionService cqs;

	private String agreeOrNot;
	
    private String variables;
    
    private Map<String,String> variablePairs ;

   

	public ICriticalQuestionService getCqs() {
		return cqs;
	}



	public void setCqs(ICriticalQuestionService cqs) {
		this.cqs = cqs;
	}



	public String getVariables() {
		return variables;
	}



	public void setVariables(String variables) {
		this.variables = variables;
	}



	public IAspectService getAs() {
		return as;
	}



	public void setAs(IAspectService as) {
		this.as = as;
	}



	public String getAgreeOrNot() {
		return agreeOrNot;
	}



	public void setAgreeOrNot(String agreeOrNot) {
		this.agreeOrNot = agreeOrNot;
	}



	public IProposalService getPs() {
		return ps;
	}



	public void setPs(IProposalService ps) {
		this.ps = ps;
	}



	
	@Override
	public String execute() throws Exception {


		return SUCCESS;
	}


	
	 public String voteProposal() throws Exception {
	      Proposal p = (Proposal)this.session().getAttribute("proposal");
		 
	      try{
	      if(agreeOrNot.equalsIgnoreCase("agree")){

			  ps.voteAgree(p,true);
		  
		  }else if(agreeOrNot.equalsIgnoreCase("disagree")){
			  ps.voteAgree(p,false);
			  
			  Proposal proposal=ps.getProposalById(p.getId());
			  
				this.session().setAttribute("aspects", proposal.getAspects());
				
			  return "cq";

		  }else{
			  return ERROR;
		  }
	      }catch(HibernateOptimisticLockingFailureException he){
				System.out.println("Optimistic lock");
				Proposal newP = ps.getProposalById(p.getId());
				this.session().setAttribute("proposal", newP);
				voteProposal();
			}catch(Throwable t){
				t.printStackTrace();
			}
	      
	     		  Proposal proposal=ps.getProposalById(p.getId());
			this.session().setAttribute("aspects", proposal.getAspects());

			this.session().setAttribute("proposal", proposal);
			
			this.request().setAttribute("message", "thank you for voting");
	        
			
		  
		return SUCCESS;
	}


	@SuppressWarnings("unchecked")
	public String showProposalDetail()  {
	try{
		
		
		String idS =  this.request().getParameter("id");
		if(idS==null){
			idS = (String) this.session().getAttribute("pid");
		}else {
	         this.session().setAttribute("pid", idS);

		}
         
         
		int id = Integer.parseInt(idS);
		Proposal proposal=ps.getProposalById(id);
		this.session().setAttribute("proposal", proposal);
		
	    	(this.request()).setAttribute("message", "");

		


		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	public String addProposal() throws Exception {

		
	       Proposal p=new Proposal();
	       ArgumentScheme argumentScheme = (ArgumentScheme) this.session().getAttribute("argumentScheme");
	   
	       p.setType(argumentScheme.getName());	   
	       
	       

	       
	       String[] variableList = argumentScheme.getVariables().split("/");

	       String[] variableValueList = this.getVariables().split("/");

	       //prevent xss attack
	       for(int i=0;i<variableValueList.length;i++){
	    	   variableValueList[i]=HtmlEncode.htmlEncode(variableValueList[i]);
	   	}
	       
	    
	       if(variableList.length!=variableValueList.length){
	    	  this.request().setAttribute("message", "number of the variables is wrong");
	    	   return ERROR;
	       }
	       else{
	    	    variablePairs = new HashMap();
	    	   
	    	    for(int i=0;i<variableList.length;i++){
	    	    	variablePairs.put(variableList[i], variableValueList[i]);
	    	    }
	    	    
	       }
	       
	       List<Aspect> aspects=new ArrayList();
	       for(AspectType at : argumentScheme.getAspectTypes()){
	    	   Aspect a = new Aspect();
	    	   a.setType(at.getName());
	    	   String tempalate = at.getTemplate();
	    	   
	    	   String value = replaceVariables(tempalate);
	    	    	   
	

	
	    	   a.setValue(value);
	    	 
	    	   for(CriticalQuestion cq:at.getCriticalQuestionTemplates()){
	    		   String cqValue = replaceVariables(cq.getValue());
		    	   CriticalQuestion newCq = new CriticalQuestion();
		    	   newCq.setValue(cqValue);
		    	   
		    	   a.addCriticalQuestion(newCq);
	    	   }
	    	  
	    	   aspects.add(a);
	    	   
	       }
	       
	       
	       p.setAspects(aspects);
	     
	       
	       try{ 
	    		 ps.save(p);

	    		 
	    		 
	    	    String attackOrSupport = (String)this.session().getAttribute("attackOrSupport");
	 	       
	 	       if(attackOrSupport!=null){
	 	    	   
	 	    	   String id = (String) this.session().getAttribute("cid");
	 	    	
	 	    	
	 	    	   
	 	    	   int cid =  Integer.parseInt(id);
	     		   CriticalQuestion cq = cqs.getCriticalQuestionById(cid);
	     		   
	     		   Proposal target = ps.getProposalById(p.getId());
	     		   
	 	    	   if(attackOrSupport.equalsIgnoreCase("attack")){
		     		   addAttackerToCq(cq,target);
	 	    		   			  }
	 	    	   else if(attackOrSupport.equalsIgnoreCase("support")){
		     		   addSupporterToCq(cq,target);
	 	    	   
	 	    	   }
	 	    	   
	 	    	 this.session().removeAttribute("attackOrSupport");
	 	    	 this.session().removeAttribute("cid");
	 	    	 
	 	    	(this.request()).setAttribute("message", "succeed");


				return "aOrS_success";
	 	    	 
	 	       }
	 	       
	    	   
	    	   
	    	   
	       }
	       catch(Throwable e){
	    	   e.printStackTrace();
	    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
	    	   return ERROR;
	       }
	       
	       
	       
	       
	       (this.request()).setAttribute("message", "succeed");


			return SUCCESS;
		}
	
	
	
	



	private void addSupporterToCq(CriticalQuestion cq, Proposal target) {
		cq.addSupporter(target); 		
  	  
		try{
			cqs.update(cq);
		}catch(HibernateOptimisticLockingFailureException he){
			System.out.println("Optimistic lock");
			CriticalQuestion newCq = cqs.getCriticalQuestionById(cq.getId());
			addSupporterToCq(newCq,target);
		}catch(Throwable t){
			t.printStackTrace();
		}	
		

	}
	private void addAttackerToCq(CriticalQuestion cq, Proposal target) {
		  cq.addAttacker(target); 	
		  try{
	  	   cqs.update(cq);
		  }catch(HibernateOptimisticLockingFailureException he){
				System.out.println("Optimistic lock");
				CriticalQuestion newCq = cqs.getCriticalQuestionById(cq.getId());
				addAttackerToCq(newCq,target);
			}catch(Throwable t){
				t.printStackTrace();
			}	
		  
	}



	private String replaceVariables(String tempalateS) {
		
		for(String s:variablePairs.keySet()){
			if(tempalateS.contains(s)){
				
				tempalateS=tempalateS.replace(s, variablePairs.get(s));
			}
			
		}
		
		
		return tempalateS;
	}



	public String getASProposals()  {

		Set<Proposal> attackers;
		Set<Proposal> supporters;

		
		String idS =  this.request().getParameter("cid");
		if(idS==null){
			idS = (String) this.session().getAttribute("cid");
		}else {
	         this.session().setAttribute("cid", idS);

		}
         
         
		int cid = Integer.parseInt(idS);
		
		
		
		
		
		try{
  		   CriticalQuestion cq = cqs.getCriticalQuestionById(cid);
			
			supporters=cq.getSupporters();
			attackers=cq.getAttackers();

		this.session().setAttribute("supporters", supporters);
		this.session().setAttribute("attackers", attackers);
    	(this.request()).setAttribute("message", "");



		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}


	public String evaluation(){
		
		
		List<String> results = new ArrayList();
		
		String idS =  this.request().getParameter("id");
		if(idS==null){
			idS = (String) this.session().getAttribute("pid");
		}else {
	         this.session().setAttribute("pid", idS);

		}
		
		int id = Integer.parseInt(idS);
		// get the newest proposal 
		Proposal target=ps.getProposalById(id);
		
		Evaluation e = new Evaluation();
		e.setTarget(target);
		
		String basicResult = "it is "+e.basicEvaluation();
		String cQResult = "it is "+e.CQEvaluation();
		String aSResult = "it is "+e.ASEvaluation(target);
		
		results.add(basicResult);
		results.add(cQResult);
		results.add(aSResult);

		
		// pay attention to the order in JSP
		this.request().setAttribute("results", results);
		
		return SUCCESS;

	}
	
	
}
