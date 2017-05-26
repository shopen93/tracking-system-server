package pl.lodz.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coordinates {

	public final static String ERROR_TYPE = "E";
	
	public final static String NORMAL_TYPE = "N";
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;

	@Column(name = "creationDate")
	private Date date;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "show")
	private boolean show;
	
	public Coordinates() {
		
	}
	
	public Coordinates(double latitude, double longitude, String type) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = new Date();
		this.type = type;
		this.show = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
}
