package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    @OneToMany(fetch=FetchType.EAGER,targetEntity=CriticalQuestion.class,cascade={CascadeType.ALL})
	@JoinColumns(value={@JoinColumn(name="atId",referencedColumnName="id")})
	private Set<CriticalQuestion> criticalQuestionTemplates=new HashSet();
 
    
    
    
    
	 public Set<CriticalQuestion> getCriticalQuestionTemplates() {
		return criticalQuestionTemplates;
	}

	public void setCriticalQuestionTemplates(
			Set<CriticalQuestion> criticalQuestionTemplates) {
		this.criticalQuestionTemplates = criticalQuestionTemplates;
	}

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

	public void addCriticalQuestionTemplate(CriticalQuestion cq) {
		criticalQuestionTemplates.add(cq);		
	}




	 
	 
}
