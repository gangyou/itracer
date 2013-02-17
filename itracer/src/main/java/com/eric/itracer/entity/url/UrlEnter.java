package com.eric.itracer.entity.url;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.CustomerInfo;
import com.eric.itracer.entity.embeded.HttpHeader;

@Entity
@DiscriminatorValue("url_enter")
public class UrlEnter extends UrlVisit {

	public UrlEnter() {
	}

	public UrlEnter(Channel channel, CustomerInfo customer,
			HttpHeader httpHeader, String requestUrl, Date time) {
		super(channel, customer, httpHeader, requestUrl, time);
	}

	private static final long serialVersionUID = 4827066903419101093L;

}
