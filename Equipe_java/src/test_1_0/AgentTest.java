package test_1_0;

import aiguilleur.AddHost;
import aiguilleur.AiguilleurOntology;
import aiguilleur.GetHosts;
import aiguilleur.SelectHostRandomly;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

public class AgentTest extends Agent {
	private AID aiguilleur;

	protected void setup() {
		String aiguilleurName = "aiguilleur";
		aiguilleur = new AID(aiguilleurName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());
		getContentManager().registerOntology(AiguilleurOntology.getInstance());

		// addBehaviour(new OntologyServer(this, AiguilleurOntology.getInstance(),
		// ACLMessage.REQUEST, this));

		requestGetHosts();
		requestAddHost("test");
		requestGetHosts();
		requestSelectHostRandomly();
	}

	private void requestGetHosts() {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(aiguilleur);
		request.setOntology(AiguilleurOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			GetHosts gh = new GetHosts();
			Action actExpr = new Action(aiguilleur, gh);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out.println("Agent " + myAgent.getLocalName() + " - Hosts are " + inform.getContent());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void requestAddHost(String host) {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(aiguilleur);
		request.setOntology(AiguilleurOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			AddHost ah = new AddHost();
			ah.addHost(host);
			Action actExpr = new Action(aiguilleur, ah);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out.println("Agent " + myAgent.getLocalName() + " - Added host: " + inform.getPerformative());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void requestSelectHostRandomly() {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(aiguilleur);
		request.setOntology(AiguilleurOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			SelectHostRandomly shr = new SelectHostRandomly();
			Action actExpr = new Action(aiguilleur, shr);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out
							.println("Agent " + myAgent.getLocalName() + " - Selected host is: " + inform.getContent());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
