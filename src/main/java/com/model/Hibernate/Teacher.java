package com.model.Hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
//当实体类名和数据库名不一致时需要指定table属性
@Table(name="TTeacher") 	
//自动生成的主键，所有的表会公用一个，可以用以下属性指定区分
//@SequenceGenerator(name="teacherSEQ", sequenceName="teacherSEQ_DB")
public class Teacher {
	private int id;
	private String name;
	private String title;

	private String ownerName; 
	private Date date;
	
	//枚举类型，存到数据库，常用在下拉框中,注解
	private Grade grade;
	
	//枚举类型用到的注解;枚举类型存库有两种方式：字符串和数值型
	@Enumerated(EnumType.STRING)
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	//映射日期与时间类型，指定时间精度(temporal)
	@Temporal(TemporalType.DATE)  //（value=TemporalType.DATE）可以省略value
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Transient 	//不参与持久化，数据库不可见
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	 //id注解表示主键，可以放在成员变量上面，
	 // 不一定要放在get方法上面，但是会破坏封装性，hibernat可以访问私有的变量上
	@Id
	//@GeneratedValue为主键自动生产策略，也可以不指定，但是不指定就需要在insert试set改值，默认的策略为native
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue
	//自动生成的主键，所有的表会公用一个，可以用以下属性指定区分
    //@GeneratedValue(strategy=GenerationType.TABLE, generator="Teacher_GEN")
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
	@Column(name="Ttitle")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

