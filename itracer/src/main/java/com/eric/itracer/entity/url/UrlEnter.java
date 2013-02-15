package com.eric.itracer.entity.url;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("url_enter")
public class UrlEnter extends UrlVisit {

	private static final long serialVersionUID = 4827066903419101093L;
}
