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

public class AiguilleurTest extends Agent {
	private AID aiguilleur;

	protected void setup() {
		String aiguilleurName = "aiguilleur";
		aiguilleur = new AID(aiguilleurName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());

		getContentManager().registerOntology(AiguilleurOntology.getInstance());

		requestGetHosts(aiguilleur);
		requestAddHost(aiguilleur, "test");
		requestAddHost(aiguilleur, "test2");
		requestAddHost(aiguilleur, "test3");
		requestGetHosts(aiguilleur);
		requestSelectHostRandomly(aiguilleur);
	}

	private void requestGetHosts(AID aiguilleur) {
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

	private void requestAddHost(AID aiguilleur, String host) {
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
					System.out.println("Agent " + myAgent.getLocalName() + " - Add Host - performative: "
							+ inform.getPerformative());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void requestSelectHostRandomly(AID aiguilleur) {
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
