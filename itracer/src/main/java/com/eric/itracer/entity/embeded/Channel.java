package com.eric.itracer.entity.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Channel {
	@Column(name = "channel_name")
	private String name;
	@Column(name = "channel_client")
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
