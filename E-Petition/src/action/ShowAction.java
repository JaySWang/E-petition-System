package action;

import java.util.List;

import model.ArgumentScheme;
import model.Proposal;

import service.IArgumentSchemeService;
import service.IProposalService;



public class ShowAction extends BaseAction {

	/**
	 * 
	 */
	
	private IProposalService ps;
	private IArgumentSchemeService ass;

	

	public IArgumentSchemeService getAss() {
		return ass;
	}



	public void setAss(IArgumentSchemeService ass) {
		this.ass = ass;
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



	public String show()  {

		List<Proposal> proposals;
		
		List<ArgumentScheme> argumentSchemes;			
		
		
		try{
			
		argumentSchemes=ass.getArgumentSchemes();
		this.session().setAttribute("argumentSchemes", argumentSchemes);
		
		proposals=ps.getProposals();
		this.request().setAttribute("proposals", proposals);
		
		this.request().setAttribute("message", " ");

		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	

}
