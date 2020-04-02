package Compteur;

import jade.content.onto.BeanOntology;

public class CompteurOntology extends BeanOntology {
    
    public static final String NAME = "Compteur-Ontology";
    
    private static CompteurOntology instance = new CompteurOntology();

    /**
     * @return the instance
     */
    public static CompteurOntology getInstance() {
        return instance;
    }

    private CompteurOntology(){
        super(NAME);

        try {
            add(getClass().getPackage().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}