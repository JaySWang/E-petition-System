package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table
public class CriticalQuestion  extends BaseEntityBean  implements Serializable {
	int agree;
	int disagree;
	int na ;
	String value;
	
	@Version
	private int version;
	

	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Proposal.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="support",referencedColumnName="id")})
		private Set<Proposal> supporters=new HashSet();
	 
	 
	 @OneToMany(fetch=FetchType.EAGER,targetEntity=Proposal.class,cascade={CascadeType.ALL})
		@JoinColumns(value={@JoinColumn(name="attack",referencedColumnName="id")})
		private Set<Proposal> attackers=new HashSet();
	 
	 
	 
	 
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
	
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 
	public void addAttacker(Proposal p){
		attackers.add(p);
		
	}
	 public void addSupporter(Proposal p){
		 supporters.add(p);
	 }
	  
		@Override
		public boolean equals(Object obj) { 
			CriticalQuestion cq = (CriticalQuestion)obj; 
			if(!this.value.equals(cq.value)){
				return false;
			}
		
			if(this.attackers.size()!=cq.attackers.size()){
				return false;
			}
			if(this.supporters.size()!=cq.supporters.size()){
				return false;
			}
			
			int hashcode1=0;
			int hashcode2=0;
			for(Proposal p:attackers){
				hashcode1=+p.getType().hashCode();
				for(Proposal p2:cq.attackers){
					hashcode2=+p2.getType().hashCode();
			}
				if(hashcode1!=hashcode2){
					return false;
				}	
			}
			for(Proposal p:supporters){
				hashcode1=+p.getType().hashCode();
				for(Proposal p2:cq.supporters){
					hashcode2=+p2.getType().hashCode();
			}
				if(hashcode1!=hashcode2){
					return false;
				}	
			}
			
		
		    return true; 
		     

		} 
		@Override
		public int hashCode(){
			int hashCode = this.value.hashCode()*29;
			hashCode+=this.attackers.size()*13;
			hashCode+=this.supporters.size()*11;

			return hashCode;
		}
	
}
