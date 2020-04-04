package test_1_0;

import compteur.CompteurOntology;
import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;

public class CompteurTest extends Agent {
	private AID compteur;

	protected void setup() {

		String compteurName = "compteur";
		compteur = new AID(compteurName, AID.ISLOCALNAME);

		getContentManager().registerLanguage(new SLCodec());

		getContentManager().registerOntology(CompteurOntology.getInstance());

		// getContentManager().registerOntology(CompteurOntology.getInstance());
	}

	private void requestDec(AID compteur) {

	}

	private void requestGet(AID compteur) {

	}

	private void requestInc(AID compteur) {

	}
}
