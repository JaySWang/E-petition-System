package action;

import java.util.List;

import model.Proposal;

import service.IProposalService;



public class ShowAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProposalService ps;

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



	@SuppressWarnings("unchecked")
	public String showProposals()  {

		List<Proposal> proposals;
		try{
			
		
		proposals=ps.getProposals();
		this.request().setAttribute("proposals", proposals);

		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	

}
