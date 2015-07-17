package action;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.Proposal;

import service.IAspectService;
import service.IProposalService;



public class ProposalAction extends BaseAction {


	private IProposalService ps;
	private IAspectService as;
	private String agreeOrNot;
	
    private String variables;
    
    private Map<String,String> variablePairs ;

    
	
	
    
	
	
	
	
	



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
		  
		  Proposal proposal=ps.getProposalById(p.getId());
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

	       
	       
	       if(variableList.length!=variableValueList.length){
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
	    	   aspects.add(a);
	    	   
	       }
	       
	       
	       p.setAspects(aspects);
	     
	       
	       try{ 
	    		 ps.save(p);

	    		 
	    		 
	    	    String attackOrSupport = (String)this.session().getAttribute("attackOrSupport");
	 	       
	 	       if(attackOrSupport!=null){
	 	    	   int aid = (Integer) this.session().getAttribute("aid");
	     		   Aspect a = as.getAspectById(aid);
	     		   Proposal target = ps.getProposalById(p.getId());
	 	    	   if(attackOrSupport.equalsIgnoreCase("attack")){
	 					a.addAttacker(target);  
	 	    		 
	 	    		   			  }
	 	    	   else if(attackOrSupport.equalsIgnoreCase("support")){
               a.addSupporter(target);
	 	    	   
	 	    	   }
	 	    	   as.update(a);
	 	    	   
	 	    	  this.session().removeAttribute("attackOrSupport");
	 	    	 this.session().removeAttribute("aid");
	 	    	 
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

		
		String idS =  this.request().getParameter("aid");
		if(idS==null){
			idS = (String) this.session().getAttribute("aid");
		}else {
	         this.session().setAttribute("aid", idS);

		}
         
         
		int aid = Integer.parseInt(idS);
		
		
		
		
		
		try{
			Aspect a = as.getAspectById(aid);
			
			supporters=a.getSupporters();
			attackers=a.getAttackers();

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


}
