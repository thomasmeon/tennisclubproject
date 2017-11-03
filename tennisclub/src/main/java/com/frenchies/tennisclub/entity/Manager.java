package com.frenchies.tennisclub.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/* CLASS MANAGER */

@Entity
@Table(name = "Manager")
public class Manager extends People {

	//////// CONSTRUCTOR///////////
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

}
