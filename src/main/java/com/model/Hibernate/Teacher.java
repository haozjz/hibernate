package com.model.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//当实体类名和数据库名不一致时需要指定table属性
@Table(name="_teacher") 	
public class Teacher {
	private int id;
	private String name;
	private String title;
	private String ownerName; //不参与持久化，数据库不可见
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	/**
	 * id注解表示主键，可以放在成员变量上面，
	 * 不一定要放在get方法上面，但是会破坏封装性，hibernat可以访问私有的变量上
	 */
	@Id
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
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
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

///当字段名和表中不一致时需要指定column值 
	@Column(name="_title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

