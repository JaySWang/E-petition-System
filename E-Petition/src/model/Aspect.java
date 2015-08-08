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
import javax.persistence.Version;


@Entity
@Table
public class Aspect  extends BaseEntityBean  implements Serializable {
	String value;
	String type;
	 int agree;
	 int disagree;
   
	 @Version
		private int version;
		

	
	
	
	@OneToMany(fetch=FetchType.EAGER,targetEntity=CriticalQuestion.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="aid",referencedColumnName="id")})
		private Set<CriticalQuestion> criticalQuestions=new HashSet();
	 

	 
	 
	 
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void addCriticalQuestion(CriticalQuestion cq){
		 criticalQuestions.add(cq);
	 }
	 
	public Set<CriticalQuestion> getCriticalQuestions() {
		return criticalQuestions;
	}
	public void setCriticalQuestions(Set<CriticalQuestion> criticalQuestions) {
		this.criticalQuestions = criticalQuestions;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	public int getDisagree() {
		return disagree;
	}
	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}
	 

	 
}
