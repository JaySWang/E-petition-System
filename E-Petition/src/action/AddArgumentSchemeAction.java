package action;


import java.util.ArrayList;
import java.util.List;

import model.ArgumentScheme;
import model.AspectType;

import service.IArgumentSchemeService;



public class AddArgumentSchemeAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IArgumentSchemeService ass;

	private String name;
	private String description;


	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public IArgumentSchemeService getAss() {
		return ass;
	}





	public void setAss(IArgumentSchemeService ass) {
		this.ass = ass;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String execute() throws Exception {

		
       ArgumentScheme as = new ArgumentScheme();
      as.setName(name); 
       as.setDescription(description);
       
   	List<AspectType> ats = new ArrayList();

       
       
       String numOfAspectTypes = request().getParameter("num");
       int numOfAspectType = Integer.parseInt(numOfAspectTypes);
       
       
    
    for(int i =0;i<numOfAspectType;i++){
    	String typeName = request().getParameter("type"+i);
    	System.out.println(typeName);
    	
       	AspectType at = new AspectType();
       	at.setName(typeName);
    	
    	ats.add(at);
    }
   	
       
    as.setAspectTypes(ats);   
      
       
       try{   
 ass.save(as);
       }
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed£º" + e.getMessage());
    	   return ERROR;
       }
       this.request().setAttribute("message", "succeed" );


		return SUCCESS;
	}



	
}
