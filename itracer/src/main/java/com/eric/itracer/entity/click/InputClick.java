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

@Entity(name = "input_click")
public class InputClick implements Serializable {
	private static final long serialVersionUID = -3205153640491545305L;
	@Id
	@GenericGenerator(name = "input_click_gen", strategy = "native")
	@GeneratedValue(generator = "input_click_gen")
	private long id;
	@Column(name = "input_name")
	private String inputName;
	@Column(name = "input_id")
	private String inputId;
	@Column(name = "input_hint")
	private String inputHint;
	@Column(name = "form_name")
	private String formName;
	@Column(name = "form_action")
	private String formAction;
	@Embedded
	private ClickAction clickAction;
	@Embedded
	private Channel channel;

	public InputClick(String inputName, String inputId, String inputHint,
			String formName, String formAction, ClickAction clickAction,
			Channel channel) {
		super();
		this.inputName = inputName;
		this.inputId = inputId;
		this.inputHint = inputHint;
		this.formName = formName;
		this.formAction = formAction;
		this.clickAction = clickAction;
		this.channel = channel;
	}

	public InputClick() {
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

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputId() {
		return inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputHint() {
		return inputHint;
	}

	public void setInputHint(String inputHint) {
		this.inputHint = inputHint;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormAction() {
		return formAction;
	}

	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}

}
