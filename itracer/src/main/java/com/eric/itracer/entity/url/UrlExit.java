package com.eric.itracer.entity.url;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("url_exit")
public class UrlExit extends UrlVisit {

	private static final long serialVersionUID = -6419926766822982230L;
}
