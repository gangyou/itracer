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
import com.eric.itracer.entity.embeded.CustomerInfo;

@Entity(name = "button_click")
public class ButtonClick implements Serializable {
	private static final long serialVersionUID = -2695820285672830782L;

	@Id
	@GenericGenerator(name = "gen", strategy = "native")
	@GeneratedValue(generator = "gen")
	private long id;

	@Column(name = "button_name")
	private String buttonName;
	@Column(name = "button_id")
	private String buttonId;
	@Column(name = "button_type")
	private String buttonType;
	@Column(name = "button_class")
	private String buttonClass;
	@Embedded
	private ClickAction clickAction;
	@Embedded
	private Channel channel;
	@Embedded
	private CustomerInfo customer;

	public ButtonClick(String buttonName, String buttonId, String buttonType,
			String buttonClass, CustomerInfo customer, ClickAction clickAction,
			Channel channel) {
		super();
		this.buttonName = buttonName;
		this.buttonId = buttonId;
		this.buttonType = buttonType;
		this.buttonClass = buttonClass;
		this.clickAction = clickAction;
		this.channel = channel;
		this.customer = customer;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public ButtonClick() {
	}

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

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getButtonClass() {
		return buttonClass;
	}

	public void setButtonClass(String buttonClass) {
		this.buttonClass = buttonClass;
	}
}
