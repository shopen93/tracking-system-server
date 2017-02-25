package pl.lodz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Coordinates> coords;

	public User() {
		this.coords = new ArrayList<Coordinates>();
	}
	
	public User(String name) {
		this.name = name;
		this.coords = new ArrayList<Coordinates>();
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

	public List<Coordinates> getCoords() {
		return coords;
	}

	public void setCoords(List<Coordinates> coords) {
		this.coords = coords;
	}
	
	/**
	 * Metoda dodająca parę współrzędnych do listy
	 * 
	 * @param coords
	 */
	public void addCoords(Coordinates coords) {
		this.coords.add(coords);
	}
	
}
