package pl.lodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restriction {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "first")
	private String firstCorner;
	
	@Column(name = "second")
	private String secondCorner;
	
	public Restriction() {
		
	}
	
	public Restriction(String name, String first, String second) {
		this.name = name;
		this.firstCorner = first;
		this.secondCorner = second;
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

	public String getFirstCorner() {
		return firstCorner;
	}

	public void setFirstCorner(String firstCorner) {
		this.firstCorner = firstCorner;
	}

	public String getSecondCorner() {
		return secondCorner;
	}

	public void setSecondCorner(String secondCorner) {
		this.secondCorner = secondCorner;
	}
	
}
