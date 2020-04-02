package projetinfo;

import jade.content.AgentAction;

public class AddHost implements AgentAction {
	private String host;

	public void addHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}

}
