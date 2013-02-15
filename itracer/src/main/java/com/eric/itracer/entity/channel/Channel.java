package com.eric.itracer.entity.channel;

public class Channel {
	//Channel name
	private String name;
	//which client does customer using
	private String client;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
}
