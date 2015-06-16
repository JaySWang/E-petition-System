package action;


import model.Proposal;

import service.IProposalService;



public class ShowProposalDetailAction extends BaseAction {

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
		System.out.println("lala");


		return SUCCESS;
	}



	@SuppressWarnings("unchecked")
	public String showProposalDetail()  {
		System.out.println("lolll");
	try{
		
		String idS =  this.request().getParameter("id");

		int id = Integer.parseInt(idS);
		Proposal proposal=ps.getProposalById(id);
		this.request().setAttribute("proposal", proposal);
		this.request().setAttribute("message", "here is the details");


		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	

}
