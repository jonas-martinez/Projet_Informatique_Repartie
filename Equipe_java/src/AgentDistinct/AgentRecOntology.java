package agentDistinct;

import jade.content.onto.BeanOntology;
import jade.content.onto.Ontology;
public class AgentRecOntology extends BeanOntology {
	public static  final String name = "Agent_Receveur_Ontology";
	private static AgentRecOntology theInstance = new AgentRecOntology();

	public static Ontology getInstance() {
		return theInstance;
	}
	public AgentRecOntology() {
		super(name);
		try {
			// Add all Concepts, Predicates and AgentActions in the local package
			add(getClass().getPackage().getName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
