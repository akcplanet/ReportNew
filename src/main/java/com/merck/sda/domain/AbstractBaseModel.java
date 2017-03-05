package com.merck.sda.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public  class AbstractBaseModel<T> {
	protected T primaryKey;
}