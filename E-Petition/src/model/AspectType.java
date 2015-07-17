package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class AspectType  extends BaseEntityBean  implements Serializable {
	
	String name;
    String template;
    
	 
    
	 public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
  
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	 
	 
}
