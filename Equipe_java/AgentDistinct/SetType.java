package PROJET;
import jade.content.AgentAction;
public class SetType implements AgentAction{
	private String type; 
	public void setType (String type) {
		this.type= type;
	}
	
	public String getType () {
		return this.type;
	}
	
}
