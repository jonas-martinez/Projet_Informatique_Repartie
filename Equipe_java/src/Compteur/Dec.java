package Compteur;

import jade.content.AgentAction;

public class Dec implements AgentAction {
    private int pheromone;

    public void dec(int ph){
        this.pheromone = ph-1;
    }

    public int getPheromone(){
        return this.pheromone;
    }
}