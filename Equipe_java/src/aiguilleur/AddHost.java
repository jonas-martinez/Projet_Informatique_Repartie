package aiguilleur;

import jade.content.AgentAction;

public class AddHost implements AgentAction {
	private String host;

	public void addHost(String host) {
		setHost(host);
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}
}
