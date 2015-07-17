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
    
	

	private String attackOrSupport;
    private int aid;
	
	
    
	public String getAttackOrSupport() {
		return attackOrSupport;
	}





	public void setAttackOrSupport(String attackOrSupport) {
		this.attackOrSupport = attackOrSupport;
	}





	public int getAid() {
		return aid;
	}





	public void setAid(int aid) {
		this.aid = aid;
	}





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
    	String template = request().getParameter("template"+i);
    	
       	AspectType at = new AspectType();
       	at.setName(typeName);
    	at.setTemplate(template);
    	
    	ats.add(at);
    }
   	
	
    as.setAspectTypes(ats);   
    String variables = request().getParameter("variables");
    
    as.setVariables(variables);
    
       
       try{   
 ass.save(as);
       }
       catch(Exception e){
    	   (this.request()).setAttribute("message", "failed��" + e.getMessage());
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
			String sName =  this.request().getParameter("sName");

			if(sName==null){
				sName = ((ArgumentScheme)this.session().getAttribute("argumentScheme")).getName()+"";
			}
		
			argumentScheme=ass.getArgumentSchemeByName(sName);

			this.session().setAttribute("argumentScheme", argumentScheme);
		    this.session().setAttribute("aid", aid);
		    this.session().setAttribute("attackOrSupport", attackOrSupport);
			
			
			this.request().setAttribute("message", " ");

		}
		catch(Exception e){
			e.printStackTrace();
			return ERROR;
			
		}

		return SUCCESS;
	}
	
	
}
