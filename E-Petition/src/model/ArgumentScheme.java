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
   String discription;
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=AspectType.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="sid",referencedColumnName="id")})
		private List<AspectType> aspectType=new ArrayList();

	 
	 
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<AspectType> getAspectType() {
		return aspectType;
	}

	public void setAspectType(List<AspectType> aspectType) {
		this.aspectType = aspectType;
	}
	
	





	 
	 
}
