package aiguilleur;

import jade.content.onto.BeanOntology;
import jade.content.onto.Ontology;

public class AiguilleurOntology extends BeanOntology {
	public static final String NAME = "Aiguilleur-Ontology";

	private static AiguilleurOntology instance = new AiguilleurOntology();

	public static Ontology getInstance() {
		return instance;
	}

	private AiguilleurOntology() {
		super(NAME);

		try {
			add(getClass().getPackage().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
