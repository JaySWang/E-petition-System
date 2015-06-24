package action;


import java.util.ArrayList;
import java.util.List;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.Proposal;

import service.IProposalService;



public class ProposalAction extends BaseAction {


	private IProposalService ps;
	private String agreeOrNot;

	
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
		this.request().setAttribute("message", "here is the details");


		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	public String addProposal() throws Exception {

		
	       Proposal p=new Proposal();
	       ArgumentScheme as = (ArgumentScheme) this.session().getAttribute("argumentScheme");
	   
	       
	       
	       List<Aspect> aspects=new ArrayList();
	       
	       
	       
	   	
	       for(AspectType s : as.getAspectTypes()){
	    	   Aspect a = new Aspect();
	    	   a.setType(s.getName());
	String value = request().getParameter(s.getName());

	    	   a.setValue(value);
	    	   aspects.add(a);
	    	   
	       }
	       
	       
	       p.setAspects(aspects);
	     
	       
	       try{   
	 ps.save(p);
	       }
	       catch(Throwable e){
	    	   e.printStackTrace();
	    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
	    	   return ERROR;
	       }
	       
	       
	       (this.request()).setAttribute("message", "succeed");


			return SUCCESS;
		}


}
