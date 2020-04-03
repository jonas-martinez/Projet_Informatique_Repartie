package aiguilleur;

import jade.content.AgentAction;

public class AddHost implements AgentAction {
	private String host;

	public void addHost(String host) {
		System.out.println("AddHost - addHost - " + host);
		this.host = host;
		System.out.println("AddHost - addHost - " + this.host);
	}

	public String getHost() {
		System.out.println("AddHost - getHost - " + host);
		return this.host;
	}

}
