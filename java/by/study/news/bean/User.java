package by.study.news.bean;

import java.util.Objects;

public class User {

	private int id;
	private String name;
	private String lastName;
	private String login;
	private String email;
	private String password;
	private int roleId;

	public User() {
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public User(String name, String lastName, String login, String email, String password, int roleId) {
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
	}

	public User(int id, String name, String lastName, String login, String email, String password, int roleId) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, lastName, login, name, password, roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && roleId == other.roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", login=" + login + ", email=" + email
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}
	
	
	
	
}