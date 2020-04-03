package compteur;

import jade.content.AgentAction;

public class Inc implements AgentAction {
    private int pheromone;

    public void inc(int ph){
        this.pheromone = ph+1;
    }

    public int getPheromone(){
        return this.pheromone;
    }
}