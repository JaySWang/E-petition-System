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

	
	 
	 
	 
	 @OneToMany(fetch = FetchType.EAGER,targetEntity=Aspect.class,cascade={  CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="pid",referencedColumnName="id")})
		
	 private List<Aspect> aspects=new ArrayList();
	 
	 
		
	
	private String type; 
	private int agree;
	private int disagree;
	
	
	





	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Proposal(){
		
	}
	
	
	
	
	public List<Aspect> getAspects(){
		
		// remove duplicate elements caused by the Hibernate;
		List <Aspect> aspectsN = new ArrayList();
		for(Aspect a:aspects){
			if(!aspectsN.contains(a)){
				aspectsN.add(a);
			}
			
		}
		
	
		return aspectsN;
		
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




	public void setAspects(List<Aspect> aspects) {
		this.aspects = aspects;
	}










	
	
	
}
