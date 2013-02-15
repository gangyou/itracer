package com.eric.itracer.entity.url;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.CustomerInfo;
import com.eric.itracer.entity.embeded.HttpHeader;

@Entity(name = "url_visit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "viste_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("not_sepcified")
public class UrlVisit implements Serializable {
	private static final long serialVersionUID = 1443884814873870139L;
	@Id
	@GenericGenerator(name = "url_record_gen", strategy = "native")
	@GeneratedValue(generator = "url_record_gen")
	private long id;
	@Embedded
	private Channel channel;
	@Embedded
	private CustomerInfo customer = new CustomerInfo();
	@Embedded
	private HttpHeader httpHeader;
	@Column(name = "request_url")
	private String requestUrl;
	@Column(name = "request_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Channel getChannel() {
		return channel;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public HttpHeader getHttpHeader() {
		return httpHeader;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public void setHttpHeader(HttpHeader httpHeader) {
		this.httpHeader = httpHeader;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
