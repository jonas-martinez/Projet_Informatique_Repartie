package agentDistinct;
import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OntologyServer;
import jade.lang.acl.ACLMessage;

public class AgentReceveur extends Agent {
	private AID timeServerAgent; 
	private String typeAgent;
	
	public void setup() {
		
		getContentManager().registerLanguage(new SLCodec());
		getContentManager().registerOntology(AgentRecOntology.getInstance());
		

		addBehaviour(new OntologyServer(this, AgentRecOntology.getInstance(), ACLMessage.REQUEST, this));
	}
	
	
	public void servSetTypeRequest(SetType st, ACLMessage request) {
		
		typeAgent= st.getType();
		
		
		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		send(reply);
		
	}
	
	public void servGetTypeRequest(GetType gt, ACLMessage request) {
		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(typeAgent);
		send(reply);
	
	}
	
	
	public void ServIsMatchingRequest(IsInformationMatching IIM, ACLMessage request) {
		
		boolean match; 
		
		match = IIM.getType() == typeAgent; 
		

		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(String.valueOf(match));
		send(reply);
	
		}
}
