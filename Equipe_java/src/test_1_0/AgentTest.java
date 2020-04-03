package test_1_0;

import agentDistinct.AgentRecOntology;
import agentDistinct.GetType;
import agentDistinct.IsInformationMatching;
import agentDistinct.SetType;
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
	private AID compteur;
	private AID receveur;

	protected void setup() {
		String aiguilleurName = "aiguilleur";
		aiguilleur = new AID(aiguilleurName, AID.ISLOCALNAME);

		String compteurName = "compteur";
		compteur = new AID(compteurName, AID.ISLOCALNAME);

		String receveurName = "receveur";
		receveur = new AID(receveurName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());
		/*
		 * getContentManager().registerOntology(AiguilleurOntology.getInstance());
		 * 
		 * // addBehaviour(new OntologyServer(this, AiguilleurOntology.getInstance(), //
		 * ACLMessage.REQUEST, this));
		 * 
		 * requestGetHosts(aiguilleur); requestAddHost(aiguilleur, "test");
		 * requestAddHost(aiguilleur, "test2"); requestAddHost(aiguilleur, "test3");
		 * requestGetHosts(aiguilleur); requestSelectHostRandomly(aiguilleur);
		 * 
		 * getContentManager().registerOntology(CompteurOntology.getInstance());
		 */

		// TODO COMPTEUR

		getContentManager().registerOntology(AgentRecOntology.getInstance());

		requestGetType(receveur);
		requestSetType(receveur, "Video");
		requestGetType(receveur);
		requestIsInformationMatching(receveur, "Video");
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
					System.out.println("Agent " + myAgent.getLocalName() + " - Added host - performative: "
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

	private void requestDec(AID compteur) {

	}

	private void requestGet(AID compteur) {

	}

	private void requestInc(AID compteur) {

	}

	private void requestGetType(AID receveur) {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(receveur);
		request.setOntology(AgentRecOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			GetType gt = new GetType();
			Action actExpr = new Action(receveur, gt);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out.println("Agent " + myAgent.getLocalName() + " - Type is " + inform.getContent());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void requestSetType(AID receveur, String type) {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(receveur);
		request.setOntology(AgentRecOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			SetType st = new SetType();
			st.setType(type);
			Action actExpr = new Action(receveur, st);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out.println("Agent " + myAgent.getLocalName() + " - Set Type - performative: "
							+ inform.getPerformative());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void requestIsInformationMatching(AID receveur, String type) {
		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(receveur);
		request.setOntology(AgentRecOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
		try {
			IsInformationMatching iim = new IsInformationMatching();
			iim.setType(type);
			Action actExpr = new Action(receveur, iim);
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				public void handleInform(ACLMessage inform) {
					System.out.println(
							"Agent " + myAgent.getLocalName() + " - Is Information Matching: " + inform.getContent());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
