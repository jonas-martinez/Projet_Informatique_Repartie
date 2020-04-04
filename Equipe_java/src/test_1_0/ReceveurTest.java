package test_1_0;

import agentDistinct.AgentRecOntology;
import agentDistinct.GetType;
import agentDistinct.IsInformationMatching;
import agentDistinct.SetType;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

public class ReceveurTest extends Agent {
	private AID receveur;

	protected void setup() {
		String receveurName = "receveur";
		receveur = new AID(receveurName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());

		getContentManager().registerOntology(AgentRecOntology.getInstance());

		requestGetType(receveur);
		requestSetType(receveur, "Video");
		requestGetType(receveur);
		requestIsInformationMatching(receveur, "Video");
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
