package compteur;

import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OntologyServer;
import jade.lang.acl.ACLMessage;

import jade.core.behaviours.CyclicBehaviour;

public class AgentCompteur extends Agent {

    private int pheromone;

    protected void setup() {
        pheromone = 0;

        getContentManager().registerLanguage(new SLCodec());
        getContentManager().registerOntology(CompteurOntology.getInstance());

        addBehaviour(new OntologyServer(this, CompteurOntology.getInstance(), ACLMessage.REQUEST, this));
    }

    public void serveGetRequest(Get g, ACLMessage request) {
        ACLMessage reply = request.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        reply.setContent(String.valueOf(pheromone));
        send(reply);
    }

    public void serveDecRequest(Dec d, ACLMessage request) {
        d.dec(pheromone);
        pheromone = d.getPheromone();
        ACLMessage reply = request.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        System.out.println(pheromone);
        send(reply);
    }

    public void serveIncRequest(Inc i, ACLMessage request) {
        i.inc(pheromone);
        pheromone = i.getPheromone();
        ACLMessage reply = request.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        System.out.println(pheromone);
        send(reply);
    }
}