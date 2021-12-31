package com.reysl.SpringBootApp.Entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8129619057521208769L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native") //Valor automático generado y el nativo, es para que use autoincremento de mysql 
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	@NotBlank
	@Size(min=3, max=10, message = "no se cumple las reglas de tamaño")
	private String firstName;
	
	@Column
	@NotBlank
	private String lastName;
	
	@Column
	@NotBlank
	private String email;
	
	@Column
	@NotBlank
	private String username;
	
	@Column
	@NotBlank
	private String password;
	
	@Transient
	@NotBlank
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")) //busca cual es el Id del objeto rol y lo asigna como clave foranea
	private Set<Role> roles; // Creamos, donde se van a almacenar los roles (colección que no guarda valores repetidos)
	
	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public int hashCode() {
		return Objects.hash(confirmPassword, email, firstName, id, lastName, password, roles, username);
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
		return Objects.equals(confirmPassword, other.confirmPassword) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", roles=" + roles + "]";
	}	
	
}
