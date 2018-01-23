package com.model.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	private int id;
	private String name;
	private String title;
	/**
	 * @return id
	 */
	@Id
	public int getId() {
		return id;
	}
	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Ҫ���õ� name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
