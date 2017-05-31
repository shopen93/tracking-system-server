package pl.lodz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.lodz.Polygon2D;

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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Restriction> restrictions;
	
	public User() {
		this.coords = new ArrayList<Coordinates>();
	}
	
	public User(String name) {
		this.name = name;
		this.coords = new ArrayList<Coordinates>();
		this.restrictions = new ArrayList<Restriction>();
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
	
	public List<Restriction> getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(List<Restriction> restrictions) {
		this.restrictions = restrictions;
	}

	/**
	 * Metoda dodająca parę współrzędnych do listy
	 * 
	 * @param coords
	 */
	public void addCoords(Coordinates coords) {
		this.coords.add(coords);
	}
	
	
	public void addRestriction(Restriction restriction) {
		this.restrictions.add(restriction);
	}
	
	public void addCoordsWithCheck(Coordinates coords) {
		boolean inPolygon = false;
		
		for(Restriction restriction : this.restrictions) {
			double x[] = new double[restriction.getPoints().size()];
			double y[] = new double[restriction.getPoints().size()];
			for(int i = 0; i < restriction.getPoints().size(); i++) {
				x[i] = restriction.getPoints().get(i).getX();
				y[i] = restriction.getPoints().get(i).getY();
			}
			
			Polygon2D polygon = new Polygon2D(x, y, x.length);
			inPolygon = inPolygon || polygon.contains(coords.getLongitude(), coords.getLatitude());
		}
		
		if(!inPolygon && this.restrictions.size() != 0) {
			coords.setType(Coordinates.ERROR_TYPE);
		}
		
		this.addCoords(coords);
	}
	
	public boolean anyNewMessages() {
		for(Coordinates coord : this.coords) {
			if(Coordinates.ERROR_TYPE.equals(coord.getType()) && coord.isShow()) {
				coord.setShow(false);
				return true;
			}
		}
		
		return false;
	}
}
