package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class ArgumentScheme  extends BaseEntityBean  implements Serializable {
	
   String name;
   String description;
   
   String variables;

 	
 	
	 
	 @OneToMany(fetch = FetchType.EAGER,targetEntity=AspectType.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="sid",referencedColumnName="id")})
		private List<AspectType> aspectTypes = new ArrayList<AspectType>();

	 

	 	public String getVariables() {
	 		return variables;
	 	}

	 	public void setVariables(String variables) {
	 		this.variables = variables;
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

	public List<AspectType> getAspectTypes() {
		return aspectTypes;
	}



	public void setAspectTypes(List<AspectType> aspectTypes) {
		this.aspectTypes = aspectTypes;
		
	}


	
	@Override
	public boolean equals(Object obj) { 
		ArgumentScheme as = (ArgumentScheme)obj; 
	    return this.name.equals(as.name); 
	} 

	@Override
	public int hashCode(){
		int hashCode = this.name.hashCode()*29;
		return hashCode;
	}

	 
	 
}
