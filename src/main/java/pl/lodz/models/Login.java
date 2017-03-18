package pl.lodz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Login {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> users;

	public Login(String login, String password) {
		this.login = login;
		this.password = password;
		this.users = new ArrayList<User>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
