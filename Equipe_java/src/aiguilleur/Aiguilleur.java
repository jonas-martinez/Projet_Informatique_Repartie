package aiguilleur;

import java.util.ArrayList;
import java.util.Random;

import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OntologyServer;
import jade.lang.acl.ACLMessage;

public class Aiguilleur extends Agent {
	private AID mobileAgent;

	private ArrayList<String> hosts;
	private Random random;

	protected void setup() {
		hosts = new ArrayList<>();
		random = new Random();

		String mobileAgentName = "mobile";
		mobileAgent = new AID(mobileAgentName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());
		getContentManager().registerOntology(AiguilleurOntology.getInstance());

		addBehaviour(new OntologyServer(this, AiguilleurOntology.getInstance(), ACLMessage.REQUEST, this));
	}

	public void serveGetHostsRequest(GetHosts gh, ACLMessage request) {
		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(hosts.toString());
		send(reply);
	}

	public void serveAddHostRequest(AddHost ah, ACLMessage request) {
		System.out.println("Aiguilleur - " + ah.getHost());
		this.hosts.add(ah.getHost());
		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		send(reply);
	}

	public void serveSelectHostRandomlyRequest(SelectHostRandomly shr, ACLMessage request) {
		String random_host = hosts.get(random.nextInt(hosts.size()));

		ACLMessage reply = request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(random_host);
		send(reply);
	}
}
