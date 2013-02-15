package com.eric.itracer.entity.click;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.ClickAction;

@Entity(name = "hyperlink_click")
public class HyperlinkClick implements Serializable {
	private static final long serialVersionUID = -4271769264687563620L;
	@Id
	@GenericGenerator(name = "href_gen", strategy = "native")
	@GeneratedValue(generator = "href_gen")
	private long id;
	@Column(name = "link_href")
	private String href;
	@Column(name = "link_id")
	private String linkId;
	@Column(name = "link_name")
	private String linkName;
	@Column(name = "link_class")
	private String linkClass;
	@Embedded
	private ClickAction clickAction;
	@Embedded
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClickAction getClickAction() {
		return clickAction;
	}

	public void setClickAction(ClickAction clickAction) {
		this.clickAction = clickAction;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkClass() {
		return linkClass;
	}

	public void setLinkClass(String linkClass) {
		this.linkClass = linkClass;
	}

}
