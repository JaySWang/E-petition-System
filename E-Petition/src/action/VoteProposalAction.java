package action;



import model.Proposal;
import service.IProposalService;



public class VoteProposalAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	
	private String agreeOrNot;
	

	private IProposalService ps;
	

	
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





	public static long getSerialversionuid() {
		return serialVersionUID;
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

	  }else{
		  return ERROR;
	  }
	  
	  Proposal proposal=ps.getProposalById(p.getId());
		this.session().setAttribute("proposal", proposal);
		
		this.request().setAttribute("message", "thank you for voting");

	  
	return SUCCESS;
}

	
}
