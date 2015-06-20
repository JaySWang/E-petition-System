package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Proposal extends BaseEntityBean  implements Serializable {

	
	 
	 
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Aspect.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="pid",referencedColumnName="id")})
		private Map<String,Aspect> aspects=new HashMap();
	 
	 
		@ManyToOne(fetch=FetchType.LAZY, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="asid")
	  private ArgumentScheme argumentScheme;
	
	 
	private int agree;
	private int disagree;
	
	
	




	public ArgumentScheme getArgumentScheme() {
		return argumentScheme;
	}




	public void setArgumentScheme(ArgumentScheme argumentScheme) {
		this.argumentScheme = argumentScheme;
	}




	public Proposal(){
		
	}
	
	
	
	
	public Map<String,Aspect> getAspects(){
		
		return aspects;
		
	}
	
	





	public int getAgree() {
		return agree;
	}



	public void setAgree(int agree) {
		this.agree = agree;
	}

    public void agree(){
    	this.agree++;
    }
    
  public void disagree(){
	  this.disagree++;
    }

	public int getDisagree() {
		return disagree;
	}



	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}




	public void setAspects(Map<String,Aspect> aspects) {
		this.aspects = aspects;
	}










	
	
	
}
