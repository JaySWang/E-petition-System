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
public class ArgumentScheme  extends BaseEntityBean  implements Serializable {
	
   String name;
   String description;
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=AspectType.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="sid",referencedColumnName="id")})
		private List<AspectType> aspectTypes=new ArrayList();

	 
	 
	 
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
	
	





	 
	 
}
