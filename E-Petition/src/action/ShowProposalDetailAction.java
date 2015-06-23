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
	
	

}
