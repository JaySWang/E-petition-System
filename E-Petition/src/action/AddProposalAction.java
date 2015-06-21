package action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
    	   return ERROR;
       }
       this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}



	
}
