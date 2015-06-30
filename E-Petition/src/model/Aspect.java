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
public class Aspect  extends BaseEntityBean  implements Serializable {
	String value;
	String type;
	 int agree;
	 int disagree;


	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=CriticalQuestion.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="aid",referencedColumnName="id")})
		private Set<CriticalQuestion> criticalQuestions=new HashSet();
	 
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Proposal.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="aid",referencedColumnName="id")})
		private Set<Proposal> attackers=new HashSet();
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Proposal.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="sid",referencedColumnName="id")})
		private Set<Proposal> supporters=new HashSet();
	 
	 
	 
	 
	 
	 
	 
	 public Set<Proposal> getAttackers() {
		return attackers;
	}

	public void setAttackers(Set<Proposal> attackers) {
		this.attackers = attackers;
	}

	public Set<Proposal> getSupporters() {
		return supporters;
	}

	public void setSupporters(Set<Proposal> supporters) {
		this.supporters = supporters;
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
	 
	public void addAttacker(Proposal p){
		attackers.add(p);
		
	}
	 public void addSupporter(Proposal p){
		 supporters.add(p);
	 }
	 
	 
}
