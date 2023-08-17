package com.gamesuggester.pacj.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Game")
public class Game {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name="name")
	private String name;	
	
	@Column(name="type")
	private String type;
	
	@Column(name="des")
	private String des;
	
	@Column(name="mothdlg")
	private String mothdlg;
	
	@Column(name="age")
	private String age;
	
	
	@Column(name="pic")
	private byte[] pic;
	
	

	public Game() {
		
	}









	public Game(int id, String name, String type, String des, String mothdlg, String age, byte[] pic) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.des = des;
		this.mothdlg = mothdlg;
		this.age = age;
		this.pic = pic;
	}









	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getDes() {
		return des;
	}




	public String getMothdlg() {
		return mothdlg;
	}









	public void setMothdlg(String mothdlg) {
		this.mothdlg = mothdlg;
	}









	public String getAge() {
		return age;
	}









	public void setAge(String age) {
		this.age = age;
	}









	public void setDes(String des) {
		this.des = des;
	}







	public byte[] getPic() {
		return pic;
	}







	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	
	
	
	
	
	

}
