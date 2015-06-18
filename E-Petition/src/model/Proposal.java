package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Proposal extends BaseEntityBean  implements Serializable {

	 @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="tid",referencedColumnName="id")
	private Aspect topic;
	
	 @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="sid",referencedColumnName="id")
	private Aspect situation ;
	
	 @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="aid",referencedColumnName="id")
	private Aspect action;
	
	 @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="gid",referencedColumnName="id")
	private Aspect goal;
	
	 @ManyToOne(fetch=FetchType.EAGER, cascade ={CascadeType.ALL}  )
	    @JoinColumn(name="vid",referencedColumnName="id")
	private Aspect value;
	
	private int agree;
	private int disagree;
	
	
	public Proposal(){
		
	}
	
	
	
	
	public List<Aspect> getAspects(){
		List<Aspect> aspects = new ArrayList();
		aspects.add(topic);
		aspects.add(situation);
		aspects.add(action);
		aspects.add(goal);
		aspects.add(value);

		
		
		return aspects;
		
	}
	
	
	
	public void setTopic(Aspect topic) {
		this.topic = topic;
	}








	public void setSituation(Aspect situation) {
		this.situation = situation;
	}








	public void setAction(Aspect action) {
		this.action = action;
	}








	public void setGoal(Aspect goal) {
		this.goal = goal;
	}








	public void setValue(Aspect value) {
		this.value = value;
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








	public Aspect getTopic() {
		return topic;
	}








	public Aspect getSituation() {
		return situation;
	}








	public Aspect getAction() {
		return action;
	}








	public Aspect getGoal() {
		return goal;
	}








	public Aspect getValue() {
		return value;
	}



	
	
	
}
