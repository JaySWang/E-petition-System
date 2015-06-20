package action;


import java.util.HashMap;
import java.util.Map;

import model.ArgumentScheme;
import model.Aspect;
import model.AspectType;
import model.Proposal;

import service.IProposalService;



public class AddProposalAction extends BaseAction {
	
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





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String execute() throws Exception {

		
       Proposal p=new Proposal();
       ArgumentScheme as = (ArgumentScheme) this.session().getAttribute("argumentScheme");
       as = new ArgumentScheme();
       
       
       Map<String,Aspect> aspects=new HashMap();
       
       
       
   	Aspect a = new Aspect();
       for(AspectType s : as.getAspectType()){
    	   a.setType(s.getName());
    	   a.setValue(request().getParameter(s.getName()));
    	   aspects.put(s.getName(), a);
    	   
       }
       
       
       p.setAspects(aspects);
   
      
       
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
