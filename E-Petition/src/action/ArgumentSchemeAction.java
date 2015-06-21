package action;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.ArgumentScheme;
import model.AspectType;

import service.IArgumentSchemeService;



public class ArgumentSchemeAction extends BaseAction {
	
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


	public String addArgumentScheme() throws Exception {

		
       ArgumentScheme as = new ArgumentScheme();
      as.setName(name); 
       as.setDescription(description);
       
   List<AspectType> ats = new ArrayList();

       
       
       String numOfAspectTypes = request().getParameter("num");
       int numOfAspectType = Integer.parseInt(numOfAspectTypes);
       
       
    
    for(int i =0;i<numOfAspectType;i++){
    	String typeName = request().getParameter("type"+i);
    	
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

	
	
	
	
	
	public String showArgumentSchemes()  throws Exception  {

		List<ArgumentScheme> argumentSchemes;
		try{
			
		
			argumentSchemes=ass.getArgumentSchemes();
		this.request().setAttribute("argumentSchemes", argumentSchemes);
		this.request().setAttribute("message", " ");

		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	
	public String getArgumentScheme()  throws Exception  {

		ArgumentScheme argumentScheme;
		try{
			String idS =  this.request().getParameter("sid");

			if(idS==null){
				idS = ((ArgumentScheme)this.session().getAttribute("argumentScheme")).getId()+"";
			}
			int id = Integer.parseInt(idS);
		
			argumentScheme=ass.getArgumentSchemeById(id);

			this.session().setAttribute("argumentScheme", argumentScheme);
		this.request().setAttribute("message", " ");

		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}
		
		return SUCCESS;
	}
	
	
}
